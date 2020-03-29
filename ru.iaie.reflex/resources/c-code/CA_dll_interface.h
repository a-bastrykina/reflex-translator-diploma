#pragma once
#pragma pack(1)
/*CA algoblock*/ 
//#include <stdint.h>
#include "LabVIEWData.h"

#define TEST_MODE_TRUE

//extern struct St_Word;

extern "C" __declspec(dllexport)void LLD(  PortsHdl, //algInputPorts 
								PortsHdl, //algOutputPorts
								ArrayOfMessagesHdl, //scenarios2VirtPlantOutputMsgs
								ArrayOfMessagesHdl, //virtualPlant2GUIOutputMsgs
								ArrayOfStatesHdl);

