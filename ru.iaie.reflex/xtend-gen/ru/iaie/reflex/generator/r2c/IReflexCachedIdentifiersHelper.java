package ru.iaie.reflex.generator.r2c;

import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.Register;
import ru.iaie.reflex.reflex.State;
import ru.iaie.reflex.reflex.Variable;

@SuppressWarnings("all")
public interface IReflexCachedIdentifiersHelper {
  public abstract String getProcessId(final ru.iaie.reflex.reflex.Process proc);
  
  public abstract String getProcessFuncId(final ru.iaie.reflex.reflex.Process proc);
  
  public abstract String getStateId(final ru.iaie.reflex.reflex.Process proc, final State state);
  
  public abstract String getVariableId(final ru.iaie.reflex.reflex.Process proc, final Variable v);
  
  public abstract String getConstantId(final Const c);
  
  public abstract String getPortId(final Register reg);
  
  public abstract String getId(final String original);
  
  public abstract void clearCaches();
}
