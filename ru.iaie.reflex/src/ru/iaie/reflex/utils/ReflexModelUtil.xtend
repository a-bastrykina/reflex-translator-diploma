package ru.iaie.reflex.utils
import ru.iaie.reflex.reflex.Process;
import ru.iaie.reflex.reflex.Program;
import ru.iaie.reflex.reflex.State;
import org.eclipse.emf.ecore.resource.Resource
import ru.iaie.reflex.reflex.EnumMember
import ru.iaie.reflex.reflex.StopProcStat
import ru.iaie.reflex.reflex.ErrorStat

class ReflexModelUtil {
	def static State findStateByName(Process proc, String stateName) {
		val matchingStates = proc.states.filter[name.equals(stateName)].toList
		if (matchingStates.isEmpty) return null;
		return matchingStates.get(0)
	}
	
	def static Process findProcessByName(Program prog, String procName) {
		val matchingProcs = prog.processes.filter[name.equals(procName)].toList
		if (matchingProcs.isEmpty) return null;
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
	
	def static boolean selfError(ErrorStat sps) {
		return sps.process === null
	}
	
}