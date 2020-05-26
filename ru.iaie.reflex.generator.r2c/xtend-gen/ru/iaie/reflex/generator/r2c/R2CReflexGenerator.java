package ru.iaie.reflex.generator.r2c;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import ru.iaie.reflex.generator.IReflexGenerator;
import ru.iaie.reflex.generator.r2c.R2CFileGenerator;
import ru.iaie.reflex.generator.r2c.R2CResourceProvider;
import ru.iaie.reflex.generator.r2c.interfaces.IFileGenerator;

@SuppressWarnings("all")
public class R2CReflexGenerator implements IReflexGenerator {
  private IFileGenerator fileGen;
  
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
    this.copyResources(fsa);
    this.fileGen.generateVariableDefinitions();
    this.fileGen.generateConstantDefinitions();
    this.fileGen.generateProcessDefinitions();
    this.fileGen.generateProcessImplementations();
    this.fileGen.generateIOFiles();
    this.fileGen.generatePlatformImplementations();
    this.fileGen.generateMain();
    this.fileGen.generateBuildFiles();
  }
  
  public void copyResources(final IFileSystemAccess2 fsa) {
    for (final String resource : R2CResourceProvider.COMMON_RESOURCES) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("c-code/");
      _builder.append(resource);
      Class<? extends R2CReflexGenerator> _class = this.getClass();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("/resources/c-code/");
      _builder_1.append(resource);
      fsa.generateFile(_builder.toString(), _class.getResourceAsStream(_builder_1.toString()));
    }
  }
}
