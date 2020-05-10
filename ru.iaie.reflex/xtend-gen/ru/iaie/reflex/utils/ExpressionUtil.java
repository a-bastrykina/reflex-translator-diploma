package ru.iaie.reflex.utils;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import ru.iaie.reflex.reflex.AssignmentExpression;
import ru.iaie.reflex.reflex.Expression;
import ru.iaie.reflex.reflex.FunctionCall;
import ru.iaie.reflex.reflex.IdReference;
import ru.iaie.reflex.reflex.PhysicalVariable;
import ru.iaie.reflex.reflex.PrimaryExpression;
import ru.iaie.reflex.reflex.ProgramVariable;

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
  
  public static boolean isBoolean(final PrimaryExpression e) {
    Boolean _bool = e.getBool();
    return (_bool != null);
  }
  
  public static boolean hasFunctionCall(final Expression e) {
    boolean _isEmpty = EcoreUtil2.<FunctionCall>eAllOfType(e, FunctionCall.class).isEmpty();
    return (!_isEmpty);
  }
  
  public static boolean isConstExpr(final Expression e) {
    final Function1<IdReference, Boolean> _function = (IdReference ref) -> {
      return Boolean.valueOf(((ref instanceof ProgramVariable) || (ref instanceof PhysicalVariable)));
    };
    return IterableExtensions.isEmpty(IterableExtensions.<IdReference>filter(EcoreUtil2.<IdReference>eAllOfType(e, IdReference.class), _function));
  }
}
