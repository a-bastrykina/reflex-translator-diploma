/*
*    ���� ������������ ���������� ��������� �������������
*    � ���������������� ������������� (�������������) ��������
*    ������ ��������� (������ ��������, �������, ������� � ��������� ������,
*    ����������� �������� �� ��������� � ��������� � ��.)
*    ��������� ����� ���������� � ������ �������� � ����� ��������� �� ������
*    ��������, ��� ����� ����������� ���������� ��� (����) ��� �����
*    ������������ �������
*/

/*
 *  �������:
 *       1. ���������� ����� �������� n (������������ �
 *          �������� ��������� �������) �������������
 *          ��������� ��� ������� n-1 � ������� �������� PSW
 *          ���������� ������ ��������� ���������� � �������.
 *       2. ���������� ������ ��������� ���������� � �������.
 *
 */

#include <stdio.h>

#include "r_cnst.h"
#include "r_lib.h"
//#include "r_main.h"


St_Word *Pr_States;                          /* ��������� ��� ����� � R_LIB.C */
St_Word Original_Pr_States[PROCESS_Nn + 1];  /* ����� ��� ��������� PSW */


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

/*================ Reset Process Timer ====================*/
void Reset_Timer (INT16U pr_num)
{
    Pr_States[pr_num].TimeInState = (INT32U)0;
}

/*================ Work Up Current State Of Process ===================*/
INT16U Check_State (INT16U pr_num)
{
    return((INT16U)Pr_States[pr_num].cur_state);
}

/* ==== ��������� �������� �������� - 
 * ��������� ����� ���������� 
 * � ��������� � � ������, ����� 
 * ����� ���������� � ������� ��������� 
 * ������ ��� ����� �������� ��������,
 * ���������� ������� ===== 
 */
INT16U Timeout (INT16U pr_num, INT32U timeout_value) /* �������, ������� */
{
    if (Pr_States[pr_num].TimeInState >= timeout_value) return(!NULL);
    return((INT16U)NULL);
}



/*================ Initialization Of Process State Words ===================*/
void Init_PSW (INT16U FirstProc, INT16U LastProc)
{
    register INT16U i;

    Pr_States = Original_Pr_States;                       /* ���������� ��������� �� PSWs */

    Set_Start(FirstProc);                              /* ��������� ������ ������� �� ����������: */
    for (i = (FirstProc + 1); i <= LastProc; i++) {    /* ��������� �������������: */
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
 
