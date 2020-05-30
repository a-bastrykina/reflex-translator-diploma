/* FILE OF PROC-IMAGES OF THE PROJECT */
#include "ext.h" /* Common files for all generated c-files */
#include "xvar.h"  /* Var-images */
void _p_INIT() { /* Process: INIT */
	switch (Check_State(0)) {
		case 0: { /* State: InitialSetup */
			Set_Start(2);
			Set_Start(5);
			Set_Start(3);
			Set_Start(4);
			Set_Start(1);
			Set_Start(6);
			Set_Stop(0);
			break;
		}
	}
}
void _p_ReadInputMsgs() { /* Process: ReadInputMsgs */
	switch (Check_State(1)) {
		case 0: { /* State: StartReading */
			if (GetNextMsgGUI()) 
				{
				_g_msg_code = GetMsgGUICode();
				if (_g_msg_code == _e_em_COM2CA_XD) 
					{
					_g_XD = GetFloatParamGUI();
					}
				}
			break;
		}
	}
}
void _p_READ_ADC() { /* Process: READ_ADC */
	switch (Check_State(2)) {
		case 0: { /* State: READ */
			_g_X = PortsToFloat(_g_X_BIT0,_g_X_BIT1,_g_X_BIT2,_g_X_BIT3);
			break;
		}
	}
}
void _p_CONTROLLER() { /* Process: CONTROLLER */
	switch (Check_State(3)) {
		case 0: { /* State: Init */
			_p_CONTROLLER_v_Sum = 0.0;
			_p_CONTROLLER_v_E = 0.0;
			Set_State(3, 1);
			break;
		}
		case 1: { /* State: NormalPIControl */
			_p_CONTROLLER_v_E = _g_XD - _g_X;
			_p_CONTROLLER_v_Sum += _p_CONTROLLER_v_E;
			_g_U = _c_K_P * _p_CONTROLLER_v_E + _c_K_I * _p_CONTROLLER_v_Sum * _c_T_H;
			if (_g_U > _c_U_MAX) 
				_g_U = _c_U_MAX;
			if (_g_U < 0) 
				_g_U = 0.0;
			if (_g_X >= _c_X_MAX) 
				Set_State(3, 2);
			else if (_g_X < _c_X_MIN) 
				Set_State(3, 3);
			break;
		}
		case 2: { /* State: Overflow */
			_g_U = 0;
			if (_g_X < _c_X_MAX) 
				Set_State(3, 0);
			break;
		}
		case 3: { /* State: LowLevel */
			_g_U = _c_U_MAX;
			if (_g_X > _c_X_MIN) 
				Set_State(3, 0);
			break;
		}
	}
}
void _p_Filter() { /* Process: Filter */
	switch (Check_State(4)) {
		case 0: { /* State: Init */
			_p_Filter_v_U_Prev = _c_U_MIN;
			Set_State(4, 1);
			break;
		}
		case 1: { /* State: Filtering */
			if (_g_U >= _p_Filter_v_U_Prev) 
				{
				if (_g_U - _p_Filter_v_U_Prev > _c_DELTA_U) 
					{
					_g_U = _p_Filter_v_U_Prev + _c_DELTA_U;
					}
				}
			else {
			if (_p_Filter_v_U_Prev - _g_U > _c_DELTA_U) 
				{
				_g_U = _p_Filter_v_U_Prev - _c_DELTA_U;
				}
			}
			_p_Filter_v_U_Prev = _g_U;
			break;
		}
	}
}
void _p_WRITE_DAC() { /* Process: WRITE_DAC */
	switch (Check_State(5)) {
		case 0: { /* State: WRITE */
			_g_U_BIT0 = GetBit(_g_U,0);
			_g_U_BIT1 = GetBit(_g_U,1);
			_g_U_BIT2 = GetBit(_g_U,2);
			_g_U_BIT3 = GetBit(_g_U,3);
			break;
		}
	}
}
void _p_Info() { /* Process: Info */
	switch (Check_State(6)) {
		case 0: { /* State: Idiling */
			if (Timeout(6, (INT32_U) 50000UL))
				{
				SendMsgFloatParamGUI(_e_em_CA2GUI_U_LEVEL,_g_U);
				Set_State(6, 0);
				}
			break;
		}
	}
}
