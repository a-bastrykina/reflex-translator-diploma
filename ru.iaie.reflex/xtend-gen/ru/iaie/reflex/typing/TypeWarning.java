package ru.iaie.reflex.typing;

import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class TypeWarning {
  public String message;
  
  public EObject expression;
  
  public TypeWarning(final String message, final EObject expression) {
    this.message = message;
    this.expression = expression;
  }
}
