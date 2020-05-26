package ru.iaie.reflex.generator.r2c.helpers

import ru.iaie.reflex.reflex.Process
import ru.iaie.reflex.reflex.Const
import ru.iaie.reflex.reflex.Enum
import ru.iaie.reflex.reflex.EnumMember
import ru.iaie.reflex.reflex.GlobalVariable
import java.util.Map
import java.util.HashMap
import ru.iaie.reflex.reflex.IdReference
import ru.iaie.reflex.reflex.ProcessVariable
import static extension ru.iaie.reflex.utils.ReflexModelUtil.*
import static extension org.eclipse.xtext.EcoreUtil2.*
import ru.iaie.reflex.reflex.PhysicalVariable
import ru.iaie.reflex.reflex.ProgramVariable
import ru.iaie.reflex.reflex.Port
import ru.iaie.reflex.reflex.PortType
import ru.iaie.reflex.generator.r2c.interfaces.IReflexIdentifiersHelper

class ReflexIdentifiersHelper implements IReflexIdentifiersHelper {
	val Map<String, Map<String, String>> procVarIdentifiers = newHashMap()
	val Map<String, String> globalVarIdentifiers = newHashMap()
	val Map<String, String> constIdentifiers = newHashMap()
	val Map<String, String> portIdentifiers = newHashMap()
	val Map<String, String> enumIdentifiers = newHashMap()

	override getProcessFuncId(Process proc) {
		return '''_p_«proc.name»'''
	}

	override getProcessVariableId(Process proc, ProcessVariable v) {
		val procKey = proc.name
		val varKey = v.name
		if (!procVarIdentifiers.containsKey(procKey)) {
			procVarIdentifiers.put(procKey, new HashMap)
		}
		val procMap = procVarIdentifiers.get(procKey)
		if (procMap.containsKey(varKey)) {
			return procMap.get(varKey)
		} else {
			val value = '''_p_«proc.name»_v_«v.name»'''
			procMap.put(varKey, value)
			return value
		}
	}

	override getConstantId(Const c) {
		val key = c.name
		if (constIdentifiers.containsKey(key)) {
			return constIdentifiers.get(key)
		} else {
			val value = '''_c_«c.name»'''
			constIdentifiers.put(key, value)
			return value
		}
	}

	override getPortId(Port port) {
		val key = port.name
		if (portIdentifiers.containsKey(key)) {
			return portIdentifiers.get(key)
		} else {
			val value = '''_«port.type == PortType.INPUT ? "i" : "o"»_«port.name»'''
			portIdentifiers.put(key, value)
			return value
		}
	}

	override getEnumId(Enum en) {
		val key = en.identifier
		if (enumIdentifiers.containsKey(key)) {
			return enumIdentifiers.get(key)
		} else {
			val value = '''_e_«en.identifier»'''
			enumIdentifiers.put(key, value)
			return value
		}
	}

	override getEnumMemberId(EnumMember em) {
		val key = em.name
		if (constIdentifiers.containsKey(key)) {
			return constIdentifiers.get(key)
		} else {
			val value = '''_e_em_«em.name»'''
			constIdentifiers.put(key, value)
			return value
		}
	}

	override getGlobalVariableId(GlobalVariable v) {
		val key = v.name
		if (globalVarIdentifiers.containsKey(key)) {
			return globalVarIdentifiers.get(key)
		} else {
			val value = '''_g_«v.name»'''
			globalVarIdentifiers.put(key, value)
			return value
		}
	}

	override getMapping(IdReference ref) {
		if (ref instanceof PhysicalVariable || ref instanceof ProgramVariable) {
			val proc = ref.getContainerOfType(Process)
			if (proc === null) return getGlobalVariableId(ref as GlobalVariable)
			return getProcessVariableId(ref.getContainerOfType(Process), ref as ProcessVariable)
		}
		if (ref instanceof Const) return getConstantId(ref)
		if (ref instanceof EnumMember) return getEnumMemberId(ref)
	}

}
