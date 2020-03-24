package ru.iaie.reflex;

import org.eclipse.xtext.generator.IGenerator2;

import com.google.inject.Guice;
import com.google.inject.Injector;

import ru.iaie.reflex.generator.R2CReflexGenerator;

public class ReflexStandaloneSetupR2CGen extends ReflexStandaloneSetup {
	public Injector createInjector() {
		return Guice.createInjector(new ReflexRuntimeModule() {		
			@Override
			public Class<? extends IGenerator2> bindIGenerator2() {
				return R2CReflexGenerator.class;
			}
		});
	}
}
