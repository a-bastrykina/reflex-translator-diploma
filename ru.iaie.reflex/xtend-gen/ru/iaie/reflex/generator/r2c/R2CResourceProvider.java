package ru.iaie.reflex.generator.r2c;

import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class R2CResourceProvider {
  private static final String MAIN_FILE_NAME = "%smain.cpp";
  
  private static final String VARIABLES_FILE_NAME = "%sgvar.cpp";
  
  private static final String ALGORITHM_FILE_NAME = "%sgvar.cpp";
  
  private static final List<String> commonResources = CollectionLiterals.<String>newArrayList("dll_interface.cpp", "dll_interface.h", "queue_const.h", 
    "io.h", "ports.h", "usr1.cpp", "usr1.h", "usr2.h", "custom_dll_interface.cpp", "dll_interface.h", 
    "LabVIEWData.h", "lib.cpp", "lib.h", "msg_queue.cpp", "msg_queue.h", "proc.h", "R_CNST.H", 
    "r_io.cpp", "r_io.h", "r_lib.cpp", "R_LIB.H", "r_main.h");
  
  public R2CResourceProvider(final String programName) {
  }
  
  public String getVariablesFileName() {
    return null;
  }
  
  public String getMainFileName() {
    return null;
  }
}
