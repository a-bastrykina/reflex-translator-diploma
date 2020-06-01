package ru.iaie.reflex.generator.r2c.arduino;

import java.util.Map;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import ru.iaie.reflex.generator.r2c.common.R2CFileGenerator;
import ru.iaie.reflex.utils.ReflexModelUtil;

@SuppressWarnings("all")
public class ArduinoFileGenerator extends R2CFileGenerator {
  private static final String ANNOTATION_NAMESPACE = "ArduinoPLC";
  
  private static final String TIMER_INIT_ANNOTATION = "timer_init";
  
  private static final String TIMER_ANNOTATION = "timer_function";
  
  private static final String IO_INIT_ANNOTATION = "io_init";
  
  private static final String GLOBAL_ANNOTATION = "insert_global";
  
  private static final String BYTE_READ_ANNOTATION = "read_byte";
  
  private static final String WORD_READ_ANNOTATION = "read_word";
  
  private static final String BYTE_WRITE_ANNOTATION = "write_byte";
  
  private static final String WORD_WRITE_ANNOTATION = "write_word";
  
  private static final String DEFAULT_TIMER_INIT = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("//Init timer0");
      _builder.newLine();
      _builder.append("TCCR0B = (1 << CS00) | (1 << CS02); // /1024 prescaler");
      _builder.newLine();
      _builder.append("TIMSK0 = (1 << TOIE0); // overflow interrupt");
      _builder.newLine();
      _builder.append("sei();");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  private static final String DEFAULT_IO_INIT = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("DDRB = 0;");
      _builder.newLine();
      _builder.append("DDRC = 0xFF;");
      _builder.newLine();
      _builder.append("DDRD = 0;");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  private static final String DEFAULT_GET_TIME_IMPL = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("unsigned char sreg = SREG;");
      _builder.newLine();
      _builder.append("cli(); //start critical section");
      _builder.newLine();
      _builder.append("unsigned long ovf = ovf_cnt;");
      _builder.newLine();
      _builder.append("unsigned long tcnt = TCNT0;");
      _builder.newLine();
      _builder.append("SREG = sreg; //end of critical section - no sei() needed");
      _builder.newLine();
      _builder.newLine();
      _builder.append("//Timer has already overflown, but interrupt has yet to execute");
      _builder.newLine();
      _builder.append("if ((TIFR0 & _BV(TOV0)) && (tcnt < 255)) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ovf++;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("unsigned long fract;");
      _builder.newLine();
      _builder.append("const unsigned long mfcpu = F_CPU/1000; // 1000 -> milliseconds");
      _builder.newLine();
      _builder.newLine();
      _builder.append("fract = ovf % mfcpu;");
      _builder.newLine();
      _builder.append("fract <<= (8UL + 10UL); //8 -> 256 timer, 10 -> 1024 prescaler");
      _builder.newLine();
      _builder.append("fract /= mfcpu;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("ovf /= mfcpu;");
      _builder.newLine();
      _builder.append("ovf <<= (8UL + 10UL);");
      _builder.newLine();
      _builder.append("ovf += fract;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("return ovf + (tcnt << 10UL) / mfcpu;");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  private static final String DEFAULT_GLOBAL_CONTENT = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("static volatile unsigned long ovf_cnt = 0;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("//Timer0 overflow interrupt handler");
      _builder.newLine();
      _builder.append("ISR(TIMER0_OVF_vect) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ovf_cnt++;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  private static final String DEFAULT_BYTE_READ_CONTENT = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// Ignore addr1");
      _builder.newLine();
      _builder.append("switch (addr2) {");
      _builder.newLine();
      _builder.append("case 0x00: ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return PINB;");
      _builder.newLine();
      _builder.append("case 0x01:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return PINC;");
      _builder.newLine();
      _builder.append("case 0x02:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return PIND;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("return -1;");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  private static final String DEFAULT_BYTE_WRITE_CONTENT = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// Ignore addr1");
      _builder.newLine();
      _builder.append("switch (addr2) {");
      _builder.newLine();
      _builder.append("case 0x00: ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("PORTB = data;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("case 0x01:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("PORTC = data;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("case 0x02:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("PORTD = data;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("return 0;");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  private static final String DEFAULT_WORD_READ_CONTENT = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("return -1;");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  private static final String DEFAULT_WORD_WRITE_CONTENT = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("return -1;");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  @Override
  public String getRootDirName() {
    return "arduino";
  }
  
  public ArduinoFileGenerator(final Resource resource, final IFileSystemAccess2 fsa) {
    super(resource, fsa);
  }
  
  @Override
  public void generateBuildFiles() {
  }
  
  @Override
  public void generatePlatformImplementations() {
    final Map<String, String> annotations = ReflexModelUtil.collectNamespaceAnnotations(this.program, ArduinoFileGenerator.ANNOTATION_NAMESPACE);
    String _xifexpression = null;
    boolean _containsKey = annotations.containsKey(ArduinoFileGenerator.TIMER_INIT_ANNOTATION);
    if (_containsKey) {
      _xifexpression = annotations.get(ArduinoFileGenerator.TIMER_INIT_ANNOTATION);
    } else {
      _xifexpression = ArduinoFileGenerator.DEFAULT_TIMER_INIT;
    }
    final String timerInitContent = _xifexpression;
    String _xifexpression_1 = null;
    boolean _containsKey_1 = annotations.containsKey(ArduinoFileGenerator.IO_INIT_ANNOTATION);
    if (_containsKey_1) {
      _xifexpression_1 = annotations.get(ArduinoFileGenerator.IO_INIT_ANNOTATION);
    } else {
      _xifexpression_1 = ArduinoFileGenerator.DEFAULT_IO_INIT;
    }
    final String ioInitContent = _xifexpression_1;
    String _xifexpression_2 = null;
    boolean _containsKey_2 = annotations.containsKey(ArduinoFileGenerator.TIMER_ANNOTATION);
    if (_containsKey_2) {
      _xifexpression_2 = annotations.get(ArduinoFileGenerator.TIMER_ANNOTATION);
    } else {
      _xifexpression_2 = ArduinoFileGenerator.DEFAULT_GET_TIME_IMPL;
    }
    final String timerContent = _xifexpression_2;
    String _xifexpression_3 = null;
    boolean _containsKey_3 = annotations.containsKey(ArduinoFileGenerator.GLOBAL_ANNOTATION);
    if (_containsKey_3) {
      _xifexpression_3 = annotations.get(ArduinoFileGenerator.GLOBAL_ANNOTATION);
    } else {
      _xifexpression_3 = ArduinoFileGenerator.DEFAULT_GLOBAL_CONTENT;
    }
    final String globalContent = _xifexpression_3;
    String _xifexpression_4 = null;
    boolean _containsKey_4 = annotations.containsKey(ArduinoFileGenerator.BYTE_READ_ANNOTATION);
    if (_containsKey_4) {
      _xifexpression_4 = annotations.get(ArduinoFileGenerator.BYTE_READ_ANNOTATION);
    } else {
      _xifexpression_4 = ArduinoFileGenerator.DEFAULT_BYTE_READ_CONTENT;
    }
    final String byteReadContent = _xifexpression_4;
    String _xifexpression_5 = null;
    boolean _containsKey_5 = annotations.containsKey(ArduinoFileGenerator.WORD_READ_ANNOTATION);
    if (_containsKey_5) {
      _xifexpression_5 = annotations.get(ArduinoFileGenerator.WORD_READ_ANNOTATION);
    } else {
      _xifexpression_5 = ArduinoFileGenerator.DEFAULT_WORD_READ_CONTENT;
    }
    final String wordReadContent = _xifexpression_5;
    String _xifexpression_6 = null;
    boolean _containsKey_6 = annotations.containsKey(ArduinoFileGenerator.BYTE_WRITE_ANNOTATION);
    if (_containsKey_6) {
      _xifexpression_6 = annotations.get(ArduinoFileGenerator.BYTE_WRITE_ANNOTATION);
    } else {
      _xifexpression_6 = ArduinoFileGenerator.DEFAULT_BYTE_WRITE_CONTENT;
    }
    final String byteWriteContent = _xifexpression_6;
    String _xifexpression_7 = null;
    boolean _containsKey_7 = annotations.containsKey(ArduinoFileGenerator.WORD_WRITE_ANNOTATION);
    if (_containsKey_7) {
      _xifexpression_7 = annotations.get(ArduinoFileGenerator.WORD_WRITE_ANNOTATION);
    } else {
      _xifexpression_7 = ArduinoFileGenerator.DEFAULT_WORD_WRITE_CONTENT;
    }
    final String wordWriteContent = _xifexpression_7;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#include <avr/io.h>");
    _builder.newLine();
    _builder.append("#include <avr/interrupt.h>");
    _builder.newLine();
    _builder.append("#include \"../lib/platform.h\"");
    _builder.newLine();
    _builder.append("#include \"../generated/xvar.h\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// Atmega 368p");
    _builder.newLine();
    _builder.append("#ifndef F_CPU");
    _builder.newLine();
    _builder.append("#define F_CPU 16000000UL");
    _builder.newLine();
    _builder.append("#endif");
    _builder.newLine();
    _builder.newLine();
    _builder.append(globalContent);
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("void init_time() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(timerInitContent, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(R2CFileGenerator.CUR_TIME_NAME, "\t");
    _builder.append(" = 0;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(R2CFileGenerator.NEXT_TIME_NAME, "\t");
    _builder.append(" = 0;");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("void init_io() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(ioInitContent, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("INT32_U get_time() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(timerContent, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("INT8 read_byte(int addr1, int addr2) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(byteReadContent, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int write_byte(int addr1, int addr2, INT8 data) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(byteWriteContent, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("INT16 read_word(int addr1, int addr2) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(wordReadContent, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("int write_word(int addr1, int addr2, INT16 data) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(wordWriteContent, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    final String fileContent = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    String _rootDirName = this.getRootDirName();
    _builder_1.append(_rootDirName);
    _builder_1.append("/generated/platform.c");
    this.fsa.generateFile(_builder_1.toString(), fileContent);
  }
}
