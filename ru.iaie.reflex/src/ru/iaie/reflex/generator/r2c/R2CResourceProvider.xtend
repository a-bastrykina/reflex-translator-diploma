package ru.iaie.reflex.generator.r2c

import java.util.List

class R2CResourceProvider {
	
	// TODO: copy resources under names depends on program file name
	// TODO: replace headers in files with updated file names 
	
	
	public static final List<String> COMMON_RESOURCES = newArrayList("usr/usr.c", "usr/usr.h",
		"lib/r_cnst.h", "lib/r_io.c", "lib/r_io.h", "lib/r_lib.c", "lib/r_lib.h", "lib/r_main.h",
		"generated/ext.h", "generated/io.h")

	
}