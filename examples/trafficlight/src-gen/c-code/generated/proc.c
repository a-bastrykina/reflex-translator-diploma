/* FILE OF PROC-IMAGES OF THE PROJECT */
#include "ext.h" /* Common files for all generated c-files */
#include "xvar.h"  /* Var-images */
void _p_LightCycle() { /* Process: LightCycle */
	switch (Check_State(0)) {
		case 0: { /* State: Green */
			_p_LightCycle_v_green_control = _c_ON;
			if (Timeout(0, (INT32_U) 5000UL))
				{
				_p_LightCycle_v_green_control = _c_OFF;
				Set_State(0, 1);
				}
			break;
		}
		case 1: { /* State: Yellow */
			_p_LightCycle_v_yellow_control = _c_ON;
			if (Timeout(0, (INT32_U) 500UL))
				{
				_p_LightCycle_v_yellow_control = _c_OFF;
				Set_State(0, 2);
				}
			break;
		}
		case 2: { /* State: Red */
			_p_LightCycle_v_red_control = _c_ON;
			if (Timeout(0, (INT32_U) 5000UL))
				{
				_p_LightCycle_v_red_control = _c_OFF;
				Set_State(0, 0);
				}
			break;
		}
	}
}
