package ru.iaie.reflex.utils

import ru.iaie.reflex.reflex.AssignmentExpression
import ru.iaie.reflex.reflex.PrimaryExpression
import ru.iaie.reflex.reflex.Expression
import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension ru.iaie.reflex.utils.ReflexModelUtil.*
import static extension ru.iaie.reflex.typing.TypeUtils.*

import ru.iaie.reflex.reflex.IdReference
import ru.iaie.reflex.reflex.ProgramVariable
import ru.iaie.reflex.reflex.PhysicalVariable
import ru.iaie.reflex.reflex.FunctionCall
import ru.iaie.reflex.reflex.Type
import java.util.List
import ru.iaie.reflex.typing.TypeWarning
import ru.iaie.reflex.reflex.InfixOp
import ru.iaie.reflex.reflex.PostfixOp
import org.eclipse.emf.ecore.EObject
import ru.iaie.reflex.reflex.UnaryExpression
import ru.iaie.reflex.reflex.CastExpression
import ru.iaie.reflex.reflex.CheckStateExpression
import ru.iaie.reflex.reflex.MultiplicativeExpression
import ru.iaie.reflex.reflex.AdditiveExpression
import ru.iaie.reflex.reflex.ShiftExpression
import ru.iaie.reflex.reflex.CompareExpression
import ru.iaie.reflex.reflex.EqualityExpression
import ru.iaie.reflex.reflex.BitAndExpression
import ru.iaie.reflex.reflex.BitXorExpression
import ru.iaie.reflex.reflex.BitOrExpression
import ru.iaie.reflex.reflex.LogicalAndExpression
import ru.iaie.reflex.reflex.LogicalOrExpression
import ru.iaie.reflex.typing.TypeUtils.OperationType
import ru.iaie.reflex.typing.TypeUtils.TypeIssue

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

	static def boolean isInteger(PrimaryExpression e) {
		return e.integer !== null
	}

	static def boolean isFloating(PrimaryExpression e) {
		return e.floating !== null
	}

	static def boolean isTime(PrimaryExpression e) {
		return e.time !== null
	}

	static def boolean hasFunctionCall(Expression e) {
		!e.eAllOfType(FunctionCall).empty
	}

	static def boolean isConstExpr(Expression e) {
		(e.eAllOfType(IdReference).filter(ref|ref instanceof ProgramVariable || ref instanceof PhysicalVariable).
			empty && e.eAllOfType(FunctionCall).empty)
	}

	private static def Type resolveExprType(EObject expr, List<TypeWarning> warnings) {
		switch (expr) {
			InfixOp:
				return resolveExprType(expr.ref, warnings)
			PostfixOp:
				return resolveExprType(expr.ref, warnings)
			FunctionCall:
				return expr.function.returnType
			IdReference:
				return expr.resolveType
			PrimaryExpression: {
				if(expr.isNestedExpr) return resolveExprType(expr.nestedExpr, warnings)
				if (expr.isBoolean) {
					return Type.BOOL
				}
				if (expr.isReference) {
					return resolveExprType(expr.reference, warnings)
				}
				if (expr.isInteger) {
					return defaultIntLiteralType
				}
				if (expr.isFloating) {
					return Type.FLOAT
				}
			}
			UnaryExpression: {
				val exprType = resolveExprType(expr.right, warnings)
				try {
					doUnaryTypeChecking(expr.operationType, exprType)
				} catch (TypeIssue i) {
					warnings.add(new TypeWarning(i.message, expr))
				}
				return exprType
			}
			CastExpression: {
				// Allow all casts for now
				val fromType = resolveExprType(expr.right, warnings)
				if (!fromType.canBeSafelyCastedTo(expr.type)) {
					warnings.add(new TypeWarning('''Cast from «fromType» to «expr.type» is not safe''', expr))
				}
				return expr.type

			}
			CheckStateExpression:
				return Type.BOOL
			AssignmentExpression: {
				if (expr.hasAssignment) {
					val assignType = resolveExprType(expr.assignVar, warnings)
					val valueType = resolveExprType(expr.expr, warnings)
					if (!valueType.canBeSafelySignedTo(assignType)) {
						warnings.add(
							new TypeWarning('''Assign variable type «assignType» is incompitable with assigned expression type «valueType»''',
								expr))
					}
					return assignType
				}
				return resolveExprType(expr.expr, warnings)
			}
			default:
				resolveBinaryExprType(expr, warnings)
		}
	}

	private static def Type resolveBinaryExprType(EObject expr, List<TypeWarning> warnings) {
		var EObject left
		var EObject right
		var OperationType exprOpType
		switch (expr) {
			MultiplicativeExpression: {
				left = expr.left
				right = expr.right
				exprOpType = OperationType.ARITHMETIC
			}
			AdditiveExpression: {
				left = expr.left
				right = expr.right
				exprOpType = OperationType.ARITHMETIC
			}
			ShiftExpression: {
				left = expr.left
				right = expr.right
				exprOpType = OperationType.BIT
			}
			CompareExpression: {
				left = expr.left
				right = expr.right
				exprOpType = OperationType.COMPARE
			}
			EqualityExpression: {
				left = expr.left
				right = expr.right
				exprOpType = OperationType.EQ
			}
			BitAndExpression: {
				left = expr.left
				right = expr.right
				exprOpType = OperationType.BIT
			}
			BitXorExpression: {
				left = expr.left
				right = expr.right
				exprOpType = OperationType.BIT
			}
			BitOrExpression: {
				left = expr.left
				right = expr.right
				exprOpType = OperationType.BIT
			}
			LogicalAndExpression: {
				left = expr.left
				right = expr.right
				exprOpType = OperationType.LOGICAL
			}
			LogicalOrExpression: {
				left = expr.left
				right = expr.right
				exprOpType = OperationType.LOGICAL
			}
		}
		if (left === null || right === null) {
			// This only may happen during real-time source code editing 
			// This means that code is syntactically incorrect 
			throw new IllegalStateException();
		}
		val leftType = resolveExprType(left, warnings)
		val rightType = resolveExprType(right, warnings)
		try {
			doBinaryTypeChecking(exprOpType, leftType, rightType)
		} catch (TypeIssue i) {
			warnings.add(new TypeWarning(i.message, expr))
		}

		return max(leftType, rightType)
	}

	static def Type resolveType(Expression expr, List<TypeWarning> warnings) {
		return resolveExprType(expr, warnings)
	}

	static def Type resolveType(Expression expr) {
		return resolveExprType(expr, newArrayList())
	}

	static def OperationType getOperationType(UnaryExpression e) {
		switch (e.unaryOp) {
			case BIT_NOT: {
				return OperationType.BIT
			}
			case LOGICAL_NOT: {
				return OperationType.LOGICAL
			}
			case MINUS: {
				return OperationType.ARITHMETIC
			}
			case PLUS: {
				return OperationType.ARITHMETIC
			}
		}
	}

}
