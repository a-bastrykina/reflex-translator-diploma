package ru.iaie.reflex.generator;

import com.google.common.collect.Iterables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import ru.iaie.reflex.reflex.Program;

@SuppressWarnings("all")
public class AnotherReflexGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    final Program program = ((Program[])Conversions.unwrapArray((Iterables.<Program>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Program.class)), Program.class))[0];
    StringConcatenation _builder = new StringConcatenation();
    String _lowerCase = program.getName().toLowerCase();
    _builder.append(_lowerCase);
    _builder.append(".txt");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Hello ");
    String _name = program.getName();
    _builder_1.append(_name);
    fsa.generateFile(_builder.toString(), _builder_1);
  }
}
