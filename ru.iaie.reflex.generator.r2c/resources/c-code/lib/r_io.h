#ifndef _R_IO_H
#define _R_IO_H 1
#include "r_cnst.h"
//#include "bsvtxvar.h"
/**********************************************
 * Структура для безопасной
 * передачи слова для 8-ми
 * разрядной системной магистрали 
 **********************************************/

struct Word {
    INT8_U  Channel; /* номер действительного канала */
    INT16_U Value0;  /* канал N 0 */
    INT16_U Value1;  /* канал N 1 */
};

/*********************************************
 * Структура для безопасной
 * передачи двойного слова для 8-ми
 * и 16-ти разрядной системной магистрали 
 *********************************************/

struct DWord{
    INT8_U  Channel; /* номер действительного канала */
    INT32_U Value0;  /* канал N 0 */
    INT32_U Value1;  /* канал N 1 */
};

//extern INT16 aInput [INPUT_PORTS_COUNTER + 1];
//extern INT16 aOutput [OUTPUT_PORTS_COUNTER + 1];

extern INT8 * aInput;
extern INT8 * aOutput;

extern int input_counter;
extern int output_counter;

//INT16 input_counter = INPUT_PORTS_COUNTER;
//INT16 output_counter = INPUT_PORTS_COUNTER;

unsigned char INBYTE(unsigned int, unsigned int);         /* считывание байта из UNIO */
unsigned int  OUTBYTE(unsigned int, unsigned int, unsigned char); /* запись байта в UNIO */

/* signed int  INWORD(INT16_U, void far *);
 signed long INDWORD(INT16_U, void far *);
*/

#endif
