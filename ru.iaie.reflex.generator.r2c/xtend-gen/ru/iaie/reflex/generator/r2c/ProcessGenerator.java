package ru.iaie.reflex.generator.r2c;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import ru.iaie.reflex.generator.r2c.LiteralGenerationUtil;
import ru.iaie.reflex.generator.r2c.helpers.ExpressionGenerationHelper;
import ru.iaie.reflex.generator.r2c.interfaces.IReflexIdentifiersHelper;
import ru.iaie.reflex.reflex.CaseStat;
import ru.iaie.reflex.reflex.CompoundStatement;
import ru.iaie.reflex.reflex.Expression;
import ru.iaie.reflex.reflex.IfElseStat;
import ru.iaie.reflex.reflex.ResetStat;
import ru.iaie.reflex.reflex.RestartStat;
import ru.iaie.reflex.reflex.SetStateStat;
import ru.iaie.reflex.reflex.StartProcStat;
import ru.iaie.reflex.reflex.State;
import ru.iaie.reflex.reflex.Statement;
import ru.iaie.reflex.reflex.StopProcStat;
import ru.iaie.reflex.reflex.SwitchStat;
import ru.iaie.reflex.reflex.TimeoutFunction;
import ru.iaie.reflex.utils.ReflexModelUtil;

@SuppressWarnings("all")
public class ProcessGenerator {
  private ru.iaie.reflex.reflex.Process proc;
  
  private IReflexIdentifiersHelper identifiersHelper;
  
  private ExpressionGenerationHelper expressionGenerator;
  
  public ProcessGenerator(final ru.iaie.reflex.reflex.Process process, final IReflexIdentifiersHelper identifiersHelper) {
    this.proc = process;
    this.identifiersHelper = identifiersHelper;
    ExpressionGenerationHelper _expressionGenerationHelper = new ExpressionGenerationHelper(identifiersHelper);
    this.expressionGenerator = _expressionGenerationHelper;
  }
  
  public String generate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void ");
    String _processFuncId = this.identifiersHelper.getProcessFuncId(this.proc);
    _builder.append(_processFuncId);
    _builder.append("() { /* Process: ");
    String _name = this.proc.getName();
    _builder.append(_name);
    _builder.append(" */");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("switch (Check_State(");
    int _index = ReflexModelUtil.getIndex(this.proc);
    _builder.append(_index, "\t");
    _builder.append(")) {");
    _builder.newLineIfNotEmpty();
    {
      EList<State> _states = this.proc.getStates();
      for(final State state : _states) {
        _builder.append("\t\t");
        String _translateState = this.translateState(state);
        _builder.append(_translateState, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String translateState(final State state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("case ");
    int _index = ReflexModelUtil.getIndex(state);
    _builder.append(_index);
    _builder.append(": { /* State: ");
    String _name = state.getName();
    _builder.append(_name);
    _builder.append(" */");
    _builder.newLineIfNotEmpty();
    {
      EList<Statement> _statements = state.getStateFunction().getStatements();
      for(final Statement stat : _statements) {
        _builder.append("\t");
        String _translateStatement = this.translateStatement(state, stat);
        _builder.append(_translateStatement, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      TimeoutFunction _timeoutFunction = state.getTimeoutFunction();
      boolean _tripleNotEquals = (_timeoutFunction != null);
      if (_tripleNotEquals) {
        _builder.append("\t");
        String _translateTimeoutFunction = this.translateTimeoutFunction(this.proc, state, state.getTimeoutFunction());
        _builder.append(_translateTimeoutFunction, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String translateTimeoutFunction(final ru.iaie.reflex.reflex.Process proc, final State state, final TimeoutFunction func) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (Timeout(");
    int _index = ReflexModelUtil.getIndex(proc);
    _builder.append(_index);
    _builder.append(", ");
    String _translateTimeout = this.translateTimeout(func);
    _builder.append(_translateTimeout);
    _builder.append("))");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _translateStatement = this.translateStatement(state, func.getBody());
    _builder.append(_translateStatement, "\t");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String translateTimeout(final TimeoutFunction func) {
    String _xblockexpression = null;
    {
      boolean _isClearTimeout = ReflexModelUtil.isClearTimeout(func);
      if (_isClearTimeout) {
        return LiteralGenerationUtil.translateTime(func.getTime());
      }
      String _xifexpression = null;
      boolean _isReferencedTimeout = ReflexModelUtil.isReferencedTimeout(func);
      if (_isReferencedTimeout) {
        _xifexpression = this.identifiersHelper.getMapping(func.getRef());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String translateStatement(final State state, final EObject statement) {
    boolean _matched = false;
    if (statement instanceof StopProcStat) {
      _matched=true;
      return this.translateStopProcStat(((StopProcStat)statement));
    }
    if (!_matched) {
      if (statement instanceof SetStateStat) {
        _matched=true;
        return this.translateSetStateStat(state, ((SetStateStat)statement));
      }
    }
    if (!_matched) {
      if (statement instanceof IfElseStat) {
        _matched=true;
        return this.translateIfElseStat(state, ((IfElseStat)statement));
      }
    }
    if (!_matched) {
      if (statement instanceof Expression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _translateExpr = this.expressionGenerator.translateExpr(statement);
        _builder.append(_translateExpr);
        _builder.append(";");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (statement instanceof SwitchStat) {
        _matched=true;
        return this.translateSwitchCaseStat(state, ((SwitchStat)statement));
      }
    }
    if (!_matched) {
      if (statement instanceof StartProcStat) {
        _matched=true;
        return this.translateStartProcStat(((StartProcStat)statement));
      }
    }
    if (!_matched) {
      if (statement instanceof ResetStat) {
        _matched=true;
        return this.translateResetTimer();
      }
    }
    if (!_matched) {
      if (statement instanceof RestartStat) {
        _matched=true;
        return this.translateRestartProcStat();
      }
    }
    if (!_matched) {
      if (statement instanceof CompoundStatement) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{");
        _builder.newLine();
        {
          EList<Statement> _statements = ((CompoundStatement)statement).getStatements();
          for(final Statement stat : _statements) {
            String _translateStatement = this.translateStatement(state, stat);
            _builder.append(_translateStatement);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
        return _builder.toString();
      }
    }
    return null;
  }
  
  public String translateIfElseStat(final State state, final IfElseStat stat) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (");
    String _translateExpr = this.expressionGenerator.translateExpr(stat.getCond());
    _builder.append(_translateExpr);
    _builder.append(") ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _translateStatement = this.translateStatement(state, stat.getThen());
    _builder.append(_translateStatement, "\t");
    _builder.newLineIfNotEmpty();
    {
      Statement _else = stat.getElse();
      boolean _tripleNotEquals = (_else != null);
      if (_tripleNotEquals) {
        _builder.append("else ");
        String _translateStatement_1 = this.translateStatement(state, stat.getElse());
        _builder.append(_translateStatement_1);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  public String translateSwitchCaseStat(final State state, final SwitchStat stat) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch (");
    String _translateExpr = this.expressionGenerator.translateExpr(stat.getExpr());
    _builder.append(_translateExpr);
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    {
      EList<CaseStat> _options = stat.getOptions();
      for(final CaseStat variant : _options) {
        _builder.append("\t");
        _builder.append("case (");
        String _translateExpr_1 = this.expressionGenerator.translateExpr(variant.getOption());
        _builder.append(_translateExpr_1, "\t");
        _builder.append("): {");
        _builder.newLineIfNotEmpty();
        {
          EList<Statement> _statements = variant.getStatements();
          for(final Statement statement : _statements) {
            _builder.append("\t");
            _builder.append("\t");
            String _translateStatement = this.translateStatement(state, statement);
            _builder.append(_translateStatement, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        {
          boolean _isHasBreak = variant.isHasBreak();
          if (_isHasBreak) {
            _builder.append("break;");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    {
      boolean _hasDefaultOption = ReflexModelUtil.hasDefaultOption(stat);
      if (_hasDefaultOption) {
        _builder.append("default: {");
        _builder.newLineIfNotEmpty();
        {
          EList<Statement> _statements_1 = stat.getDefaultOption().getStatements();
          for(final Statement statement_1 : _statements_1) {
            _builder.append("\t");
            _builder.append("\t\t");
            String _translateStatement_1 = this.translateStatement(state, statement_1);
            _builder.append(_translateStatement_1, "\t\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t\t");
        {
          boolean _isHasBreak_1 = stat.getDefaultOption().isHasBreak();
          if (_isHasBreak_1) {
            _builder.append("break;");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String translateResetTimer() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Reset_Timer(");
    int _index = ReflexModelUtil.getIndex(this.proc);
    _builder.append(_index);
    _builder.append(");");
    return _builder.toString();
  }
  
  public String translateSetStateStat(final State state, final SetStateStat sss) {
    boolean _isNext = sss.isNext();
    if (_isNext) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Set_State(");
      int _index = ReflexModelUtil.getIndex(this.proc);
      _builder.append(_index);
      _builder.append(", ");
      int _index_1 = ReflexModelUtil.getIndex(state);
      int _plus = (_index_1 + 1);
      _builder.append(_plus);
      _builder.append(");");
      return _builder.toString();
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Set_State(");
    int _index_2 = ReflexModelUtil.getIndex(this.proc);
    _builder_1.append(_index_2);
    _builder_1.append(", ");
    int _index_3 = ReflexModelUtil.getIndex(sss.getState());
    _builder_1.append(_index_3);
    _builder_1.append(");");
    return _builder_1.toString();
  }
  
  public String translateStopProcStat(final StopProcStat sps) {
    ru.iaie.reflex.reflex.Process _xifexpression = null;
    boolean _selfStop = ReflexModelUtil.selfStop(sps);
    if (_selfStop) {
      _xifexpression = this.proc;
    } else {
      _xifexpression = sps.getProcess();
    }
    final ru.iaie.reflex.reflex.Process procToStop = _xifexpression;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Set_Stop(");
    int _index = ReflexModelUtil.getIndex(procToStop);
    _builder.append(_index);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String translateStartProcStat(final StartProcStat sps) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Set_Start(");
    int _index = ReflexModelUtil.getIndex(sps.getProcess());
    _builder.append(_index);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String translateRestartProcStat() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Set_Start(");
    int _index = ReflexModelUtil.getIndex(this.proc);
    _builder.append(_index);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
}
