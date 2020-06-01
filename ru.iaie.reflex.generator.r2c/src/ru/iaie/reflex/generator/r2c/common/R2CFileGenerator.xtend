package ru.iaie.reflex.generator.r2c.common

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
import ru.iaie.reflex.generator.r2c.util.LiteralGenerationUtil

class R2CFileGenerator implements IFileGenerator {
	protected String C_STANDART = "99";
	protected String GENERATED_DIR_NAME = "generated"
	 
	// AST root 
	protected Program program
	protected IFileSystemAccess2 fsa
	
	IReflexIdentifiersHelper identifiersHelper
	PortGenerationHelper portGenerationHelper
	ConstantGenerationHelper constGenerationHelper
	VariableGenerationHelper varGenerationHelper

	protected static String CLOCK_CONST_NAME = "_r_CLOCK" 
	protected static String CUR_TIME_NAME = "_r_cur_time" 
	protected static String NEXT_TIME_NAME = "_r_next_act_time" 
	
	def String getRootDirName() {
		return "c-code"
	}

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
			fsa.generateFile('''«rootDirName»/«resource»''', class.getResourceAsStream('''/resources/«resource»'''))
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
		fsa.generateFile('''«rootDirName»/CMakeLists.txt''', fileContent)
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
		
		void input(void) {
			«FOR inPort: program.ports.filter[type == PortType.INPUT]»
				«portGenerationHelper.translateInputPortReading(inPort)»
			«ENDFOR»
		    «FOR physVar : inputVars»
		    	«portGenerationHelper.translateReadingFromInput(physVar)»
		    «ENDFOR»
		}
		
		void output(void) {
			«FOR physVar : outputVars»
				«portGenerationHelper.translateWritingToOutput(physVar)»
		    «ENDFOR»
			«FOR outPort: program.ports.filter[type == PortType.OUTPUT]»
				«portGenerationHelper.translateOutputPortWriting(outPort)»
			«ENDFOR»
		}
		'''
		fsa.generateFile('''«rootDirName»/«GENERATED_DIR_NAME»/io.c''', fileContent)
	}
	
	override generatePlatformImplementations() {
		fsa.generateFile('''«rootDirName»/«GENERATED_DIR_NAME»/platform.c''', R2CResourceProvider.DUMMY_PLATFORM_IMPL)
	}

	override generateConstantDefinitions() {
		val fileContent = '''
			#ifndef _cnst_h
			#define _cnst_h 1

			«generateConstants()»

			«generateEnums()»
			
			«generateClockConst()»
			#endif
		'''
		fsa.generateFile('''«rootDirName»/«GENERATED_DIR_NAME»/cnst.h''', fileContent)
	}

	override generateVariableDefinitions() {
		val fileContent = '''
			#ifndef _gvar_h
			#define _gvar_h 1
			#include "../lib/r_cnst.h"
			«generateTimeVariableDefinitions(false)»
			«generateVariables(false)»
			«generatePorts(false)»
			#endif
		'''
		fsa.generateFile('''«rootDirName»/generated/gvar.h''', fileContent)
		val externFileContent = '''
			#ifndef _xvar_h
			#define _xvar_h 1
			#include "../lib/r_cnst.h"
			«generateTimeVariableDefinitions(true)»
			«generateVariables(true)»
			«generatePorts(true)»
			#endif
		'''
		fsa.generateFile('''«rootDirName»/«GENERATED_DIR_NAME»/xvar.h''', externFileContent)
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
		fsa.generateFile('''«rootDirName»/«GENERATED_DIR_NAME»/proc.h''', fileContent)
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
		fsa.generateFile('''«rootDirName»/«GENERATED_DIR_NAME»/proc.c''', fileContent)
	}
	
	override generateMain() {
		val fileContent = '''
		#include "ext.h" /* Common files for all generated c-files */
		#include "proc.h"  /* Process-functions desription */
		#include "gvar.h"  /* Project variables images */
		#include "io.h"    /* Scan-input/output functions */
		#include "../lib/platform.h"

		void control_loop(void)    /* Control algorithm */
		{
			init_processes();
			init_time();
			init_io();
			for (;;) {
				«CUR_TIME_NAME» = get_time();
				if («CUR_TIME_NAME» - «NEXT_TIME_NAME» >= 0) {
					// Find next activation time
					«NEXT_TIME_NAME» += «CLOCK_CONST_NAME»;
					if («NEXT_TIME_NAME» - «CUR_TIME_NAME» > _r_CLOCK) {
						«NEXT_TIME_NAME» = «CUR_TIME_NAME» + _r_CLOCK;
					}
					input();
					«FOR proc : program.processes»
					«identifiersHelper.getProcessFuncId(proc)»(); /* Process «proc.name» */
					«ENDFOR»
					output();
				}
			}
		}

		int main() {
			control_loop();
		}
		'''

		fsa.generateFile('''«rootDirName»/«GENERATED_DIR_NAME»/main.c''', fileContent)
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
		return '''#define «CLOCK_CONST_NAME» «LiteralGenerationUtil.translateClockDefinition(program.clock)»'''
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
		return '''
		«IF extern»extern «ENDIF»INT32_U «CUR_TIME_NAME»;
		«IF extern»extern «ENDIF»INT32_U «NEXT_TIME_NAME»;
		'''
	}
	
}
