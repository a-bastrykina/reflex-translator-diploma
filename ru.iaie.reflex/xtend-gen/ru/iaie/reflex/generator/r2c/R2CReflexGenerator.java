package ru.iaie.reflex.generator.r2c;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import ru.iaie.reflex.generator.r2c.ReflexIdentifiers;
import ru.iaie.reflex.reflex.CaseStat;
import ru.iaie.reflex.reflex.Expression;
import ru.iaie.reflex.reflex.IfElseStat;
import ru.iaie.reflex.reflex.LoopStat;
import ru.iaie.reflex.reflex.Program;
import ru.iaie.reflex.reflex.ResetStat;
import ru.iaie.reflex.reflex.RestartStat;
import ru.iaie.reflex.reflex.SetStateStat;
import ru.iaie.reflex.reflex.StartProcStat;
import ru.iaie.reflex.reflex.State;
import ru.iaie.reflex.reflex.Statement;
import ru.iaie.reflex.reflex.StatementBlock;
import ru.iaie.reflex.reflex.StopProcStat;
import ru.iaie.reflex.reflex.SwitchStat;
import ru.iaie.reflex.reflex.TimeoutFunction;

@SuppressWarnings("all")
public class R2CReflexGenerator extends AbstractGenerator {
  private Map<String, String> procIdentifiers = new HashMap<String, String>();
  
  private Map<String, String> stateIdentifiers = new HashMap<String, String>();
  
  private Program program;
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.program = ((Program[])Conversions.unwrapArray((Iterables.<Program>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Program.class)), Program.class))[0];
    final String fileContent = this.translateProgram(this.program);
    StringConcatenation _builder = new StringConcatenation();
    String _lowerCase = this.program.getName().toLowerCase();
    _builder.append(_lowerCase);
    _builder.append(".cpp");
    fsa.generateFile(_builder.toString(), fileContent);
  }
  
  public String translateProgram(final Program prog) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#include <stdio.h>");
    _builder.newLine();
    _builder.append("#include <stdlib.h>");
    _builder.newLine();
    String _generateProgramInfo = this.generateProgramInfo(prog);
    _builder.append(_generateProgramInfo);
    _builder.newLineIfNotEmpty();
    _builder.append("int main() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("while (1) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int i = 0;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (; i < ");
    _builder.append(ReflexIdentifiers.PROC_COUNT_VAR, "\t\t");
    _builder.append("; i++) {");
    _builder.newLineIfNotEmpty();
    {
      EList<ru.iaie.reflex.reflex.Process> _processes = prog.getProcesses();
      for(final ru.iaie.reflex.reflex.Process proc : _processes) {
        _builder.append("\t\t\t");
        String _translateProcess = this.translateProcess(proc);
        _builder.append(_translateProcess, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String translateProcess(final ru.iaie.reflex.reflex.Process proc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch (");
    _builder.append(ReflexIdentifiers.PROC_STATES_ARRAY_NAME);
    _builder.append("[");
    String _processId = this.getProcessId(proc);
    _builder.append(_processId);
    _builder.append("]) {");
    _builder.newLineIfNotEmpty();
    {
      EList<State> _states = proc.getStates();
      for(final State state : _states) {
        _builder.append("\t");
        String _translateState = this.translateState(proc, state);
        _builder.append(_translateState, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String getProcessId(final ru.iaie.reflex.reflex.Process proc) {
    boolean _containsKey = this.procIdentifiers.containsKey(proc.getName());
    boolean _not = (!_containsKey);
    if (_not) {
      final String id = proc.getName().toUpperCase();
      this.procIdentifiers.put(proc.getName(), id);
    }
    return this.procIdentifiers.get(proc.getName());
  }
  
  public String generateProcessesEnum(final Program prog) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("enum ");
    _builder.append(ReflexIdentifiers.PROC_ENUM_ID);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<ru.iaie.reflex.reflex.Process> _processes = prog.getProcesses();
      for(final ru.iaie.reflex.reflex.Process proc : _processes) {
        _builder.append("\t");
        String _processId = this.getProcessId(proc);
        _builder.append(_processId, "\t");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String getStateId(final ru.iaie.reflex.reflex.Process proc, final State state) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = proc.getName();
    _builder.append(_name);
    _builder.append(".");
    String _name_1 = state.getName();
    _builder.append(_name_1);
    final String key = _builder.toString();
    boolean _containsKey = this.stateIdentifiers.containsKey(key);
    boolean _not = (!_containsKey);
    if (_not) {
      StringConcatenation _builder_1 = new StringConcatenation();
      String _upperCase = proc.getName().toUpperCase();
      _builder_1.append(_upperCase);
      _builder_1.append("_");
      String _upperCase_1 = state.getName().toUpperCase();
      _builder_1.append(_upperCase_1);
      final String id = _builder_1.toString();
      this.stateIdentifiers.put(key, id);
    }
    return this.stateIdentifiers.get(key);
  }
  
  public String generateStateEnum(final ru.iaie.reflex.reflex.Process proc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("enum ");
    String _name = proc.getName();
    _builder.append(_name);
    _builder.append("_STATES {");
    _builder.newLineIfNotEmpty();
    {
      EList<State> _states = proc.getStates();
      for(final State state : _states) {
        _builder.append("\t");
        String _stateId = this.getStateId(proc, state);
        _builder.append(_stateId, "\t");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    String _upperCase = proc.getName().toUpperCase();
    _builder.append(_upperCase, "\t");
    _builder.append(ReflexIdentifiers.STOP_STATE_ID_SUFFIX, "\t");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _upperCase_1 = proc.getName().toUpperCase();
    _builder.append(_upperCase_1, "\t");
    _builder.append(ReflexIdentifiers.ERR_STATE_ID_SUFFIX, "\t");
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String generateTimers(final Program prog) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("int ");
    _builder.append(ReflexIdentifiers.TIMER_ARRAY_NAME);
    _builder.append("[");
    _builder.append(ReflexIdentifiers.PROC_COUNT_VAR);
    _builder.append("];");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String generateStatesArray(final Program prog) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("int ");
    _builder.append(ReflexIdentifiers.PROC_STATES_ARRAY_NAME);
    _builder.append("[");
    _builder.append(ReflexIdentifiers.PROC_COUNT_VAR);
    _builder.append("];");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String generateProgramInfo(final Program prog) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("int ");
    _builder.append(ReflexIdentifiers.PROC_COUNT_VAR);
    _builder.append(" = ");
    int _length = ((Object[])Conversions.unwrapArray(prog.getProcesses(), Object.class)).length;
    _builder.append(_length);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    String _generateTimers = this.generateTimers(prog);
    _builder.append(_generateTimers);
    _builder.newLineIfNotEmpty();
    String _generateStatesArray = this.generateStatesArray(prog);
    _builder.append(_generateStatesArray);
    _builder.newLineIfNotEmpty();
    String _generateProcessesEnum = this.generateProcessesEnum(prog);
    _builder.append(_generateProcessesEnum);
    _builder.newLineIfNotEmpty();
    {
      EList<ru.iaie.reflex.reflex.Process> _processes = prog.getProcesses();
      for(final ru.iaie.reflex.reflex.Process proc : _processes) {
        String _generateStateEnum = this.generateStateEnum(proc);
        _builder.append(_generateStateEnum);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  public String translateState(final ru.iaie.reflex.reflex.Process proc, final State state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("case ");
    String _stateId = this.getStateId(proc, state);
    _builder.append(_stateId);
    _builder.append(": {");
    _builder.newLineIfNotEmpty();
    {
      EList<Statement> _statements = state.getStateFunction().getStatements();
      for(final Statement stat : _statements) {
        String _translateStatement = this.translateStatement(proc, state, stat);
        _builder.append(_translateStatement);
        _builder.newLineIfNotEmpty();
        {
          TimeoutFunction _timeoutFunction = state.getTimeoutFunction();
          boolean _notEquals = (!Objects.equal(_timeoutFunction, null));
          if (_notEquals) {
            String _translateTimeoutFunction = this.translateTimeoutFunction(proc, state, state.getTimeoutFunction());
            _builder.append(_translateTimeoutFunction);
            _builder.newLineIfNotEmpty();
          }
        }
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
    _builder.append("if (");
    _builder.append(ReflexIdentifiers.TIMER_ARRAY_NAME);
    _builder.append("[");
    String _processId = this.getProcessId(proc);
    _builder.append(_processId);
    _builder.append("] >= TODO_Time)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _translateStatement = this.translateStatement(proc, state, func.getBody());
    _builder.append(_translateStatement, "\t");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String translateStatement(final ru.iaie.reflex.reflex.Process proc, final State state, final EObject statement) {
    if ((statement instanceof StopProcStat)) {
      return this.translateStopProcStat(proc, state, ((StopProcStat)statement));
    } else {
      if ((statement instanceof SetStateStat)) {
        return this.translateSetStateStat(proc, state, ((SetStateStat)statement));
      } else {
        if ((statement instanceof IfElseStat)) {
          StringConcatenation _builder = new StringConcatenation();
          String _translateIfElseStat = this.translateIfElseStat(proc, state, ((IfElseStat)statement));
          _builder.append(_translateIfElseStat);
          return _builder.toString();
        } else {
          if ((statement instanceof Expression)) {
            StringConcatenation _builder_1 = new StringConcatenation();
            String _translateExpr = this.translateExpr(((Expression)statement));
            _builder_1.append(_translateExpr);
            _builder_1.append(";");
            return _builder_1.toString();
          } else {
            if ((statement instanceof SwitchStat)) {
              StringConcatenation _builder_2 = new StringConcatenation();
              String _translateSwitchCaseStat = this.translateSwitchCaseStat(proc, state, ((SwitchStat)statement));
              _builder_2.append(_translateSwitchCaseStat);
              return _builder_2.toString();
            } else {
              if ((statement instanceof StartProcStat)) {
                StringConcatenation _builder_3 = new StringConcatenation();
                String _translateStartProcStat = this.translateStartProcStat(this.program, proc, state, ((StartProcStat)statement));
                _builder_3.append(_translateStartProcStat);
                return _builder_3.toString();
              } else {
                if ((statement instanceof LoopStat)) {
                  StringConcatenation _builder_4 = new StringConcatenation();
                  String _translateLoop = this.translateLoop(proc, state);
                  _builder_4.append(_translateLoop);
                  return _builder_4.toString();
                } else {
                  if ((statement instanceof ResetStat)) {
                    StringConcatenation _builder_5 = new StringConcatenation();
                    String _translateResetTimer = this.translateResetTimer(proc);
                    _builder_5.append(_translateResetTimer);
                    return _builder_5.toString();
                  } else {
                    if ((statement instanceof RestartStat)) {
                      StringConcatenation _builder_6 = new StringConcatenation();
                      String _translateRestartProcStat = this.translateRestartProcStat(proc);
                      _builder_6.append(_translateRestartProcStat);
                      return _builder_6.toString();
                    } else {
                      if ((statement instanceof StatementBlock)) {
                        StringConcatenation _builder_7 = new StringConcatenation();
                        {
                          int _length = ((Object[])Conversions.unwrapArray(((StatementBlock)statement).getStatements(), Object.class)).length;
                          boolean _greaterThan = (_length > 1);
                          if (_greaterThan) {
                            _builder_7.append("{");
                          }
                        }
                        _builder_7.newLineIfNotEmpty();
                        {
                          EList<Statement> _statements = ((StatementBlock)statement).getStatements();
                          for(final Statement stat : _statements) {
                            String _translateStatement = this.translateStatement(proc, state, stat);
                            _builder_7.append(_translateStatement);
                            _builder_7.newLineIfNotEmpty();
                          }
                        }
                        {
                          int _length_1 = ((Object[])Conversions.unwrapArray(((StatementBlock)statement).getStatements(), Object.class)).length;
                          boolean _greaterThan_1 = (_length_1 > 1);
                          if (_greaterThan_1) {
                            _builder_7.append("}");
                          }
                        }
                        _builder_7.newLineIfNotEmpty();
                        return _builder_7.toString();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return null;
  }
  
  public String translateIfElseStat(final ru.iaie.reflex.reflex.Process proc, final State state, final IfElseStat stat) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (");
    String _translateExpr = this.translateExpr(stat.getCond());
    _builder.append(_translateExpr);
    _builder.append(") ");
    String _translateStatement = this.translateStatement(proc, state, stat.getThen());
    _builder.append(_translateStatement);
    _builder.newLineIfNotEmpty();
    {
      Statement _else = stat.getElse();
      boolean _tripleNotEquals = (_else != null);
      if (_tripleNotEquals) {
        _builder.append("else ");
        String _translateStatement_1 = this.translateStatement(proc, state, stat.getElse());
        _builder.append(_translateStatement_1);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  public String translateLoop(final ru.iaie.reflex.reflex.Process proc, final State state) {
    return this.translateResetTimer(proc);
  }
  
  public String translateResetTimer(final ru.iaie.reflex.reflex.Process proc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(ReflexIdentifiers.TIMER_ARRAY_NAME);
    _builder.append("[");
    String _processId = this.getProcessId(proc);
    _builder.append(_processId);
    _builder.append("] =  0;");
    return _builder.toString();
  }
  
  public String translateSetStateStat(final ru.iaie.reflex.reflex.Process proc, final State state, final SetStateStat sss) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isNext = sss.isNext();
      if (_isNext) {
        _builder.append(ReflexIdentifiers.PROC_STATES_ARRAY_NAME);
        _builder.append("[");
        String _processId = this.getProcessId(proc);
        _builder.append(_processId);
        _builder.append("] =  ");
        String _stateId = this.getStateId(proc, state);
        _builder.append(_stateId);
        _builder.append(" + 1;");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append(ReflexIdentifiers.PROC_STATES_ARRAY_NAME);
        _builder.append("[");
        String _processId_1 = this.getProcessId(proc);
        _builder.append(_processId_1);
        _builder.append("] =  ");
        String _upperCase = proc.getName().toUpperCase();
        _builder.append(_upperCase);
        _builder.append("_");
        String _upperCase_1 = sss.getStateId().toUpperCase();
        _builder.append(_upperCase_1);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    String _translateResetTimer = this.translateResetTimer(proc);
    _builder.append(_translateResetTimer);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String translateStopProcStat(final ru.iaie.reflex.reflex.Process proc, final State state, final StopProcStat sps) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(ReflexIdentifiers.PROC_STATES_ARRAY_NAME);
    _builder.append("[");
    String _processId = this.getProcessId(proc);
    _builder.append(_processId);
    _builder.append("] =  ");
    String _upperCase = proc.getName().toUpperCase();
    _builder.append(_upperCase);
    _builder.append(ReflexIdentifiers.STOP_STATE_ID_SUFFIX);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String translateStartProcStat(final Program prog, final ru.iaie.reflex.reflex.Process proc, final State state, final StartProcStat sps) {
    final Function1<ru.iaie.reflex.reflex.Process, Boolean> _function = (ru.iaie.reflex.reflex.Process it) -> {
      return Boolean.valueOf(proc.getName().equals(sps.getProcId()));
    };
    final List<ru.iaie.reflex.reflex.Process> matchingProcs = IterableExtensions.<ru.iaie.reflex.reflex.Process>toList(IterableExtensions.<ru.iaie.reflex.reflex.Process>filter(prog.getProcesses(), _function));
    boolean _isEmpty = matchingProcs.isEmpty();
    if (_isEmpty) {
      StringConcatenation _builder = new StringConcatenation();
      return _builder.toString();
    }
    final ru.iaie.reflex.reflex.Process procToStart = matchingProcs.get(0);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(ReflexIdentifiers.PROC_STATES_ARRAY_NAME);
    _builder_1.append("[");
    String _processId = this.getProcessId(procToStart);
    _builder_1.append(_processId);
    _builder_1.append("] =  ");
    String _stateId = this.getStateId(procToStart, procToStart.getStates().get(0));
    _builder_1.append(_stateId);
    _builder_1.append(";");
    _builder_1.newLineIfNotEmpty();
    String _translateResetTimer = this.translateResetTimer(procToStart);
    _builder_1.append(_translateResetTimer);
    _builder_1.newLineIfNotEmpty();
    return _builder_1.toString();
  }
  
  public String translateRestartProcStat(final ru.iaie.reflex.reflex.Process proc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(ReflexIdentifiers.PROC_STATES_ARRAY_NAME);
    _builder.append("[");
    String _processId = this.getProcessId(proc);
    _builder.append(_processId);
    _builder.append("] =  ");
    String _stateId = this.getStateId(proc, proc.getStates().get(0));
    _builder.append(_stateId);
    _builder.newLineIfNotEmpty();
    String _translateResetTimer = this.translateResetTimer(proc);
    _builder.append(_translateResetTimer);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String translateSwitchCaseStat(final ru.iaie.reflex.reflex.Process proc, final State state, final SwitchStat stat) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch (");
    String _translateExpr = this.translateExpr(stat.getExpr());
    _builder.append(_translateExpr);
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    {
      EList<CaseStat> _options = stat.getOptions();
      for(final CaseStat variant : _options) {
        _builder.append("\t");
        _builder.append("case (");
        ru.iaie.reflex.reflex.Integer _option = variant.getOption();
        _builder.append(_option, "\t");
        _builder.append("):");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        String _translateStatement = this.translateStatement(proc, state, stat);
        _builder.append(_translateStatement, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        {
          boolean _isHasBreak = variant.isHasBreak();
          if (_isHasBreak) {
            _builder.append("break;");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String translateExpr(final Expression expr) {
    StringConcatenation _builder = new StringConcatenation();
    String _trim = NodeModelUtils.getNode(expr).getText().trim();
    _builder.append(_trim);
    return _builder.toString();
  }
}