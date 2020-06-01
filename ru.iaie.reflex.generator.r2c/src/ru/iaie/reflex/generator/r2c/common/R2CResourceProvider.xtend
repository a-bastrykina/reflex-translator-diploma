package ru.iaie.reflex.generator.r2c.common

import java.util.List

class R2CResourceProvider {
	
	public static final List<String> COMMON_RESOURCES = newArrayList("usr/usr.c", "usr/usr.h",
		"lib/r_cnst.h", "lib/r_lib.c", "lib/r_lib.h", "lib/r_main.h",
		"generated/ext.h", "generated/io.h", "lib/platform.h")
		
	public static val DUMMY_PLATFORM_IMPL = '''
		#include <sys/time.h>
		#include <stdio.h>
		#include "../lib/platform.h"
		
		// Dummy realizations when no target platform is specified
		
		void init_time() {}
		
		void init_io() {}
		
		INT32_U get_time() {
		    struct timeval time;
		    gettimeofday(&time, NULL);
		    return time.tv_sec * 1000 + time.tv_usec / 1000;
		}
		
		INT8 read_byte(int addr1, int addr2) {
		    return 1;
		}
		
		int write_byte(int addr1, int addr2, INT8 data) {
		    printf("Value for %d %d: %d\n", addr1, addr2, data);
		}
		
		INT16 read_word(int addr1, int addr2) {
		    return 1;
		}
		
		int write_word(int addr1, int addr2, INT16 data) {
		    printf("Value for %d %d: %hd\n", addr1, addr2, data);
		}
	'''  
}