package ru.iaie.reflex.generator.r2c.common;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import ru.iaie.reflex.generator.r2c.common.ProcessGenerator;
import ru.iaie.reflex.generator.r2c.common.R2CResourceProvider;
import ru.iaie.reflex.generator.r2c.helpers.ConstantGenerationHelper;
import ru.iaie.reflex.generator.r2c.helpers.PortGenerationHelper;
import ru.iaie.reflex.generator.r2c.helpers.ReflexIdentifiersHelper;
import ru.iaie.reflex.generator.r2c.helpers.VariableGenerationHelper;
import ru.iaie.reflex.generator.r2c.interfaces.IFileGenerator;
import ru.iaie.reflex.generator.r2c.interfaces.IReflexIdentifiersHelper;
import ru.iaie.reflex.generator.r2c.util.LiteralGenerationUtil;
import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.GlobalVariable;
import ru.iaie.reflex.reflex.PhysicalVariable;
import ru.iaie.reflex.reflex.Port;
import ru.iaie.reflex.reflex.PortType;
import ru.iaie.reflex.reflex.ProcessVariable;
import ru.iaie.reflex.reflex.Program;
import ru.iaie.reflex.utils.ReflexModelUtil;

@SuppressWarnings("all")
public class R2CFileGenerator implements IFileGenerator {
  protected String C_STANDART = "99";
  
  protected String GENERATED_DIR_NAME = "generated";
  
  protected Program program;
  
  protected IFileSystemAccess2 fsa;
  
  private IReflexIdentifiersHelper identifiersHelper;
  
  private PortGenerationHelper portGenerationHelper;
  
  private ConstantGenerationHelper constGenerationHelper;
  
  private VariableGenerationHelper varGenerationHelper;
  
  protected static String CLOCK_CONST_NAME = "_r_CLOCK";
  
  protected static String CUR_TIME_NAME = "_r_cur_time";
  
  protected static String NEXT_TIME_NAME = "_r_next_act_time";
  
  public String getRootDirName() {
    return "c-code";
  }
  
  public R2CFileGenerator(final Resource resource, final IFileSystemAccess2 fsa) {
    this.program = ReflexModelUtil.getProgram(resource);
    this.fsa = fsa;
    ReflexIdentifiersHelper _reflexIdentifiersHelper = new ReflexIdentifiersHelper();
    this.identifiersHelper = _reflexIdentifiersHelper;
    PortGenerationHelper _portGenerationHelper = new PortGenerationHelper(this.identifiersHelper);
    this.portGenerationHelper = _portGenerationHelper;
    ConstantGenerationHelper _constantGenerationHelper = new ConstantGenerationHelper(this.identifiersHelper);
    this.constGenerationHelper = _constantGenerationHelper;
    VariableGenerationHelper _variableGenerationHelper = new VariableGenerationHelper(this.identifiersHelper);
    this.varGenerationHelper = _variableGenerationHelper;
  }
  
  @Override
  public void prepareForGeneration() {
    for (final String resource : R2CResourceProvider.COMMON_RESOURCES) {
      StringConcatenation _builder = new StringConcatenation();
      String _rootDirName = this.getRootDirName();
      _builder.append(_rootDirName);
      _builder.append("/");
      _builder.append(resource);
      Class<? extends R2CFileGenerator> _class = this.getClass();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("/resources/");
      _builder_1.append(resource);
      this.fsa.generateFile(_builder.toString(), _class.getResourceAsStream(_builder_1.toString()));
    }
  }
  
  @Override
  public void generateBuildFiles() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("cmake_minimum_required(VERSION 3.15)");
    _builder.newLine();
    _builder.append("project(");
    String _lowerCase = this.program.getName().toLowerCase();
    _builder.append(_lowerCase);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("set(CMAKE_C_STANDARD ");
    _builder.append(this.C_STANDART);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("set(CMAKE_C_FLAGS \"-Wall\")");
    _builder.newLine();
    _builder.newLine();
    _builder.append("add_executable(");
    String _lowerCase_1 = this.program.getName().toLowerCase();
    _builder.append(_lowerCase_1);
    _builder.append(" generated/main.c generated/proc.c lib/r_lib.c usr/usr.c generated/io.c generated/platform.c)");
    _builder.newLineIfNotEmpty();
    String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    String _rootDirName = this.getRootDirName();
    _builder_1.append(_rootDirName);
    _builder_1.append("/CMakeLists.txt");
    this.fsa.generateFile(_builder_1.toString(), fileContent);
  }
  
  @Override
  public void generateIOFiles() {
    final ArrayList<PhysicalVariable> inputVars = CollectionLiterals.<PhysicalVariable>newArrayList();
    final ArrayList<PhysicalVariable> outputVars = CollectionLiterals.<PhysicalVariable>newArrayList();
    final Consumer<PhysicalVariable> _function = (PhysicalVariable v) -> {
      PortType _mappedPortType = ReflexModelUtil.getMappedPortType(v);
      boolean _equals = Objects.equal(_mappedPortType, PortType.INPUT);
      if (_equals) {
        inputVars.add(v);
      } else {
        outputVars.add(v);
      }
    };
    EcoreUtil2.<PhysicalVariable>eAllOfType(this.program, PhysicalVariable.class).forEach(_function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#include \"io.h\"");
    _builder.newLine();
    _builder.append("#include \"xvar.h\"");
    _builder.newLine();
    _builder.append("#include \"../lib/r_cnst.h\"");
    _builder.newLine();
    _builder.append("#include \"../lib/platform.h\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("void Input(void) {");
    _builder.newLine();
    {
      final Function1<Port, Boolean> _function_1 = (Port it) -> {
        PortType _type = it.getType();
        return Boolean.valueOf(Objects.equal(_type, PortType.INPUT));
      };
      Iterable<Port> _filter = IterableExtensions.<Port>filter(this.program.getPorts(), _function_1);
      for(final Port inPort : _filter) {
        _builder.append("\t");
        String _translateInputPortReading = this.portGenerationHelper.translateInputPortReading(inPort);
        _builder.append(_translateInputPortReading, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      for(final PhysicalVariable physVar : inputVars) {
        _builder.append("    ");
        String _translateReadingFromInput = this.portGenerationHelper.translateReadingFromInput(physVar);
        _builder.append(_translateReadingFromInput, "    ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("void Output(void) {");
    _builder.newLine();
    {
      for(final PhysicalVariable physVar_1 : outputVars) {
        _builder.append("\t");
        String _translateReadingFromOutput = this.portGenerationHelper.translateReadingFromOutput(physVar_1);
        _builder.append(_translateReadingFromOutput, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      final Function1<Port, Boolean> _function_2 = (Port it) -> {
        PortType _type = it.getType();
        return Boolean.valueOf(Objects.equal(_type, PortType.OUTPUT));
      };
      Iterable<Port> _filter_1 = IterableExtensions.<Port>filter(this.program.getPorts(), _function_2);
      for(final Port outPort : _filter_1) {
        String _translateOutputPortWriting = this.portGenerationHelper.translateOutputPortWriting(outPort);
        _builder.append(_translateOutputPortWriting);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    final String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    String _rootDirName = this.getRootDirName();
    _builder_1.append(_rootDirName);
    _builder_1.append("/");
    _builder_1.append(this.GENERATED_DIR_NAME);
    _builder_1.append("/io.c");
    this.fsa.generateFile(_builder_1.toString(), fileContent);
  }
  
  @Override
  public void generatePlatformImplementations() {
    StringConcatenation _builder = new StringConcatenation();
    String _rootDirName = this.getRootDirName();
    _builder.append(_rootDirName);
    _builder.append("/");
    _builder.append(this.GENERATED_DIR_NAME);
    _builder.append("/platform.c");
    this.fsa.generateFile(_builder.toString(), R2CResourceProvider.DUMMY_PLATFORM_IMPL);
  }
  
  @Override
  public void generateConstantDefinitions() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#ifndef _cnst_h");
    _builder.newLine();
    _builder.append("#define _cnst_h 1");
    _builder.newLine();
    _builder.newLine();
    String _generateConstants = this.generateConstants();
    _builder.append(_generateConstants);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _generateEnums = this.generateEnums();
    _builder.append(_generateEnums);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _generateClockConst = this.generateClockConst();
    _builder.append(_generateClockConst);
    _builder.newLineIfNotEmpty();
    _builder.append("#endif");
    _builder.newLine();
    final String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    String _rootDirName = this.getRootDirName();
    _builder_1.append(_rootDirName);
    _builder_1.append("/");
    _builder_1.append(this.GENERATED_DIR_NAME);
    _builder_1.append("/cnst.h");
    this.fsa.generateFile(_builder_1.toString(), fileContent);
  }
  
  @Override
  public void generateVariableDefinitions() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#ifndef _gvar_h");
    _builder.newLine();
    _builder.append("#define _gvar_h 1");
    _builder.newLine();
    _builder.append("#include \"../lib/r_cnst.h\"");
    _builder.newLine();
    String _generateTimeVariableDefinitions = this.generateTimeVariableDefinitions(false);
    _builder.append(_generateTimeVariableDefinitions);
    _builder.newLineIfNotEmpty();
    String _generateVariables = this.generateVariables(false);
    _builder.append(_generateVariables);
    _builder.newLineIfNotEmpty();
    String _generatePorts = this.generatePorts(false);
    _builder.append(_generatePorts);
    _builder.newLineIfNotEmpty();
    _builder.append("#endif");
    _builder.newLine();
    final String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    String _rootDirName = this.getRootDirName();
    _builder_1.append(_rootDirName);
    _builder_1.append("/generated/gvar.h");
    this.fsa.generateFile(_builder_1.toString(), fileContent);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("#ifndef _xvar_h");
    _builder_2.newLine();
    _builder_2.append("#define _xvar_h 1");
    _builder_2.newLine();
    _builder_2.append("#include \"../lib/r_cnst.h\"");
    _builder_2.newLine();
    String _generateTimeVariableDefinitions_1 = this.generateTimeVariableDefinitions(true);
    _builder_2.append(_generateTimeVariableDefinitions_1);
    _builder_2.newLineIfNotEmpty();
    String _generateVariables_1 = this.generateVariables(true);
    _builder_2.append(_generateVariables_1);
    _builder_2.newLineIfNotEmpty();
    String _generatePorts_1 = this.generatePorts(true);
    _builder_2.append(_generatePorts_1);
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("#endif");
    _builder_2.newLine();
    final String externFileContent = _builder_2.toString();
    StringConcatenation _builder_3 = new StringConcatenation();
    String _rootDirName_1 = this.getRootDirName();
    _builder_3.append(_rootDirName_1);
    _builder_3.append("/");
    _builder_3.append(this.GENERATED_DIR_NAME);
    _builder_3.append("/xvar.h");
    this.fsa.generateFile(_builder_3.toString(), externFileContent);
  }
  
  @Override
  public void generateProcessDefinitions() {
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
    String _rootDirName = this.getRootDirName();
    _builder_1.append(_rootDirName);
    _builder_1.append("/");
    _builder_1.append(this.GENERATED_DIR_NAME);
    _builder_1.append("/proc.h");
    this.fsa.generateFile(_builder_1.toString(), fileContent);
  }
  
  @Override
  public void generateProcessImplementations() {
    final Function1<ru.iaie.reflex.reflex.Process, ProcessGenerator> _function = (ru.iaie.reflex.reflex.Process p) -> {
      return new ProcessGenerator(p, this.identifiersHelper);
    };
    final List<ProcessGenerator> processGenerators = ListExtensions.<ru.iaie.reflex.reflex.Process, ProcessGenerator>map(this.program.getProcesses(), _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* FILE OF PROC-IMAGES OF THE PROJECT */");
    _builder.newLine();
    _builder.append("#include \"ext.h\" /* Common files for all generated c-files */");
    _builder.newLine();
    _builder.append("#include \"xvar.h\"  /* Var-images */");
    _builder.newLine();
    {
      for(final ProcessGenerator gen : processGenerators) {
        String _generate = gen.generate();
        _builder.append(_generate);
        _builder.newLineIfNotEmpty();
      }
    }
    final String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    String _rootDirName = this.getRootDirName();
    _builder_1.append(_rootDirName);
    _builder_1.append("/");
    _builder_1.append(this.GENERATED_DIR_NAME);
    _builder_1.append("/proc.c");
    this.fsa.generateFile(_builder_1.toString(), fileContent);
  }
  
  @Override
  public void generateMain() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#include \"ext.h\" /* Common files for all generated c-files */");
    _builder.newLine();
    _builder.append("#include \"proc.h\"  /* Process-functions desription */");
    _builder.newLine();
    _builder.append("#include \"gvar.h\"  /* Project variables images */");
    _builder.newLine();
    _builder.append("#include \"io.h\"    /* Scan-input/output functions */");
    _builder.newLine();
    _builder.append("#include \"../lib/platform.h\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("void Control_Loop(void)    /* Control algorithm */");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Init_Processes();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Init_Time();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Init_IO();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (;;) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(R2CFileGenerator.CUR_TIME_NAME, "\t\t");
    _builder.append(" = Get_Time();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("if (");
    _builder.append(R2CFileGenerator.CUR_TIME_NAME, "\t\t");
    _builder.append(" - ");
    _builder.append(R2CFileGenerator.NEXT_TIME_NAME, "\t\t");
    _builder.append(" >= 0) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("// Find next activation time");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append(R2CFileGenerator.NEXT_TIME_NAME, "\t\t\t");
    _builder.append(" += ");
    _builder.append(R2CFileGenerator.CLOCK_CONST_NAME, "\t\t\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("if (");
    _builder.append(R2CFileGenerator.NEXT_TIME_NAME, "\t\t\t");
    _builder.append(" - ");
    _builder.append(R2CFileGenerator.CUR_TIME_NAME, "\t\t\t");
    _builder.append(" > _r_CLOCK) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append(R2CFileGenerator.NEXT_TIME_NAME, "\t\t\t\t");
    _builder.append(" = ");
    _builder.append(R2CFileGenerator.CUR_TIME_NAME, "\t\t\t\t");
    _builder.append(" + _r_CLOCK;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Input();");
    _builder.newLine();
    {
      EList<ru.iaie.reflex.reflex.Process> _processes = this.program.getProcesses();
      for(final ru.iaie.reflex.reflex.Process proc : _processes) {
        _builder.append("\t\t\t");
        String _processFuncId = this.identifiersHelper.getProcessFuncId(proc);
        _builder.append(_processFuncId, "\t\t\t");
        _builder.append("(); /* Process ");
        String _name = proc.getName();
        _builder.append(_name, "\t\t\t");
        _builder.append(" */");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("Output();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int main() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Control_Loop();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    String _rootDirName = this.getRootDirName();
    _builder_1.append(_rootDirName);
    _builder_1.append("/");
    _builder_1.append(this.GENERATED_DIR_NAME);
    _builder_1.append("/main.c");
    this.fsa.generateFile(_builder_1.toString(), fileContent);
  }
  
  public String generateVariables(final boolean externDef) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<GlobalVariable> _globalVars = this.program.getGlobalVars();
      for(final GlobalVariable variable : _globalVars) {
        {
          if (externDef) {
            _builder.append("extern ");
          }
        }
        String _generateGlobalVariableDefinition = this.varGenerationHelper.generateGlobalVariableDefinition(variable);
        _builder.append(_generateGlobalVariableDefinition);
        _builder.append(";");
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
            String _generateProcessVariableDefinition = this.varGenerationHelper.generateProcessVariableDefinition(variable_1);
            _builder.append(_generateProcessVariableDefinition);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder.toString();
  }
  
  public String generatePorts(final boolean externDef) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Port> _ports = this.program.getPorts();
      for(final Port reg : _ports) {
        {
          if (externDef) {
            _builder.append("extern ");
          }
        }
        String _generatePortVariableDefinition = this.portGenerationHelper.generatePortVariableDefinition(reg);
        _builder.append(_generatePortVariableDefinition);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  public String generateClockConst() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#define ");
    _builder.append(R2CFileGenerator.CLOCK_CONST_NAME);
    _builder.append(" ");
    String _translateClockDefinition = LiteralGenerationUtil.translateClockDefinition(this.program.getClock());
    _builder.append(_translateClockDefinition);
    return _builder.toString();
  }
  
  public String generateConstants() {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Const> _consts = this.program.getConsts();
      for(final Const constant : _consts) {
        String _generateConstantDefinition = this.constGenerationHelper.generateConstantDefinition(constant);
        _builder.append(_generateConstantDefinition);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  public String generateEnums() {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ru.iaie.reflex.reflex.Enum> _enums = this.program.getEnums();
      for(final ru.iaie.reflex.reflex.Enum en : _enums) {
        String _generateEnumDefifnition = this.constGenerationHelper.generateEnumDefifnition(en);
        _builder.append(_generateEnumDefifnition);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  public String generateTimeVariableDefinitions(final boolean extern) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (extern) {
        _builder.append("extern ");
      }
    }
    _builder.append("INT32_U ");
    _builder.append(R2CFileGenerator.CUR_TIME_NAME);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      if (extern) {
        _builder.append("extern ");
      }
    }
    _builder.append("INT32_U ");
    _builder.append(R2CFileGenerator.NEXT_TIME_NAME);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
}
