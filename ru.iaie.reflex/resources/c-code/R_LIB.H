/*
*    Файл обеспечивает реализацию системной независимости
*    и межплатформенной переносимости (портируемости) программ
*    уровня процессов (запуск процесса, останов, перевод в состояние ошибки,
*    организация перехода из состояния в состояние и пр.)
*    Коррекция файла проводится в случае перехода с одной платформы на другую
*    Например, при смене архитектуры процессора или (реже) при смене
*    операционной системы
*/

#ifndef _R_LIB_H
#define _R_LIB_H 1

#pragma pack (1)

#include "proc.h"

struct St_Word
{
    INT32U TimeInState;  /* время нахождения в текущем состоянии обнуляется Старт и Set_State*/
    INT8U cur_state;     /* текущее состояние */
};


extern struct St_Word *Pr_States;                          /* Указатель для связи с R_LIB.C */
extern struct St_Word Original_Pr_States[PROCESS_Nn + 1];  /* место под структуры PSW */


/*================ Set State Of Process ===================*/
void Set_State(INT16U, INT8U);
/*================ Set Pause Of Process ===================*/
INT16U Timeout(INT16U, INT32U); /* процесс, таймаут */

/*================ Set Stop Of Process ===================*/
void Set_Stop(INT16U);

/*================ Set Error Of Process ===================*/
void Set_Error(INT16U);

/*================ Set Start Of Process ===================*/
void Set_Start(INT16U);

/*================ Work Up Current State Of Process ===================*/
INT16U Check_State(INT16U);

/*=========== Prepare Of Process State Words For Next Tact =============*/
void Prepare_PSW(INT16U, INT16U);

/*================ Initialization Of Process State Words ===================*/
void Init_PSW(INT16U, INT16U);

void DebugInit(void);
void Debug(void);

#endif
