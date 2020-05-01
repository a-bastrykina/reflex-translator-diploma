package ru.iaie.reflex.generator;

import org.eclipse.emf.ecore.EObject;
import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.IfElseStat;

@SuppressWarnings("all")
public interface ITranslationStrategy {
  public abstract String translateConstDefinition(final Const c);
  
  public abstract String translateExpression(final EObject expr);
  
  public abstract String translateIfElseStat(final IfElseStat stat);
}
