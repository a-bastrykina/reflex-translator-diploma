#include "../generated/xvar.h"

#include "r_cnst.h"
#include "r_lib.h"

struct Process processes[PROCESS_Nn + 1];

/*================ Set State Of Process ===================*/
void set_state(INT16_U pr_num, INT8_U st_num)
{
    processes[pr_num].cur_state   = (INT8_U)st_num;
    processes[pr_num].state_start_time = _r_cur_time;
}

/*================ Set Stop Of Process ===================*/
void set_stop(INT16_U pr_num)
{
    processes[pr_num].cur_state = (INT8_U)STATE_OF_STOP;
}

/*================ Set Error Of Process ===================*/
void set_error(INT16_U pr_num)
{
    processes[pr_num].cur_state = (INT8_U)STATE_OF_ERROR;
}

/*================ Set Start Of Process ===================*/
void set_start(INT16_U pr_num)
{
    processes[pr_num].cur_state = (INT8_U)0;
    processes[pr_num].state_start_time = _r_cur_time;
}

/*================ Reset Process Timer ====================*/
void reset_timer(INT16_U pr_num)
{
    processes[pr_num].state_start_time = _r_cur_time;
}

/*================ Get Current State Of Process ===================*/
INT16_U check_state(INT16_U pr_num)
{
    return ((INT16_U)processes[pr_num].cur_state);
}

BOOL timeout(INT16_U pr_num, INT32_U timeout)
{
    if (_r_cur_time - processes[pr_num].state_start_time < timeout) return FALSE;
    return TRUE;
}

INT16_U is_error(INT16_U pr_num)
{
    return (INT16_U)(check_state(pr_num) == STATE_OF_ERROR);
}

INT16_U is_stop(INT16_U pr_num)
{
    return (INT16_U)(check_state(pr_num) == STATE_OF_STOP);
}

INT8_U is_active(INT16_U pr_num) {
    return !is_stop(pr_num) && !is_error(pr_num);
}

INT8_U  is_inactive(INT16_U pr_num) {
    return is_stop(pr_num) || is_error(pr_num);
}

/*================ Initialization Of Processes ===================*/
void init_processes()
{
    register INT16_U i;
    set_start(PROCESS_N1);
    for (i = (PROCESS_N1 + 1); i <= PROCESS_Nn; i++) {
        set_stop(i);
    }
}

