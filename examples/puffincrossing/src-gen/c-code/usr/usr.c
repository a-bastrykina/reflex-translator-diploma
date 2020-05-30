//#include "usr.h"
//#include "msg_queue.h"
//QueueMsg last_msg;
//
//MsgQueue MainInputQueue;
//MsgQueue MainOutputQueue;
//
//
//int GetOutMsgNumber_GUI(void)
//{
//	return GetLenMsgQueue(&MainOutputQueue);
//}
////������� ��� GetNextMsgGUI(�����);
//int GetNextMsgGUI(void)
//{
//	return GetHeadMsgQueue(&MainInputQueue, &last_msg);
//}
//
////������� ���  GetMsgGUICode        (�����);  /*������ �� ������ ���� ������� */
//int GetMsgGUICode()
//{
//	return last_msg.code;
//}
//
////������� ���� GetFloatParamGUI     (�����);  /*������ �� ������ ��������� ������� */
//float GetFloatParamGUI()
//{
//	return last_msg.param.pr_float;
//}
//
///* ������� ���� GetShortParamGUI     (�����); */
//short GetShortParamGUI()
//{
//	return last_msg.param.pr_short[0];
//}
//
////������� ���  GetIntParamGUI       (�����);
//int GetIntParamGUI()
//{
//	return last_msg.param.pr_int;
//}
//
////������� ���� GetLongParamGUI      (�����);
//long GetLongParamGUI()
//{
//	return last_msg.param.pr_long;
//}
//
////������� ���  SendMsgGUICode       (���);
//int SendMsgGUICode(int code)
//{
//	return PutTailMsgQueue(&MainOutputQueue, code);
//}
//
////������� ���  SendMsgFloatParamGUI (���, ����);
//int SendMsgFloatParamGUI(int code, float param)
//{
//	return PutTailMsgQueueF(&MainOutputQueue, code, param);
//
//}
//
///* ������� ���  SendMsgShortParamGUI (���, ����); */
//int SendMsgShortParamGUI(int code, short param)
//{
//	return PutTailMsgQueueS(&MainOutputQueue, code, param);
//
//}
//
///* ������� ���  SendMsgIntParamGUI   (���, ���); */
//int SendMsgIntParamGUI(int code, int param)
//{
//	return PutTailMsgQueueI(&MainOutputQueue, code, param);
//
//}
//
////������� ���  SendMsgLongParamGUI  (���, ����);
//int SendMsgLongParamGUI(int code, long param)
//{
//	return PutTailMsgQueueL(&MainOutputQueue, code, param);
//}
//
////������� ���  GetInpMsgNumber_GUI (�����);  /* ������ ����� �����. �� �����. ������ */
//int GetInpMsgNumber_GUI()
//{
//	return GetLenMsgQueue(&MainInputQueue);
//}

