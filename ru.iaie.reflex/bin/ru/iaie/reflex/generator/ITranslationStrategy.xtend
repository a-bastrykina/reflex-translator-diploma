package ru.iaie.reflex.generator

import org.eclipse.emf.ecore.EObject
import ru.iaie.reflex.reflex.IfElseStat
import ru.iaie.reflex.reflex.Const
import ru.iaie.reflex.reflex.Enum
import ru.iaie.reflex.reflex.ProcessVariable
import ru.iaie.reflex.reflex.Process
import ru.iaie.reflex.reflex.GlobalVariable

interface ITranslationStrategy {
	def String translateConstDefinition(Const c);

	def String translateEnumDefinition(Enum e);

	def String translateProcessVarDefinition(Process p, ProcessVariable v);

	def String translateGlobalVarDefinition(GlobalVariable v);

	def String translateExpression(EObject expr);

	def String translateIfElseStat(IfElseStat stat);

	def String getSeparator()
}
