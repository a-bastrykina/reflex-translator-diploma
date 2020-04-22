package ru.iaie.reflex.generator.r2c;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import ru.iaie.reflex.generator.r2c.IReflexCachedIdentifiersHelper;
import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.EnumMember;
import ru.iaie.reflex.reflex.GlobalVariable;
import ru.iaie.reflex.reflex.PhysicalVariable;
import ru.iaie.reflex.reflex.ProcessVariable;
import ru.iaie.reflex.reflex.ProgramVariable;
import ru.iaie.reflex.reflex.Register;
import ru.iaie.reflex.reflex.State;

@SuppressWarnings("all")
public class ReflexIdentifiersHelper implements IReflexCachedIdentifiersHelper {
  private Map<String, String> procIdentifiers = new HashMap<String, String>();
  
  private Map<String, Map<String, String>> stateIdentifiers = new HashMap<String, Map<String, String>>();
  
  private Map<String, Map<String, String>> varIdentifiers = new HashMap<String, Map<String, String>>();
  
  private Map<String, String> globalVarIdentifiers = new HashMap<String, String>();
  
  private Map<String, String> constIdentifiers = new HashMap<String, String>();
  
  private Map<String, String> portIdentifiers = new HashMap<String, String>();
  
  private Map<String, String> enumIdentifiers = new HashMap<String, String>();
  
  private Map<String, String> identifiers = new HashMap<String, String>();
  
  private String _getKey(final ru.iaie.reflex.reflex.Process proc) {
    return proc.getName();
  }
  
  private String _getKey(final State state) {
    return state.getName();
  }
  
  private String _getKey(final PhysicalVariable v) {
    return v.getName();
  }
  
  private String _getKey(final ProgramVariable v) {
    return v.getName();
  }
  
  private String _getKey(final Const c) {
    return c.getName();
  }
  
  private String _getKey(final Register r) {
    return r.getName();
  }
  
  private String _getKey(final ru.iaie.reflex.reflex.Enum en) {
    return en.getIdentifier();
  }
  
  @Override
  public String getProcessId(final ru.iaie.reflex.reflex.Process proc) {
    boolean _containsKey = this.procIdentifiers.containsKey(this.getKey(proc));
    if (_containsKey) {
      return this.procIdentifiers.get(this.getKey(proc));
    } else {
      StringConcatenation _builder = new StringConcatenation();
      int _size = this.procIdentifiers.size();
      _builder.append(_size);
      final String value = _builder.toString();
      this.procIdentifiers.put(this.getKey(proc), value);
      return value;
    }
  }
  
  @Override
  public String getStateId(final ru.iaie.reflex.reflex.Process proc, final State state) {
    final String procKey = this.getKey(proc);
    final String stateKey = this.getKey(state);
    boolean _containsKey = this.stateIdentifiers.containsKey(procKey);
    boolean _not = (!_containsKey);
    if (_not) {
      HashMap<String, String> _hashMap = new HashMap<String, String>();
      this.stateIdentifiers.put(procKey, _hashMap);
    }
    final Map<String, String> procMap = this.stateIdentifiers.get(procKey);
    boolean _containsKey_1 = procMap.containsKey(stateKey);
    if (_containsKey_1) {
      return procMap.get(stateKey);
    } else {
      StringConcatenation _builder = new StringConcatenation();
      int _size = procMap.size();
      _builder.append(_size);
      final String value = _builder.toString();
      procMap.put(stateKey, value);
      return value;
    }
  }
  
  @Override
  public String getProcessVariableId(final ru.iaie.reflex.reflex.Process proc, final ProcessVariable v) {
    final String procKey = this.getKey(proc);
    final String varKey = this.getKey(v);
    boolean _containsKey = this.varIdentifiers.containsKey(procKey);
    boolean _not = (!_containsKey);
    if (_not) {
      HashMap<String, String> _hashMap = new HashMap<String, String>();
      this.varIdentifiers.put(procKey, _hashMap);
    }
    final Map<String, String> procMap = this.varIdentifiers.get(procKey);
    boolean _containsKey_1 = procMap.containsKey(varKey);
    if (_containsKey_1) {
      return procMap.get(varKey);
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("P");
      String _processId = this.getProcessId(proc);
      _builder.append(_processId);
      _builder.append("V");
      int _size = procMap.size();
      _builder.append(_size);
      final String value = _builder.toString();
      procMap.put(varKey, value);
      this.identifiers.put(varKey, value);
      return value;
    }
  }
  
  @Override
  public String getConstantId(final Const c) {
    final String key = this.getKey(c).toString();
    boolean _containsKey = this.constIdentifiers.containsKey(key);
    if (_containsKey) {
      return this.constIdentifiers.get(key);
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("C_");
      int _size = this.constIdentifiers.size();
      _builder.append(_size);
      final String value = _builder.toString();
      this.constIdentifiers.put(key, value);
      this.identifiers.put(key, value);
      return value;
    }
  }
  
  @Override
  public String getPortId(final Register reg) {
    final String key = this.getKey(reg);
    boolean _containsKey = this.portIdentifiers.containsKey(key);
    if (_containsKey) {
      return this.portIdentifiers.get(key);
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("P");
      char _charAt = reg.getType().getLiteral().toUpperCase().charAt(0);
      _builder.append(_charAt);
      int _size = this.portIdentifiers.size();
      _builder.append(_size);
      final String value = _builder.toString();
      this.portIdentifiers.put(key, value);
      return value;
    }
  }
  
  @Override
  public String getProcessFuncId(final ru.iaie.reflex.reflex.Process proc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("P");
    String _processId = this.getProcessId(proc);
    _builder.append(_processId);
    return _builder.toString();
  }
  
  @Override
  public void clearCaches() {
    this.procIdentifiers.clear();
    this.stateIdentifiers.clear();
    this.varIdentifiers.clear();
    this.constIdentifiers.clear();
    this.portIdentifiers.clear();
    this.enumIdentifiers.clear();
    this.globalVarIdentifiers.clear();
  }
  
  @Override
  public String getEnumId(final ru.iaie.reflex.reflex.Enum en) {
    final String key = this.getKey(en);
    boolean _containsKey = this.enumIdentifiers.containsKey(key);
    if (_containsKey) {
      return this.enumIdentifiers.get(key);
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("EN");
      int _size = this.enumIdentifiers.size();
      _builder.append(_size);
      final String value = _builder.toString();
      this.enumIdentifiers.put(key, value);
      return value;
    }
  }
  
  @Override
  public String getEnumMemberId(final EnumMember em) {
    final String key = em.getName();
    boolean _containsKey = this.constIdentifiers.containsKey(key);
    if (_containsKey) {
      return this.constIdentifiers.get(key);
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("C_");
      int _size = this.constIdentifiers.size();
      _builder.append(_size);
      final String value = _builder.toString();
      this.constIdentifiers.put(key, value);
      this.identifiers.put(key, value);
      return value;
    }
  }
  
  @Override
  public String getGlobalVariableId(final GlobalVariable v) {
    final String key = this.getKey(v);
    boolean _containsKey = this.globalVarIdentifiers.containsKey(key);
    if (_containsKey) {
      return this.globalVarIdentifiers.get(key);
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("GV");
      int _size = this.globalVarIdentifiers.size();
      _builder.append(_size);
      final String value = _builder.toString();
      this.globalVarIdentifiers.put(key, value);
      this.identifiers.put(key, value);
      return value;
    }
  }
  
  @Override
  public String getId(final String original) {
    boolean _containsKey = this.identifiers.containsKey(original);
    boolean _not = (!_containsKey);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Name ");
      _builder.append(original);
      _builder.append(" wasn\'t declared");
      throw new IllegalArgumentException(_builder.toString());
    }
    return this.identifiers.get(original);
  }
  
  private String getKey(final EObject v) {
    if (v instanceof PhysicalVariable) {
      return _getKey((PhysicalVariable)v);
    } else if (v instanceof ProgramVariable) {
      return _getKey((ProgramVariable)v);
    } else if (v instanceof Const) {
      return _getKey((Const)v);
    } else if (v instanceof ru.iaie.reflex.reflex.Enum) {
      return _getKey((ru.iaie.reflex.reflex.Enum)v);
    } else if (v instanceof ru.iaie.reflex.reflex.Process) {
      return _getKey((ru.iaie.reflex.reflex.Process)v);
    } else if (v instanceof Register) {
      return _getKey((Register)v);
    } else if (v instanceof State) {
      return _getKey((State)v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v).toString());
    }
  }
}
