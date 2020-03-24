package ru.iaie.reflex.generator;

import com.google.common.collect.Iterables;
import java.io.IOException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import ru.iaie.reflex.reflex.Program;

@SuppressWarnings("all")
public class XMIReflexGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    final Program program = ((Program[])Conversions.unwrapArray((Iterables.<Program>filter(IteratorExtensions.<EObject>toIterable(input.getAllContents()), Program.class)), Program.class))[0];
    this.exportXMI(program.getName().toLowerCase(), input, fsa);
  }
  
  public void exportXMI(final String fileName, final Resource resource, final IFileSystemAccess2 fsa) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(fileName);
    _builder.append(".xmi");
    final String outputURI = fsa.getURI(_builder.toString()).toPlatformString(true);
    final ResourceSet resourceSet = resource.getResourceSet();
    if ((resourceSet == null)) {
      throw new IllegalStateException("enclosing resourceSet not found");
    }
    final Resource xmiResource = resourceSet.createResource(URI.createURI(outputURI));
    xmiResource.getContents().add(resource.getContents().get(0));
    try {
      xmiResource.save(null);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        e.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
