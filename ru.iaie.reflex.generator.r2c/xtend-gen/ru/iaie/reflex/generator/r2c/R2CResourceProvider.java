package ru.iaie.reflex.generator.r2c;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class R2CResourceProvider {
  public static final List<String> COMMON_RESOURCES = CollectionLiterals.<String>newArrayList("usr/usr.c", "usr/usr.h", 
    "lib/r_cnst.h", "lib/r_lib.c", "lib/r_lib.h", "lib/r_main.h", 
    "generated/ext.h", "generated/io.h", "lib/platform.h");
  
  public static final String DUMMY_PLATFORM_IMPL = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#include <sys/time.h>");
      _builder.newLine();
      _builder.append("#include <stdio.h>");
      _builder.newLine();
      _builder.append("#include \"../lib/platform.h\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("// Dummy realizations when no target platform is specified");
      _builder.newLine();
      _builder.newLine();
      _builder.append("INT32_U Get_Time() {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("struct timeval time;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("gettimeofday(&time, NULL);");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return time.tv_sec * 1000 + time.tv_usec / 1000;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("INT8 Read_Input8(int addr1, int addr2) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return 1;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("int Write_Output8(int addr1, int addr2, INT8 data) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("printf(\"Value for %d %d: %d\\n\", addr1, addr2, data);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("INT16 Read_Input16(int addr1, int addr2) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return 1;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("int Write_Output16(int addr1, int addr2, INT16 data) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("printf(\"Value for %d %d: %hd\\n\", addr1, addr2, data);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
}
