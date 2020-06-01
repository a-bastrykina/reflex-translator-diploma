#ifndef PLATFORM_H
#define PLATFORM_H

#include "r_cnst.h"

void init_time();
void init_io();

INT32_U get_time();

INT8 read_byte(int, int);
int write_byte(int, int, INT8);
INT16 read_word(int, int);
int write_word(int, int, INT16);

#endif
