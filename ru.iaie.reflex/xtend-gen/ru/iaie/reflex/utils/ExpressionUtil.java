package ru.iaie.reflex.utils;

import ru.iaie.reflex.reflex.AssignmentExpression;
import ru.iaie.reflex.reflex.Expression;
import ru.iaie.reflex.reflex.PrimaryExpression;

@SuppressWarnings("all")
public class ExpressionUtil {
  public static boolean hasAssignment(final AssignmentExpression e) {
    String _assignVar = e.getAssignVar();
    return (_assignVar != null);
  }
  
  public static boolean isVariableReference(final PrimaryExpression e) {
    String _varId = e.getVarId();
    return (_varId != null);
  }
  
  public static boolean isNestedExpr(final PrimaryExpression e) {
    Expression _nestedExpr = e.getNestedExpr();
    return (_nestedExpr != null);
  }
}
