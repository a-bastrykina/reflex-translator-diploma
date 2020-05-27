package ru.iaie.reflex.generator.r2c.helpers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import ru.iaie.reflex.generator.r2c.LiteralGenerationUtil;
import ru.iaie.reflex.generator.r2c.interfaces.IReflexIdentifiersHelper;
import ru.iaie.reflex.reflex.AdditiveExpression;
import ru.iaie.reflex.reflex.AdditiveOp;
import ru.iaie.reflex.reflex.AssignOperator;
import ru.iaie.reflex.reflex.AssignmentExpression;
import ru.iaie.reflex.reflex.BitAndExpression;
import ru.iaie.reflex.reflex.BitOrExpression;
import ru.iaie.reflex.reflex.BitXorExpression;
import ru.iaie.reflex.reflex.CastExpression;
import ru.iaie.reflex.reflex.CheckStateExpression;
import ru.iaie.reflex.reflex.CompareEqOp;
import ru.iaie.reflex.reflex.CompareExpression;
import ru.iaie.reflex.reflex.CompareOp;
import ru.iaie.reflex.reflex.EqualityExpression;
import ru.iaie.reflex.reflex.Expression;
import ru.iaie.reflex.reflex.FunctionCall;
import ru.iaie.reflex.reflex.IdReference;
import ru.iaie.reflex.reflex.InfixOp;
import ru.iaie.reflex.reflex.InfixPostfixOp;
import ru.iaie.reflex.reflex.LogicalAndExpression;
import ru.iaie.reflex.reflex.LogicalOrExpression;
import ru.iaie.reflex.reflex.MultiplicativeExpression;
import ru.iaie.reflex.reflex.MultiplicativeOp;
import ru.iaie.reflex.reflex.PostfixOp;
import ru.iaie.reflex.reflex.PrimaryExpression;
import ru.iaie.reflex.reflex.ShiftExpression;
import ru.iaie.reflex.reflex.ShiftOp;
import ru.iaie.reflex.reflex.StateQualifier;
import ru.iaie.reflex.reflex.UnaryExpression;
import ru.iaie.reflex.reflex.UnaryOp;
import ru.iaie.reflex.utils.ExpressionUtil;
import ru.iaie.reflex.utils.ReflexModelUtil;

@SuppressWarnings("all")
public class ExpressionGenerationHelper {
  private final IReflexIdentifiersHelper identifiersHelper;
  
  public ExpressionGenerationHelper(final IReflexIdentifiersHelper ih) {
    this.identifiersHelper = ih;
  }
  
  public String translateExpr(final EObject expr) {
    boolean _matched = false;
    if (expr instanceof InfixOp) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      InfixPostfixOp _op = ((InfixOp)expr).getOp();
      _builder.append(_op);
      _builder.append(" ");
      String _mapping = this.identifiersHelper.getMapping(((InfixOp)expr).getRef());
      _builder.append(_mapping);
      return _builder.toString();
    }
    if (!_matched) {
      if (expr instanceof PostfixOp) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _mapping = this.identifiersHelper.getMapping(((PostfixOp)expr).getRef());
        _builder.append(_mapping);
        _builder.append(" ");
        InfixPostfixOp _op = ((PostfixOp)expr).getOp();
        _builder.append(_op);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof FunctionCall) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _name = ((FunctionCall)expr).getFunction().getName();
        _builder.append(_name);
        _builder.append("(");
        final Function1<Expression, String> _function = (Expression it) -> {
          return this.translateExpr(it);
        };
        String _join = String.join(",", ListExtensions.<Expression, String>map(((FunctionCall)expr).getArgs(), _function));
        _builder.append(_join);
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof IdReference) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _mapping = this.identifiersHelper.getMapping(((IdReference)expr));
        _builder.append(_mapping);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof PrimaryExpression) {
        _matched=true;
        boolean _isNestedExpr = ExpressionUtil.isNestedExpr(((PrimaryExpression)expr));
        if (_isNestedExpr) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("(");
          String _translateExpr = this.translateExpr(((PrimaryExpression)expr).getNestedExpr());
          _builder.append(_translateExpr);
          _builder.append(")");
          return _builder.toString();
        }
        boolean _isBoolean = ExpressionUtil.isBoolean(((PrimaryExpression)expr));
        if (_isBoolean) {
          return LiteralGenerationUtil.translateBoolLiteral(((PrimaryExpression)expr).getBool());
        }
        boolean _isReference = ExpressionUtil.isReference(((PrimaryExpression)expr));
        if (_isReference) {
          return this.translateExpr(((PrimaryExpression)expr).getReference());
        }
        boolean _isTime = ExpressionUtil.isTime(((PrimaryExpression)expr));
        if (_isTime) {
          return LiteralGenerationUtil.translateTime(((PrimaryExpression)expr).getTime());
        }
        return NodeModelUtils.getNode(expr).getText().trim();
      }
    }
    if (!_matched) {
      if (expr instanceof UnaryExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        UnaryOp _unaryOp = ((UnaryExpression)expr).getUnaryOp();
        _builder.append(_unaryOp);
        _builder.append(" ");
        String _translateExpr = this.translateExpr(((UnaryExpression)expr).getRight());
        _builder.append(_translateExpr);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof CastExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        String _translateType = LiteralGenerationUtil.translateType(((CastExpression)expr).getType());
        _builder.append(_translateType);
        _builder.append(") ");
        String _translateExpr = this.translateExpr(((CastExpression)expr).getRight());
        _builder.append(_translateExpr);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof MultiplicativeExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _translateExpr = this.translateExpr(((MultiplicativeExpression)expr).getLeft());
        _builder.append(_translateExpr);
        _builder.append(" ");
        MultiplicativeOp _mulOp = ((MultiplicativeExpression)expr).getMulOp();
        _builder.append(_mulOp);
        _builder.append(" ");
        String _translateExpr_1 = this.translateExpr(((MultiplicativeExpression)expr).getRight());
        _builder.append(_translateExpr_1);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof AdditiveExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _translateExpr = this.translateExpr(((AdditiveExpression)expr).getLeft());
        _builder.append(_translateExpr);
        _builder.append(" ");
        AdditiveOp _addOp = ((AdditiveExpression)expr).getAddOp();
        _builder.append(_addOp);
        _builder.append(" ");
        String _translateExpr_1 = this.translateExpr(((AdditiveExpression)expr).getRight());
        _builder.append(_translateExpr_1);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof CheckStateExpression) {
        _matched=true;
        return this.translateCheckStateExpression(((CheckStateExpression)expr));
      }
    }
    if (!_matched) {
      if (expr instanceof ShiftExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _translateExpr = this.translateExpr(((ShiftExpression)expr).getLeft());
        _builder.append(_translateExpr);
        _builder.append(" ");
        ShiftOp _shiftOp = ((ShiftExpression)expr).getShiftOp();
        _builder.append(_shiftOp);
        _builder.append(" ");
        String _translateExpr_1 = this.translateExpr(((ShiftExpression)expr).getRight());
        _builder.append(_translateExpr_1);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof CompareExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _translateExpr = this.translateExpr(((CompareExpression)expr).getLeft());
        _builder.append(_translateExpr);
        _builder.append(" ");
        CompareOp _cmpOp = ((CompareExpression)expr).getCmpOp();
        _builder.append(_cmpOp);
        _builder.append(" ");
        String _translateExpr_1 = this.translateExpr(((CompareExpression)expr).getRight());
        _builder.append(_translateExpr_1);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof EqualityExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _translateExpr = this.translateExpr(((EqualityExpression)expr).getLeft());
        _builder.append(_translateExpr);
        _builder.append(" ");
        CompareEqOp _eqCmpOp = ((EqualityExpression)expr).getEqCmpOp();
        _builder.append(_eqCmpOp);
        _builder.append(" ");
        String _translateExpr_1 = this.translateExpr(((EqualityExpression)expr).getRight());
        _builder.append(_translateExpr_1);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof BitAndExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _translateExpr = this.translateExpr(((BitAndExpression)expr).getLeft());
        _builder.append(_translateExpr);
        _builder.append(" & ");
        String _translateExpr_1 = this.translateExpr(((BitAndExpression)expr).getRight());
        _builder.append(_translateExpr_1);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof BitXorExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _translateExpr = this.translateExpr(((BitXorExpression)expr).getLeft());
        _builder.append(_translateExpr);
        _builder.append(" ^ ");
        String _translateExpr_1 = this.translateExpr(((BitXorExpression)expr).getRight());
        _builder.append(_translateExpr_1);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof BitOrExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _translateExpr = this.translateExpr(((BitOrExpression)expr).getLeft());
        _builder.append(_translateExpr);
        _builder.append(" | ");
        String _translateExpr_1 = this.translateExpr(((BitOrExpression)expr).getRight());
        _builder.append(_translateExpr_1);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof LogicalAndExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _translateExpr = this.translateExpr(((LogicalAndExpression)expr).getLeft());
        _builder.append(_translateExpr);
        _builder.append(" && ");
        String _translateExpr_1 = this.translateExpr(((LogicalAndExpression)expr).getRight());
        _builder.append(_translateExpr_1);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof LogicalOrExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _translateExpr = this.translateExpr(((LogicalOrExpression)expr).getLeft());
        _builder.append(_translateExpr);
        _builder.append(" || ");
        String _translateExpr_1 = this.translateExpr(((LogicalOrExpression)expr).getRight());
        _builder.append(_translateExpr_1);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof AssignmentExpression) {
        _matched=true;
        boolean _hasAssignment = ExpressionUtil.hasAssignment(((AssignmentExpression)expr));
        if (_hasAssignment) {
          StringConcatenation _builder = new StringConcatenation();
          String _translateExpr = this.translateExpr(((AssignmentExpression)expr).getAssignVar());
          _builder.append(_translateExpr);
          _builder.append(" ");
          AssignOperator _assignOp = ((AssignmentExpression)expr).getAssignOp();
          _builder.append(_assignOp);
          _builder.append(" ");
          String _translateExpr_1 = this.translateExpr(((AssignmentExpression)expr).getExpr());
          _builder.append(_translateExpr_1);
          return _builder.toString();
        }
        StringConcatenation _builder_1 = new StringConcatenation();
        String _translateExpr_2 = this.translateExpr(((AssignmentExpression)expr).getExpr());
        _builder_1.append(_translateExpr_2);
        return _builder_1.toString();
      }
    }
    return null;
  }
  
  public String translateCheckStateExpression(final CheckStateExpression cse) {
    StateQualifier _qualfier = cse.getQualfier();
    if (_qualfier != null) {
      switch (_qualfier) {
        case STOP:
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Is_Stop(");
          int _index = ReflexModelUtil.getIndex(cse.getProcess());
          _builder.append(_index);
          _builder.append(")");
          return _builder.toString();
        case ERROR:
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Is_Error(");
          int _index_1 = ReflexModelUtil.getIndex(cse.getProcess());
          _builder_1.append(_index_1);
          _builder_1.append(")");
          return _builder_1.toString();
        case ACTIVE:
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("Is_Active(");
          int _index_2 = ReflexModelUtil.getIndex(cse.getProcess());
          _builder_2.append(_index_2);
          _builder_2.append(")");
          return _builder_2.toString();
        case INACTIVE:
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("Is_Inactive(");
          int _index_3 = ReflexModelUtil.getIndex(cse.getProcess());
          _builder_3.append(_index_3);
          _builder_3.append(")");
          return _builder_3.toString();
        default:
          break;
      }
    }
    return null;
  }
}
