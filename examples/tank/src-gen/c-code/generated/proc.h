#ifndef _proc_h
#define _proc_h 1
void _p_INIT();
void _p_ReadInputMsgs();
void _p_READ_ADC();
void _p_CONTROLLER();
void _p_Filter();
void _p_WRITE_DAC();
void _p_Info();
#define PROCESS_Nn 6
#define PROCESS_N1 0
#endif
