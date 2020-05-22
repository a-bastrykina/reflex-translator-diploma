package ru.iaie.reflex.generator.r2c;

import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class R2CResourceProvider {
  public static final List<String> COMMON_RESOURCES = CollectionLiterals.<String>newArrayList("usr/usr.c", "usr/usr.h", 
    "lib/r_cnst.h", "lib/r_lib.c", "lib/r_lib.h", "lib/r_main.h", 
    "generated/ext.h", "generated/io.h", "lib/platform.h");
}
