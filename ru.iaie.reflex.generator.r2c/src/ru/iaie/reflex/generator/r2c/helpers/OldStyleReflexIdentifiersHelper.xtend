package ru.iaie.reflex.generator.r2c.helpers

import ru.iaie.reflex.reflex.Process
import ru.iaie.reflex.reflex.State
import ru.iaie.reflex.reflex.Const
import ru.iaie.reflex.reflex.Port
import java.util.Map
import java.util.HashMap
import ru.iaie.reflex.reflex.PhysicalVariable
import ru.iaie.reflex.reflex.ProgramVariable
import ru.iaie.reflex.reflex.Enum
import ru.iaie.reflex.reflex.EnumMember
import ru.iaie.reflex.reflex.GlobalVariable

import static extension ru.iaie.reflex.utils.ReflexModelUtil.*
import ru.iaie.reflex.reflex.IdReference
import ru.iaie.reflex.reflex.ProcessVariable
import ru.iaie.reflex.generator.r2c.interfaces.IReflexIdentifiersHelper

@Deprecated
class OldStyleReflexIdentifiersHelper implements IReflexIdentifiersHelper {

	// TODO: final
	Map<String, Map<String, String>> varIdentifiers = new HashMap
	Map<String, String> globalVarIdentifiers = new HashMap
	Map<String, String> constIdentifiers = new HashMap
	Map<String, String> portIdentifiers = new HashMap
	Map<String, String> enumIdentifiers = new HashMap

	Map<String, String> identifiers = new HashMap

	// TODO: investigate possibility to implement an interface to get name 
	private def dispatch getKey(Process proc) {
		return proc.name
	}

	private def dispatch getKey(State state) {
		return state.name
	}

	private def dispatch getKey(PhysicalVariable v) {
		return v.name
	}

	private def dispatch getKey(ProgramVariable v) {
		return v.name
	}

	private def dispatch getKey(Const c) {
		return c.name
	}

	private def dispatch getKey(Port r) {
		return r.name
	}

	private def dispatch getKey(Enum en) {
		return en.identifier
	}

	override getProcessVariableId(Process proc, ProcessVariable v) {
		val procKey = getKey(proc)
		val varKey = getKey(v)
		if (!varIdentifiers.containsKey(procKey)) {
			varIdentifiers.put(procKey, new HashMap)
		}
		val procMap = varIdentifiers.get(procKey)
		if (procMap.containsKey(varKey)) {
			return procMap.get(varKey)
		} else {
			val value = '''P«proc.index»V«procMap.size»'''
			procMap.put(varKey, value)
			identifiers.put(varKey, value)
			return value
		}
	}

	override getConstantId(Const c) {
		val key = getKey(c).toString
		if (constIdentifiers.containsKey(key)) {
			return constIdentifiers.get(key)
		} else {
			val value = '''C_«constIdentifiers.size»'''
			constIdentifiers.put(key, value)
			identifiers.put(key, value)
			return value
		}
	}

	override getPortId(Port reg) {
		val key = getKey(reg)
		if (portIdentifiers.containsKey(key)) {
			return portIdentifiers.get(key)
		} else {
			val value = '''P«reg.type.literal.toUpperCase.charAt(0)»«portIdentifiers.size»'''
			portIdentifiers.put(key, value)
			return value
		}
	}

	override getProcessFuncId(Process proc) {
		return '''P«proc.index»'''
	}

	override getEnumId(Enum en) {
		val key = getKey(en)
		if (enumIdentifiers.containsKey(key)) {
			return enumIdentifiers.get(key)
		} else {
			val value = '''EN«enumIdentifiers.size»'''
			enumIdentifiers.put(key, value)
			return value
		}
	}

	override getEnumMemberId(EnumMember em) {
		val key = em.getName
		if (constIdentifiers.containsKey(key)) {
			return constIdentifiers.get(key)
		} else {
			val value = '''C_«constIdentifiers.size»'''
			constIdentifiers.put(key, value)
			identifiers.put(key, value)
			return value
		}
	}

	override getGlobalVariableId(GlobalVariable v) {
		val key = getKey(v)
		if (globalVarIdentifiers.containsKey(key)) {
			return globalVarIdentifiers.get(key)
		} else {
			val value = '''GV«globalVarIdentifiers.size»'''
			globalVarIdentifiers.put(key, value)
			identifiers.put(key, value)
			return value
		}
	}

	override getMapping(IdReference original) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
