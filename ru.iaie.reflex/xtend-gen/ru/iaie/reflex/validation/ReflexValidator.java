/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import ru.iaie.reflex.reflex.AssignmentExpression;
import ru.iaie.reflex.reflex.CompoundStatement;
import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.EnumMember;
import ru.iaie.reflex.reflex.ErrorStat;
import ru.iaie.reflex.reflex.Expression;
import ru.iaie.reflex.reflex.GlobalVariable;
import ru.iaie.reflex.reflex.IdReference;
import ru.iaie.reflex.reflex.IfElseStat;
import ru.iaie.reflex.reflex.ImportedVariableList;
import ru.iaie.reflex.reflex.PhysicalVariable;
import ru.iaie.reflex.reflex.Port;
import ru.iaie.reflex.reflex.PortMapping;
import ru.iaie.reflex.reflex.PortType;
import ru.iaie.reflex.reflex.ProcessVariable;
import ru.iaie.reflex.reflex.Program;
import ru.iaie.reflex.reflex.ProgramVariable;
import ru.iaie.reflex.reflex.ReflexPackage;
import ru.iaie.reflex.reflex.SetStateStat;
import ru.iaie.reflex.reflex.StartProcStat;
import ru.iaie.reflex.reflex.Statement;
import ru.iaie.reflex.reflex.StopProcStat;
import ru.iaie.reflex.reflex.SwitchStat;
import ru.iaie.reflex.reflex.TimeoutFunction;
import ru.iaie.reflex.reflex.Type;
import ru.iaie.reflex.typing.TypeUtils;
import ru.iaie.reflex.typing.TypeWarning;
import ru.iaie.reflex.utils.ExpressionUtil;
import ru.iaie.reflex.utils.LiteralUtils;
import ru.iaie.reflex.utils.ReflexModelUtil;
import ru.iaie.reflex.validation.AbstractReflexValidator;

/**
 * This class contains custom validation rules.
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class ReflexValidator extends AbstractReflexValidator {
  private static ReflexPackage ePackage = ReflexPackage.eINSTANCE;
  
  @Check
  public void checkForNextState(final SetStateStat setStateStat) {
    boolean _isNext = setStateStat.isNext();
    if (_isNext) {
      final ru.iaie.reflex.reflex.State state = EcoreUtil2.<ru.iaie.reflex.reflex.State>getContainerOfType(setStateStat, ru.iaie.reflex.reflex.State.class);
      final ru.iaie.reflex.reflex.Process process = EcoreUtil2.<ru.iaie.reflex.reflex.Process>getContainerOfType(setStateStat, ru.iaie.reflex.reflex.Process.class);
      int _index = ReflexModelUtil.getIndex(state);
      int _plus = (_index + 1);
      int _length = ((Object[])Conversions.unwrapArray(process.getStates(), Object.class)).length;
      boolean _greaterEqualsThan = (_plus >= _length);
      if (_greaterEqualsThan) {
        this.error("Invalid state transition: no next state in the process", ReflexValidator.ePackage.getSetStateStat_Next());
      }
    }
  }
  
  @Check
  public void checkStateTransitions(final ru.iaie.reflex.reflex.State state) {
    boolean _isLooped = state.isLooped();
    if (_isLooped) {
      return;
    }
    final Iterator<SetStateStat> stateTransitions = Iterators.<SetStateStat>filter(state.eAllContents(), SetStateStat.class);
    boolean _isEmpty = IteratorExtensions.isEmpty(stateTransitions);
    if (_isEmpty) {
      final Function1<StopProcStat, Boolean> _function = (StopProcStat it) -> {
        return Boolean.valueOf(ReflexModelUtil.selfStop(it));
      };
      final Iterator<StopProcStat> selfStopTransitions = IteratorExtensions.<StopProcStat>filter(Iterators.<StopProcStat>filter(state.eAllContents(), StopProcStat.class), _function);
      boolean _isEmpty_1 = IteratorExtensions.isEmpty(selfStopTransitions);
      if (_isEmpty_1) {
        final Function1<ErrorStat, Boolean> _function_1 = (ErrorStat it) -> {
          return Boolean.valueOf(ReflexModelUtil.selfError(it));
        };
        final Iterator<ErrorStat> selfErrorTransitions = IteratorExtensions.<ErrorStat>filter(Iterators.<ErrorStat>filter(state.eAllContents(), ErrorStat.class), _function_1);
        boolean _isEmpty_2 = IteratorExtensions.isEmpty(selfErrorTransitions);
        if (_isEmpty_2) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Potential cycle in state ");
          String _name = state.getName();
          _builder.append(_name);
          _builder.append(": no state transitions declared");
          this.error(_builder.toString(), 
            ReflexValidator.ePackage.getState_Name());
        }
      }
    }
  }
  
  @Check
  public void checkStartStatement(final StartProcStat startStat) {
    final ru.iaie.reflex.reflex.Process selfProcess = EcoreUtil2.<ru.iaie.reflex.reflex.Process>getContainerOfType(startStat, ru.iaie.reflex.reflex.Process.class);
    final String procName = startStat.getProcess().getName();
    boolean _equals = selfProcess.getName().equals(procName);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Use \'restart\' statement for restarting current process");
      this.warning(_builder.toString(), ReflexValidator.ePackage.getStartProcStat_Process());
    }
  }
  
  @Check
  public void checkStopStatement(final StopProcStat stopStat) {
    final ru.iaie.reflex.reflex.Process selfProcess = EcoreUtil2.<ru.iaie.reflex.reflex.Process>getContainerOfType(stopStat, ru.iaie.reflex.reflex.Process.class);
    final String procName = stopStat.getProcess().getName();
    boolean _equals = selfProcess.getName().equals(procName);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Use \'stop\' without argument to stop current process");
      this.warning(_builder.toString(), ReflexValidator.ePackage.getStopProcStat_Process());
    }
  }
  
  @Check
  public void checkErrorStatement(final ErrorStat errorStat) {
    final ru.iaie.reflex.reflex.Process selfProcess = EcoreUtil2.<ru.iaie.reflex.reflex.Process>getContainerOfType(errorStat, ru.iaie.reflex.reflex.Process.class);
    final String procName = errorStat.getProcess().getName();
    boolean _equals = selfProcess.getName().equals(procName);
    if (_equals) {
      this.warning("Use \'error\' without argument to set current process state to error", ReflexValidator.ePackage.getErrorStat_Process());
    }
  }
  
  @Check
  public void checkAssignVariable(final AssignmentExpression expr) {
    boolean _hasAssignment = ExpressionUtil.hasAssignment(expr);
    if (_hasAssignment) {
      final IdReference assignVar = expr.getAssignVar();
      if ((assignVar instanceof PhysicalVariable)) {
        PortType _mappedPortType = ReflexModelUtil.getMappedPortType(((PhysicalVariable)assignVar));
        boolean _equals = Objects.equal(_mappedPortType, PortType.INPUT);
        if (_equals) {
          this.warning("An attempt to assign value into variable mapped on input port", 
            ReflexValidator.ePackage.getAssignmentExpression_AssignVar());
        }
      }
      if (((assignVar instanceof Const) || (assignVar instanceof EnumMember))) {
        this.error("Can\'t assign values to constants or enum members", ReflexValidator.ePackage.getAssignmentExpression_AssignVar());
      }
    }
  }
  
  @Check
  public void checkOutputVarUsagesInAssignment(final PhysicalVariable physVar) {
    PortType _mappedPortType = ReflexModelUtil.getMappedPortType(physVar);
    boolean _equals = Objects.equal(_mappedPortType, PortType.OUTPUT);
    if (_equals) {
      final Program program = EcoreUtil2.<Program>getContainerOfType(physVar, Program.class);
      boolean usedInAssignment = ReflexModelUtil.containsReferencesOfType(program, physVar, ReflexValidator.ePackage.getAssignmentExpression_AssignVar());
      if ((!usedInAssignment)) {
        this.warning("Variable mapped on output port is not used in assignment", ReflexValidator.ePackage.getPhysicalVariable_Name());
      }
    }
  }
  
  @Check
  public void checkStateReachability(final ru.iaie.reflex.reflex.State state) {
    final ru.iaie.reflex.reflex.Process process = EcoreUtil2.<ru.iaie.reflex.reflex.Process>getContainerOfType(state, ru.iaie.reflex.reflex.Process.class);
    int curStateIndex = ReflexModelUtil.getIndex(state);
    if ((curStateIndex == 0)) {
      return;
    }
    boolean transitionExists = ReflexModelUtil.containsReferencesOfType(process, state, ReflexValidator.ePackage.getSetStateStat_State());
    if ((!transitionExists)) {
      final ru.iaie.reflex.reflex.State prevState = process.getStates().get((curStateIndex - 1));
      final Function1<SetStateStat, Boolean> _function = (SetStateStat it) -> {
        return Boolean.valueOf(it.isNext());
      };
      final Iterable<SetStateStat> nextStateTransitions = IterableExtensions.<SetStateStat>filter(EcoreUtil2.<SetStateStat>eAllOfType(prevState, SetStateStat.class), _function);
      transitionExists = (transitionExists || (!IterableExtensions.isEmpty(nextStateTransitions)));
    }
    if ((!transitionExists)) {
      this.warning("State is unreachable", ReflexValidator.ePackage.getState_Name());
    }
  }
  
  @Check
  public void checkTimeoutVariable(final TimeoutFunction func) {
    boolean _isReferencedTimeout = ReflexModelUtil.isReferencedTimeout(func);
    if (_isReferencedTimeout) {
      final Program program = EcoreUtil2.<Program>getContainerOfType(func, Program.class);
      final IdReference timeContainer = func.getRef();
      if ((timeContainer instanceof ProgramVariable)) {
        boolean _containsReferencesOfType = ReflexModelUtil.containsReferencesOfType(program, timeContainer, ReflexValidator.ePackage.getAssignmentExpression_AssignVar());
        boolean _not = (!_containsReferencesOfType);
        if (_not) {
          this.warning("Uninitialized variable is used in timeout", ReflexValidator.ePackage.getTimeAmountOrRef_Ref());
        }
      }
    }
  }
  
  @Check
  public void checkNameShadowing(final ru.iaie.reflex.reflex.Process process) {
    final Map<String, EObject> globalCtx = CollectionLiterals.<String, EObject>newHashMap();
    final Program program = EcoreUtil2.<Program>getContainerOfType(process, Program.class);
    final Function1<GlobalVariable, String> _function = (GlobalVariable it) -> {
      return ReflexModelUtil.getName(it);
    };
    globalCtx.putAll(IterableExtensions.<GlobalVariable, String, EObject>toMap(program.getGlobalVars(), _function, new Function1<GlobalVariable, EObject>() {
        public EObject apply(GlobalVariable p) {
          return Function.<GlobalVariable>identity().apply(p);
        }
    }));
    final Function1<Port, String> _function_1 = (Port it) -> {
      return it.getName();
    };
    globalCtx.putAll(IterableExtensions.<Port, String, EObject>toMap(program.getPorts(), _function_1, new Function1<Port, EObject>() {
        public EObject apply(Port p) {
          return Function.<Port>identity().apply(p);
        }
    }));
    final Function1<ru.iaie.reflex.reflex.Enum, EList<EnumMember>> _function_2 = (ru.iaie.reflex.reflex.Enum it) -> {
      return it.getEnumMembers();
    };
    final Function1<EnumMember, String> _function_3 = (EnumMember it) -> {
      return it.getName();
    };
    globalCtx.putAll(IterableExtensions.<EnumMember, String, EObject>toMap(Iterables.<EnumMember>concat(ListExtensions.<ru.iaie.reflex.reflex.Enum, EList<EnumMember>>map(program.getEnums(), _function_2)), _function_3, new Function1<EnumMember, EObject>() {
        public EObject apply(EnumMember p) {
          return Function.<EnumMember>identity().apply(p);
        }
    }));
    final Function1<Const, String> _function_4 = (Const it) -> {
      return it.getName();
    };
    globalCtx.putAll(IterableExtensions.<Const, String, EObject>toMap(program.getConsts(), _function_4, new Function1<Const, EObject>() {
        public EObject apply(Const p) {
          return Function.<Const>identity().apply(p);
        }
    }));
    EList<ProcessVariable> _variables = process.getVariables();
    for (final ProcessVariable variable : _variables) {
      {
        EAttribute _xifexpression = null;
        boolean _isPhysical = ReflexModelUtil.isPhysical(variable);
        if (_isPhysical) {
          _xifexpression = ReflexValidator.ePackage.getPhysicalVariable_Name();
        } else {
          _xifexpression = ReflexValidator.ePackage.getProgramVariable_Name();
        }
        EAttribute ref = _xifexpression;
        boolean _containsKey = globalCtx.containsKey(ReflexModelUtil.getName(variable));
        if (_containsKey) {
          EObject shadowed = globalCtx.get(ReflexModelUtil.getName(variable));
          String errorMessage = null;
          boolean _matched = false;
          if (shadowed instanceof GlobalVariable) {
            _matched=true;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Process variable shadows global variable with name \"");
            String _name = ReflexModelUtil.getName(((GlobalVariable)shadowed));
            _builder.append(_name);
            _builder.append("\"");
            errorMessage = _builder.toString();
          }
          if (!_matched) {
            if (shadowed instanceof Port) {
              _matched=true;
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Process variable shadows port with name \"");
              String _name = ((Port)shadowed).getName();
              _builder.append(_name);
              _builder.append("\"");
              errorMessage = _builder.toString();
            }
          }
          if (!_matched) {
            if (shadowed instanceof EnumMember) {
              _matched=true;
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Process variable shadows enum member with name \"");
              String _name = ((EnumMember)shadowed).getName();
              _builder.append(_name);
              _builder.append("\"");
              errorMessage = _builder.toString();
            }
          }
          if (!_matched) {
            if (shadowed instanceof Const) {
              _matched=true;
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Process variable shadows constant with name \"");
              String _name = ((Const)shadowed).getName();
              _builder.append(_name);
              _builder.append("\"");
              errorMessage = _builder.toString();
            }
          }
          this.error(errorMessage, variable, ref);
        }
      }
    }
  }
  
  @Check
  public void checkImportedVariablesConflictsProcessVariables(final ImportedVariableList imports) {
    final Function1<ProcessVariable, String> _function = (ProcessVariable it) -> {
      return ReflexModelUtil.getName(it);
    };
    final Map<String, ProcessVariable> ctx = IterableExtensions.<ProcessVariable, String, ProcessVariable>toMap(EcoreUtil2.<ru.iaie.reflex.reflex.Process>getContainerOfType(imports, ru.iaie.reflex.reflex.Process.class).getVariables(), _function, new Function1<ProcessVariable, ProcessVariable>() {
        public ProcessVariable apply(ProcessVariable p) {
          return Function.<ProcessVariable>identity().apply(p);
        }
    });
    EList<ProcessVariable> _variables = imports.getVariables();
    for (final ProcessVariable variable : _variables) {
      boolean _containsKey = ctx.containsKey(ReflexModelUtil.getName(variable));
      if (_containsKey) {
        ProcessVariable conflicted = ctx.get(ReflexModelUtil.getName(variable));
        EAttribute _xifexpression = null;
        boolean _isPhysical = ReflexModelUtil.isPhysical(conflicted);
        if (_isPhysical) {
          _xifexpression = ReflexValidator.ePackage.getPhysicalVariable_Name();
        } else {
          _xifexpression = ReflexValidator.ePackage.getProgramVariable_Name();
        }
        EAttribute ref = _xifexpression;
        this.error("Process variable conflicts with imported variable", conflicted, ref);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Name \"");
        String _name = ReflexModelUtil.getName(variable);
        _builder.append(_name);
        _builder.append("\" conflicts with process variable name");
        this.error(_builder.toString(), 
          ReflexValidator.ePackage.getImportedVariableList_Variables());
      }
    }
  }
  
  @Check
  public void checkImportedVariablesConflictsOtherImports(final ImportedVariableList importToCheck) {
    Map<String, ImportedVariableList> ctx = CollectionLiterals.<String, ImportedVariableList>newHashMap();
    final Function1<ImportedVariableList, Boolean> _function = (ImportedVariableList it) -> {
      return Boolean.valueOf(it.equals(importToCheck));
    };
    Iterable<ImportedVariableList> _reject = IterableExtensions.<ImportedVariableList>reject(EcoreUtil2.<ru.iaie.reflex.reflex.Process>getContainerOfType(importToCheck, ru.iaie.reflex.reflex.Process.class).getImports(), _function);
    for (final ImportedVariableList imp : _reject) {
      EList<ProcessVariable> _variables = imp.getVariables();
      for (final ProcessVariable variable : _variables) {
        ctx.put(ReflexModelUtil.getName(variable), imp);
      }
    }
    EList<ProcessVariable> _variables_1 = importToCheck.getVariables();
    for (final ProcessVariable variable_1 : _variables_1) {
      boolean _containsKey = ctx.containsKey(ReflexModelUtil.getName(variable_1));
      if (_containsKey) {
        ImportedVariableList conflicted = ctx.get(ReflexModelUtil.getName(variable_1));
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Conflict for name ");
        String _name = ReflexModelUtil.getName(variable_1);
        _builder.append(_name);
        _builder.append(" in imports");
        this.error(_builder.toString(), conflicted, 
          ReflexValidator.ePackage.getImportedVariableList_Variables());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Conflict for name ");
        String _name_1 = ReflexModelUtil.getName(variable_1);
        _builder_1.append(_name_1);
        _builder_1.append(" in imports");
        this.error(_builder_1.toString(), importToCheck, 
          ReflexValidator.ePackage.getImportedVariableList_Variables());
      }
    }
  }
  
  @Check
  public void checkProcessHasStates(final ru.iaie.reflex.reflex.Process proc) {
    boolean _isEmpty = proc.getStates().isEmpty();
    if (_isEmpty) {
      this.error("No states declared in process", ReflexValidator.ePackage.getProcess_Name());
    }
  }
  
  @Check
  public void checkTimeoutHasReaction(final TimeoutFunction func) {
    final Statement rootStat = func.getBody();
    if ((rootStat instanceof CompoundStatement)) {
      boolean _isEmpty = ReflexModelUtil.isEmpty(((CompoundStatement)rootStat));
      if (_isEmpty) {
        this.error("Timeout reaction has no statements", null);
      }
    }
  }
  
  @Check
  public void checkIfStat(final IfElseStat stat) {
    final Statement ifRootStat = stat.getThen();
    if ((ifRootStat instanceof CompoundStatement)) {
      boolean _isEmpty = ReflexModelUtil.isEmpty(((CompoundStatement)ifRootStat));
      if (_isEmpty) {
        this.warning("Empty body", null);
      }
    }
  }
  
  @Check
  public void checkStateBody(final ru.iaie.reflex.reflex.State state) {
    if ((state.getStateFunction().getStatements().isEmpty() && (!ReflexModelUtil.hasTimeoutReaction(state)))) {
      this.error("State body has no statements", null);
    }
  }
  
  @Check
  public void checkProcessIsReachable(final ru.iaie.reflex.reflex.Process process) {
    int _index = ReflexModelUtil.getIndex(process);
    boolean _equals = (_index == 0);
    if (_equals) {
      return;
    }
    final Program program = EcoreUtil2.<Program>getContainerOfType(process, Program.class);
    final Function1<ru.iaie.reflex.reflex.Process, Boolean> _function = (ru.iaie.reflex.reflex.Process it) -> {
      return Boolean.valueOf(it.equals(process));
    };
    Iterable<ru.iaie.reflex.reflex.Process> _reject = IterableExtensions.<ru.iaie.reflex.reflex.Process>reject(program.getProcesses(), _function);
    for (final ru.iaie.reflex.reflex.Process outsideProcess : _reject) {
      boolean _containsReferencesOfType = ReflexModelUtil.containsReferencesOfType(outsideProcess, process, ReflexValidator.ePackage.getStartProcStat_Process());
      if (_containsReferencesOfType) {
        return;
      }
    }
    this.warning("Process is unreachable (never started by another process)", ReflexValidator.ePackage.getProcess_Name());
  }
  
  @Check
  public void checkStateContainsMeaningfulStatements(final ru.iaie.reflex.reflex.State state) {
    final Function1<Statement, Boolean> _function = (Statement stat) -> {
      return Boolean.valueOf(((((((stat instanceof StartProcStat) || ((stat instanceof StopProcStat) && (!ReflexModelUtil.selfStop(((StopProcStat) stat))))) || 
        ((stat instanceof ErrorStat) && (!ReflexModelUtil.selfError(((ErrorStat) stat))))) || 
        ((stat instanceof AssignmentExpression) && (ExpressionUtil.hasAssignment(((AssignmentExpression) stat)) || 
          ExpressionUtil.hasFunctionCall(((AssignmentExpression) stat))))) || (stat instanceof IfElseStat)) || 
        (stat instanceof SwitchStat)));
    };
    final Iterable<Statement> meaningful = IterableExtensions.<Statement>filter(EcoreUtil2.<Statement>eAllOfType(state, Statement.class), _function);
    boolean _isEmpty = IterableExtensions.isEmpty(meaningful);
    if (_isEmpty) {
      this.warning("State body has no start | stop | error process statements or assign expressions", null);
    }
  }
  
  @Check
  public void checkConstValue(final Const c) {
    boolean _isConstExpr = ExpressionUtil.isConstExpr(c.getValue());
    boolean _not = (!_isConstExpr);
    if (_not) {
      this.error("Only constant expressions allowed", ReflexValidator.ePackage.getConst_Value());
    }
  }
  
  @Check
  public void checkEnumMemberValue(final EnumMember em) {
    boolean _hasValue = ReflexModelUtil.hasValue(em);
    if (_hasValue) {
      boolean _isConstExpr = ExpressionUtil.isConstExpr(em.getValue());
      boolean _not = (!_isConstExpr);
      if (_not) {
        this.error("Only constant expressions allowed", ReflexValidator.ePackage.getEnumMember_Value());
      }
    }
  }
  
  @Check
  public void checkPortSize(final Port p) {
    final long size = LiteralUtils.parseInteger(p.getSize());
    if ((!((size == 8) || (size == 16)))) {
      this.error("Only 8 or 16 values allowed", ReflexValidator.ePackage.getPort_Size());
    }
  }
  
  @Check
  public void checkPortMapping(final PhysicalVariable physVar) {
    boolean _isFullMapping = ReflexModelUtil.isFullMapping(physVar.getMapping());
    boolean _not = (!_isFullMapping);
    if (_not) {
      final long portSize = LiteralUtils.parseInteger(physVar.getMapping().getPort().getSize());
      final long bitNum = LiteralUtils.parseInteger(physVar.getMapping().getBit());
      if (((bitNum > portSize) || (bitNum <= 0))) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Port bit value must be in interval of 1..");
        _builder.append(portSize);
        this.error(_builder.toString(), physVar.getMapping(), 
          ReflexValidator.ePackage.getPortMapping_Bit());
      }
    }
  }
  
  @Check
  public void validateTypes(final Expression expr) {
    try {
      final List<TypeWarning> warnings = CollectionLiterals.<TypeWarning>newArrayList();
      ExpressionUtil.resolveType(expr, warnings);
      for (final TypeWarning typeWarning : warnings) {
        this.warning(typeWarning.message, typeWarning.expression, null);
      }
    } catch (final Throwable _t) {
      if (_t instanceof IllegalStateException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Check
  public void checkConstAssignType(final Const const_) {
    try {
      final Type assignType = ExpressionUtil.resolveType(const_.getValue());
      boolean _canBeSafelySignedTo = TypeUtils.canBeSafelySignedTo(const_.getType(), assignType);
      boolean _not = (!_canBeSafelySignedTo);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Constant type ");
        Type _type = const_.getType();
        _builder.append(_type);
        _builder.append(" is not compitable with assigned value type ");
        _builder.append(assignType);
        this.warning(_builder.toString(), 
          ReflexValidator.ePackage.getConst_Name());
      }
    } catch (final Throwable _t) {
      if (_t instanceof IllegalStateException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Check
  public void checkEnumMemberAssignType(final EnumMember em) {
    final Type assignType = ExpressionUtil.resolveType(em.getValue());
    Type _defaultType = TypeUtils.getDefaultType(em);
    boolean _notEquals = (!Objects.equal(assignType, _defaultType));
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Enum member type ");
      _builder.append(Type.INT32_U);
      _builder.append(" is not compitable with assigned value type ");
      _builder.append(assignType);
      this.warning(_builder.toString(), ReflexValidator.ePackage.getEnumMember_Name());
    }
  }
  
  @Check
  public void checkPhysicalVariableType(final PhysicalVariable physVar) {
    final PortMapping mapping = physVar.getMapping();
    boolean _isFullMapping = ReflexModelUtil.isFullMapping(mapping);
    if (_isFullMapping) {
      try {
        final Type expectedType = ReflexModelUtil.getSuitableTypeForPort(mapping.getPort());
        Type _type = physVar.getType();
        boolean _notEquals = (!Objects.equal(expectedType, _type));
        if (_notEquals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Variable mapped on port ");
          String _name = mapping.getPort().getName();
          _builder.append(_name);
          _builder.append(" should have ");
          _builder.append(expectedType);
          _builder.append(" type");
          this.warning(_builder.toString(), 
            ReflexValidator.ePackage.getPhysicalVariable_Type());
        }
      } catch (final Throwable _t) {
        if (_t instanceof IllegalStateException) {
          return;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } else {
      Type _type = physVar.getType();
      boolean _notEquals = (!Objects.equal(_type, Type.BOOL));
      if (_notEquals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("One bit mapped variables should be only ");
        _builder.append(Type.BOOL);
        _builder.append(" type");
        this.warning(_builder.toString(), ReflexValidator.ePackage.getPhysicalVariable_Type());
      }
    }
  }
}
