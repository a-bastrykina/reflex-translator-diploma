/*
    Util functions for translation support
*/

#ifndef _R_LIB_H
#define _R_LIB_H 1

#include "../generated/proc.h"

struct Process
{
    INT32_U state_start_time;   /* Time when last state changed  */
    INT8_U  cur_state;          /*  Current state identifier      */
};

extern struct Process Pr_States[PROCESS_Nn + 1];

/*================ Set State Of Process ===================*/
void Set_State(INT16_U, INT8_U);

/*================ Check if timed out ===================*/
BOOL Timeout(INT16_U, INT32_U); /* process, cur_time, timeout */

/*================ Set Stop Of Process ===================*/
void Set_Stop(INT16_U);

/*================ Set Error Of Process ===================*/
void Set_Error(INT16_U);

/*================ Set Start Of Process ===================*/
void Set_Start(INT16_U);

/*================ Work Up Current State Of Process       ===================*/
INT16_U Check_State(INT16_U);

INT8_U Is_Active(INT16_U pr_num);

INT8_U Is_Inactive(INT16_U pr_num);

/*=========== Prepare Processes For Next Tact   =============*/
void Update_Processes(INT16_U, INT16_U, INT32_U);

/*================ Initialization Of Processes ===================*/
void Init_Processes();

/*================  Reset process timer ===================*/
void Reset_Timer(INT16_U pr_num);

void DebugInit(void);
void Debug(void);

#endif
