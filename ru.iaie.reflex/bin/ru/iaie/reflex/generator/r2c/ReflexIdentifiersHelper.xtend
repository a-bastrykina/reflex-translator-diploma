package ru.iaie.reflex.generator.r2c

import ru.iaie.reflex.reflex.Process
import ru.iaie.reflex.reflex.State
import ru.iaie.reflex.reflex.Variable
import ru.iaie.reflex.reflex.Const
import ru.iaie.reflex.reflex.Register
import java.util.Map
import java.util.HashMap
import ru.iaie.reflex.reflex.PhysicalVariable
import ru.iaie.reflex.reflex.ProgramVariable
import ru.iaie.reflex.reflex.Enum
import ru.iaie.reflex.reflex.EnumMember

class ReflexIdentifiersHelper implements IReflexCachedIdentifiersHelper {

	Map<String, String> procIdentifiers = new HashMap
	Map<String, Map<String, String>> stateIdentifiers = new HashMap
	Map<String, Map<String, String>> varIdentifiers = new HashMap
	Map<String, String> constIdentifiers = new HashMap
	Map<String, String> portIdentifiers = new HashMap
	Map<String, String> enumIdentifiers = new HashMap

	Map<String, String> identifiers = new HashMap

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
		return c.constId
	}
	
	private def dispatch getKey(Register r) {
		return r.name
	}
	
	private def dispatch getKey(Enum en) {
		return en.enumId
	}

	override getProcessId(Process proc) {
		if (procIdentifiers.containsKey(getKey(proc))) {
			return procIdentifiers.get(getKey(proc))
		} else {
			val value = '''«procIdentifiers.size»'''
			procIdentifiers.put(getKey(proc), value)
			return value
		}
	}
	
	override getStateId(Process proc, State state) {
		val procKey = getKey(proc)
		val stateKey = getKey(state)
		if (!stateIdentifiers.containsKey(procKey)) {
			stateIdentifiers.put(procKey, new HashMap)
		}
		val procMap = stateIdentifiers.get(procKey)
		if (procMap.containsKey(stateKey)) {
			return procMap.get(stateKey)
		} else {
			val value = '''«procMap.size»'''
			procMap.put(stateKey, value)
			return value
		}
	}

	override getVariableId(Process proc, Variable v) {
		val procKey = getKey(proc)
		val varKey = getKey(v)
		if (!varIdentifiers.containsKey(procKey)) {
			varIdentifiers.put(procKey, new HashMap)
		}
		val procMap = varIdentifiers.get(procKey)
		if (procMap.containsKey(varKey)) {
			return procMap.get(varKey)
		} else {
			val value = '''P«getProcessId(proc)»V«procMap.size»'''
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

	override getPortId(Register reg) {
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
		return '''P«getProcessId(proc)»'''
	}
	
	override clearCaches() {
		procIdentifiers.clear
		stateIdentifiers.clear
		varIdentifiers.clear
		constIdentifiers.clear
		portIdentifiers.clear
		enumIdentifiers.clear
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

	override getId(String original) {
		if (!identifiers.containsKey(original)) 
			throw new IllegalArgumentException('''Name «original» wasn't declared''')
		return identifiers.get(original)
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
	

}
