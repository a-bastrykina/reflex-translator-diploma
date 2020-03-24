package ru.iaie.reflex;

import org.eclipse.xtext.generator.IGenerator2;

import com.google.inject.Guice;
import com.google.inject.Injector;

import ru.iaie.reflex.generator.XMIReflexGenerator;

public class ReflexStandaloneSetupXMIGen extends ReflexStandaloneSetup {
	public Injector createInjector() {
		return Guice.createInjector(new ReflexRuntimeModule() {		
			@Override
			public Class<? extends IGenerator2> bindIGenerator2() {
				return XMIReflexGenerator.class;
			}
		});
	}
}
