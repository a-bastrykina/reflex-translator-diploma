package ru.iaie.reflex.utils

import ru.iaie.reflex.reflex.AssignmentExpression
import ru.iaie.reflex.reflex.PrimaryExpression

class ExpressionUtil {
	static def boolean hasAssignment(AssignmentExpression e) {
		return e.assignVar !== null
	}
	
	static def boolean isVariableReference(PrimaryExpression e) {
		return e.varId !== null
	}
	
	static def boolean isNestedExpr(PrimaryExpression e) {
		return e.nestedExpr !== null
	}
	
}