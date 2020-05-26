package ru.iaie.reflex.utils;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import ru.iaie.reflex.reflex.ClockDefinition;
import ru.iaie.reflex.reflex.CompoundStatement;
import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.DefaultStat;
import ru.iaie.reflex.reflex.EnumMember;
import ru.iaie.reflex.reflex.ErrorStat;
import ru.iaie.reflex.reflex.Expression;
import ru.iaie.reflex.reflex.GlobalVariable;
import ru.iaie.reflex.reflex.IdReference;
import ru.iaie.reflex.reflex.ImportedVariableList;
import ru.iaie.reflex.reflex.PhysicalVariable;
import ru.iaie.reflex.reflex.Port;
import ru.iaie.reflex.reflex.PortMapping;
import ru.iaie.reflex.reflex.PortType;
import ru.iaie.reflex.reflex.ProcessVariable;
import ru.iaie.reflex.reflex.Program;
import ru.iaie.reflex.reflex.ProgramVariable;
import ru.iaie.reflex.reflex.State;
import ru.iaie.reflex.reflex.Statement;
import ru.iaie.reflex.reflex.StopProcStat;
import ru.iaie.reflex.reflex.SwitchStat;
import ru.iaie.reflex.reflex.TimeoutFunction;
import ru.iaie.reflex.reflex.Type;
import ru.iaie.reflex.utils.LiteralUtils;

@SuppressWarnings("all")
public class ReflexModelUtil {
  public static Program getProgram(final Resource resource) {
    return ((Program[])Conversions.unwrapArray((Iterables.<Program>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Program.class)), Program.class))[0];
  }
  
  public static boolean hasValue(final EnumMember em) {
    Expression _value = em.getValue();
    return (_value != null);
  }
  
  public static boolean selfStop(final StopProcStat sps) {
    ru.iaie.reflex.reflex.Process _process = sps.getProcess();
    return (_process == null);
  }
  
  public static boolean selfError(final ErrorStat es) {
    ru.iaie.reflex.reflex.Process _process = es.getProcess();
    return (_process == null);
  }
  
  public static boolean isClearTimeout(final TimeoutFunction f) {
    String _time = f.getTime();
    return (_time != null);
  }
  
  public static boolean isReferencedTimeout(final TimeoutFunction f) {
    IdReference _ref = f.getRef();
    return (_ref != null);
  }
  
  public static boolean hasTimeout(final State s) {
    TimeoutFunction _timeoutFunction = s.getTimeoutFunction();
    return (_timeoutFunction != null);
  }
  
  public static boolean hasDefaultOption(final SwitchStat s) {
    DefaultStat _defaultOption = s.getDefaultOption();
    return (_defaultOption != null);
  }
  
  public static boolean isShared(final ProcessVariable v) {
    boolean _matched = false;
    if (v instanceof ProgramVariable) {
      _matched=true;
      return ((ProgramVariable)v).isShared();
    }
    if (!_matched) {
      if (v instanceof PhysicalVariable) {
        _matched=true;
        return ((PhysicalVariable)v).isShared();
      }
    }
    return false;
  }
  
  public static List<ProcessVariable> getImportedVariables(final ru.iaie.reflex.reflex.Process p) {
    final Function1<ImportedVariableList, EList<ProcessVariable>> _function = (ImportedVariableList it) -> {
      return it.getVariables();
    };
    return IterableExtensions.<ProcessVariable>toList(Iterables.<ProcessVariable>concat(ListExtensions.<ImportedVariableList, EList<ProcessVariable>>map(p.getImports(), _function)));
  }
  
  public static ru.iaie.reflex.reflex.Process getProcess(final ProcessVariable v) {
    return EcoreUtil2.<ru.iaie.reflex.reflex.Process>getContainerOfType(v, ru.iaie.reflex.reflex.Process.class);
  }
  
  public static Type getType(final ProcessVariable v) {
    if ((v instanceof PhysicalVariable)) {
      return ((PhysicalVariable)v).getType();
    }
    if ((v instanceof ProgramVariable)) {
      return ((ProgramVariable)v).getType();
    }
    return null;
  }
  
  public static Type getType(final GlobalVariable v) {
    if ((v instanceof PhysicalVariable)) {
      return ((PhysicalVariable)v).getType();
    }
    if ((v instanceof ProgramVariable)) {
      return ((ProgramVariable)v).getType();
    }
    return null;
  }
  
  public static String getName(final GlobalVariable v) {
    if ((v instanceof ProgramVariable)) {
      return ((ProgramVariable)v).getName();
    }
    if ((v instanceof PhysicalVariable)) {
      return ((PhysicalVariable)v).getName();
    }
    return null;
  }
  
  public static String getName(final ProcessVariable v) {
    if ((v instanceof ProgramVariable)) {
      return ((ProgramVariable)v).getName();
    }
    if ((v instanceof PhysicalVariable)) {
      return ((PhysicalVariable)v).getName();
    }
    return null;
  }
  
  public static boolean isImportedList(final ProcessVariable v) {
    return (v instanceof ImportedVariableList);
  }
  
  public static boolean isPhysical(final ProcessVariable v) {
    return (v instanceof PhysicalVariable);
  }
  
  public static PortType getMappedPortType(final PhysicalVariable v) {
    return v.getMapping().getPort().getType();
  }
  
  public static boolean isFullMapping(final PortMapping m) {
    String _bit = m.getBit();
    return (_bit == null);
  }
  
  public static boolean isEmpty(final CompoundStatement compStat) {
    return IterableExtensions.isEmpty(IterableExtensions.<Statement>reject(EcoreUtil2.<Statement>eAllOfType(compStat, Statement.class), CompoundStatement.class));
  }
  
  public static boolean hasTimeoutReaction(final State state) {
    TimeoutFunction _timeoutFunction = state.getTimeoutFunction();
    return (_timeoutFunction != null);
  }
  
  public static int getIndex(final ru.iaie.reflex.reflex.Process p) {
    return EcoreUtil2.<Program>getContainerOfType(p, Program.class).getProcesses().indexOf(p);
  }
  
  public static int getIndex(final State s) {
    return EcoreUtil2.<ru.iaie.reflex.reflex.Process>getContainerOfType(s, ru.iaie.reflex.reflex.Process.class).getStates().indexOf(s);
  }
  
  public static Type resolveType(final IdReference ref) {
    boolean _matched = false;
    if (ref instanceof Const) {
      _matched=true;
      return ((Const)ref).getType();
    }
    if (!_matched) {
      if (ref instanceof PhysicalVariable) {
        _matched=true;
        return ((PhysicalVariable)ref).getType();
      }
    }
    if (!_matched) {
      if (ref instanceof ProgramVariable) {
        _matched=true;
        return ((ProgramVariable)ref).getType();
      }
    }
    if (!_matched) {
      if (ref instanceof EnumMember) {
        _matched=true;
        return Type.INT32_U;
      }
    }
    return null;
  }
  
  public static boolean hasTimeFormat(final ClockDefinition clck) {
    String _timeValue = clck.getTimeValue();
    return (_timeValue != null);
  }
  
  public static Type getSuitableTypeForPort(final Port p) {
    int _intValue = Long.valueOf(LiteralUtils.parseInteger(p.getSize())).intValue();
    switch (_intValue) {
      case 8:
        return Type.INT8;
      case 16:
        return Type.INT16;
      default:
        throw new IllegalStateException();
    }
  }
  
  public static boolean containsReferencesOfType(final EObject context, final EObject target, final EReference refType) {
    final HashSet<EObject> targetSet = CollectionLiterals.<EObject>newHashSet(target);
    final ArrayList<EObject> refered = CollectionLiterals.<EObject>newArrayList();
    final EcoreUtil2.ElementReferenceAcceptor _function = (EObject referrer, EObject referenced, EReference reference, int index) -> {
      boolean _equals = Objects.equal(reference, refType);
      if (_equals) {
        refered.add(referrer);
      }
    };
    final EcoreUtil2.ElementReferenceAcceptor acceptor = _function;
    EcoreUtil2.findCrossReferences(context, targetSet, acceptor);
    boolean _isEmpty = refered.isEmpty();
    return (!_isEmpty);
  }
}
