#ifndef _R_IO_H
#define _R_IO_H 1
#include "R_CNST.H"
#include "proc.h"
//#include "bsvtxvar.h"
/**********************************************
 * Структура для безопасной
 * передачи слова для 8-ми
 * разрядной системной магистрали 
 **********************************************/

struct Word {
    INT8U  Channel; /* номер действительного канала */
    INT16U Value0;  /* канал N 0 */
    INT16U Value1;  /* канал N 1 */
};

/*********************************************
 * Структура для безопасной
 * передачи двойного слова для 8-ми
 * и 16-ти разрядной системной магистрали 
 *********************************************/

struct DWord{
    INT8U  Channel; /* номер действительного канала */
    INT32U Value0;  /* канал N 0 */
    INT32U Value1;  /* канал N 1 */
};

//extern INT16S aInput [INPUT_PORTS_COUNTER + 1];
//extern INT16S aOutput [OUTPUT_PORTS_COUNTER + 1];

extern INT8S * aInput;
extern INT8S * aOutput;

extern int input_counter;
extern int output_counter;

//INT16S input_counter = INPUT_PORTS_COUNTER;
//INT16S output_counter = INPUT_PORTS_COUNTER;

unsigned char INBYTE(unsigned int, unsigned int);         /* считывание байта из UNIO */
unsigned int  OUTBYTE(unsigned int, unsigned int, unsigned char); /* запись байта в UNIO */

/* signed int  INWORD(INT16U, void far *);
 signed long INDWORD(INT16U, void far *);
*/

#endif
