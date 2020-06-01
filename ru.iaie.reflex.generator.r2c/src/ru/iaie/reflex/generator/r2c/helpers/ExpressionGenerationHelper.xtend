package ru.iaie.reflex.generator.r2c.helpers

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import ru.iaie.reflex.reflex.AdditiveExpression
import ru.iaie.reflex.reflex.AssignmentExpression
import ru.iaie.reflex.reflex.BitAndExpression
import ru.iaie.reflex.reflex.BitOrExpression
import ru.iaie.reflex.reflex.BitXorExpression
import ru.iaie.reflex.reflex.CastExpression
import ru.iaie.reflex.reflex.CompareExpression
import ru.iaie.reflex.reflex.EqualityExpression
import ru.iaie.reflex.reflex.FunctionCall
import ru.iaie.reflex.reflex.InfixOp
import ru.iaie.reflex.reflex.LogicalAndExpression
import ru.iaie.reflex.reflex.LogicalOrExpression
import ru.iaie.reflex.reflex.MultiplicativeExpression
import ru.iaie.reflex.reflex.PostfixOp
import ru.iaie.reflex.reflex.PrimaryExpression
import ru.iaie.reflex.reflex.ShiftExpression
import ru.iaie.reflex.reflex.UnaryExpression

import static extension ru.iaie.reflex.utils.ExpressionUtil.*
import static extension ru.iaie.reflex.utils.ReflexModelUtil.*
import ru.iaie.reflex.reflex.IdReference
import ru.iaie.reflex.reflex.CheckStateExpression
import ru.iaie.reflex.generator.r2c.interfaces.IReflexIdentifiersHelper
import ru.iaie.reflex.generator.r2c.util.LiteralGenerationUtil

class ExpressionGenerationHelper {
	val IReflexIdentifiersHelper identifiersHelper

	new(IReflexIdentifiersHelper ih) {
		this.identifiersHelper = ih;
	}

	def String translateExpr(EObject expr) {
		switch (expr) {
			InfixOp:
				return '''«expr.op» «identifiersHelper.getMapping(expr.ref)»'''
			PostfixOp:
				return '''«identifiersHelper.getMapping(expr.ref)» «expr.op»'''
			FunctionCall:
				return '''«expr.function.name»(«String.join(",", expr.args.map[translateExpr])»)'''
			IdReference:
				return '''«identifiersHelper.getMapping(expr)»'''
			PrimaryExpression: {
				if(expr.isNestedExpr) return '''(«translateExpr(expr.nestedExpr)»)'''
				if (expr.isBoolean) {
					return LiteralGenerationUtil.translateBoolLiteral(expr.bool)
				}
				if (expr.isReference) {
					return translateExpr(expr.reference)
				}
				if (expr.isTime) {
					return LiteralGenerationUtil.translateTime(expr.time)
				}
				return NodeModelUtils.getNode(expr).text.trim
			}
			UnaryExpression:
				return '''«expr.unaryOp» «translateExpr(expr.right)»'''
			CastExpression:
				return '''(«LiteralGenerationUtil.translateType(expr.type)») «translateExpr(expr.right)»'''
			MultiplicativeExpression:
				return '''«translateExpr(expr.left)» «expr.mulOp» «translateExpr(expr.right)»'''
			AdditiveExpression:
				return '''«translateExpr(expr.left)» «expr.addOp» «translateExpr(expr.right)»'''
			CheckStateExpression:
				return translateCheckStateExpression(expr)
			ShiftExpression:
				return '''«translateExpr(expr.left)» «expr.shiftOp» «translateExpr(expr.right)»'''
			CompareExpression:
				return '''«translateExpr(expr.left)» «expr.cmpOp» «translateExpr(expr.right)»'''
			EqualityExpression:
				return '''«translateExpr(expr.left)» «expr.eqCmpOp» «translateExpr(expr.right)»'''
			BitAndExpression:
				return '''«translateExpr(expr.left)» & «translateExpr(expr.right)»'''
			BitXorExpression:
				return '''«translateExpr(expr.left)» ^ «translateExpr(expr.right)»'''
			BitOrExpression:
				return '''«translateExpr(expr.left)» | «translateExpr(expr.right)»'''
			LogicalAndExpression:
				return '''«translateExpr(expr.left)» && «translateExpr(expr.right)»'''
			LogicalOrExpression:
				return '''«translateExpr(expr.left)» || «translateExpr(expr.right)»'''
			AssignmentExpression: {
				if (expr.hasAssignment)
					return '''«translateExpr(expr.assignVar)» «expr.assignOp» «translateExpr(expr.expr)»'''
				return '''«translateExpr(expr.expr)»'''
			}
		}
	}

	def translateCheckStateExpression(CheckStateExpression cse) {
		switch (cse.qualfier) {
			case STOP:
				return '''is_stop(«cse.process.index»)'''
			case ERROR:
				return '''is_error(«cse.process.index»)'''
			case ACTIVE:
				return '''is_active(«cse.process.index»)'''
			case INACTIVE:
				return '''is_inactive(«cse.process.index»)'''
		}
	}
}
