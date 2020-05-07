package ru.iaie.reflex.generator;

import org.eclipse.emf.ecore.EObject;
import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.GlobalVariable;
import ru.iaie.reflex.reflex.IfElseStat;
import ru.iaie.reflex.reflex.ProcessVariable;

@SuppressWarnings("all")
public interface ITranslationStrategy {
  public abstract String translateConstDefinition(final Const c);
  
  public abstract String translateEnumDefinition(final ru.iaie.reflex.reflex.Enum e);
  
  public abstract String translateProcessVarDefinition(final ru.iaie.reflex.reflex.Process p, final ProcessVariable v);
  
  public abstract String translateGlobalVarDefinition(final GlobalVariable v);
  
  public abstract String translateExpression(final EObject expr);
  
  public abstract String translateIfElseStat(final IfElseStat stat);
  
  public abstract String getSeparator();
}
