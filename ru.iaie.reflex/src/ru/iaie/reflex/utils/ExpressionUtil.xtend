package ru.iaie.reflex.utils

import ru.iaie.reflex.reflex.AssignmentExpression
import ru.iaie.reflex.reflex.PrimaryExpression

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
	
}