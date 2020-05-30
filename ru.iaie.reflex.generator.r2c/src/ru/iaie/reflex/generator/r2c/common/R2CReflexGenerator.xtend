package ru.iaie.reflex.generator.r2c.common

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

import ru.iaie.reflex.generator.IReflexGenerator
import ru.iaie.reflex.generator.r2c.interfaces.IFileGenerator

class R2CReflexGenerator implements IReflexGenerator {

	protected IFileGenerator fileGen;

	override void beforeGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		fileGen = new R2CFileGenerator(resource, fsa)
	}

	override void afterGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {}

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		fileGen.prepareForGeneration()
		fileGen.generateVariableDefinitions()
		fileGen.generateConstantDefinitions()
		fileGen.generateProcessDefinitions()
		fileGen.generateProcessImplementations()
		fileGen.generateIOFiles()
		fileGen.generatePlatformImplementations()
		fileGen.generateMain()
		fileGen.generateBuildFiles()
	}
}
