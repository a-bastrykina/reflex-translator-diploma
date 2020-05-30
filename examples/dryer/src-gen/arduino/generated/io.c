#include "io.h"
#include "xvar.h"
#include "../lib/r_cnst.h"
#include "../lib/platform.h"

void Input(void) {
	_i_inp = Read_Input8(0x00, 0x00);
    if (_i_inp & MASK1_S8) {
    	_p_Dryer_v_hands_under_dryer = TRUE;
    }
    else {
    	_p_Dryer_v_hands_under_dryer = FALSE;
    } 
}

void Output(void) {
	if (_p_Dryer_v_dryer_control) {
		_o_out |= MASK1_S8; 
	} else {
		_o_out &= ~MASK1_S8; 
	}
Write_Output8(0x00, 0x01, _o_out);
}
