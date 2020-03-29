#pragma once
#ifndef LAB_VIEW_DATA_TYPES_H
#define LAB_VIEW_DATA_TYPES_H
//#include <cstdint> 
//#ifdef __cplusplus
//extern "C" {
//#include "extcode.h"
//}
//#else
//#include "extcode.h"
//#endif

#include <inttypes.h>
typedef int64_t __int64;

#if defined(_WIN32) &&  defined(__GNUC__)
   //  #pragma message("WIN 32")// Windows
	  #define _MSC_VER 1
 #endif	
 
#include "extcode.h"
#pragma pack(1) 
//#include "windows.h"

#define TEST_MODE_TRUE

/* LabVIEW created typedefs - входныевыходные массивы*/
typedef struct Port
{
	int32_t dimSize;
	int8_t ports[1];
};
typedef Port **PortsHdl;

/* —ообщение типа:
*	- код сообщени€
*	- новое значение типа string
* - тип параметра */
typedef struct MessageCluster 
{
	int16_t msg;// Msg 
	int32_t param; // Value
	int16_t type;
};

/*ћассив сообщений*/
typedef struct ArrayOfMessages 
{
	int32_t dimSize;
	MessageCluster message[1];
};
typedef ArrayOfMessages **ArrayOfMessagesHdl;

typedef struct ProcessState
{
	uint16_t TimeInState;  /* врем€ нахождени€ в текущем состо€нии обнул€етс€ —тарт и Set_State*/
	int8_t cur_state;     /* текущее состо€ние */
};

typedef struct ArrayOfStates
{
	int32_t dimSize;
	ProcessState state[1];
} ArrayOfStates;

typedef ArrayOfStates ** ArrayOfStatesHdl;


#endif // !LAB_VIEW_DATA_TYPES_H

