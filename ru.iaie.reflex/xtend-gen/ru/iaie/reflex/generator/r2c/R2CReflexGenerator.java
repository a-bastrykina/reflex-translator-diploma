package ru.iaie.reflex.generator.r2c;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import ru.iaie.reflex.generator.r2c.IReflexCachedIdentifiersHelper;
import ru.iaie.reflex.generator.r2c.ReflexIdentifiersHelper;
import ru.iaie.reflex.reflex.CaseStat;
import ru.iaie.reflex.reflex.Expression;
import ru.iaie.reflex.reflex.IfElseStat;
import ru.iaie.reflex.reflex.LoopStat;
import ru.iaie.reflex.reflex.PrimaryExpression;
import ru.iaie.reflex.reflex.Program;
import ru.iaie.reflex.reflex.ProgramVariable;
import ru.iaie.reflex.reflex.Register;
import ru.iaie.reflex.reflex.RegisterType;
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
import ru.iaie.reflex.reflex.Variable;

@SuppressWarnings("all")
public class R2CReflexGenerator extends AbstractGenerator {
  private IReflexCachedIdentifiersHelper identifiersHelper = new ReflexIdentifiersHelper();
  
  private Program program;
  
  private List<String> commonResources = CollectionLiterals.<String>newArrayList("CA_dll_interface.cpp", "CA_dll_interface.h", "CA_queue_const.h", 
    "CAio.h", "CAports.h", "CAusr1.cpp", "CAusr1.h", "CAusr2.h", "custom_dll_interface.cpp", "dll_interface.h", 
    "LabVIEWData.h", "dll_interface.h", "lib.cpp", "lib.h", "msg_queue.cpp", "msg_queue.h", "proc.h", "R_CNST.H", 
    "r_io.cpp", "r_io.h", "r_lib.cpp", "R_LIB.H", "r_main.h");
  
  @Override
  public void afterGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.identifiersHelper.clearCaches();
  }
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.program = ((Program[])Conversions.unwrapArray((Iterables.<Program>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Program.class)), Program.class))[0];
    this.copyResources(fsa);
    this.generateVariables(resource, fsa, context);
    this.generateProcessImplementations(resource, fsa, context);
    this.generateMain(resource, fsa, context);
  }
  
  public void copyResources(final IFileSystemAccess2 fsa) {
    for (final String resource : this.commonResources) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("c-code/");
      _builder.append(resource);
      Class<? extends R2CReflexGenerator> _class = this.getClass();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("/resources/c-code/");
      _builder_1.append(resource);
      fsa.generateFile(_builder.toString(), _class.getResourceAsStream(_builder_1.toString()));
    }
  }
  
  public void generateVariables(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*           Variables          */");
    _builder.newLine();
    _builder.append("/* CAGVAR.H = Global Variables Image-File. */");
    _builder.newLine();
    _builder.append("#pragma once");
    _builder.newLine();
    _builder.append("/*       Process variables     */");
    _builder.newLine();
    String _generateProcessVariables = this.generateProcessVariables();
    _builder.append(_generateProcessVariables);
    _builder.newLineIfNotEmpty();
    _builder.append("/*          Input Ports         */");
    _builder.newLine();
    String _generateInputPorts = this.generateInputPorts();
    _builder.append(_generateInputPorts);
    _builder.newLineIfNotEmpty();
    _builder.append("/*         Output Ports         */");
    _builder.newLine();
    String _generateOutputPorts = this.generateOutputPorts();
    _builder.append(_generateOutputPorts);
    _builder.newLineIfNotEmpty();
    final String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("c-code/CAgvar.cpp");
    fsa.generateFile(_builder_1.toString(), fileContent);
  }
  
  public String generateProcessVariables() {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ru.iaie.reflex.reflex.Process> _processes = this.program.getProcesses();
      for(final ru.iaie.reflex.reflex.Process proc : _processes) {
        {
          EList<Variable> _variables = proc.getVariables();
          for(final Variable variable : _variables) {
            {
              if ((variable instanceof ProgramVariable)) {
                String _trim = NodeModelUtils.getNode(((ProgramVariable)variable).getType()).getText().trim();
                _builder.append(_trim);
                _builder.append(" ");
                String _variableId = this.identifiersHelper.getVariableId(proc, variable);
                _builder.append(_variableId);
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    return _builder.toString();
  }
  
  public String generateInputPorts() {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Register> _registers = this.program.getRegisters();
      for(final Register reg : _registers) {
        {
          RegisterType _type = reg.getType();
          boolean _equals = Objects.equal(_type, RegisterType.INPUT);
          if (_equals) {
            _builder.append("char ");
            String _portId = this.identifiersHelper.getPortId(reg);
            _builder.append(_portId);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder.toString();
  }
  
  public String generateOutputPorts() {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Register> _registers = this.program.getRegisters();
      for(final Register reg : _registers) {
        {
          RegisterType _type = reg.getType();
          boolean _equals = Objects.equal(_type, RegisterType.OUTPUT);
          if (_equals) {
            _builder.append("char ");
            String _portId = this.identifiersHelper.getPortId(reg);
            _builder.append(_portId);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder.toString();
  }
  
  public void generateProcessImplementations(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* FILE OF PROC-IMAGES OF THE PROJECT */");
    _builder.newLine();
    _builder.append("#include \"CAext.h\" /* Common files for all generated c-files */");
    _builder.newLine();
    _builder.append("#include \"CAxvar.h\"  /* Var-images */");
    _builder.newLine();
    _builder.newLine();
    {
      EList<ru.iaie.reflex.reflex.Process> _processes = this.program.getProcesses();
      for(final ru.iaie.reflex.reflex.Process proc : _processes) {
        String _translateProcess = this.translateProcess(proc);
        _builder.append(_translateProcess);
        _builder.newLineIfNotEmpty();
      }
    }
    final String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("c-code/CA0001.cpp");
    fsa.generateFile(_builder_1.toString(), fileContent);
  }
  
  public void generateMain(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* MAIN FILE OF THE PROJECT */");
    _builder.newLine();
    _builder.append("#include \"CAext.h\" /* Common files for all generated c-files */");
    _builder.newLine();
    _builder.append("#include \"CAproc.h\"  /* Process-functions desription */");
    _builder.newLine();
    _builder.append("#include \"CAgvar.h\"  /* Project variables images */");
    _builder.newLine();
    _builder.append("#include \"CAio.h\"    /* Scan-input/output functions */");
    _builder.newLine();
    _builder.append("void Control_Loop(void);  /* for r_main.h */");
    _builder.newLine();
    _builder.append("#include \"r_main.h\"  /* Codes of the main-function that calls Control_Loop */");
    _builder.newLine();
    _builder.newLine();
    _builder.append("void Control_Loop (void)    /* Control algorithm */");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Input();");
    _builder.newLine();
    {
      EList<ru.iaie.reflex.reflex.Process> _processes = this.program.getProcesses();
      for(final ru.iaie.reflex.reflex.Process proc : _processes) {
        _builder.append("\t");
        String _processFuncId = this.identifiersHelper.getProcessFuncId(proc);
        _builder.append(_processFuncId, "\t");
        _builder.append("(); /* Process ");
        String _name = proc.getName();
        _builder.append(_name, "\t");
        _builder.append(" */");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("Output();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Prepare_PSW((INT16S)(PROCESS_N1), (INT16S)PROCESS_Nn);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("c-code/CAmain.cpp");
    fsa.generateFile(_builder_1.toString(), fileContent);
  }
  
  public String translateProcess(final ru.iaie.reflex.reflex.Process proc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void ");
    String _processFuncId = this.identifiersHelper.getProcessFuncId(proc);
    _builder.append(_processFuncId);
    _builder.append("() { /* Process: ");
    String _name = proc.getName();
    _builder.append(_name);
    _builder.append(" */");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("switch (Check_State(");
    String _processId = this.identifiersHelper.getProcessId(proc);
    _builder.append(_processId, "\t");
    _builder.append(")) {");
    _builder.newLineIfNotEmpty();
    {
      EList<State> _states = proc.getStates();
      for(final State state : _states) {
        _builder.append("\t\t");
        String _translateState = this.translateState(proc, state);
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
  
  public String translateState(final ru.iaie.reflex.reflex.Process proc, final State state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("case ");
    String _stateId = this.identifiersHelper.getStateId(proc, state);
    _builder.append(_stateId);
    _builder.append(": { /* State: ");
    String _name = state.getName();
    _builder.append(_name);
    _builder.append(" */");
    _builder.newLineIfNotEmpty();
    {
      EList<Statement> _statements = state.getStateFunction().getStatements();
      for(final Statement stat : _statements) {
        String _translateStatement = this.translateStatement(proc, state, stat);
        _builder.append(_translateStatement);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      TimeoutFunction _timeoutFunction = state.getTimeoutFunction();
      boolean _tripleNotEquals = (_timeoutFunction != null);
      if (_tripleNotEquals) {
        String _translateTimeoutFunction = this.translateTimeoutFunction(proc, state, state.getTimeoutFunction());
        _builder.append(_translateTimeoutFunction);
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
    String _processId = this.identifiersHelper.getProcessId(proc);
    _builder.append(_processId);
    _builder.append(", ");
    String _ticks = func.getTime().getTicks();
    _builder.append(_ticks);
    _builder.append("))");
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
                    String _translateResetTimer = this.translateResetTimer(proc, state);
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
    StringConcatenation _builder = new StringConcatenation();
    return _builder.toString();
  }
  
  public String translateResetTimer(final ru.iaie.reflex.reflex.Process proc, final State state) {
    return this.translateLoop(proc, state);
  }
  
  public String translateSetStateStat(final ru.iaie.reflex.reflex.Process proc, final State state, final SetStateStat sss) {
    boolean _isNext = sss.isNext();
    if (_isNext) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Set_State(");
      String _processId = this.identifiersHelper.getProcessId(proc);
      _builder.append(_processId);
      _builder.append(", ");
      String _stateId = this.identifiersHelper.getStateId(proc, state);
      _builder.append(_stateId);
      _builder.append(" + 1);");
      return _builder.toString();
    }
    final Function1<State, Boolean> _function = (State it) -> {
      return Boolean.valueOf(state.getName().equals(sss.getStateId()));
    };
    final List<State> matchingStates = IterableExtensions.<State>toList(IterableExtensions.<State>filter(proc.getStates(), _function));
    boolean _isEmpty = matchingStates.isEmpty();
    if (_isEmpty) {
      StringConcatenation _builder_1 = new StringConcatenation();
      return _builder_1.toString();
    }
    final State stateToSet = matchingStates.get(0);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("Set_State(");
    String _processId_1 = this.identifiersHelper.getProcessId(proc);
    _builder_2.append(_processId_1);
    _builder_2.append(", ");
    String _stateId_1 = this.identifiersHelper.getStateId(proc, stateToSet);
    _builder_2.append(_stateId_1);
    _builder_2.append(");");
    return _builder_2.toString();
  }
  
  public String translateStopProcStat(final ru.iaie.reflex.reflex.Process proc, final State state, final StopProcStat sps) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Set_Stop(");
    String _processId = this.identifiersHelper.getProcessId(proc);
    _builder.append(_processId);
    _builder.append(");");
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
    _builder_1.append("Set_Start(");
    String _processId = this.identifiersHelper.getProcessId(procToStart);
    _builder_1.append(_processId);
    _builder_1.append(");");
    _builder_1.newLineIfNotEmpty();
    return _builder_1.toString();
  }
  
  public String translateRestartProcStat(final ru.iaie.reflex.reflex.Process proc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Set_Start(");
    String _processId = this.identifiersHelper.getProcessId(proc);
    _builder.append(_processId);
    _builder.append(");");
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
        String _option = variant.getOption();
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
  
  public void translateId(final PrimaryExpression e) {
    String _varId = e.getVarId();
    boolean _tripleNotEquals = (_varId != null);
    if (_tripleNotEquals) {
      e.setVarId(this.identifiersHelper.getId(e.getVarId()));
    }
  }
}
