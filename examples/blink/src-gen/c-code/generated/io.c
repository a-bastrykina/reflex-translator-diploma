#include "io.h"
#include "xvar.h"
#include "../lib/r_cnst.h"
#include "../lib/platform.h"

void Input(void) {
}

void Output(void) {
	if (_p_Blink_v_light_control) {
		_o_out |= MASK1_S8; 
	} else {
		_o_out &= ~MASK1_S8; 
	}
Write_Output8(0x00, 0x01, _o_out);
}
