package ru.iaie.reflex.utils;

import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import ru.iaie.reflex.reflex.AdditiveExpression;
import ru.iaie.reflex.reflex.AssignmentExpression;
import ru.iaie.reflex.reflex.BitAndExpression;
import ru.iaie.reflex.reflex.BitOrExpression;
import ru.iaie.reflex.reflex.BitXorExpression;
import ru.iaie.reflex.reflex.CastExpression;
import ru.iaie.reflex.reflex.CheckStateExpression;
import ru.iaie.reflex.reflex.CompareExpression;
import ru.iaie.reflex.reflex.EqualityExpression;
import ru.iaie.reflex.reflex.Expression;
import ru.iaie.reflex.reflex.FunctionCall;
import ru.iaie.reflex.reflex.IdReference;
import ru.iaie.reflex.reflex.InfixOp;
import ru.iaie.reflex.reflex.LogicalAndExpression;
import ru.iaie.reflex.reflex.LogicalOrExpression;
import ru.iaie.reflex.reflex.MultiplicativeExpression;
import ru.iaie.reflex.reflex.PhysicalVariable;
import ru.iaie.reflex.reflex.PostfixOp;
import ru.iaie.reflex.reflex.PrimaryExpression;
import ru.iaie.reflex.reflex.ProgramVariable;
import ru.iaie.reflex.reflex.ShiftExpression;
import ru.iaie.reflex.reflex.Type;
import ru.iaie.reflex.reflex.UnaryExpression;
import ru.iaie.reflex.typing.TypeUtils;
import ru.iaie.reflex.typing.TypeWarning;
import ru.iaie.reflex.utils.ReflexModelUtil;

@SuppressWarnings("all")
public class ExpressionUtil {
  public enum ExpressionType {
    ARITHMETIC,
    
    LOGICAL,
    
    BIT,
    
    COMPARE,
    
    EQ;
  }
  
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
  
  public static boolean isInteger(final PrimaryExpression e) {
    String _integer = e.getInteger();
    return (_integer != null);
  }
  
  public static boolean isFloating(final PrimaryExpression e) {
    String _floating = e.getFloating();
    return (_floating != null);
  }
  
  public static boolean isTime(final PrimaryExpression e) {
    String _time = e.getTime();
    return (_time != null);
  }
  
  public static boolean hasFunctionCall(final Expression e) {
    boolean _isEmpty = EcoreUtil2.<FunctionCall>eAllOfType(e, FunctionCall.class).isEmpty();
    return (!_isEmpty);
  }
  
  public static boolean isConstExpr(final Expression e) {
    return (IterableExtensions.isEmpty(IterableExtensions.<IdReference>filter(EcoreUtil2.<IdReference>eAllOfType(e, IdReference.class), ((Function1<IdReference, Boolean>) (IdReference ref) -> {
      return Boolean.valueOf(((ref instanceof ProgramVariable) || (ref instanceof PhysicalVariable)));
    }))) && EcoreUtil2.<FunctionCall>eAllOfType(e, FunctionCall.class).isEmpty());
  }
  
  private static Type resolveExprType(final EObject expr, final List<TypeWarning> warnings) {
    Type _switchResult = null;
    boolean _matched = false;
    if (expr instanceof InfixOp) {
      _matched=true;
      return ExpressionUtil.resolveExprType(((InfixOp)expr).getRef(), warnings);
    }
    if (!_matched) {
      if (expr instanceof PostfixOp) {
        _matched=true;
        return ExpressionUtil.resolveExprType(((PostfixOp)expr).getRef(), warnings);
      }
    }
    if (!_matched) {
      if (expr instanceof FunctionCall) {
        _matched=true;
        return ((FunctionCall)expr).getFunction().getReturnType();
      }
    }
    if (!_matched) {
      if (expr instanceof IdReference) {
        _matched=true;
        return ReflexModelUtil.resolveType(((IdReference)expr));
      }
    }
    if (!_matched) {
      if (expr instanceof PrimaryExpression) {
        _matched=true;
        boolean _isNestedExpr = ExpressionUtil.isNestedExpr(((PrimaryExpression)expr));
        if (_isNestedExpr) {
          return ExpressionUtil.resolveExprType(((PrimaryExpression)expr).getNestedExpr(), warnings);
        }
        boolean _isBoolean = ExpressionUtil.isBoolean(((PrimaryExpression)expr));
        if (_isBoolean) {
          return Type.BOOL;
        }
        boolean _isReference = ExpressionUtil.isReference(((PrimaryExpression)expr));
        if (_isReference) {
          return ExpressionUtil.resolveExprType(((PrimaryExpression)expr).getReference(), warnings);
        }
        boolean _isInteger = ExpressionUtil.isInteger(((PrimaryExpression)expr));
        if (_isInteger) {
          return TypeUtils.getDefaultIntLiteralType();
        }
        boolean _isFloating = ExpressionUtil.isFloating(((PrimaryExpression)expr));
        if (_isFloating) {
          return Type.FLOAT;
        }
      }
    }
    if (!_matched) {
      if (expr instanceof UnaryExpression) {
        _matched=true;
        return ExpressionUtil.resolveExprType(((UnaryExpression)expr).getRight(), warnings);
      }
    }
    if (!_matched) {
      if (expr instanceof CastExpression) {
        _matched=true;
        final Type fromType = ExpressionUtil.resolveExprType(((CastExpression)expr).getRight(), warnings);
        boolean _canBeSafelyCastedTo = TypeUtils.canBeSafelyCastedTo(fromType, ((CastExpression)expr).getType());
        boolean _not = (!_canBeSafelyCastedTo);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Cast from ");
          _builder.append(fromType);
          _builder.append(" to ");
          Type _type = ((CastExpression)expr).getType();
          _builder.append(_type);
          _builder.append(" is not safe");
          TypeWarning _typeWarning = new TypeWarning(_builder.toString(), expr);
          warnings.add(_typeWarning);
        }
        return ((CastExpression)expr).getType();
      }
    }
    if (!_matched) {
      if (expr instanceof CheckStateExpression) {
        _matched=true;
        return Type.BOOL;
      }
    }
    if (!_matched) {
      if (expr instanceof AssignmentExpression) {
        _matched=true;
        boolean _hasAssignment = ExpressionUtil.hasAssignment(((AssignmentExpression)expr));
        if (_hasAssignment) {
          final Type assignType = ExpressionUtil.resolveExprType(((AssignmentExpression)expr).getAssignVar(), warnings);
          final Type valueType = ExpressionUtil.resolveExprType(((AssignmentExpression)expr).getExpr(), warnings);
          boolean _canBeSafelySignedTo = TypeUtils.canBeSafelySignedTo(valueType, assignType);
          boolean _not = (!_canBeSafelySignedTo);
          if (_not) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Assign variable type ");
            _builder.append(assignType);
            _builder.append(" is incompitable with assigned expression type ");
            _builder.append(valueType);
            TypeWarning _typeWarning = new TypeWarning(_builder.toString(), expr);
            warnings.add(_typeWarning);
          }
          return assignType;
        }
        return ExpressionUtil.resolveExprType(((AssignmentExpression)expr).getExpr(), warnings);
      }
    }
    if (!_matched) {
      _switchResult = ExpressionUtil.resolveBinaryExprType(expr, warnings);
    }
    return _switchResult;
  }
  
  private static Type resolveBinaryExprType(final EObject expr, final List<TypeWarning> warnings) {
    EObject left = null;
    EObject right = null;
    ExpressionUtil.ExpressionType exprType = null;
    boolean _matched = false;
    if (expr instanceof MultiplicativeExpression) {
      _matched=true;
      left = ((MultiplicativeExpression)expr).getLeft();
      right = ((MultiplicativeExpression)expr).getRight();
      exprType = ExpressionUtil.ExpressionType.ARITHMETIC;
    }
    if (!_matched) {
      if (expr instanceof AdditiveExpression) {
        _matched=true;
        left = ((AdditiveExpression)expr).getLeft();
        right = ((AdditiveExpression)expr).getRight();
        exprType = ExpressionUtil.ExpressionType.ARITHMETIC;
      }
    }
    if (!_matched) {
      if (expr instanceof ShiftExpression) {
        _matched=true;
        left = ((ShiftExpression)expr).getLeft();
        right = ((ShiftExpression)expr).getRight();
        exprType = ExpressionUtil.ExpressionType.BIT;
      }
    }
    if (!_matched) {
      if (expr instanceof CompareExpression) {
        _matched=true;
        left = ((CompareExpression)expr).getLeft();
        right = ((CompareExpression)expr).getRight();
        exprType = ExpressionUtil.ExpressionType.COMPARE;
      }
    }
    if (!_matched) {
      if (expr instanceof EqualityExpression) {
        _matched=true;
        left = ((EqualityExpression)expr).getLeft();
        right = ((EqualityExpression)expr).getRight();
        exprType = ExpressionUtil.ExpressionType.EQ;
      }
    }
    if (!_matched) {
      if (expr instanceof BitAndExpression) {
        _matched=true;
        left = ((BitAndExpression)expr).getLeft();
        right = ((BitAndExpression)expr).getRight();
        exprType = ExpressionUtil.ExpressionType.BIT;
      }
    }
    if (!_matched) {
      if (expr instanceof BitXorExpression) {
        _matched=true;
        left = ((BitXorExpression)expr).getLeft();
        right = ((BitXorExpression)expr).getRight();
        exprType = ExpressionUtil.ExpressionType.BIT;
      }
    }
    if (!_matched) {
      if (expr instanceof BitOrExpression) {
        _matched=true;
        left = ((BitOrExpression)expr).getLeft();
        right = ((BitOrExpression)expr).getRight();
        exprType = ExpressionUtil.ExpressionType.BIT;
      }
    }
    if (!_matched) {
      if (expr instanceof LogicalAndExpression) {
        _matched=true;
        left = ((LogicalAndExpression)expr).getLeft();
        right = ((LogicalAndExpression)expr).getRight();
        exprType = ExpressionUtil.ExpressionType.LOGICAL;
      }
    }
    if (!_matched) {
      if (expr instanceof LogicalOrExpression) {
        _matched=true;
        left = ((LogicalOrExpression)expr).getLeft();
        right = ((LogicalOrExpression)expr).getRight();
        exprType = ExpressionUtil.ExpressionType.LOGICAL;
      }
    }
    if (((left == null) || (right == null))) {
      throw new IllegalStateException();
    }
    final Type leftType = ExpressionUtil.resolveExprType(left, warnings);
    final Type rightType = ExpressionUtil.resolveExprType(right, warnings);
    return leftType;
  }
  
  public static Type resolveType(final Expression expr, final List<TypeWarning> warnings) {
    return ExpressionUtil.resolveExprType(expr, warnings);
  }
  
  public static Type resolveType(final Expression expr) {
    return ExpressionUtil.resolveExprType(expr, CollectionLiterals.<TypeWarning>newArrayList());
  }
}
