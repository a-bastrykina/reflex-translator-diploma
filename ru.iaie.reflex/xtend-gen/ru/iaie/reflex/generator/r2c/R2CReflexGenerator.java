package ru.iaie.reflex.generator.r2c;

import com.google.common.base.Objects;
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
import org.eclipse.xtext.xbase.lib.ListExtensions;
import ru.iaie.reflex.generator.r2c.IReflexCachedIdentifiersHelper;
import ru.iaie.reflex.generator.r2c.ReflexIdentifiersHelper;
import ru.iaie.reflex.reflex.AdditiveExpression;
import ru.iaie.reflex.reflex.AdditiveOp;
import ru.iaie.reflex.reflex.AssignOperator;
import ru.iaie.reflex.reflex.AssignmentExpression;
import ru.iaie.reflex.reflex.BitAndExpression;
import ru.iaie.reflex.reflex.BitOrExpression;
import ru.iaie.reflex.reflex.BitXorExpression;
import ru.iaie.reflex.reflex.CaseStat;
import ru.iaie.reflex.reflex.CastExpression;
import ru.iaie.reflex.reflex.CompareEqOp;
import ru.iaie.reflex.reflex.CompareExpression;
import ru.iaie.reflex.reflex.CompareOp;
import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.EnumMember;
import ru.iaie.reflex.reflex.EqualityExpression;
import ru.iaie.reflex.reflex.Expression;
import ru.iaie.reflex.reflex.FunctionCall;
import ru.iaie.reflex.reflex.IfElseStat;
import ru.iaie.reflex.reflex.InfixOp;
import ru.iaie.reflex.reflex.InfixPostfixOp;
import ru.iaie.reflex.reflex.LogicalAndExpression;
import ru.iaie.reflex.reflex.LogicalOrExpression;
import ru.iaie.reflex.reflex.LoopStat;
import ru.iaie.reflex.reflex.MultiplicativeExpression;
import ru.iaie.reflex.reflex.MultiplicativeOp;
import ru.iaie.reflex.reflex.PhysicalVariable;
import ru.iaie.reflex.reflex.PostfixOp;
import ru.iaie.reflex.reflex.PrimaryExpression;
import ru.iaie.reflex.reflex.Program;
import ru.iaie.reflex.reflex.ProgramVariable;
import ru.iaie.reflex.reflex.Register;
import ru.iaie.reflex.reflex.RegisterType;
import ru.iaie.reflex.reflex.ResetStat;
import ru.iaie.reflex.reflex.RestartStat;
import ru.iaie.reflex.reflex.SetStateStat;
import ru.iaie.reflex.reflex.ShiftExpression;
import ru.iaie.reflex.reflex.ShiftOp;
import ru.iaie.reflex.reflex.StartProcStat;
import ru.iaie.reflex.reflex.State;
import ru.iaie.reflex.reflex.Statement;
import ru.iaie.reflex.reflex.StatementBlock;
import ru.iaie.reflex.reflex.StopProcStat;
import ru.iaie.reflex.reflex.SwitchStat;
import ru.iaie.reflex.reflex.TimeoutFunction;
import ru.iaie.reflex.reflex.UnaryExpression;
import ru.iaie.reflex.reflex.UnaryOp;
import ru.iaie.reflex.reflex.Variable;
import ru.iaie.reflex.utils.ExpressionUtil;
import ru.iaie.reflex.utils.ReflexModelUtil;

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
    this.program = ReflexModelUtil.getProgram(resource);
    this.copyResources(this.program.getName().toLowerCase(), fsa);
    this.generateVariables(resource, fsa, context);
    this.generateConstants(resource, fsa, context);
    this.generateProcessImplementations(resource, fsa, context);
    this.generateMain(resource, fsa, context);
  }
  
  public void copyResources(final String fileNamePrefix, final IFileSystemAccess2 fsa) {
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
  
  public void generateConstants(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#pragma once");
    _builder.newLine();
    _builder.append("/*           Constant definitions          */");
    _builder.newLine();
    String _generateConstants = this.generateConstants(resource);
    _builder.append(_generateConstants);
    _builder.newLineIfNotEmpty();
    _builder.append("/*                Enums                    */");
    _builder.newLine();
    String _generateEnums = this.generateEnums(resource);
    _builder.append(_generateEnums);
    _builder.newLineIfNotEmpty();
    final String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("c-code/CAcnst.h");
    fsa.generateFile(_builder_1.toString(), fileContent);
  }
  
  public String generateConstants(final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Const> _consts = ReflexModelUtil.getProgram(resource).getConsts();
      for(final Const constant : _consts) {
        _builder.append("#define ");
        String _constantId = this.identifiersHelper.getConstantId(constant);
        _builder.append(_constantId);
        _builder.append(" /*");
        String _constId = constant.getConstId();
        _builder.append(_constId);
        _builder.append("*/ ");
        String _translateExpr = this.translateExpr(constant.getConstValue());
        _builder.append(_translateExpr);
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  public String generateEnums(final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ru.iaie.reflex.reflex.Enum> _enums = ReflexModelUtil.getProgram(resource).getEnums();
      for(final ru.iaie.reflex.reflex.Enum en : _enums) {
        _builder.append("enum ");
        String _enumId = this.identifiersHelper.getEnumId(en);
        _builder.append(_enumId);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        {
          EList<EnumMember> _enumMembers = en.getEnumMembers();
          for(final EnumMember enumMember : _enumMembers) {
            _builder.append("\t ");
            String _enumMemberId = this.identifiersHelper.getEnumMemberId(enumMember);
            _builder.append(_enumMemberId, "\t ");
            {
              boolean _hasValue = ReflexModelUtil.hasValue(enumMember);
              if (_hasValue) {
                _builder.append("=");
                String _translateExpr = this.translateExpr(enumMember.getValue());
                _builder.append(_translateExpr, "\t ");
              }
            }
            _builder.append(", ");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder.toString();
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
    String _generateProcessVariables = this.generateProcessVariables(resource);
    _builder.append(_generateProcessVariables);
    _builder.newLineIfNotEmpty();
    _builder.append("/*          Input Ports         */");
    _builder.newLine();
    String _generateInputPorts = this.generateInputPorts(resource);
    _builder.append(_generateInputPorts);
    _builder.newLineIfNotEmpty();
    _builder.append("/*         Output Ports         */");
    _builder.newLine();
    String _generateOutputPorts = this.generateOutputPorts(resource);
    _builder.append(_generateOutputPorts);
    _builder.newLineIfNotEmpty();
    final String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("c-code/CAgvar.cpp");
    fsa.generateFile(_builder_1.toString(), fileContent);
  }
  
  public String generateProcessVariables(final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ru.iaie.reflex.reflex.Process> _processes = ReflexModelUtil.getProgram(resource).getProcesses();
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
            {
              if ((variable instanceof PhysicalVariable)) {
                String _type = ((PhysicalVariable)variable).getType();
                _builder.append(_type);
                _builder.append(" ");
                String _variableId_1 = this.identifiersHelper.getVariableId(proc, variable);
                _builder.append(_variableId_1);
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
  
  public String generateInputPorts(final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Register> _registers = ReflexModelUtil.getProgram(resource).getRegisters();
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
  
  public String generateOutputPorts(final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Register> _registers = ReflexModelUtil.getProgram(resource).getRegisters();
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
      EList<ru.iaie.reflex.reflex.Process> _processes = ReflexModelUtil.getProgram(resource).getProcesses();
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
    boolean _matched = false;
    if (statement instanceof StopProcStat) {
      _matched=true;
      return this.translateStopProcStat(proc, state, ((StopProcStat)statement));
    }
    if (!_matched) {
      if (statement instanceof SetStateStat) {
        _matched=true;
        return this.translateSetStateStat(proc, state, ((SetStateStat)statement));
      }
    }
    if (!_matched) {
      if (statement instanceof IfElseStat) {
        _matched=true;
        return this.translateIfElseStat(proc, state, ((IfElseStat)statement));
      }
    }
    if (!_matched) {
      if (statement instanceof Expression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _translateExpr = this.translateExpr(statement);
        _builder.append(_translateExpr);
        _builder.append(";");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (statement instanceof SwitchStat) {
        _matched=true;
        return this.translateSwitchCaseStat(proc, state, ((SwitchStat)statement));
      }
    }
    if (!_matched) {
      if (statement instanceof StartProcStat) {
        _matched=true;
        return this.translateStartProcStat(proc, state, ((StartProcStat)statement));
      }
    }
    if (!_matched) {
      if (statement instanceof LoopStat) {
        _matched=true;
        return this.translateLoop(proc, state);
      }
    }
    if (!_matched) {
      if (statement instanceof ResetStat) {
        _matched=true;
        return this.translateResetTimer(proc, state);
      }
    }
    if (!_matched) {
      if (statement instanceof RestartStat) {
        _matched=true;
        return this.translateRestartProcStat(proc);
      }
    }
    if (!_matched) {
      if (statement instanceof StatementBlock) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        {
          int _length = ((Object[])Conversions.unwrapArray(((StatementBlock)statement).getStatements(), Object.class)).length;
          boolean _greaterThan = (_length > 1);
          if (_greaterThan) {
            _builder.append("{");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          EList<Statement> _statements = ((StatementBlock)statement).getStatements();
          for(final Statement stat : _statements) {
            String _translateStatement = this.translateStatement(proc, state, stat);
            _builder.append(_translateStatement);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          int _length_1 = ((Object[])Conversions.unwrapArray(((StatementBlock)statement).getStatements(), Object.class)).length;
          boolean _greaterThan_1 = (_length_1 > 1);
          if (_greaterThan_1) {
            _builder.append("}");
          }
        }
        _builder.newLineIfNotEmpty();
        return _builder.toString();
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
    final State stateToSet = ReflexModelUtil.findStateByName(proc, sss.getStateId());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Set_State(");
    String _processId_1 = this.identifiersHelper.getProcessId(proc);
    _builder_1.append(_processId_1);
    _builder_1.append(", ");
    String _stateId_1 = this.identifiersHelper.getStateId(proc, stateToSet);
    _builder_1.append(_stateId_1);
    _builder_1.append(");");
    return _builder_1.toString();
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
  
  public String translateStartProcStat(final ru.iaie.reflex.reflex.Process proc, final State state, final StartProcStat sps) {
    final ru.iaie.reflex.reflex.Process procToStart = ReflexModelUtil.findProcessByName(ReflexModelUtil.getProgram(proc.eResource()), sps.getProcId());
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Set_Start(");
    String _processId = this.identifiersHelper.getProcessId(procToStart);
    _builder.append(_processId);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
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
  
  public String translateExpr(final EObject expr) {
    boolean _matched = false;
    if (expr instanceof InfixOp) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      InfixPostfixOp _op = ((InfixOp)expr).getOp();
      _builder.append(_op);
      _builder.append(" ");
      String _id = this.identifiersHelper.getId(((InfixOp)expr).getVarId());
      _builder.append(_id);
      return _builder.toString();
    }
    if (!_matched) {
      if (expr instanceof PostfixOp) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _id = this.identifiersHelper.getId(((PostfixOp)expr).getVarId());
        _builder.append(_id);
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
        String _funcId = ((FunctionCall)expr).getFuncId();
        _builder.append(_funcId);
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
      if (expr instanceof PrimaryExpression) {
        _matched=true;
        boolean _isVariableReference = ExpressionUtil.isVariableReference(((PrimaryExpression)expr));
        if (_isVariableReference) {
          return this.identifiersHelper.getId(((PrimaryExpression)expr).getVarId());
        }
        boolean _isNestedExpr = ExpressionUtil.isNestedExpr(((PrimaryExpression)expr));
        if (_isNestedExpr) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("(");
          String _translateExpr = this.translateExpr(((PrimaryExpression)expr).getNestedExpr());
          _builder.append(_translateExpr);
          _builder.append(")");
          return _builder.toString();
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
        String _trim = NodeModelUtils.getNode(((CastExpression)expr).getType()).getText().trim();
        _builder.append(_trim);
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
          String _id = this.identifiersHelper.getId(((AssignmentExpression)expr).getAssignVar());
          _builder.append(_id);
          _builder.append(" ");
          AssignOperator _assignOp = ((AssignmentExpression)expr).getAssignOp();
          _builder.append(_assignOp);
          _builder.append(" ");
          String _translateExpr = this.translateExpr(((AssignmentExpression)expr).getExpr());
          _builder.append(_translateExpr);
          return _builder.toString();
        }
        StringConcatenation _builder_1 = new StringConcatenation();
        String _translateExpr_1 = this.translateExpr(((AssignmentExpression)expr).getExpr());
        _builder_1.append(_translateExpr_1);
        return _builder_1.toString();
      }
    }
    return null;
  }
}
