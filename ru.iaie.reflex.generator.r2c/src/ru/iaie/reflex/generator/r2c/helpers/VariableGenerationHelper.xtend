package ru.iaie.reflex.generator.r2c.helpers

import static extension ru.iaie.reflex.utils.ReflexModelUtil.*
import ru.iaie.reflex.reflex.ProcessVariable
import ru.iaie.reflex.reflex.GlobalVariable
import ru.iaie.reflex.generator.r2c.interfaces.IReflexIdentifiersHelper
import ru.iaie.reflex.generator.r2c.util.LiteralGenerationUtil

class VariableGenerationHelper {
	IReflexIdentifiersHelper identifiersHelper
	
	new(IReflexIdentifiersHelper ih) {
		this.identifiersHelper = ih 
	}
	
	def generateProcessVariableDefinition(ProcessVariable variable) {
		if (!variable.isImportedList) {
			return '''«LiteralGenerationUtil.translateType(variable.type)» «identifiersHelper.getProcessVariableId(variable.process, variable)»'''
		}
	}

	def generateGlobalVariableDefinition(GlobalVariable variable) {
		return '''«LiteralGenerationUtil.translateType(variable.type)» «identifiersHelper.getGlobalVariableId(variable)»'''
	}
	
}