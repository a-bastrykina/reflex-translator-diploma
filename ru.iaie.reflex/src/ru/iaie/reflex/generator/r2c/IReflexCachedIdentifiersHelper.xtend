package ru.iaie.reflex.generator.r2c

import ru.iaie.reflex.reflex.Const
import ru.iaie.reflex.reflex.Process
import ru.iaie.reflex.reflex.State
import ru.iaie.reflex.reflex.Variable
import ru.iaie.reflex.reflex.Register

interface IReflexCachedIdentifiersHelper {
	def String getProcessId(Process proc)
	def String getProcessFuncId(Process proc)
	def String getStateId(Process proc, State state)
	def String getVariableId(Process proc, Variable v)
	def String getConstantId(Const c)
	def String getPortId(Register reg)
	
	def String getId(String original);
	
	def void clearCaches()
}