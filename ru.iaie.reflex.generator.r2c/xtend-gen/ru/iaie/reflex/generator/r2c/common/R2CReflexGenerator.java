package ru.iaie.reflex.generator.r2c.common;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import ru.iaie.reflex.generator.IReflexGenerator;
import ru.iaie.reflex.generator.r2c.common.R2CFileGenerator;
import ru.iaie.reflex.generator.r2c.interfaces.IFileGenerator;

@SuppressWarnings("all")
public class R2CReflexGenerator implements IReflexGenerator {
  protected IFileGenerator fileGen;
  
  @Override
  public void beforeGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    R2CFileGenerator _r2CFileGenerator = new R2CFileGenerator(resource, fsa);
    this.fileGen = _r2CFileGenerator;
  }
  
  @Override
  public void afterGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
  }
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.fileGen.prepareForGeneration();
    this.fileGen.generateVariableDefinitions();
    this.fileGen.generateConstantDefinitions();
    this.fileGen.generateProcessDefinitions();
    this.fileGen.generateProcessImplementations();
    this.fileGen.generateIOFiles();
    this.fileGen.generatePlatformImplementations();
    this.fileGen.generateMain();
    this.fileGen.generateBuildFiles();
  }
}
