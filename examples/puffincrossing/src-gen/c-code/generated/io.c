#include "io.h"
#include "xvar.h"
#include "../lib/r_cnst.h"
#include "../lib/platform.h"

void Input(void) {
	_i_INPUTS = Read_Input8(0, 0);
    if (_i_INPUTS & MASK1_S8) {
    	_p_WaitingButton_v_I_BUTTON = TRUE;
    }
    else {
    	_p_WaitingButton_v_I_BUTTON = FALSE;
    } 
}

void Output(void) {
	if (_p_WaitingButton_v_O_CROSSWALK) {
		_o_OUTPUTS |= MASK1_S8; 
	} else {
		_o_OUTPUTS &= ~MASK1_S8; 
	}
Write_Output8(0, 0, _o_OUTPUTS);
}
