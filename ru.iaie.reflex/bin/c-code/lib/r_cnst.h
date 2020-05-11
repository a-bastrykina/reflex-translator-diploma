/*
*    r_cnst.h
*    REFLEX utility constant definitions
*/

#ifndef _R_CNST_H
#define _R_CNST_H 1

#define MASK_OF_INACTIVITY 0x80 /* если в ячейке с текущим состоянием 1-ца в ст.разряде - процесс неактивен */
#define STATE_OF_ERROR      254 /* Reserved state of error */
#define STATE_OF_STOP       255 /* Reserved state of stop */

#ifndef NULL
#define NULL 0
#endif
#define ZERO 0
#define TRUE 1
#define FALSE 0

/*========= Masks for logical variables generation ====*/
#define MASK1_S8 0x01
#define MASK2_S8 0x02
#define MASK3_S8 0x04
#define MASK4_S8 0x08
#define MASK5_S8 0x10
#define MASK6_S8 0x20
#define MASK7_S8 0x40
#define MASK8_S8 0x80

#define MASK1_S16 0x0001
#define MASK2_S16 0x0002
#define MASK3_S16 0x0004
#define MASK4_S16 0x0008
#define MASK5_S16 0x0010
#define MASK6_S16 0x0020
#define MASK7_S16 0x0040
#define MASK8_S16 0x0080
#define MASK9_S16 0x0100
#define MASK10_S16 0x0200
#define MASK11_S16 0x0400
#define MASK12_S16 0x0800
#define MASK13_S16 0x1000
#define MASK14_S16 0x2000
#define MASK15_S16 0x4000
#define MASK16_S16 0x8000

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
