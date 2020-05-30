package ru.iaie.reflex.generator.r2c.arduino

import ru.iaie.reflex.generator.r2c.common.R2CReflexGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

class ArduinoReflexGenerator extends R2CReflexGenerator {
	
	override void beforeGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		fileGen = new ArduinoFileGenerator(resource, fsa)
	}

}