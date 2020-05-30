#ifndef PLATFORM_H
#define PLATFORM_H

#include "r_cnst.h"

void Init_Time();
void Init_IO();

INT32_U Get_Time();

INT8 Read_Input8(int, int);
int Write_Output8(int, int, INT8);
INT16 Read_Input16(int, int);
int Write_Output16(int, int, INT16);

#endif
