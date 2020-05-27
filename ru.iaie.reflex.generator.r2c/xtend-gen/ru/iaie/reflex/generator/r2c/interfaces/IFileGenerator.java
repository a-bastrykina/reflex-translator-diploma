package ru.iaie.reflex.generator.r2c.interfaces;

@SuppressWarnings("all")
public interface IFileGenerator {
  public abstract void prepareForGeneration();
  
  public abstract void generateVariableDefinitions();
  
  public abstract void generateConstantDefinitions();
  
  public abstract void generateProcessDefinitions();
  
  public abstract void generateProcessImplementations();
  
  public abstract void generateIOFiles();
  
  public abstract void generatePlatformImplementations();
  
  public abstract void generateMain();
  
  public abstract void generateBuildFiles();
}
