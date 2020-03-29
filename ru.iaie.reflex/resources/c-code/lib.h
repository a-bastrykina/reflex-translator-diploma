#pragma once
#include "LabVIEWData.h"
#include "r_io.h"
#include "msg_queue.h"


MgErr _msg_array_resize(ArrayOfMessagesHdl _msgs);
MgErr _states_array_resize(ArrayOfStatesHdl states_hdl);
MgErr _ports_array_resize(PortsHdl new_handler, size_t size, INT8S * & array, int32_t & counter);

void parse_input_msg_array(ArrayOfMessagesHdl input_LV_queue, MsgQueue & result_queue);

void parse_output_msg_array(MsgQueue & output_queue, ArrayOfMessagesHdl output_LV_queue); 
