#include <stdio.h>
#include <sys/time.h>

#include "r_cnst.h"
#include "r_lib.h"

struct Process *Pr_States;
struct Process Original_Pr_States[PROCESS_Nn + 1];


/*================ Set State Of Process ===================*/
void Set_State (INT16_U pr_num, INT8_U st_num)
{
    Pr_States[pr_num].cur_state   = (INT8_U)st_num;
    Pr_States[pr_num].cur_time = (INT32_U)0;
}

/*================ Set Stop Of Process ===================*/
void Set_Stop (INT16_U pr_num)
{
    Pr_States[pr_num].cur_state = (INT8_U)STATE_OF_STOP;
}

/*================ Set Error Of Process ===================*/
void Set_Error (INT16_U pr_num)
{
    Pr_States[pr_num].cur_state = (INT8_U)STATE_OF_ERROR;
}

/*================ Set Start Of Process ===================*/
void Set_Start (INT16_U pr_num)
{
    Pr_States[pr_num].cur_state = (INT8_U)0;
    Pr_States[pr_num].cur_time = (INT32_U)0;
}

/*================ Reset Process Timer ====================*/
void Reset_Timer (INT16_U pr_num)
{
    Pr_States[pr_num].cur_time = (INT32_U)0;
}

/*================ Get Current State Of Process ===================*/
INT16_U Check_State (INT16_U pr_num)
{
    return((INT16_U)Pr_States[pr_num].cur_state);
}

INT16_U Timeout (INT16_U pr_num, INT32_U timeout_value)
{
    if (Pr_States[pr_num].cur_time >= timeout_value) return(!NULL);
    return((INT16_U)NULL);
}

INT16_U Is_Error(INT16_U pr_num)
{
    return (INT16_U)(Check_State(pr_num) == STATE_OF_ERROR);
}

INT16_U Is_Stop(INT16_U pr_num)
{
    return (INT16_U)(Check_State(pr_num) == STATE_OF_STOP);
}

INT16_U Is_Active(INT16_U pr_num) {
    return !Is_Stop(pr_num) && !Is_Error(pr_num);
}

INT8_U  Is_Inactive(INT16_U pr_num) {
    return Is_Stop(pr_num) || Is_Error(pr_num);
}

/*================ Initialization Of Process State Words ===================*/
void Init_PSW (INT16_U FirstProc, INT16_U LastProc)
{
    register INT16_U i;

    Pr_States = Original_Pr_States;

    Set_Start(FirstProc);
    for (i = (FirstProc + 1); i <= LastProc; i++) {
        Set_Stop(i);
    }
}

/*=========== Prepare Of Process State Words For Next Tact =============*/
void Prepare_PSW (INT16_U FirstProc, INT16_U LastProc)
{
    register INT16_U i;
#ifdef DEBUG_FLAG
   // Debug();
#endif
    for (i = FirstProc; i <= LastProc; i++)
         Pr_States[i].cur_time ++;
}
 
