package ru.iaie.reflex.generator.r2c

import java.util.List

class R2CResourceProvider {
	
	// TODO: copy resources under names depends on program file name
	// TODO: replace headers in files with updated file names 
	
	private String filePrefix
	
	static final String MAIN_FILE_NAME = "%smain.cpp"
	static final String VARIABLES_FILE_NAME = "%sgvar.cpp"
	static final String ALGORITHM_FILE_NAME = "%sgvar.cpp"
	 
	static final List<String> commonResources = newArrayList("dll_interface.cpp", "dll_interface.h", "queue_const.h",
		"io.h", "ports.h", "usr1.cpp", "usr1.h", "usr2.h", "custom_dll_interface.cpp", "dll_interface.h",
		"LabVIEWData.h", "lib.cpp", "lib.h", "msg_queue.cpp", "msg_queue.h", "proc.h", "R_CNST.H",
		"r_io.cpp", "r_io.h", "r_lib.cpp", "R_LIB.H", "r_main.h")
	
	new(String programName) {
		
	}
	
	def String getVariablesFileName() {
		
	}
	
	def String getMainFileName() {
		
	}
}