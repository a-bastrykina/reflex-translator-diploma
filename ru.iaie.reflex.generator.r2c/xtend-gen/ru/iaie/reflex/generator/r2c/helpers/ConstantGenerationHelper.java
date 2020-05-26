package ru.iaie.reflex.generator.r2c.helpers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import ru.iaie.reflex.generator.r2c.ExpressionGenerator;
import ru.iaie.reflex.generator.r2c.interfaces.IReflexIdentifiersHelper;
import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.EnumMember;
import ru.iaie.reflex.utils.ReflexModelUtil;

@SuppressWarnings("all")
public class ConstantGenerationHelper {
  private IReflexIdentifiersHelper identifiersHelper;
  
  private ExpressionGenerator expressionGenerator;
  
  public ConstantGenerationHelper(final IReflexIdentifiersHelper ih) {
    this.identifiersHelper = ih;
    ExpressionGenerator _expressionGenerator = new ExpressionGenerator(this.identifiersHelper);
    this.expressionGenerator = _expressionGenerator;
  }
  
  public String generateConstantDefinition(final Const c) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#define ");
    String _constantId = this.identifiersHelper.getConstantId(c);
    _builder.append(_constantId);
    _builder.append(" ");
    String _translateExpr = this.expressionGenerator.translateExpr(c.getValue());
    _builder.append(_translateExpr);
    return _builder.toString();
  }
  
  public String generateEnumDefifnition(final ru.iaie.reflex.reflex.Enum en) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("enum ");
    String _enumId = this.identifiersHelper.getEnumId(en);
    _builder.append(_enumId);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<EnumMember> _enumMembers = en.getEnumMembers();
      for(final EnumMember enumMember : _enumMembers) {
        String _enumMemberId = this.identifiersHelper.getEnumMemberId(enumMember);
        _builder.append(_enumMemberId);
        {
          boolean _hasValue = ReflexModelUtil.hasValue(enumMember);
          if (_hasValue) {
            _builder.append("=");
            String _translateExpr = this.expressionGenerator.translateExpr(enumMember.getValue());
            _builder.append(_translateExpr);
          }
        }
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("};");
    _builder.newLine();
    return _builder.toString();
  }
}
