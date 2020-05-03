/*
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import ru.iaie.reflex.reflex.IdReference
import ru.iaie.reflex.reflex.ImportedVariable
import ru.iaie.reflex.reflex.Process
import ru.iaie.reflex.reflex.Program
import ru.iaie.reflex.reflex.ReflexPackage
import ru.iaie.reflex.reflex.SetStateStat

import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension ru.iaie.reflex.utils.ReflexModelUtil.*
import java.util.ArrayList
import ru.iaie.reflex.reflex.PrimaryExpression
import ru.iaie.reflex.reflex.AssignmentExpression

/** 
 * This class contains custom scoping description.
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class ReflexScopeProvider extends AbstractReflexScopeProvider {

	val ePackage = ReflexPackage.eINSTANCE

	override IScope getScope(EObject ctx, EReference ref) {
		if (ctx instanceof SetStateStat && ref == ePackage.setStateStat_State) {
			val candidates = ctx.getContainerOfType(Process).states;
			return Scopes.scopeFor(candidates);
		}
		if (ctx instanceof ImportedVariable && ref == ePackage.importedVariable_Variables) {
			val candidates = (ctx as ImportedVariable).process.variables.filter[shared]
			return Scopes.scopeFor(candidates)
		}
		if (ctx instanceof PrimaryExpression) {
			if (ref == ePackage.primaryExpression_Reference) {
				val prog = ctx.getContainerOfType(Program)
				val proc = ctx.getContainerOfType(Process)

				val candidates = new ArrayList<EObject>
				candidates.addAll(prog.enums.map[enumMembers].flatten)
				candidates.addAll(prog.consts)
				candidates.addAll(prog.globalVars)
				if (proc !== null) {
					candidates.addAll(proc.variables.filter[declared])
					candidates.addAll(proc.variables.filter(ImportedVariable).map[variables].flatten)
				}

				return Scopes.scopeFor(candidates)
			}
		}
		if (ctx instanceof AssignmentExpression) {
			if (ref == ePackage.assignmentExpression_AssignVar) {
				val prog = ctx.getContainerOfType(Program)
				val proc = ctx.getContainerOfType(Process)

				val candidates = new ArrayList<EObject>
				candidates.addAll(prog.globalVars)
				if (proc !== null) {
					candidates.addAll(proc.variables.filter[declared])
					candidates.addAll(proc.variables.filter(ImportedVariable).map[variables].flatten)
				}

				return Scopes.scopeFor(candidates)
			}
		}
		return super.getScope(ctx, ref)
	}
}
