/* FILE OF PROC-IMAGES OF THE PROJECT */
#include "ext.h" /* Common files for all generated c-files */
#include "xvar.h"  /* Var-images */
void _p_Dryer() { /* Process: Dryer */
	switch (Check_State(0)) {
		case 0: { /* State: Wait */
			if (_p_Dryer_v_hands_under_dryer) 
				{
				_p_Dryer_v_dryer_control = _c_ON;
				Set_State(0, 1);
				}
			break;
		}
		case 1: { /* State: Work */
			if (_p_Dryer_v_hands_under_dryer) 
				Reset_Timer(0);
			if (Timeout(0, _c_TIMEOUT))
				{
				_p_Dryer_v_dryer_control = _c_OFF;
				Set_State(0, 0);
				}
			break;
		}
	}
}
