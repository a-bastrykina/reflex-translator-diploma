﻿/*
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

//#pragma pack (1)

#include "../generated/proc.h"

struct St_Word
{
    INT32_U TimeInState;  /* время нахождения в текущем состоянии обнуляется Старт и Set_State*/
    INT8_U cur_state;     /* текущее состояние */
};

extern struct St_Word *Pr_States;                          /* Указатель для связи с R_LIB.C */
extern struct St_Word Original_Pr_States[PROCESS_Nn + 1];  /* место под структуры PSW */


/*================ Set State Of Process ===================*/
void Set_State(INT16_U, INT8_U);
/*================ Set Pause Of Process ===================*/
INT16_U Timeout(INT16_U, INT32_U); /* процесс, таймаут */

/*================ Set Stop Of Process ===================*/
void Set_Stop(INT16_U);

/*================ Set Error Of Process ===================*/
void Set_Error(INT16_U);

/*================ Set Start Of Process ===================*/
void Set_Start(INT16_U);

/*================ Work Up Current State Of Process ===================*/
INT16_U Check_State(INT16_U);

/*=========== Prepare Of Process State Words For Next Tact =============*/
void Prepare_PSW(INT16_U, INT16_U);

/*================ Initialization Of Process State Words ===================*/
void Init_PSW(INT16_U, INT16_U);

/*================  Reset process timer ===================*/
void Reset_Timer(INT16_U pr_num);

void DebugInit(void);
void Debug(void);

#endif
