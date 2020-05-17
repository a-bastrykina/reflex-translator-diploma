package ru.iaie.reflex.generator.r2c;

import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import ru.iaie.reflex.generator.r2c.IReflexCachedIdentifiersHelper;
import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.EnumMember;
import ru.iaie.reflex.reflex.GlobalVariable;
import ru.iaie.reflex.reflex.IdReference;
import ru.iaie.reflex.reflex.PhysicalVariable;
import ru.iaie.reflex.reflex.Port;
import ru.iaie.reflex.reflex.PortType;
import ru.iaie.reflex.reflex.ProcessVariable;
import ru.iaie.reflex.reflex.ProgramVariable;
import ru.iaie.reflex.utils.ReflexModelUtil;

@SuppressWarnings("all")
public class ReflexIdentifiersHelper implements IReflexCachedIdentifiersHelper {
  private final Map<String, String> procIdentifiers = CollectionLiterals.<String, String>newHashMap();
  
  private final Map<String, Map<String, String>> stateIdentifiers = CollectionLiterals.<String, Map<String, String>>newHashMap();
  
  private final Map<String, Map<String, String>> procVarIdentifiers = CollectionLiterals.<String, Map<String, String>>newHashMap();
  
  private final Map<String, String> globalVarIdentifiers = CollectionLiterals.<String, String>newHashMap();
  
  private final Map<String, String> constIdentifiers = CollectionLiterals.<String, String>newHashMap();
  
  private final Map<String, String> portIdentifiers = CollectionLiterals.<String, String>newHashMap();
  
  private final Map<String, String> enumIdentifiers = CollectionLiterals.<String, String>newHashMap();
  
  @Override
  public String getProcessFuncId(final ru.iaie.reflex.reflex.Process proc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_p_");
    String _name = proc.getName();
    _builder.append(_name);
    return _builder.toString();
  }
  
  @Override
  public String getProcessVariableId(final ru.iaie.reflex.reflex.Process proc, final ProcessVariable v) {
    final String procKey = proc.getName();
    final String varKey = ReflexModelUtil.getName(v);
    boolean _containsKey = this.procVarIdentifiers.containsKey(procKey);
    boolean _not = (!_containsKey);
    if (_not) {
      HashMap<String, String> _hashMap = new HashMap<String, String>();
      this.procVarIdentifiers.put(procKey, _hashMap);
    }
    final Map<String, String> procMap = this.procVarIdentifiers.get(procKey);
    boolean _containsKey_1 = procMap.containsKey(varKey);
    if (_containsKey_1) {
      return procMap.get(varKey);
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_p_");
      String _name = proc.getName();
      _builder.append(_name);
      _builder.append("_v_");
      String _name_1 = ReflexModelUtil.getName(v);
      _builder.append(_name_1);
      final String value = _builder.toString();
      procMap.put(varKey, value);
      return value;
    }
  }
  
  @Override
  public String getConstantId(final Const c) {
    final String key = c.getName();
    boolean _containsKey = this.constIdentifiers.containsKey(key);
    if (_containsKey) {
      return this.constIdentifiers.get(key);
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_c_");
      String _name = c.getName();
      _builder.append(_name);
      final String value = _builder.toString();
      this.constIdentifiers.put(key, value);
      return value;
    }
  }
  
  @Override
  public String getPortId(final Port port) {
    final String key = port.getName();
    boolean _containsKey = this.portIdentifiers.containsKey(key);
    if (_containsKey) {
      return this.portIdentifiers.get(key);
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_");
      String _xifexpression = null;
      PortType _type = port.getType();
      boolean _equals = Objects.equal(_type, PortType.INPUT);
      if (_equals) {
        _xifexpression = "i";
      } else {
        _xifexpression = "o";
      }
      _builder.append(_xifexpression);
      _builder.append("_");
      String _name = port.getName();
      _builder.append(_name);
      final String value = _builder.toString();
      this.portIdentifiers.put(key, value);
      return value;
    }
  }
  
  @Override
  public String getEnumId(final ru.iaie.reflex.reflex.Enum en) {
    final String key = en.getIdentifier();
    boolean _containsKey = this.enumIdentifiers.containsKey(key);
    if (_containsKey) {
      return this.enumIdentifiers.get(key);
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_e_");
      String _identifier = en.getIdentifier();
      _builder.append(_identifier);
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
      _builder.append("_e_em_");
      String _name = em.getName();
      _builder.append(_name);
      final String value = _builder.toString();
      this.constIdentifiers.put(key, value);
      return value;
    }
  }
  
  @Override
  public String getGlobalVariableId(final GlobalVariable v) {
    final String key = ReflexModelUtil.getName(v);
    boolean _containsKey = this.globalVarIdentifiers.containsKey(key);
    if (_containsKey) {
      return this.globalVarIdentifiers.get(key);
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_g_");
      String _name = ReflexModelUtil.getName(v);
      _builder.append(_name);
      final String value = _builder.toString();
      this.globalVarIdentifiers.put(key, value);
      return value;
    }
  }
  
  @Override
  public String getMapping(final IdReference ref) {
    if (((ref instanceof PhysicalVariable) || (ref instanceof ProgramVariable))) {
      final ru.iaie.reflex.reflex.Process proc = EcoreUtil2.<ru.iaie.reflex.reflex.Process>getContainerOfType(ref, ru.iaie.reflex.reflex.Process.class);
      if ((proc == null)) {
        return this.getGlobalVariableId(((GlobalVariable) ref));
      }
      return this.getProcessVariableId(EcoreUtil2.<ru.iaie.reflex.reflex.Process>getContainerOfType(ref, ru.iaie.reflex.reflex.Process.class), ((ProcessVariable) ref));
    }
    if ((ref instanceof Const)) {
      return this.getConstantId(((Const)ref));
    }
    if ((ref instanceof EnumMember)) {
      return this.getEnumMemberId(((EnumMember)ref));
    }
    return null;
  }
  
  @Override
  public void clearCaches() {
    this.procIdentifiers.clear();
    this.stateIdentifiers.clear();
    this.procVarIdentifiers.clear();
    this.constIdentifiers.clear();
    this.portIdentifiers.clear();
    this.enumIdentifiers.clear();
    this.globalVarIdentifiers.clear();
  }
}
