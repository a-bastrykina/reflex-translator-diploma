#include <sys/time.h>
#include <stdio.h>
#include "../lib/platform.h"

// Dummy realizations when no target platform is specified

void Init_Time() {}

void Init_IO() {}

INT32_U Get_Time() {
    struct timeval time;
    gettimeofday(&time, NULL);
    return time.tv_sec * 1000 + time.tv_usec / 1000;
}

INT8 Read_Input8(int addr1, int addr2) {
    return 1;
}

int Write_Output8(int addr1, int addr2, INT8 data) {
    printf("Value for %d %d: %d\n", addr1, addr2, data);
}

INT16 Read_Input16(int addr1, int addr2) {
    return 1;
}

int Write_Output16(int addr1, int addr2, INT16 data) {
    printf("Value for %d %d: %hd\n", addr1, addr2, data);
}
