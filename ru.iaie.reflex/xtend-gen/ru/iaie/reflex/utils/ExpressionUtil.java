package ru.iaie.reflex.utils;

import ru.iaie.reflex.reflex.AssignmentExpression;
import ru.iaie.reflex.reflex.Expression;
import ru.iaie.reflex.reflex.IdReference;
import ru.iaie.reflex.reflex.PrimaryExpression;

@SuppressWarnings("all")
public class ExpressionUtil {
  public static boolean hasAssignment(final AssignmentExpression e) {
    IdReference _assignVar = e.getAssignVar();
    return (_assignVar != null);
  }
  
  public static boolean isReference(final PrimaryExpression e) {
    IdReference _reference = e.getReference();
    return (_reference != null);
  }
  
  public static boolean isNestedExpr(final PrimaryExpression e) {
    Expression _nestedExpr = e.getNestedExpr();
    return (_nestedExpr != null);
  }
}
