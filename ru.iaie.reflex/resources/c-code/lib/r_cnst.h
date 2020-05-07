/*
*    Файл R_CNST.H
*    описывает системные константы среды REFLEX
*    Коррекция файла проводится в случае концептуальных изменений
*    в среде REFLEX
*/

#ifndef _R_CNST_H
#define _R_CNST_H 1

#define MASK_OF_INACTIVITY 0x80 /* если в ячейке с текущим состоянием 1-ца в ст.разряде - процесс неактивен */
#define STATE_OF_ERROR      254 /* номер состояния "останов по ошибке" */
#define STATE_OF_STOP       255 /* номер состояния "нормального останов" */

#ifndef NULL
#define NULL 0
#define ZERO 0
#endif

/*========= МАСКИ ДЛЯ ГЕНЕРАЦИИ ЛОГИЧЕСКИХ ПЕРЕМЕННЫХ ====*/
#define MASK1_S8 1
#define MASK2_S8 2
#define MASK3_S8 4
#define MASK4_S8 8
#define MASK5_S8 16
#define MASK6_S8 32
#define MASK7_S8 64
#define MASK8_S8 128

#define MASK1_S16      1
#define MASK2_S16      2
#define MASK3_S16      4
#define MASK4_S16      8
#define MASK5_S16     16
#define MASK6_S16     32
#define MASK7_S16     64
#define MASK8_S16    128
#define MASK9_S16    256
#define MASK10_S16   512
#define MASK11_S16  1024
#define MASK12_S16  2048
#define MASK13_S16  4096
#define MASK14_S16  8192
#define MASK15_S16 16384
#define MASK16_S16 32768

#define OFF	0
#define ON	1

#define BUFFER_LENGTH 128
#define DEBUG_FLAG


typedef unsigned char BOOLEAN;     /* Logical data type (TRUE or FALSE)   */
typedef unsigned char INT8U;      /* Unsigned  8 bit value               */
typedef signed   char INT8S;      /* Signed    8 bit value               */
typedef unsigned int  INT16U;     /* Unsigned 16 bit value               */
typedef signed   int  INT16S;     /* Signed   16 bit value               */
typedef unsigned long INT32U;     /* Unsigned 32 bit value               */
typedef signed   long INT32S;     /* Signed   32 bit value               */
/* typedef unsigned long INT64U;      Unsigned 64 bit value (if available)*/
/* typedef signed   long INT64S;      Signed   64 bit value (if available)*/
typedef float         FP32;       /* 32 bit, single prec. floating-point */
typedef double        FP64;       /* 64 bit, double prec. floating-point */


#endif
