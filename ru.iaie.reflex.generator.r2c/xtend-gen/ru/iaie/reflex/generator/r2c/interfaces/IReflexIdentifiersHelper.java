package ru.iaie.reflex.generator.r2c.interfaces;

import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.EnumMember;
import ru.iaie.reflex.reflex.GlobalVariable;
import ru.iaie.reflex.reflex.IdReference;
import ru.iaie.reflex.reflex.Port;
import ru.iaie.reflex.reflex.ProcessVariable;

@SuppressWarnings("all")
public interface IReflexIdentifiersHelper {
  public abstract String getProcessFuncId(final ru.iaie.reflex.reflex.Process proc);
  
  public abstract String getProcessVariableId(final ru.iaie.reflex.reflex.Process proc, final ProcessVariable v);
  
  public abstract String getConstantId(final Const c);
  
  public abstract String getPortId(final Port p);
  
  public abstract String getEnumId(final ru.iaie.reflex.reflex.Enum en);
  
  public abstract String getEnumMemberId(final EnumMember em);
  
  public abstract String getGlobalVariableId(final GlobalVariable v);
  
  public abstract String getMapping(final IdReference original);
}
