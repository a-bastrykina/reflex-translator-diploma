//bvz #include "IO_arrays.h"
#include "r_io.h"
#include "R_CNST.h" 

//INT16S aInput[INPUT_PORTS_COUNTER + 1];
//INT16S aOutput[OUTPUT_PORTS_COUNTER + 1];

/*
*    Файл обеспечивает реализацию системной независимости
*    и межплатформенной переносимости (портируемости) программ
*    на уровне модулей входа/выхода.
*    Коррекция файла проводится в случае перехода на другие интерфейсные
*    модули
*    Например, при смене модулей связи с объектом с ISA на PCI, или c
*    Multibus на VME.
*    Реже необходимость коррекции может возникнуть при смене
*    операционной системы
*/


/*
*    Реализация для БСВТ, где обмен организован через массивы Input и Output (int)
     SignalType (тип сигнала: 0 -- вход, 1 -- выход), 
     SignalAddress -- номер элемента в массиве,
     _DO -- значение байта для выдачи        
*/

unsigned char INBYTE(unsigned int SignalType, unsigned int SignalAddress)
{
	if (SignalType == 0)     // массив входов ?  
                return (aInput[SignalAddress]);
    else return (aOutput[SignalAddress]);
}

unsigned int OUTBYTE(unsigned int SignalType, unsigned int SignalAddress, unsigned char _DO)
{
	if (SignalType == 1)
	{
        aOutput[SignalAddress] = ~_DO; //
		return 1;
	}
	else return 0;
}
