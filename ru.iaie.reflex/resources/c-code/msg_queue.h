#ifndef MSG_INFO_H
#define MSG_INFO_H

#define ARRLENRSMSG 100 // change this value to resize message queue
	
typedef unsigned char BYTE;
typedef unsigned int  WORD;
typedef unsigned long DWORD;

enum MsgCodes
{
	EMPTY_MSG,
	BYTE_TYPE,
	INT_TYPE,
	FLOAT_TYPE
};

typedef struct QueueMsg
{
    int code;
    union {
        long pr_long;
        float pr_float;
        short pr_short[2];
        int pr_int;
        BYTE pr_char[4];
    }param;

	enum MsgCodes type;
} QueueMsg;

typedef struct MsgQueue
{
    int length;
    int head_item;
    int tail_item;
    QueueMsg Arr[ARRLENRSMSG];
}MsgQueue;

void ConstructMsgQueue(MsgQueue*);
int GetLenMsgQueue(MsgQueue*);
int PutTailMsgQueue(MsgQueue*,int code);
int PutTailMsgQueueB(MsgQueue*, int code, BYTE);
int PutTailMsgQueueI(MsgQueue*, int code, int);
int PutTailMsgQueueS(MsgQueue*, int code, short);
int PutTailMsgQueueF(MsgQueue*, int code, float);
int PutTailMsgQueueL(MsgQueue*, int code, long);
int PutTailMsgQueueStr(MsgQueue*, BYTE*, int);

int GetHeadMsgQueue(MsgQueue*, QueueMsg*);
int isEmptyMsgQueue(MsgQueue*);
void FlushMsgQueue(MsgQueue*);

#endif // MSG_INFO_H
