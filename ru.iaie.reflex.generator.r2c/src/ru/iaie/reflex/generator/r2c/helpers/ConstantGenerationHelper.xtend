package ru.iaie.reflex.generator.r2c.helpers;

import ru.iaie.reflex.reflex.Const
import ru.iaie.reflex.reflex.Enum
import static extension ru.iaie.reflex.utils.ReflexModelUtil.*
import ru.iaie.reflex.generator.r2c.interfaces.IReflexIdentifiersHelper

class ConstantGenerationHelper {
	IReflexIdentifiersHelper identifiersHelper
	ExpressionGenerationHelper expressionGenerator
	
	new(IReflexIdentifiersHelper ih) {
		this.identifiersHelper = ih 
		this.expressionGenerator = new ExpressionGenerationHelper(identifiersHelper)
	}
	
	def generateConstantDefinition(Const c) {
		return '''#define «identifiersHelper.getConstantId(c)» «expressionGenerator.translateExpr(c.value)»'''
	}
	
	def generateEnumDefifnition(Enum en) {
		return 
		'''
		enum «identifiersHelper.getEnumId(en)» {
			«FOR enumMember: en.enumMembers»
		    «identifiersHelper.getEnumMemberId(enumMember)»«IF enumMember.hasValue»=«expressionGenerator.translateExpr(enumMember.value)»«ENDIF», 
			«ENDFOR»
		};
		'''
	}
	
	
}