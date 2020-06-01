package ru.iaie.reflex.generator.r2c.arduino

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import ru.iaie.reflex.generator.r2c.common.R2CFileGenerator
import static extension ru.iaie.reflex.utils.ReflexModelUtil.*

class ArduinoFileGenerator extends R2CFileGenerator {
    
    static final String ANNOTATION_NAMESPACE = "ArduinoPLC"
    static final String TIMER_INIT_ANNOTATION = "timer_init"
    static final String TIMER_ANNOTATION = "timer_function"
    static final String IO_INIT_ANNOTATION = "io_init"
    static final String GLOBAL_ANNOTATION = "insert_global"
    static final String BYTE_READ_ANNOTATION = "read_byte"
    static final String WORD_READ_ANNOTATION = "read_word"
    static final String BYTE_WRITE_ANNOTATION = "write_byte"
    static final String WORD_WRITE_ANNOTATION = "write_word"
    
    static final String DEFAULT_TIMER_INIT = '''
    	//Init timer0
    	TCCR0B = (1 << CS00) | (1 << CS02); // /1024 prescaler
    	TIMSK0 = (1 << TOIE0); // overflow interrupt
    	sei();
    '''
    
    static final String DEFAULT_IO_INIT = '''
    	DDRB = 0;
    	DDRC = 0xFF;
    	DDRD = 0;
    '''
	
	static final String DEFAULT_GET_TIME_IMPL = '''
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
	'''
	
	static final String DEFAULT_GLOBAL_CONTENT = '''
		static volatile unsigned long ovf_cnt = 0;
		
		//Timer0 overflow interrupt handler
		ISR(TIMER0_OVF_vect) {
			ovf_cnt++;
		}
	'''
	
	static final String DEFAULT_BYTE_READ_CONTENT = '''
		// Ignore addr1
		switch (addr2) {
		case 0x00: 
			return PINB;
		case 0x01:
			return PINC;
		case 0x02:
			return PIND;
		}
		return -1;
	'''
	
	static final String DEFAULT_BYTE_WRITE_CONTENT = '''
		// Ignore addr1
		switch (addr2) {
		case 0x00: 
			PORTB = data;
			break;
		case 0x01:
			PORTC = data;
			break;
		case 0x02:
			PORTD = data;
			break;
		}
		return 0;
	'''
	static final String DEFAULT_WORD_READ_CONTENT = '''
		return -1;
	'''
	
	static final String DEFAULT_WORD_WRITE_CONTENT = '''
		return -1;
	'''
	    
    override String getRootDirName() {
		return "arduino"
	}
	
	new(Resource resource, IFileSystemAccess2 fsa) {
		super(resource, fsa)
	}
	
	override generateBuildFiles() {}
	
	override generatePlatformImplementations() {
		val annotations = program.collectNamespaceAnnotations(ANNOTATION_NAMESPACE)
		
		val timerInitContent = annotations.containsKey(TIMER_INIT_ANNOTATION) ? annotations.get(TIMER_INIT_ANNOTATION) : DEFAULT_TIMER_INIT
		val ioInitContent = annotations.containsKey(IO_INIT_ANNOTATION) ? annotations.get(IO_INIT_ANNOTATION) : DEFAULT_IO_INIT
		val timerContent = annotations.containsKey(TIMER_ANNOTATION) ? annotations.get(TIMER_ANNOTATION) : DEFAULT_GET_TIME_IMPL
		val globalContent = annotations.containsKey(GLOBAL_ANNOTATION) ? annotations.get(GLOBAL_ANNOTATION) : DEFAULT_GLOBAL_CONTENT
		val byteReadContent = annotations.containsKey(BYTE_READ_ANNOTATION) ? annotations.get(BYTE_READ_ANNOTATION) : DEFAULT_BYTE_READ_CONTENT
		val wordReadContent = annotations.containsKey(WORD_READ_ANNOTATION) ? annotations.get(WORD_READ_ANNOTATION) : DEFAULT_WORD_READ_CONTENT
		val byteWriteContent = annotations.containsKey(BYTE_WRITE_ANNOTATION) ? annotations.get(BYTE_WRITE_ANNOTATION) : DEFAULT_BYTE_WRITE_CONTENT
		val wordWriteContent = annotations.containsKey(WORD_WRITE_ANNOTATION) ? annotations.get(WORD_WRITE_ANNOTATION) : DEFAULT_WORD_WRITE_CONTENT
		
		val fileContent = '''
		#include <avr/io.h>
		#include <avr/interrupt.h>
		#include "../lib/platform.h"
		#include "../generated/xvar.h"
		
		// Atmega 368p
		#ifndef F_CPU
		#define F_CPU 16000000UL
		#endif
		
		«globalContent»
				
		void init_time() {
			«timerInitContent»
			«CUR_TIME_NAME» = 0;
			«NEXT_TIME_NAME» = 0;
		}
		
		void init_io() {
			«ioInitContent»
		}
		
		INT32_U get_time() {
			«timerContent»
		}
		
		INT8 read_byte(int addr1, int addr2) {
			«byteReadContent»
		}
		
		int write_byte(int addr1, int addr2, INT8 data) {
			«byteWriteContent»
		}
		
		INT16 read_word(int addr1, int addr2) {
			«wordReadContent»
		}
		
		int write_word(int addr1, int addr2, INT16 data) {
			«wordWriteContent»
		}
		'''
		fsa.generateFile('''«rootDirName»/generated/platform.c''', fileContent)
	}
	
}