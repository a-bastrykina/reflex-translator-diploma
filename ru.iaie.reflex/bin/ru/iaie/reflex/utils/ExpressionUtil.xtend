package ru.iaie.reflex.utils

import ru.iaie.reflex.reflex.AssignmentExpression
import ru.iaie.reflex.reflex.PrimaryExpression
import ru.iaie.reflex.reflex.Expression
import static extension org.eclipse.xtext.EcoreUtil2.*
import ru.iaie.reflex.reflex.IdReference
import ru.iaie.reflex.reflex.ProgramVariable
import ru.iaie.reflex.reflex.PhysicalVariable
import ru.iaie.reflex.reflex.FunctionCall

class ExpressionUtil {
	static def boolean hasAssignment(AssignmentExpression e) {
		return e.assignVar !== null
	}

	static def boolean isReference(PrimaryExpression e) {
		return e.reference !== null
	}

	static def boolean isNestedExpr(PrimaryExpression e) {
		return e.nestedExpr !== null
	}

	static def boolean isBoolean(PrimaryExpression e) {
		return e.bool !== null
	}

	static def boolean hasFunctionCall(Expression e) {
		!e.eAllOfType(FunctionCall).empty
	}

	static def boolean isConstExpr(Expression e) {
		(e.eAllOfType(IdReference).filter(ref|ref instanceof ProgramVariable || ref instanceof PhysicalVariable).
			empty && e.eAllOfType(FunctionCall).empty)
	}
}
