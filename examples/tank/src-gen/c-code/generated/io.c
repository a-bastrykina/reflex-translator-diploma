#include "io.h"
#include "xvar.h"
#include "../lib/r_cnst.h"
#include "../lib/platform.h"

void Input(void) {
	_i_X_BIT0_PORT = Read_Input8(0, 0);
	_i_X_BIT1_PORT = Read_Input8(0, 1);
	_i_X_BIT2_PORT = Read_Input8(0, 2);
	_i_X_BIT3_PORT = Read_Input8(0, 3);
    _g_X_BIT0 = _i_X_BIT0_PORT;
    _g_X_BIT1 = _i_X_BIT1_PORT;
    _g_X_BIT2 = _i_X_BIT2_PORT;
    _g_X_BIT3 = _i_X_BIT3_PORT;
}

void Output(void) {
	_o_U_BIT0_PORT = _g_U_BIT0;
	_o_U_BIT1_PORT = _g_U_BIT1;
	_o_U_BIT2_PORT = _g_U_BIT2;
	_o_U_BIT3_PORT = _g_U_BIT3;
Write_Output8(1, 0, _o_U_BIT0_PORT);
Write_Output8(1, 1, _o_U_BIT1_PORT);
Write_Output8(1, 2, _o_U_BIT2_PORT);
Write_Output8(1, 3, _o_U_BIT3_PORT);
}
