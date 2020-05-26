package ru.iaie.reflex.generator.r2c.interfaces;

import ru.iaie.reflex.reflex.Const
import ru.iaie.reflex.reflex.Enum
import ru.iaie.reflex.reflex.Process
import ru.iaie.reflex.reflex.Port
import ru.iaie.reflex.reflex.EnumMember
import ru.iaie.reflex.reflex.GlobalVariable
import ru.iaie.reflex.reflex.IdReference
import ru.iaie.reflex.reflex.ProcessVariable

interface IReflexIdentifiersHelper {
	def String getProcessFuncId(Process proc)
	def String getProcessVariableId(Process proc, ProcessVariable v)
	def String getConstantId(Const c)
	def String getPortId(Port p)
	def String getEnumId(Enum en)
	def String getEnumMemberId(EnumMember em)
	def String getGlobalVariableId(GlobalVariable v) 
	
	def String getMapping(IdReference original)
}