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

extern struct Process processes[PROCESS_Nn + 1];

/*================ Set State Of Process ===================*/
void set_state(INT16_U, INT8_U);

/*================ Check if timed out ===================*/
BOOL timeout(INT16_U, INT32_U); /* process, cur_time, timeout */

/*================ Set Stop Of Process ===================*/
void set_stop(INT16_U);

/*================ Set Error Of Process ===================*/
void set_error(INT16_U);

/*================ Set Start Of Process ===================*/
void set_start(INT16_U);

/*================ Work Up Current State Of Process       ===================*/
INT16_U check_state(INT16_U);

INT8_U is_active(INT16_U pr_num);

INT8_U is_inactive(INT16_U pr_num);

/*================ Initialization Of Processes ===================*/
void init_processes();

/*================  Reset process timer ===================*/
void reset_timer(INT16_U pr_num);

#endif
