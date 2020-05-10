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
import ru.iaie.reflex.reflex.CheckStateExpression;
import ru.iaie.reflex.reflex.CompareEqOp;
import ru.iaie.reflex.reflex.CompareExpression;
import ru.iaie.reflex.reflex.CompareOp;
import ru.iaie.reflex.reflex.CompoundStatement;
import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.EnumMember;
import ru.iaie.reflex.reflex.EqualityExpression;
import ru.iaie.reflex.reflex.Expression;
import ru.iaie.reflex.reflex.FunctionCall;
import ru.iaie.reflex.reflex.GlobalVariable;
import ru.iaie.reflex.reflex.IdReference;
import ru.iaie.reflex.reflex.IfElseStat;
import ru.iaie.reflex.reflex.InfixOp;
import ru.iaie.reflex.reflex.InfixPostfixOp;
import ru.iaie.reflex.reflex.LogicalAndExpression;
import ru.iaie.reflex.reflex.LogicalOrExpression;
import ru.iaie.reflex.reflex.MultiplicativeExpression;
import ru.iaie.reflex.reflex.MultiplicativeOp;
import ru.iaie.reflex.reflex.PostfixOp;
import ru.iaie.reflex.reflex.PrimaryExpression;
import ru.iaie.reflex.reflex.ProcessVariable;
import ru.iaie.reflex.reflex.Program;
import ru.iaie.reflex.reflex.Register;
import ru.iaie.reflex.reflex.RegisterType;
import ru.iaie.reflex.reflex.ResetStat;
import ru.iaie.reflex.reflex.RestartStat;
import ru.iaie.reflex.reflex.SetStateStat;
import ru.iaie.reflex.reflex.ShiftExpression;
import ru.iaie.reflex.reflex.ShiftOp;
import ru.iaie.reflex.reflex.StartProcStat;
import ru.iaie.reflex.reflex.State;
import ru.iaie.reflex.reflex.StateQualifier;
import ru.iaie.reflex.reflex.Statement;
import ru.iaie.reflex.reflex.StopProcStat;
import ru.iaie.reflex.reflex.SwitchStat;
import ru.iaie.reflex.reflex.TimeoutFunction;
import ru.iaie.reflex.reflex.Type;
import ru.iaie.reflex.reflex.Types;
import ru.iaie.reflex.reflex.UnaryExpression;
import ru.iaie.reflex.reflex.UnaryOp;
import ru.iaie.reflex.utils.ExpressionUtil;
import ru.iaie.reflex.utils.ReflexModelUtil;

@SuppressWarnings("all")
public class R2CReflexGenerator extends AbstractGenerator {
  private IReflexCachedIdentifiersHelper identifiersHelper = new ReflexIdentifiersHelper();
  
  private Program program;
  
  private List<String> commonResources = CollectionLiterals.<String>newArrayList("usr/usr.c", "usr/usr.h", 
    "lib/r_cnst.h", "lib/r_io.c", "lib/r_io.h", "lib/r_lib.c", "lib/r_lib.h", "lib/r_main.h", 
    "generated/ext.h", "generated/io.h");
  
  @Override
  public void beforeGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.program = ReflexModelUtil.getProgram(resource);
  }
  
  @Override
  public void afterGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.identifiersHelper.clearCaches();
  }
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.copyResources(this.program.getName().toLowerCase(), fsa);
    this.generateVariables(resource, fsa, context);
    this.generateConstantsFile(resource, fsa, context);
    this.generateProcessDefinitions(resource, fsa, context);
    this.generateProcessImplementations(resource, fsa, context);
    this.generateIO(resource, fsa, context);
    this.generateMain(resource, fsa, context);
    this.generateCMake(resource, fsa, context);
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
  
  public void generateCMake(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("cmake_minimum_required(VERSION 3.15)");
    _builder.newLine();
    _builder.append("project(");
    String _lowerCase = this.program.getName().toLowerCase();
    _builder.append(_lowerCase);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("set(CMAKE_C_STANDARD 99)");
    _builder.newLine();
    _builder.newLine();
    _builder.append("add_executable(");
    String _lowerCase_1 = this.program.getName().toLowerCase();
    _builder.append(_lowerCase_1);
    _builder.append(" generated/main.c generated/proc.c lib/r_io.c lib/r_lib.c usr/usr.c generated/io.c)");
    _builder.newLineIfNotEmpty();
    String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("c-code/CMakeLists.txt");
    fsa.generateFile(_builder_1.toString(), fileContent);
  }
  
  public void generateIO(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#include \"io.h\"");
    _builder.newLine();
    _builder.append("#include \"xvar.h\"\t");
    _builder.newLine();
    _builder.append("#include \"stdio.h\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("void Input(void) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("printf(\"input\\n\");");
    _builder.newLine();
    _builder.append("}  /* Reading IO func */");
    _builder.newLine();
    _builder.newLine();
    _builder.append("void Output(void) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("printf(\"output\\n\");");
    _builder.newLine();
    _builder.append("} /* Writing IO func */");
    _builder.newLine();
    final String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("c-code/generated/io.c");
    fsa.generateFile(_builder_1.toString(), fileContent);
  }
  
  public void generateConstantsFile(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#ifndef _cnst_h");
    _builder.newLine();
    _builder.append("#define _cnst_h 1");
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
    _builder.append("#endif");
    _builder.newLine();
    final String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("c-code/generated/cnst.h");
    fsa.generateFile(_builder_1.toString(), fileContent);
  }
  
  public String generateConstants(final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Const> _consts = this.program.getConsts();
      for(final Const constant : _consts) {
        _builder.append("#define ");
        String _constantId = this.identifiersHelper.getConstantId(constant);
        _builder.append(_constantId);
        _builder.append(" ");
        String _translateExpr = this.translateExpr(constant.getValue());
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
      EList<ru.iaie.reflex.reflex.Enum> _enums = this.program.getEnums();
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
    _builder.append("/* GVAR.H = Global Variables Image-File. */");
    _builder.newLine();
    _builder.append("#ifndef _gvar_h");
    _builder.newLine();
    _builder.append("#define _gvar_h 1");
    _builder.newLine();
    _builder.append("/*       Process variables     */");
    _builder.newLine();
    String _generateProcessVariables = this.generateProcessVariables(resource, false);
    _builder.append(_generateProcessVariables);
    _builder.newLineIfNotEmpty();
    _builder.append("/*          Input Ports         */");
    _builder.newLine();
    String _generateInputPorts = this.generateInputPorts(resource, false);
    _builder.append(_generateInputPorts);
    _builder.newLineIfNotEmpty();
    _builder.append("/*         Output Ports         */");
    _builder.newLine();
    String _generateOutputPorts = this.generateOutputPorts(resource, false);
    _builder.append(_generateOutputPorts);
    _builder.newLineIfNotEmpty();
    _builder.append("#endif");
    _builder.newLine();
    final String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("c-code/generated/gvar.h");
    fsa.generateFile(_builder_1.toString(), fileContent);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("/*           Variables          */");
    _builder_2.newLine();
    _builder_2.append("/* xvar.h = Extern Variables Image-File. */");
    _builder_2.newLine();
    _builder_2.append("#ifndef _xvar_h");
    _builder_2.newLine();
    _builder_2.append("#define _xvar_h 1");
    _builder_2.newLine();
    _builder_2.append("/*       Process variables     */");
    _builder_2.newLine();
    String _generateProcessVariables_1 = this.generateProcessVariables(resource, true);
    _builder_2.append(_generateProcessVariables_1);
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("/*          Input Ports         */");
    _builder_2.newLine();
    String _generateInputPorts_1 = this.generateInputPorts(resource, true);
    _builder_2.append(_generateInputPorts_1);
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("/*         Output Ports         */");
    _builder_2.newLine();
    String _generateOutputPorts_1 = this.generateOutputPorts(resource, true);
    _builder_2.append(_generateOutputPorts_1);
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("#endif");
    _builder_2.newLine();
    final String externFileContent = _builder_2.toString();
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("c-code/generated/xvar.h");
    fsa.generateFile(_builder_3.toString(), externFileContent);
  }
  
  public String generateProcessVariables(final Resource resource, final boolean externDef) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<GlobalVariable> _globalVars = this.program.getGlobalVars();
      for(final GlobalVariable variable : _globalVars) {
        {
          if (externDef) {
            _builder.append("extern ");
          }
        }
        String _generateGlobalVariableDefinition = this.generateGlobalVariableDefinition(variable);
        _builder.append(_generateGlobalVariableDefinition);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<ru.iaie.reflex.reflex.Process> _processes = this.program.getProcesses();
      for(final ru.iaie.reflex.reflex.Process proc : _processes) {
        {
          EList<ProcessVariable> _variables = proc.getVariables();
          for(final ProcessVariable variable_1 : _variables) {
            {
              if (externDef) {
                _builder.append("extern ");
              }
            }
            String _generateProcessVariableDefinition = this.generateProcessVariableDefinition(proc, variable_1);
            _builder.append(_generateProcessVariableDefinition);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder.toString();
  }
  
  public String generateProcessVariableDefinition(final ru.iaie.reflex.reflex.Process proc, final ProcessVariable variable) {
    boolean _isImportedList = ReflexModelUtil.isImportedList(variable);
    boolean _not = (!_isImportedList);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      String _translateType = this.translateType(ReflexModelUtil.getType(variable));
      _builder.append(_translateType);
      _builder.append(" ");
      String _processVariableId = this.identifiersHelper.getProcessVariableId(proc, variable);
      _builder.append(_processVariableId);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      return _builder.toString();
    }
    return null;
  }
  
  public String generateGlobalVariableDefinition(final GlobalVariable variable) {
    StringConcatenation _builder = new StringConcatenation();
    String _translateType = this.translateType(ReflexModelUtil.getType(variable));
    _builder.append(_translateType);
    _builder.append(" ");
    String _globalVariableId = this.identifiersHelper.getGlobalVariableId(variable);
    _builder.append(_globalVariableId);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String generateInputPorts(final Resource resource, final boolean externDef) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Register> _registers = this.program.getRegisters();
      for(final Register reg : _registers) {
        {
          RegisterType _type = reg.getType();
          boolean _equals = Objects.equal(_type, RegisterType.INPUT);
          if (_equals) {
            {
              if (externDef) {
                _builder.append("extern ");
              }
            }
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
  
  public String generateOutputPorts(final Resource resource, final boolean externDef) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Register> _registers = this.program.getRegisters();
      for(final Register reg : _registers) {
        {
          RegisterType _type = reg.getType();
          boolean _equals = Objects.equal(_type, RegisterType.OUTPUT);
          if (_equals) {
            {
              if (externDef) {
                _builder.append("extern ");
              }
            }
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
  
  public void generateProcessDefinitions(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#ifndef _proc_h");
    _builder.newLine();
    _builder.append("#define _proc_h 1");
    _builder.newLine();
    {
      EList<ru.iaie.reflex.reflex.Process> _processes = this.program.getProcesses();
      for(final ru.iaie.reflex.reflex.Process process : _processes) {
        _builder.append("void ");
        String _processFuncId = this.identifiersHelper.getProcessFuncId(process);
        _builder.append(_processFuncId);
        _builder.append("();");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("#define PROCESS_Nn ");
    int _size = this.program.getProcesses().size();
    int _minus = (_size - 1);
    _builder.append(_minus);
    _builder.newLineIfNotEmpty();
    _builder.append("#define PROCESS_N1 0");
    _builder.newLine();
    _builder.append("#endif");
    _builder.newLine();
    final String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("c-code/generated/proc.h");
    fsa.generateFile(_builder_1.toString(), fileContent);
  }
  
  public void generateProcessImplementations(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* FILE OF PROC-IMAGES OF THE PROJECT */");
    _builder.newLine();
    _builder.append("#include \"ext.h\" /* Common files for all generated c-files */");
    _builder.newLine();
    _builder.append("#include \"xvar.h\"  /* Var-images */");
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
    _builder_1.append("c-code/generated/proc.c");
    fsa.generateFile(_builder_1.toString(), fileContent);
  }
  
  public void generateMain(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* MAIN FILE OF THE PROJECT */");
    _builder.newLine();
    _builder.append("#include \"ext.h\" /* Common files for all generated c-files */");
    _builder.newLine();
    _builder.append("#include \"proc.h\"  /* Process-functions desription */");
    _builder.newLine();
    _builder.append("#include \"gvar.h\"  /* Project variables images */");
    _builder.newLine();
    _builder.append("#include \"io.h\"    /* Scan-input/output functions */");
    _builder.newLine();
    _builder.append("#include \"../lib/r_main.h\"  /* Code of the main-function that calls Control_Loop */");
    _builder.newLine();
    _builder.newLine();
    _builder.append("void Control_Loop (void)    /* Control algorithm */");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Init_PSW((INT16S)(PROCESS_N1), (INT16S)PROCESS_Nn);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (;;) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Input();");
    _builder.newLine();
    {
      EList<ru.iaie.reflex.reflex.Process> _processes = this.program.getProcesses();
      for(final ru.iaie.reflex.reflex.Process proc : _processes) {
        _builder.append("\t\t");
        String _processFuncId = this.identifiersHelper.getProcessFuncId(proc);
        _builder.append(_processFuncId, "\t\t");
        _builder.append("(); /* Process ");
        String _name = proc.getName();
        _builder.append(_name, "\t\t");
        _builder.append(" */");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("Output();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Prepare_PSW((INT16S)(PROCESS_N1), (INT16S)PROCESS_Nn);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int main() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Control_Loop();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("c-code/generated/main.c");
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
    int _index = ReflexModelUtil.getIndex(proc);
    _builder.append(_index, "\t");
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
        String _translateStatement = this.translateStatement(proc, state, stat);
        _builder.append(_translateStatement, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      TimeoutFunction _timeoutFunction = state.getTimeoutFunction();
      boolean _tripleNotEquals = (_timeoutFunction != null);
      if (_tripleNotEquals) {
        _builder.append("\t");
        String _translateTimeoutFunction = this.translateTimeoutFunction(proc, state, state.getTimeoutFunction());
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
    String _translateStatement = this.translateStatement(proc, state, func.getBody());
    _builder.append(_translateStatement, "\t");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String translateStateStopCheck(final ru.iaie.reflex.reflex.Process proc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Check_State(");
    int _index = ReflexModelUtil.getIndex(proc);
    _builder.append(_index);
    _builder.append(") == STATE_OF_STOP");
    return _builder.toString();
  }
  
  public String translateStateErrorCheck(final ru.iaie.reflex.reflex.Process proc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Check_State(");
    int _index = ReflexModelUtil.getIndex(proc);
    _builder.append(_index);
    _builder.append(") == STATE_OF_ERROR");
    return _builder.toString();
  }
  
  public String translateCheckStateExpression(final CheckStateExpression cse) {
    StateQualifier _qualfier = cse.getQualfier();
    if (_qualfier != null) {
      switch (_qualfier) {
        case STOP:
          return this.translateStateStopCheck(cse.getProcess());
        case ERROR:
          return this.translateStateErrorCheck(cse.getProcess());
        case ACTIVE:
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("!(");
          String _translateStateStopCheck = this.translateStateStopCheck(cse.getProcess());
          _builder.append(_translateStateStopCheck);
          _builder.append(" || ");
          String _translateStateErrorCheck = this.translateStateErrorCheck(cse.getProcess());
          _builder.append(_translateStateErrorCheck);
          _builder.append(")");
          return _builder.toString();
        case INACTIVE:
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("(");
          String _translateStateStopCheck_1 = this.translateStateStopCheck(cse.getProcess());
          _builder_1.append(_translateStateStopCheck_1);
          _builder_1.append(" || ");
          String _translateStateErrorCheck_1 = this.translateStateErrorCheck(cse.getProcess());
          _builder_1.append(_translateStateErrorCheck_1);
          _builder_1.append(")");
          return _builder_1.toString();
        default:
          break;
      }
    }
    return null;
  }
  
  public String translateTimeout(final TimeoutFunction func) {
    String _xblockexpression = null;
    {
      boolean _isClearTimeout = ReflexModelUtil.isClearTimeout(func);
      if (_isClearTimeout) {
        return func.getTime().getTicks();
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
      if (statement instanceof CompoundStatement) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{");
        _builder.newLine();
        {
          EList<Statement> _statements = ((CompoundStatement)statement).getStatements();
          for(final Statement stat : _statements) {
            String _translateStatement = this.translateStatement(proc, state, stat);
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
  
  public String translateIfElseStat(final ru.iaie.reflex.reflex.Process proc, final State state, final IfElseStat stat) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (");
    String _translateExpr = this.translateExpr(stat.getCond());
    _builder.append(_translateExpr);
    _builder.append(") ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _translateStatement = this.translateStatement(proc, state, stat.getThen());
    _builder.append(_translateStatement, "\t");
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
  
  public String translateResetTimer(final ru.iaie.reflex.reflex.Process proc, final State state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Reset_Timer(");
    int _index = ReflexModelUtil.getIndex(proc);
    _builder.append(_index);
    _builder.append(");");
    return _builder.toString();
  }
  
  public String translateSetStateStat(final ru.iaie.reflex.reflex.Process proc, final State state, final SetStateStat sss) {
    boolean _isNext = sss.isNext();
    if (_isNext) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Set_State(");
      int _index = ReflexModelUtil.getIndex(proc);
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
    int _index_2 = ReflexModelUtil.getIndex(proc);
    _builder_1.append(_index_2);
    _builder_1.append(", ");
    int _index_3 = ReflexModelUtil.getIndex(sss.getState());
    _builder_1.append(_index_3);
    _builder_1.append(");");
    return _builder_1.toString();
  }
  
  public String translateStopProcStat(final ru.iaie.reflex.reflex.Process proc, final State state, final StopProcStat sps) {
    ru.iaie.reflex.reflex.Process _xifexpression = null;
    boolean _selfStop = ReflexModelUtil.selfStop(sps);
    if (_selfStop) {
      _xifexpression = proc;
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
  
  public String translateStartProcStat(final ru.iaie.reflex.reflex.Process proc, final State state, final StartProcStat sps) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Set_Start(");
    int _index = ReflexModelUtil.getIndex(sps.getProcess());
    _builder.append(_index);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String translateRestartProcStat(final ru.iaie.reflex.reflex.Process proc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Set_Start(");
    int _index = ReflexModelUtil.getIndex(proc);
    _builder.append(_index);
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
          return this.translateBoolLiteral(((PrimaryExpression)expr).getBool());
        }
        boolean _isReference = ExpressionUtil.isReference(((PrimaryExpression)expr));
        if (_isReference) {
          return this.translateExpr(((PrimaryExpression)expr).getReference());
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
        String _translateType = this.translateType(((CastExpression)expr).getType());
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
  
  public String translateType(final Type t) {
    Types _name = t.getName();
    boolean _equals = Objects.equal(_name, Types.BOOL_TYPE);
    if (_equals) {
      return "char";
    }
    StringConcatenation _builder = new StringConcatenation();
    Types _name_1 = t.getName();
    _builder.append(_name_1);
    return _builder.toString();
  }
  
  public String translateBoolLiteral(final Boolean l) {
    String _xifexpression = null;
    boolean _booleanValue = l.booleanValue();
    if (_booleanValue) {
      _xifexpression = "TRUE";
    } else {
      _xifexpression = "FALSE";
    }
    return _xifexpression;
  }
}
