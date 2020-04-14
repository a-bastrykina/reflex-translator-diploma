package ru.iaie.reflex.generator.r2c

import ru.iaie.reflex.reflex.Const
import ru.iaie.reflex.reflex.Enum
import ru.iaie.reflex.reflex.Process
import ru.iaie.reflex.reflex.State
import ru.iaie.reflex.reflex.Register
import ru.iaie.reflex.reflex.EnumMember
import ru.iaie.reflex.reflex.GlobalVariable
import ru.iaie.reflex.reflex.ProcessVariable

interface IReflexCachedIdentifiersHelper {
	def String getProcessId(Process proc)
	def String getProcessFuncId(Process proc)
	def String getStateId(Process proc, State state)
	def String getProcessVariableId(Process proc, ProcessVariable v)
	def String getConstantId(Const c)
	def String getPortId(Register reg)
	def String getEnumId(Enum en)
	def String getEnumMemberId(EnumMember em)
	def String getGlobalVariableId(GlobalVariable v) 
	
	def String getId(String original)
	
	def void clearCaches()
}