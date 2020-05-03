package ru.iaie.reflex.utils

import ru.iaie.reflex.reflex.Process;
import ru.iaie.reflex.reflex.Program;
import ru.iaie.reflex.reflex.State;
import org.eclipse.emf.ecore.resource.Resource
import ru.iaie.reflex.reflex.EnumMember
import ru.iaie.reflex.reflex.StopProcStat
import ru.iaie.reflex.reflex.ErrorStat
import ru.iaie.reflex.reflex.ProcessVariable
import ru.iaie.reflex.reflex.ImportedVariable
import ru.iaie.reflex.reflex.ProgramVariable
import ru.iaie.reflex.reflex.PhysicalVariable
import ru.iaie.reflex.reflex.IdReference
import ru.iaie.reflex.reflex.Const
import ru.iaie.reflex.reflex.TimeoutFunction
import ru.iaie.reflex.reflex.DeclaredVariable

class ReflexModelUtil {
	def static State findStateByName(Process proc, String stateName) {
		val matchingStates = proc.states.filter[name.equals(stateName)].toList
		if(matchingStates.isEmpty) return null;
		return matchingStates.get(0)
	}

	def static Process findProcessByName(Program prog, String procName) {
		val matchingProcs = prog.processes.filter[name.equals(procName)].toList
		if(matchingProcs.isEmpty) return null;
		return matchingProcs.get(0)
	}

	def static Program getProgram(Resource resource) {
		return resource.allContents.toIterable.filter(Program).get(0);
	}

	def static boolean hasValue(EnumMember em) {
		return em.value !== null
	}

	def static boolean selfStop(StopProcStat sps) {
		return sps.process === null
	}

	def static boolean selfError(ErrorStat es) {
		return es.process === null
	}
	
	def static boolean isClearTimeout(TimeoutFunction f) {
		return f.time !== null
	}
	
	def static boolean isReferencedTimeout(TimeoutFunction f) {
		return f.ref !== null
	}
	
	def static boolean hasTimeout(State s) {
		return s.timeoutFunction !== null
	}
	
	def static boolean isShared(ProcessVariable v) {
		switch v {
			ProgramVariable:
				return v.shared
			PhysicalVariable:
				return v.shared
		}
		return false
	}
	
	def static boolean isDeclared(ProcessVariable v) {
		return v instanceof DeclaredVariable
	}
	
	def static boolean isImportedList(ProcessVariable v) {
		return v instanceof ImportedVariable
	}
	
	def static String resolveName(IdReference ref) {
		switch ref {
			ProgramVariable:
				return ref.name
			PhysicalVariable:
				return ref.name
			EnumMember:
				return ref.name
			Const:
				return ref.name
		}
	}

}
