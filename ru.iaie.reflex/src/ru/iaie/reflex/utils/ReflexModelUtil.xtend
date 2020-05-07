package ru.iaie.reflex.utils

import ru.iaie.reflex.reflex.Process;
import ru.iaie.reflex.reflex.Program;
import ru.iaie.reflex.reflex.State;
import org.eclipse.emf.ecore.resource.Resource
import ru.iaie.reflex.reflex.EnumMember
import ru.iaie.reflex.reflex.StopProcStat
import ru.iaie.reflex.reflex.ErrorStat
import ru.iaie.reflex.reflex.ProcessVariable
import ru.iaie.reflex.reflex.ImportedVariableList
import ru.iaie.reflex.reflex.ProgramVariable
import ru.iaie.reflex.reflex.PhysicalVariable
import ru.iaie.reflex.reflex.IdReference
import ru.iaie.reflex.reflex.Const
import ru.iaie.reflex.reflex.TimeoutFunction
import ru.iaie.reflex.reflex.DeclaredVariable
import ru.iaie.reflex.reflex.RegisterType
import org.eclipse.xtext.EcoreUtil2.ElementReferenceAcceptor
import static org.eclipse.xtext.EcoreUtil2.*
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import ru.iaie.reflex.reflex.GlobalVariable
import java.util.List
import ru.iaie.reflex.reflex.Type
import ru.iaie.reflex.reflex.ReflexPackage
import ru.iaie.reflex.reflex.Types

class ReflexModelUtil {
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

	def static List<DeclaredVariable> getDeclaredVariables(Process p) {
		return p.variables.filter(DeclaredVariable).toList
	}

	def static List<DeclaredVariable> getImportedVariables(Process p) {
		return p.imports.map[variables].flatten.toList
	}

	def static List<ImportedVariableList> getImports(Process p) {
		return p.variables.filter(ImportedVariableList).toList
	}

	def static boolean isDeclared(ProcessVariable v) {
		return v instanceof DeclaredVariable
	}

	def static Type getType(ProcessVariable v) {
		if (v instanceof PhysicalVariable) return v.type
		if (v instanceof ProgramVariable) return v.type
	}
	
	def static Type getType(GlobalVariable v) {
		if (v instanceof PhysicalVariable) return v.type
		if (v instanceof ProgramVariable) return v.type
	}

	def static String getName(GlobalVariable v) {
		if (v instanceof ProgramVariable) return v.name
		if (v instanceof PhysicalVariable) return v.name
	}

	def static String getName(DeclaredVariable v) {
		if(v instanceof ProgramVariable) return v.name
		if(v instanceof PhysicalVariable) return v.name
	}

	def static boolean isImportedList(ProcessVariable v) {
		return v instanceof ImportedVariableList
	}

	def static boolean isPhysical(ProcessVariable v) {
		return v instanceof PhysicalVariable
	}

	def static RegisterType getMappedPortType(PhysicalVariable v) {
		return v.port.register.type
	}

	def static boolean containsReferencesOfType(EObject context, EObject target, EReference refType) {
		val targetSet = newHashSet(target)
		val refered = newArrayList()
		val ElementReferenceAcceptor acceptor = [ EObject referrer, EObject referenced, EReference reference, int index |
			if (reference == refType) {
				refered.add(referrer)
			}
		]
		findCrossReferences(context, targetSet, acceptor)
		return !refered.empty
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

	def static boolean isCType(Type type) {
		return type.name != Types.BOOL_TYPE
	}

	def static hasModifier(Type type) {
		return type.sign !== null
	}
}
