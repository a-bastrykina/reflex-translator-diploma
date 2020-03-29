#include "lib.h"
#include "CA_dll_interface.h"
#include "R_LIB.H"
#include "CA_queue_const.h"
#include "r_main.h" 

/*CA algoblock*/ 

INT8S * aInput = nullptr;
INT8S * aOutput = nullptr;

int32_t input_counter  = 0;
int32_t output_counter = 0;


 int8_t set_input_ports_array(PortsHdl new_handler)
{
	return _ports_array_resize(new_handler, size_t(INPUT_PORTS_COUNTER), aInput, input_counter);
}

 int8_t set_output_ports_array(PortsHdl new_handler)
{
	return _ports_array_resize(new_handler, size_t(OUTPUT_PORTS_COUNTER), aOutput, output_counter);

}


 int8_t set_input_msg(ArrayOfMessagesHdl input_msg)
{
	return _msg_array_resize(input_msg); 
}

int8_t set_output_msg(ArrayOfMessagesHdl output_msg)
{
	return _msg_array_resize(output_msg);
}



extern "C" __declspec(dllexport)void LLD(PortsHdl algInputPorts, //algInputPorts 
	 PortsHdl algOutputPorts, //algOutputPorts
	 ArrayOfMessagesHdl scenarios2AlgOutputMsgs, //scenarios2AlgOutputMsgs
	 ArrayOfMessagesHdl algOutputMsgs, //algOutputMsgs
	 ArrayOfStatesHdl states_hdl)

 {
	 static int32_t counter = 0;
	 if (0 == counter)
	 {
		 // Initialization  
		 Init_PSW((INT16U)(PROCESS_N1), (INT16U)PROCESS_Nn); // »нициализаци¤  PSW процессов
		 counter = 1;
		 ConstructMsgQueue(&MainInputQueue);
		 ConstructMsgQueue(&MainOutputQueue);

		 set_input_ports_array(algInputPorts);
		 set_output_ports_array(algOutputPorts);

		 //	set_input_msg(scenarios2AlgOutputMsgs);
		 set_output_msg(algOutputMsgs);

		 _states_array_resize(states_hdl);
	 }

	 aInput = reinterpret_cast<INT8S*> ((*algInputPorts)->ports);
	 aOutput = reinterpret_cast<INT8S*> ((*algOutputPorts)->ports);


	 parse_input_msg_array(scenarios2AlgOutputMsgs, MainInputQueue);
	 Control_Loop();
	 parse_output_msg_array(MainOutputQueue, algOutputMsgs);

	 for (int k = 0; k < (*states_hdl)->dimSize && k <= PROCESS_Nn; k++)
	 {
		 (*states_hdl)->state[k].cur_state = Pr_States[k].cur_state;
		 (*states_hdl)->state[k].TimeInState = Pr_States[k].TimeInState;
	 }

 }