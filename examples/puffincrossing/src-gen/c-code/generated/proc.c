/* FILE OF PROC-IMAGES OF THE PROJECT */
#include "ext.h" /* Common files for all generated c-files */
#include "xvar.h"  /* Var-images */
void _p_WaitingButton() { /* Process: WaitingButton */
	switch (Check_State(0)) {
		case 0: { /* State: Begin */
			_p_WaitingButton_v_O_CROSSWALK = _c_ON;
			Set_State(0, 1);
			break;
		}
		case 1: { /* State: CheckButton */
			if (_p_WaitingButton_v_I_BUTTON) 
				{
				if (Is_Inactive(1)) 
					Set_Start(1);
				}
			break;
		}
	}
}
void _p_TrafficLightCycle() { /* Process: TrafficLightCycle */
	switch (Check_State(1)) {
		case 0: { /* State: Pause1min */
			_p_WaitingButton_v_O_CROSSWALK = _c_ON;
			if (Timeout(1, _c_MINUTE))
				Set_State(1, 1);
			break;
		}
		case 1: { /* State: LetCrossWalking30sec */
			_p_WaitingButton_v_O_CROSSWALK = _c_ON;
			if (Timeout(1, _c_THIRTY_SECONDS))
				{
				_p_WaitingButton_v_O_CROSSWALK = _c_OFF;
				Set_Stop(1);
				}
			break;
		}
	}
}
