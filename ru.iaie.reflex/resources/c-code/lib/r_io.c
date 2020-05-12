//bvz #include "IO_arrays.h"
#include "r_io.h"
#include "r_cnst.h"

INT8 * aInput = NULL;
INT8 * aOutput = NULL;

int input_counter = 0;
int output_counter = 0;

unsigned char INBYTE(unsigned int SignalType, unsigned int SignalAddress)
{
	if (SignalType == 0)
                return (aInput[SignalAddress]);
    else return (aOutput[SignalAddress]);
}

unsigned int OUTBYTE(unsigned int SignalType, unsigned int SignalAddress, unsigned char _DO)
{
	if (SignalType == 1)
	{
        aOutput[SignalAddress] = ~_DO;
		return 1;
	}
	else return 0;
}
