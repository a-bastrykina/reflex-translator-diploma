package ru.iaie.reflex.generator.r2c.helpers;

import org.eclipse.xtend2.lib.StringConcatenation;
import ru.iaie.reflex.generator.r2c.LiteralGenerationUtil;
import ru.iaie.reflex.generator.r2c.interfaces.IReflexIdentifiersHelper;
import ru.iaie.reflex.reflex.GlobalVariable;
import ru.iaie.reflex.reflex.ProcessVariable;
import ru.iaie.reflex.utils.ReflexModelUtil;

@SuppressWarnings("all")
public class VariableGenerationHelper {
  private IReflexIdentifiersHelper identifiersHelper;
  
  public VariableGenerationHelper(final IReflexIdentifiersHelper ih) {
    this.identifiersHelper = ih;
  }
  
  public String generateProcessVariableDefinition(final ProcessVariable variable) {
    boolean _isImportedList = ReflexModelUtil.isImportedList(variable);
    boolean _not = (!_isImportedList);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      String _translateType = LiteralGenerationUtil.translateType(ReflexModelUtil.getType(variable));
      _builder.append(_translateType);
      _builder.append(" ");
      String _processVariableId = this.identifiersHelper.getProcessVariableId(ReflexModelUtil.getProcess(variable), variable);
      _builder.append(_processVariableId);
      return _builder.toString();
    }
    return null;
  }
  
  public String generateGlobalVariableDefinition(final GlobalVariable variable) {
    StringConcatenation _builder = new StringConcatenation();
    String _translateType = LiteralGenerationUtil.translateType(ReflexModelUtil.getType(variable));
    _builder.append(_translateType);
    _builder.append(" ");
    String _globalVariableId = this.identifiersHelper.getGlobalVariableId(variable);
    _builder.append(_globalVariableId);
    return _builder.toString();
  }
}
