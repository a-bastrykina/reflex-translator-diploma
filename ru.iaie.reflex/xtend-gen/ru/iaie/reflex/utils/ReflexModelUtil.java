package ru.iaie.reflex.utils;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.DeclaredVariable;
import ru.iaie.reflex.reflex.EnumMember;
import ru.iaie.reflex.reflex.ErrorStat;
import ru.iaie.reflex.reflex.Expression;
import ru.iaie.reflex.reflex.IdReference;
import ru.iaie.reflex.reflex.ImportedVariable;
import ru.iaie.reflex.reflex.PhysicalVariable;
import ru.iaie.reflex.reflex.ProcessVariable;
import ru.iaie.reflex.reflex.Program;
import ru.iaie.reflex.reflex.ProgramVariable;
import ru.iaie.reflex.reflex.State;
import ru.iaie.reflex.reflex.StopProcStat;
import ru.iaie.reflex.reflex.Time;
import ru.iaie.reflex.reflex.TimeoutFunction;

@SuppressWarnings("all")
public class ReflexModelUtil {
  public static State findStateByName(final ru.iaie.reflex.reflex.Process proc, final String stateName) {
    final Function1<State, Boolean> _function = (State it) -> {
      return Boolean.valueOf(it.getName().equals(stateName));
    };
    final List<State> matchingStates = IterableExtensions.<State>toList(IterableExtensions.<State>filter(proc.getStates(), _function));
    boolean _isEmpty = matchingStates.isEmpty();
    if (_isEmpty) {
      return null;
    }
    return matchingStates.get(0);
  }
  
  public static ru.iaie.reflex.reflex.Process findProcessByName(final Program prog, final String procName) {
    final Function1<ru.iaie.reflex.reflex.Process, Boolean> _function = (ru.iaie.reflex.reflex.Process it) -> {
      return Boolean.valueOf(it.getName().equals(procName));
    };
    final List<ru.iaie.reflex.reflex.Process> matchingProcs = IterableExtensions.<ru.iaie.reflex.reflex.Process>toList(IterableExtensions.<ru.iaie.reflex.reflex.Process>filter(prog.getProcesses(), _function));
    boolean _isEmpty = matchingProcs.isEmpty();
    if (_isEmpty) {
      return null;
    }
    return matchingProcs.get(0);
  }
  
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
    Time _time = f.getTime();
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
  
  public static boolean isDeclared(final ProcessVariable v) {
    return (v instanceof DeclaredVariable);
  }
  
  public static boolean isImportedList(final ProcessVariable v) {
    return (v instanceof ImportedVariable);
  }
  
  public static String resolveName(final IdReference ref) {
    boolean _matched = false;
    if (ref instanceof ProgramVariable) {
      _matched=true;
      return ((ProgramVariable)ref).getName();
    }
    if (!_matched) {
      if (ref instanceof PhysicalVariable) {
        _matched=true;
        return ((PhysicalVariable)ref).getName();
      }
    }
    if (!_matched) {
      if (ref instanceof EnumMember) {
        _matched=true;
        return ((EnumMember)ref).getName();
      }
    }
    if (!_matched) {
      if (ref instanceof Const) {
        _matched=true;
        return ((Const)ref).getName();
      }
    }
    return null;
  }
}
