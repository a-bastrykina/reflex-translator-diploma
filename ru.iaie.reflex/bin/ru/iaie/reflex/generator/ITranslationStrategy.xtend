package ru.iaie.reflex.generator

import org.eclipse.emf.ecore.EObject
import ru.iaie.reflex.reflex.IfElseStat
import ru.iaie.reflex.reflex.Const

interface ITranslationStrategy {
	def String translateConstDefinition(Const c);
	def String translateExpression(EObject expr);
	def String translateIfElseStat(IfElseStat stat);
}