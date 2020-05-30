#include "io.h"
#include "xvar.h"
#include "../lib/r_cnst.h"
#include "../lib/platform.h"

void Input(void) {
}

void Output(void) {
	if (_p_LightCycle_v_red_control) {
		_o_inp |= MASK1_S8; 
	} else {
		_o_inp &= ~MASK1_S8; 
	}
	if (_p_LightCycle_v_yellow_control) {
		_o_inp |= MASK2_S8; 
	} else {
		_o_inp &= ~MASK2_S8; 
	}
	if (_p_LightCycle_v_green_control) {
		_o_inp |= MASK3_S8; 
	} else {
		_o_inp &= ~MASK3_S8; 
	}
Write_Output8(0x00, 0x01, _o_inp);
}
