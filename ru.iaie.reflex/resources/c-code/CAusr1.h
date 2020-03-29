#ifndef _CAusr1_h
#define _CAusr1_h 1
/* CAUSR1.H file. Place your code here. */
/* It will be included at the top of all include-files in every generated file. */

int GetOutMsgNumber_GUI(void);

//ФУНКЦИЯ ЦЕЛ GetNextMsgGUI(ПУСТО);
int GetNextMsgGUI(void);

//ФУНКЦИЯ ЦЕЛ  GetMsgGUICode        (ПУСТО);  /*чтение из памяти кода события */
int GetMsgGUICode();

//ФУНКЦИЯ ПЛАВ GetFloatParamGUI     (ПУСТО);  /*чтение из памяти параметра события */
float GetFloatParamGUI();

/* ФУНКЦИЯ КЦЕЛ GetShortParamGUI     (ПУСТО); */
short GetShortParamGUI();

//ФУНКЦИЯ ЦЕЛ  GetIntParamGUI       (ПУСТО);
int GetIntParamGUI();

//ФУНКЦИЯ ДЦЕЛ GetLongParamGUI      (ПУСТО);
long GetLongParamGUI();

//ФУНКЦИЯ ЦЕЛ  SendMsgGUICode       (ЦЕЛ);
int SendMsgGUICode(int code);

//ФУНКЦИЯ ЦЕЛ  SendMsgFloatParamGUI (ЦЕЛ, ПЛАВ);
int SendMsgFloatParamGUI(int code, float param);

/* ФУНКЦИЯ ЦЕЛ  SendMsgShortParamGUI (ЦЕЛ, КЦЕЛ); */
int SendMsgShortParamGUI(int code, short param);

/* ФУНКЦИЯ ЦЕЛ  SendMsgIntParamGUI   (ЦЕЛ, ЦЕЛ); */
int SendMsgIntParamGUI(int code, int param);

//ФУНКЦИЯ ЦЕЛ  SendMsgLongParamGUI  (ЦЕЛ, ДЦЕЛ);
int SendMsgLongParamGUI(int code, long param);

//ФУНКЦИЯ ЦЕЛ  GetInpMsgNumber_GUI (ПУСТО);  /* чтение числа сообщ. во входн. буфере */
int GetInpMsgNumber_GUI();

//ФУНКЦИЯ ЦЕЛ  GetOutMsgNumber_GUI (ПУСТО); /* чтение числа сообщ. в выходн. буфере */*/
int GetOutMsgNumber_GUI();


#endif