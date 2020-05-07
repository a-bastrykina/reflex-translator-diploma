package ru.iaie.reflex.generator;

@SuppressWarnings("all")
public interface ISourceBuilder {
  public abstract void withConstantDefinitions(final String str);
  
  public abstract void withEnumDefinitions(final String str);
  
  public abstract void withProcessVariableDefinitions(final String str);
  
  public abstract void withGlobalVariableDefinitions(final String str);
  
  public abstract void withProcessDefinitions(final String str);
  
  public abstract void build();
}
