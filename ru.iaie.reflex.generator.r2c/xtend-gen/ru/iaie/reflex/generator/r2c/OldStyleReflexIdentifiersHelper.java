package ru.iaie.reflex.generator.r2c;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import ru.iaie.reflex.generator.r2c.interfaces.IReflexIdentifiersHelper;
import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.EnumMember;
import ru.iaie.reflex.reflex.GlobalVariable;
import ru.iaie.reflex.reflex.IdReference;
import ru.iaie.reflex.reflex.PhysicalVariable;
import ru.iaie.reflex.reflex.Port;
import ru.iaie.reflex.reflex.ProcessVariable;
import ru.iaie.reflex.reflex.ProgramVariable;
import ru.iaie.reflex.reflex.State;
import ru.iaie.reflex.utils.ReflexModelUtil;

@Deprecated
@SuppressWarnings("all")
public class OldStyleReflexIdentifiersHelper implements IReflexIdentifiersHelper {
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
  
  private String _getKey(final Port r) {
    return r.getName();
  }
  
  private String _getKey(final ru.iaie.reflex.reflex.Enum en) {
    return en.getIdentifier();
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
      int _index = ReflexModelUtil.getIndex(proc);
      _builder.append(_index);
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
  public String getPortId(final Port reg) {
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
    int _index = ReflexModelUtil.getIndex(proc);
    _builder.append(_index);
    return _builder.toString();
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
  public String getMapping(final IdReference original) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  private String getKey(final EObject c) {
    if (c instanceof Const) {
      return _getKey((Const)c);
    } else if (c instanceof PhysicalVariable) {
      return _getKey((PhysicalVariable)c);
    } else if (c instanceof ProgramVariable) {
      return _getKey((ProgramVariable)c);
    } else if (c instanceof ru.iaie.reflex.reflex.Enum) {
      return _getKey((ru.iaie.reflex.reflex.Enum)c);
    } else if (c instanceof Port) {
      return _getKey((Port)c);
    } else if (c instanceof ru.iaie.reflex.reflex.Process) {
      return _getKey((ru.iaie.reflex.reflex.Process)c);
    } else if (c instanceof State) {
      return _getKey((State)c);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(c).toString());
    }
  }
}
