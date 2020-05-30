#include "../generated/xvar.h"

#include "r_cnst.h"
#include "r_lib.h"

struct Process Pr_States[PROCESS_Nn + 1];

/*================ Set State Of Process ===================*/
void Set_State (INT16_U pr_num, INT8_U st_num)
{
    Pr_States[pr_num].cur_state   = (INT8_U)st_num;
    Pr_States[pr_num].state_start_time = _r_cur_time;
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
    Pr_States[pr_num].state_start_time = _r_cur_time;
}

/*================ Reset Process Timer ====================*/
void Reset_Timer (INT16_U pr_num)
{
    Pr_States[pr_num].state_start_time = _r_cur_time;
}

/*================ Get Current State Of Process ===================*/
INT16_U Check_State (INT16_U pr_num)
{
    return ((INT16_U)Pr_States[pr_num].cur_state);
}

BOOL Timeout(INT16_U pr_num, INT32_U timeout)
{
    if (_r_cur_time - Pr_States[pr_num].state_start_time < timeout) return FALSE;
    return TRUE;
}

INT16_U Is_Error(INT16_U pr_num)
{
    return (INT16_U)(Check_State(pr_num) == STATE_OF_ERROR);
}

INT16_U Is_Stop(INT16_U pr_num)
{
    return (INT16_U)(Check_State(pr_num) == STATE_OF_STOP);
}

INT8_U Is_Active(INT16_U pr_num) {
    return !Is_Stop(pr_num) && !Is_Error(pr_num);
}

INT8_U  Is_Inactive(INT16_U pr_num) {
    return Is_Stop(pr_num) || Is_Error(pr_num);
}

/*================ Initialization Of Processes ===================*/
void Init_Processes()
{
    register INT16_U i;
    Set_Start(PROCESS_N1);
    for (i = (PROCESS_N1 + 1); i <= PROCESS_Nn; i++) {
        Set_Stop(i);
    }
}

// /*=========== Prepare Processes For Next Tact =============*/
// void Update_Processes(INT16_U first, INT16_U last, INT32_U increment)
// {
//    register INT16_U i;
//    for (i = first; i <= last; i++) {
//        Pr_States[i].cur_time += increment;
//    }
// }
 
