package ru.iaie.reflex.deserialization;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import ru.iaie.reflex.ReflexStandaloneSetup;

public class ModelDeserializer {
	
	public static Resource deserializeFromXMI(String serializedAST) {
		XMIResource result = null;
		try (InputStream inputStream = new ByteArrayInputStream(serializedAST.getBytes())) {
			Injector injector = ReflexStandaloneSetup.getInjector();
			XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
			result = (XMIResource) resourceSet.createResource(URI.createURI(".xmi"));
			result.load(inputStream, null);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
}
