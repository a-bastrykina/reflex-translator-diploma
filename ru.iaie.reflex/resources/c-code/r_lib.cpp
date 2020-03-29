/*
*    Файл обеспечивает реализацию системной независимости
*    и межплатформенной переносимости (портируемости) программ
*    уровня процессов (запуск процесса, останов, перевод в состояние ошибки,
*    организация перехода из состояния в состояние и пр.)
*    Коррекция файла проводится в случае перехода с одной платформы на другую
*    Например, при смене архитектуры процессора или (реже) при смене
*    операционной системы
*/

/*
 *  Правила:
 *       1. Логический номер процесса n (передаваемый в
 *          качестве параметра функций) соответствует
 *          структуре под номером n-1 в массиве структур PSW
 *          Логические номера процессов начинаются с единицы.
 *       2. Логические номера состояний начинаются с единицы.
 *
 */

#include <stdio.h>

#include "r_cnst.h"
#include "r_lib.h"
//#include "r_main.h"


St_Word *Pr_States;                          /* Указатель для связи с R_LIB.C */
St_Word Original_Pr_States[PROCESS_Nn + 1];  /* место под структуры PSW */


/*================ Set State Of Process ===================*/
void Set_State (INT16U pr_num, INT8U st_num)
{
    Pr_States[pr_num].cur_state   = (INT8U)st_num;
    Pr_States[pr_num].TimeInState = (INT32U)0;
}

/*================ Set Stop Of Process ===================*/
void Set_Stop (INT16U pr_num)
{
    Pr_States[pr_num].cur_state = (INT8U)STATE_OF_STOP;
}

/*================ Set Error Of Process ===================*/
void Set_Error (INT16U pr_num)
{
    Pr_States[pr_num].cur_state = (INT8U)STATE_OF_ERROR;
}

/*================ Set Start Of Process ===================*/
void Set_Start (INT16U pr_num)
{
    Pr_States[pr_num].cur_state = (INT8U)0;
    Pr_States[pr_num].TimeInState = (INT32U)0;
}

/*================ Work Up Current State Of Process ===================*/
INT16U Check_State (INT16U pr_num)
{
    return((INT16U)Pr_States[pr_num].cur_state);
}

/* ==== Обработка ситуации таймаута - 
 * проверяем время нахождения 
 * в состоянии и в случае, когда 
 * время нахождения в текущем состоянии 
 * больше или равно значению таймаута,
 * возвращаем ИСТИННО ===== 
 */
INT16U Timeout (INT16U pr_num, INT32U timeout_value) /* процесс, таймаут */
{
    if (Pr_States[pr_num].TimeInState >= timeout_value) return(!NULL);
    return((INT16U)NULL);
}



/*================ Initialization Of Process State Words ===================*/
void Init_PSW (INT16U FirstProc, INT16U LastProc)
{
    register INT16U i;

    Pr_States = Original_Pr_States;                       /* инициируем указатель на PSWs */

    Set_Start(FirstProc);                              /* запускаем первый процесс на процессоре: */
    for (i = (FirstProc + 1); i <= LastProc; i++) {    /* остальные останавливаем: */
        Set_Stop(i);
    }
}


/*=========== Prepare Of Process State Words For Next Tact =============*/
void Prepare_PSW (INT16U FirstProc, INT16U LastProc)
{
    register INT16U i;
#ifdef DEBUG_FLAG
   // Debug();
#endif
    for (i = FirstProc; i <= LastProc; i++)
         Pr_States[i].TimeInState ++;
}
 
