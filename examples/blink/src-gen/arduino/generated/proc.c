/* FILE OF PROC-IMAGES OF THE PROJECT */
#include "ext.h" /* Common files for all generated c-files */
#include "xvar.h"  /* Var-images */
void _p_Blink() { /* Process: Blink */
	switch (Check_State(0)) {
		case 0: { /* State: Lighting */
			_p_Blink_v_light_control = TRUE;
			if (Timeout(0, (INT32_U) 1000UL))
				{
				Set_State(0, 1);
				}
			break;
		}
		case 1: { /* State: Waiting */
			_p_Blink_v_light_control = FALSE;
			if (Timeout(0, (INT32_U) 1000UL))
				{
				Set_State(0, 0);
				}
			break;
		}
	}
}
