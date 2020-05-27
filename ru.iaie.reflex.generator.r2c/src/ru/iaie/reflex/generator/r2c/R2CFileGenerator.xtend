package ru.iaie.reflex.generator.r2c

import static extension ru.iaie.reflex.utils.ReflexModelUtil.*
import static extension org.eclipse.xtext.EcoreUtil2.*

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import ru.iaie.reflex.reflex.Program
import ru.iaie.reflex.reflex.PhysicalVariable
import ru.iaie.reflex.reflex.PortType
import ru.iaie.reflex.generator.r2c.interfaces.IFileGenerator
import ru.iaie.reflex.generator.r2c.interfaces.IReflexIdentifiersHelper
import ru.iaie.reflex.generator.r2c.helpers.PortGenerationHelper
import ru.iaie.reflex.generator.r2c.helpers.ConstantGenerationHelper
import ru.iaie.reflex.generator.r2c.helpers.VariableGenerationHelper
import ru.iaie.reflex.generator.r2c.helpers.ReflexIdentifiersHelper

class R2CFileGenerator implements IFileGenerator {
	
	static val String C_STANDART = "99";
	static val String ROOT_DIR_NAME = "c-code"
	static val String GENERATED_DIR_NAME = "generated"
	 
	// AST root 
	Program program
	IFileSystemAccess2 fsa
	IReflexIdentifiersHelper identifiersHelper
	
	PortGenerationHelper portGenerationHelper
	ConstantGenerationHelper constGenerationHelper
	VariableGenerationHelper varGenerationHelper
	
	new(Resource resource, IFileSystemAccess2 fsa) {
		program = resource.getProgram()
		this.fsa = fsa
		identifiersHelper = new ReflexIdentifiersHelper
		portGenerationHelper = new PortGenerationHelper(identifiersHelper)
		constGenerationHelper = new ConstantGenerationHelper(identifiersHelper)
		varGenerationHelper = new VariableGenerationHelper(identifiersHelper)
	}
	
	override prepareForGeneration() {
		for (resource : R2CResourceProvider.COMMON_RESOURCES) {
			fsa.generateFile('''«ROOT_DIR_NAME»/«resource»''', class.getResourceAsStream('''/resources/«ROOT_DIR_NAME»/«resource»'''))
		}
	}

	override generateBuildFiles() {
		var fileContent = '''
			cmake_minimum_required(VERSION 3.15)
			project(«program.name.toLowerCase»)
			
			set(CMAKE_C_STANDARD «C_STANDART»)
			set(CMAKE_C_FLAGS "-Wall")
			
			add_executable(«program.name.toLowerCase» generated/main.c generated/proc.c lib/r_lib.c usr/usr.c generated/io.c generated/platform.c)
		'''
		fsa.generateFile('''«ROOT_DIR_NAME»/CMakeLists.txt''', fileContent)
	}

	override generateIOFiles() {
		val inputVars = newArrayList()
		val outputVars = newArrayList()
		program.eAllOfType(PhysicalVariable).forEach [ v |
			v.mappedPortType == PortType.INPUT
				? inputVars.add(v)
				: outputVars.add(v)
		]
		val fileContent = '''
		#include "io.h"
		#include "xvar.h"
		#include "../lib/r_cnst.h"
		#include "../lib/platform.h"
		
		void Input(void) {
			«FOR inPort: program.ports.filter[type == PortType.INPUT]»
				«portGenerationHelper.translateInputPortReading(inPort)»
			«ENDFOR»
		    «FOR physVar : inputVars»
		    	«portGenerationHelper.translateReadingFromInput(physVar)»
		    «ENDFOR»
		}
		
		void Output(void) {
			«FOR physVar : outputVars»
			    «portGenerationHelper.translateReadingFromOutput(physVar)»
		    «ENDFOR»
		    «FOR outPort: program.ports.filter[type == PortType.OUTPUT]»
		 		«portGenerationHelper.translateOutputPortWriting(outPort)»
		    «ENDFOR»
		}
		'''
		fsa.generateFile('''«ROOT_DIR_NAME»/«GENERATED_DIR_NAME»/io.c''', fileContent)
	}
	
	override generatePlatformImplementations() {
		fsa.generateFile('''«ROOT_DIR_NAME»/«GENERATED_DIR_NAME»/platform.c''', R2CResourceProvider.DUMMY_PLATFORM_IMPL)
	}

	override generateConstantDefinitions() {
		val fileContent = '''
			#ifndef _cnst_h
			#define _cnst_h 1
			/*           Constant definitions          */
			«generateConstants()»
			/*                Enums                    */
			«generateEnums()»
			
			«generateClockConst()»
			#endif
		'''
		fsa.generateFile('''«ROOT_DIR_NAME»/«GENERATED_DIR_NAME»/cnst.h''', fileContent)
	}

	override generateVariableDefinitions() {
		val fileContent = '''
			/* GVAR.H = Global Variables Image-File. */
			#ifndef _gvar_h
			#define _gvar_h 1
			#include "../lib/r_cnst.h"
			«generateTimeVariableDefinitions(false)»
			«generateVariables(false)»
			«generatePorts(false)»
			#endif
		'''
		fsa.generateFile('''c-code/generated/gvar.h''', fileContent)
		val externFileContent = '''
			/* xvar.h = Extern Variables Image-File. */
			#ifndef _xvar_h
			#define _xvar_h 1
			#include "../lib/r_cnst.h"
			«generateTimeVariableDefinitions(true)»
			«generateVariables(true)»
			«generatePorts(true)»
			#endif
		'''
		fsa.generateFile('''«ROOT_DIR_NAME»/«GENERATED_DIR_NAME»/xvar.h''', externFileContent)
	}
	

	override generateProcessDefinitions() {
		val fileContent = '''
			#ifndef _proc_h
			#define _proc_h 1
			«FOR process : program.processes»
			void «identifiersHelper.getProcessFuncId(process)»();
			«ENDFOR»
			#define PROCESS_Nn «program.processes.size - 1»
			#define PROCESS_N1 0
			#endif
		'''
		fsa.generateFile('''«ROOT_DIR_NAME»/«GENERATED_DIR_NAME»/proc.h''', fileContent)
	}

	override generateProcessImplementations() {
		val processGenerators = program.processes.map[p | new ProcessGenerator(p, identifiersHelper)]
		val fileContent = '''
			/* FILE OF PROC-IMAGES OF THE PROJECT */
			#include "ext.h" /* Common files for all generated c-files */
			#include "xvar.h"  /* Var-images */
			«FOR gen : processGenerators»
			«gen.generate()»
			«ENDFOR»
		'''
		fsa.generateFile('''«ROOT_DIR_NAME»/«GENERATED_DIR_NAME»/proc.c''', fileContent)
	}
	
	override generateMain() {
		val fileContent = '''
		#include "ext.h" /* Common files for all generated c-files */
		#include "proc.h"  /* Process-functions desription */
		#include "gvar.h"  /* Project variables images */
		#include "io.h"    /* Scan-input/output functions */
		#include "../lib/platform.h"
		#include <stdio.h>
		#include <unistd.h>

		void Init_Time() {
			_r_cur_time = 0;
			_r_next_act_time = 0;
		}

		void Control_Loop(void)    /* Control algorithm */
		{
			Init_Processes();
			Init_Time();
			for (;;) {
				_r_cur_time = Get_Time();
				if (_r_next_act_time <= _r_cur_time) {
					printf("Activating\n");
					Input();
					«FOR proc : program.processes»
					«identifiersHelper.getProcessFuncId(proc)»(); /* Process «proc.name» */
					«ENDFOR»
					Output();

					// Find next activation time
					if (_r_next_act_time + _r_CLOCK <= _r_cur_time) {
						_r_next_act_time = _r_cur_time + _r_CLOCK;
					} else {
						_r_next_act_time += _r_CLOCK;
					}
				}
			}
		}

		int main() {
			Control_Loop();
		}
		'''

		fsa.generateFile('''«ROOT_DIR_NAME»/«GENERATED_DIR_NAME»/main.c''', fileContent)
	}
	
	def generateVariables(boolean externDef) {
		return '''
			«FOR variable : program.globalVars»
			«IF externDef»extern «ENDIF»«varGenerationHelper.generateGlobalVariableDefinition(variable)»;
			«ENDFOR»
			«FOR proc : program.processes»
			«FOR variable: proc.variables»
			«IF externDef»extern «ENDIF»«varGenerationHelper.generateProcessVariableDefinition(variable)»;
			«ENDFOR»
			«ENDFOR»
		'''
	}

	def generatePorts(boolean externDef) {
		return '''
			«FOR reg : program.ports»
			«IF externDef»extern «ENDIF»«portGenerationHelper.generatePortVariableDefinition(reg)»;
			«ENDFOR»
		'''
	}
	
	def generateClockConst() {
		return '''#define _r_CLOCK «LiteralGenerationUtil.translateClockDefinition(program.clock)»'''
	}

	def generateConstants() {
		return '''
			«FOR constant : program.consts»
			«constGenerationHelper.generateConstantDefinition(constant)»
			«ENDFOR»
		'''
	}

	def generateEnums() {
		return '''
			«FOR en : program.enums»
			«constGenerationHelper.generateEnumDefifnition(en)»
			«ENDFOR»
		'''
	}
	
	def generateTimeVariableDefinitions(boolean extern) {
		return '''«IF extern»extern «ENDIF»INT32_U _r_cur_time;
				  «IF extern»extern «ENDIF»INT32_U _r_next_act_time;
				'''
	}
	
}
