package ru.iaie.reflex.generator

import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import java.io.IOException
import org.eclipse.emf.common.util.URI
import ru.iaie.reflex.reflex.Program

class XMIReflexGenerator extends AbstractGenerator {
	
	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val program = input.allContents.toIterable.filter(Program).get(0)
		exportXMI(program.name.toLowerCase, input, fsa)
	}
	
			//  based on https://stackoverflow.com/questions/35839786/xtext-export-model-as-xmi-xml
	def exportXMI(String fileName, Resource resource, IFileSystemAccess2 fsa) {
		val outputURI = fsa.getURI('''«fileName».xmi''').toPlatformString(true)
		val resourceSet = resource.resourceSet
		if(resourceSet === null) throw new IllegalStateException("enclosing resourceSet not found")
		val xmiResource = resourceSet.createResource(URI.createURI(outputURI)); // default is XMI resource
		xmiResource.getContents().add(resource.getContents().get(0));
		try {
			xmiResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}