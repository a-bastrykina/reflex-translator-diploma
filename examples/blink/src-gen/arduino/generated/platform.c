#include <avr/io.h>
#include <avr/interrupt.h>
#include "../lib/platform.h"
#include "../generated/xvar.h"

// Atmega 368p
#ifndef F_CPU
#define F_CPU 16000000UL
#endif

static volatile unsigned long ovf_cnt = 0;

void Init_Time() {
	//Init timer0
	TCCR0B = (1 << CS00) | (1 << CS02); // /1024 prescaler
	TIMSK0 = (1 << TOIE0); // overflow interrupt
	sei();
	
	_r_cur_time = 0;
	_r_next_act_time = 0;
}

void Init_IO() {
	DDRB = 0;
	DDRC = 0xFF;
	DDRD = 0;
}

INT32_U Get_Time() {
	unsigned char sreg = SREG;
	cli(); //start critical section
	unsigned long ovf = ovf_cnt;
	unsigned long tcnt = TCNT0;
	SREG = sreg; //end of critical section - no sei() needed

	//Timer has already overflown, but interrupt has yet to execute
	if ((TIFR0 & _BV(TOV0)) && (tcnt < 255)) {
		ovf++;
	}

	unsigned long fract;
	const unsigned long mfcpu = F_CPU/1000; // 1000 -> milliseconds

	fract = ovf % mfcpu;
	fract <<= (8UL + 10UL); //8 -> 256 timer, 10 -> 1024 prescaler
	fract /= mfcpu;

	ovf /= mfcpu;
	ovf <<= (8UL + 10UL);
	ovf += fract;

	return ovf + (tcnt << 10UL) / mfcpu;
}

//Timer0 overflow interrupt handler
ISR(TIMER0_OVF_vect) {
	ovf_cnt++;
}

INT8 Read_Input8(int addr1, int addr2) {
	// Ignore addr1
	switch (addr2) {
		case 0: 
			return PINB;
		case 1:
			return PINC;
		case 2:
			return PIND;
	}
	return 0;
}

int Write_Output8(int addr1, int addr2, INT8 data) {
	// Ignore addr1
	switch (addr2) {
		case 0: 
			PORTB = data;
			break;
		case 1:
			PORTC = data;
			break;
		case 2:
			PORTD = data;
			break;
	}
	
	return 1;
}

INT16 Read_Input16(int addr1, int addr2) {
	return 0;
}

int Write_Output16(int addr1, int addr2, INT16 data) {
	return 0;
}
