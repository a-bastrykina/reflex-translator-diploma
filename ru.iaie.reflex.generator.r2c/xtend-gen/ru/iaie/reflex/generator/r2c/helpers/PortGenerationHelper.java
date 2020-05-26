package ru.iaie.reflex.generator.r2c.helpers;

import org.eclipse.xtend2.lib.StringConcatenation;
import ru.iaie.reflex.generator.r2c.LiteralGenerationUtil;
import ru.iaie.reflex.generator.r2c.interfaces.IReflexIdentifiersHelper;
import ru.iaie.reflex.reflex.PhysicalVariable;
import ru.iaie.reflex.reflex.Port;
import ru.iaie.reflex.reflex.PortMapping;
import ru.iaie.reflex.utils.LiteralUtils;
import ru.iaie.reflex.utils.ReflexModelUtil;

@SuppressWarnings("all")
public class PortGenerationHelper {
  private IReflexIdentifiersHelper identifiersHelper;
  
  public PortGenerationHelper(final IReflexIdentifiersHelper ih) {
    this.identifiersHelper = ih;
  }
  
  public String generatePortVariableDefinition(final Port reg) {
    StringConcatenation _builder = new StringConcatenation();
    String _translateType = LiteralGenerationUtil.translateType(ReflexModelUtil.getSuitableTypeForPort(reg));
    _builder.append(_translateType);
    _builder.append(" ");
    String _portId = this.identifiersHelper.getPortId(reg);
    _builder.append(_portId);
    return _builder.toString();
  }
  
  public String translateInputPortReading(final Port port) {
    final String portId = this.identifiersHelper.getPortId(port);
    final long portSize = LiteralUtils.parseInteger(port.getSize());
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(portId);
    _builder.append(" = Read_Input");
    _builder.append(portSize);
    _builder.append("(");
    String _addr1 = port.getAddr1();
    _builder.append(_addr1);
    _builder.append(", ");
    String _addr2 = port.getAddr2();
    _builder.append(_addr2);
    _builder.append(");");
    return _builder.toString();
  }
  
  public String translateOutputPortWriting(final Port port) {
    final String portId = this.identifiersHelper.getPortId(port);
    final long portSize = LiteralUtils.parseInteger(port.getSize());
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Write_Output");
    _builder.append(portSize);
    _builder.append("(");
    String _addr1 = port.getAddr1();
    _builder.append(_addr1);
    _builder.append(", ");
    String _addr2 = port.getAddr2();
    _builder.append(_addr2);
    _builder.append(", ");
    _builder.append(portId);
    _builder.append(");");
    return _builder.toString();
  }
  
  public String translateReadingFromInput(final PhysicalVariable v) {
    final PortMapping mapping = v.getMapping();
    final String varName = this.identifiersHelper.getMapping(v);
    boolean _isFullMapping = ReflexModelUtil.isFullMapping(mapping);
    if (_isFullMapping) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(varName);
      _builder.append(" = ");
      String _portId = this.identifiersHelper.getPortId(mapping.getPort());
      _builder.append(_portId);
      _builder.append(";");
      return _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("if (");
      String _portId_1 = this.identifiersHelper.getPortId(mapping.getPort());
      _builder_1.append(_portId_1);
      _builder_1.append(" & ");
      String _generatePortMappingMask = this.generatePortMappingMask(mapping);
      _builder_1.append(_generatePortMappingMask);
      _builder_1.append(") {");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append(varName, "\t");
      _builder_1.append(" = TRUE;");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("else {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append(varName, "\t");
      _builder_1.append(" = FALSE;");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("} ");
      _builder_1.newLine();
      return _builder_1.toString();
    }
  }
  
  public String translateReadingFromOutput(final PhysicalVariable v) {
    final PortMapping mapping = v.getMapping();
    final String portVariableName = this.identifiersHelper.getPortId(mapping.getPort());
    final String varName = this.identifiersHelper.getMapping(v);
    final String mask = this.generatePortMappingMask(mapping);
    boolean _isFullMapping = ReflexModelUtil.isFullMapping(mapping);
    if (_isFullMapping) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(portVariableName);
      _builder.append(" = ");
      _builder.append(varName);
      _builder.append(";");
      return _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("if (");
      _builder_1.append(varName);
      _builder_1.append(") {");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append(portVariableName, "\t");
      _builder_1.append(" |= ");
      _builder_1.append(mask, "\t");
      _builder_1.append("; ");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append(portVariableName, "\t");
      _builder_1.append(" &= ~");
      _builder_1.append(mask, "\t");
      _builder_1.append("; ");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("}");
      _builder_1.newLine();
      return _builder_1.toString();
    }
  }
  
  public String generatePortMappingMask(final PortMapping mapping) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MASK");
    String _bit = mapping.getBit();
    _builder.append(_bit);
    _builder.append("_S");
    String _size = mapping.getPort().getSize();
    _builder.append(_size);
    return _builder.toString();
  }
}
