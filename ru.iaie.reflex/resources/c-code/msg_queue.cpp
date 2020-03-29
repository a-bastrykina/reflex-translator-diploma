#include "msg_queue.h"

void ConstructMsgQueue(MsgQueue * queue)
{
	queue->head_item = queue->tail_item = 0;
	queue->length = 0;
	return;
}

int GetLenMsgQueue(MsgQueue * queue)
{
	return queue->length;
}

int PutTailMsgQueue(MsgQueue * queue, int code)
{
	if (queue->length == ARRLENRSMSG)
	{
		return 0;
	}

	queue->Arr[queue->tail_item].code = code;
	queue->Arr[queue->tail_item].param.pr_int = 0;

	queue->Arr[queue->tail_item].type = EMPTY_MSG;

	queue->tail_item++;

	if (queue->tail_item >= ARRLENRSMSG)
	{
		queue->tail_item = 0;
	}
	queue->length++;

	return (ARRLENRSMSG - (queue->length) + 1);
}


int PutTailMsgQueueB(MsgQueue* queue, int code, BYTE param)
{
	if (queue->length == ARRLENRSMSG)
	{
		return 0;
	}

	queue->Arr[queue->tail_item].code = code;
	queue->Arr[queue->tail_item].param.pr_char[0] = param;
	queue->Arr[queue->tail_item].param.pr_char[1] = 0;
	queue->Arr[queue->tail_item].param.pr_char[2] = 0;
	queue->Arr[queue->tail_item].param.pr_char[3] = 0;
	queue->Arr[queue->tail_item].type = BYTE_TYPE;
	queue->tail_item++;

	if (queue->tail_item >= ARRLENRSMSG)
	{
		queue->tail_item = 0;
	}
	queue->length++;

	return (ARRLENRSMSG - (queue->length) + 1);
}

int PutTailMsgQueueI(MsgQueue* queue, int code, int param)
{
	if (queue->length == ARRLENRSMSG)
	{
		return 0;
	}

	queue->Arr[queue->tail_item].code = code;
	queue->Arr[queue->tail_item].param.pr_int = param;
	//    queue->Arr[queue->tail_item].param.pr_int[1] = 0;
	queue->Arr[queue->tail_item].type = INT_TYPE;

	queue->tail_item++;

	if (queue->tail_item >= ARRLENRSMSG)
	{
		queue->tail_item = 0;
	}
	queue->length++;

	return (ARRLENRSMSG - (queue->length) + 1);
}

int PutTailMsgQueueS(MsgQueue* queue, int code, short param)
{
	if (queue->length == ARRLENRSMSG)
	{
		return 0;
	}

	queue->Arr[queue->tail_item].code = code;
	queue->Arr[queue->tail_item].param.pr_short[0] = param;
	queue->Arr[queue->tail_item].param.pr_short[1] = 0;
	queue->Arr[queue->tail_item].type = INT_TYPE;
	queue->tail_item++;

	if (queue->tail_item >= ARRLENRSMSG)
	{
		queue->tail_item = 0;
	}
	queue->length++;

	return (ARRLENRSMSG - (queue->length) + 1);

}

int PutTailMsgQueueF(MsgQueue * queue, int code, float param)
{
	if (queue->length == ARRLENRSMSG)
	{
		return 0;
	}

	queue->Arr[queue->tail_item].code = code;
	queue->Arr[queue->tail_item].param.pr_float = param;
	queue->Arr[queue->tail_item].type = FLOAT_TYPE;

	queue->tail_item++;

	if (queue->tail_item >= ARRLENRSMSG)
	{
		queue->tail_item = 0;
	}
	queue->length++;

	return (ARRLENRSMSG - (queue->length) + 1);
}

int PutTailMsgQueueL(MsgQueue * queue, int code, long param)
{
	if (queue->length == ARRLENRSMSG)
	{
		return 0;
	}

	queue->Arr[queue->tail_item].code = code;
	queue->Arr[queue->tail_item].param.pr_long = param;
	queue->Arr[queue->tail_item].type = INT_TYPE;
	queue->tail_item++;

	if (queue->tail_item >= ARRLENRSMSG)
	{
		queue->tail_item = 0;
	}
	queue->length++;

	return (ARRLENRSMSG - (queue->length) + 1);
}

/*
* 26.07.2013
* NOT TESTED
*/
int PutTailMsgQueueStr(MsgQueue * queue, BYTE * str, int length)
{
	int i;
	if (queue->length == ARRLENRSMSG)
	{
		return 0;
	}

	for (i = 0; i < length; i++)
	{
		queue->Arr[queue->tail_item].param.pr_char[i] = str[i];
	}

	queue->tail_item++;

	if (queue->tail_item >= ARRLENRSMSG)
	{
		queue->tail_item = 0;
	}
	queue->length++;

	return (ARRLENRSMSG - (queue->length) + 1);
}

int GetHeadMsgQueue(MsgQueue * queue, QueueMsg * msg)
{
	if (queue->length == 0)
	{
		return 0;
	}

	msg->code = queue->Arr[queue->head_item].code;
	msg->param.pr_int = queue->Arr[queue->head_item].param.pr_int;
	msg->type = queue->Arr[queue->head_item].type;

	queue->head_item++;
	if (queue->head_item >= ARRLENRSMSG)
	{
		queue->head_item = 0;
	}
	queue->length--;

	return (queue->length + 1);
}

int isEmptyMsgQueue(MsgQueue* queue)
{
	if (queue->length == 0)
	{
		return 1;
	}
	else
	{
		return 0;
	}
}

void FlushMsgQueue(MsgQueue * queue)
{
	queue->head_item = queue->tail_item = 0;
	queue->length = 0;
}

