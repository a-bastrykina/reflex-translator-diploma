package ru.iaie.reflex.generator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import ru.iaie.reflex.generator.ISourceBuilder;
import ru.iaie.reflex.generator.ITranslationStrategy;
import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.GlobalVariable;
import ru.iaie.reflex.reflex.ProcessVariable;
import ru.iaie.reflex.reflex.Program;
import ru.iaie.reflex.utils.ReflexModelUtil;

@SuppressWarnings("all")
public class ImperativeLangGenerator extends AbstractGenerator {
  private ITranslationStrategy strategy;
  
  private ISourceBuilder builder;
  
  private Program program;
  
  @Override
  public void beforeGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.program = ReflexModelUtil.getProgram(resource);
  }
  
  @Override
  public void afterGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
  }
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.generateConstantDefinitions();
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
  
  public void generateConstantDefinitions() {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Const> _consts = this.program.getConsts();
      for(final Const constant : _consts) {
        String _translateConstDefinition = this.strategy.translateConstDefinition(constant);
        _builder.append(_translateConstDefinition);
        String _separator = this.strategy.getSeparator();
        _builder.append(_separator);
        _builder.newLineIfNotEmpty();
      }
    }
    this.builder.withConstantDefinitions(_builder.toString());
  }
  
  public void generateEnumDefifinions() {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ru.iaie.reflex.reflex.Enum> _enums = this.program.getEnums();
      for(final ru.iaie.reflex.reflex.Enum en : _enums) {
        String _translateEnumDefinition = this.strategy.translateEnumDefinition(en);
        _builder.append(_translateEnumDefinition);
        _builder.newLineIfNotEmpty();
      }
    }
    this.builder.withEnumDefinitions(_builder.toString());
  }
  
  public void generateProcessVarDefifinitions(final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ru.iaie.reflex.reflex.Process> _processes = this.program.getProcesses();
      for(final ru.iaie.reflex.reflex.Process proc : _processes) {
        {
          EList<ProcessVariable> _variables = proc.getVariables();
          for(final ProcessVariable variable : _variables) {
            String _translateProcessVarDefinition = this.strategy.translateProcessVarDefinition(proc, variable);
            _builder.append(_translateProcessVarDefinition);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    this.builder.withGlobalVariableDefinitions(_builder.toString());
  }
  
  public void generateGlobalVarDefinitions(final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<GlobalVariable> _globalVars = this.program.getGlobalVars();
      for(final GlobalVariable variable : _globalVars) {
        String _translateGlobalVarDefinition = this.strategy.translateGlobalVarDefinition(variable);
        _builder.append(_translateGlobalVarDefinition);
        _builder.newLineIfNotEmpty();
      }
    }
    this.builder.withProcessVariableDefinitions(_builder.toString());
  }
}
