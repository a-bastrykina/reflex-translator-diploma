package ru.iaie.reflex.generator.r2c.arduino;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import ru.iaie.reflex.generator.r2c.arduino.ArduinoFileGenerator;
import ru.iaie.reflex.generator.r2c.common.R2CReflexGenerator;

@SuppressWarnings("all")
public class ArduinoReflexGenerator extends R2CReflexGenerator {
  @Override
  public void beforeGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    ArduinoFileGenerator _arduinoFileGenerator = new ArduinoFileGenerator(resource, fsa);
    this.fileGen = _arduinoFileGenerator;
  }
}
