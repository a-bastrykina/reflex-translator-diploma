package ru.iaie.reflex.generator;

@SuppressWarnings("all")
public interface ISourceBuilder {
  public abstract void withConstantDefinitions(final String str);
  
  public abstract void build();
}
