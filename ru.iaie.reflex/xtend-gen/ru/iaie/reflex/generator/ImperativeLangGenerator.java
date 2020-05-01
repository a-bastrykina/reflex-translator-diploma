package ru.iaie.reflex.generator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import ru.iaie.reflex.generator.ISourceBuilder;
import ru.iaie.reflex.generator.ITranslationStrategy;
import ru.iaie.reflex.generator.r2c.IReflexCachedIdentifiersHelper;
import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.Program;
import ru.iaie.reflex.utils.ReflexModelUtil;

@SuppressWarnings("all")
public class ImperativeLangGenerator extends AbstractGenerator {
  private IReflexCachedIdentifiersHelper identifiersHelper;
  
  private ITranslationStrategy strategy;
  
  private ISourceBuilder builder;
  
  private Program program;
  
  @Override
  public void beforeGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.program = ReflexModelUtil.getProgram(resource);
  }
  
  @Override
  public void afterGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.identifiersHelper.clearCaches();
  }
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.generateConstantDefinitions(resource, fsa, context);
    this.generateInput(resource, fsa, context);
    this.generateOutput(resource, fsa, context);
    this.builder.build();
  }
  
  public Object generateInput(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    return null;
  }
  
  public Object generateOutput(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    return null;
  }
  
  public void generateConstantDefinitions(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.builder.withConstantDefinitions(this.generateConstants(resource));
  }
  
  public String generateConstants(final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Const> _consts = this.program.getConsts();
      for(final Const constant : _consts) {
        _builder.append("strategy.translateConstDefinition(constant);");
        _builder.newLine();
      }
    }
    return _builder.toString();
  }
}
