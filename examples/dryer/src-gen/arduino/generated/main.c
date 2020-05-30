#include "ext.h" /* Common files for all generated c-files */
#include "proc.h"  /* Process-functions desription */
#include "gvar.h"  /* Project variables images */
#include "io.h"    /* Scan-input/output functions */
#include "../lib/platform.h"

void Control_Loop(void)    /* Control algorithm */
{
	Init_Processes();
	Init_Time();
	Init_IO();
	for (;;) {
		_r_cur_time = Get_Time();
		if (_r_cur_time - _r_next_act_time >= 0) {
			// Find next activation time
			_r_next_act_time += _r_CLOCK;
			if (_r_next_act_time - _r_cur_time > _r_CLOCK) {
				_r_next_act_time = _r_cur_time + _r_CLOCK;
			}
			Input();
			_p_Dryer(); /* Process Dryer */
			Output();
		}
	}
}

int main() {
	Control_Loop();
}
