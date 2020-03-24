package ru.iaie.reflex.generator

import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import ru.iaie.reflex.reflex.Program

class AnotherReflexGenerator extends AbstractGenerator {
	
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val program = resource.allContents.toIterable.filter(Program).get(0)
		
		fsa.generateFile('''«program.name.toLowerCase».txt''', '''Hello «program.name»''')
	}
	
}