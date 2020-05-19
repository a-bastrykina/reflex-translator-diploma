package ru.iaie.reflex.generator.r2c

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import ru.iaie.reflex.reflex.AdditiveExpression
import ru.iaie.reflex.reflex.AssignmentExpression
import ru.iaie.reflex.reflex.BitAndExpression
import ru.iaie.reflex.reflex.BitOrExpression
import ru.iaie.reflex.reflex.BitXorExpression
import ru.iaie.reflex.reflex.CastExpression
import ru.iaie.reflex.reflex.CompareExpression
import ru.iaie.reflex.reflex.EqualityExpression
import ru.iaie.reflex.reflex.Expression
import ru.iaie.reflex.reflex.FunctionCall
import ru.iaie.reflex.reflex.IfElseStat
import ru.iaie.reflex.reflex.InfixOp
import ru.iaie.reflex.reflex.LogicalAndExpression
import ru.iaie.reflex.reflex.LogicalOrExpression
import ru.iaie.reflex.reflex.MultiplicativeExpression
import ru.iaie.reflex.reflex.PostfixOp
import ru.iaie.reflex.reflex.PrimaryExpression
import ru.iaie.reflex.reflex.Process
import ru.iaie.reflex.reflex.Program
import ru.iaie.reflex.reflex.ResetStat
import ru.iaie.reflex.reflex.RestartStat
import ru.iaie.reflex.reflex.SetStateStat
import ru.iaie.reflex.reflex.ShiftExpression
import ru.iaie.reflex.reflex.StartProcStat
import ru.iaie.reflex.reflex.State
import ru.iaie.reflex.reflex.StopProcStat
import ru.iaie.reflex.reflex.SwitchStat
import ru.iaie.reflex.reflex.TimeoutFunction
import ru.iaie.reflex.reflex.Type
import ru.iaie.reflex.reflex.UnaryExpression

import static extension ru.iaie.reflex.utils.ExpressionUtil.*
import static extension ru.iaie.reflex.utils.LiteralUtils.*
import static extension ru.iaie.reflex.utils.ReflexModelUtil.*
import static extension org.eclipse.xtext.EcoreUtil2.*

import ru.iaie.reflex.reflex.ProcessVariable
import ru.iaie.reflex.reflex.GlobalVariable
import ru.iaie.reflex.reflex.IdReference
import ru.iaie.reflex.reflex.CheckStateExpression
import ru.iaie.reflex.reflex.CompoundStatement
import ru.iaie.reflex.reflex.PhysicalVariable
import ru.iaie.reflex.reflex.PortType
import ru.iaie.reflex.reflex.PortMapping
import ru.iaie.reflex.reflex.Port
import ru.iaie.reflex.utils.LiteralUtils
import ru.iaie.reflex.reflex.ClockDefinition

class R2CReflexGenerator extends AbstractGenerator {

	IReflexCachedIdentifiersHelper identifiersHelper = new ReflexIdentifiersHelper;
    
    // AST root element
	Program program;

	override void beforeGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		program = resource.getProgram()
	}

	override void afterGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		identifiersHelper.clearCaches()
	}

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		resource.contents
		copyResources(program.name.toLowerCase, fsa)
		generateVariables(resource, fsa, context)
		generateConstantsFile(resource, fsa, context)
		generateProcessDefinitions(resource, fsa, context)
		generateProcessImplementations(resource, fsa, context)
		generateIO(resource, fsa, context)
		generatePlatformFile(resource, fsa, context)
		generateMain(resource, fsa, context)
		generateCMake(resource, fsa, context)
	}

	def copyResources(String fileNamePrefix, IFileSystemAccess2 fsa) {
		for (resource : R2CResourceProvider.COMMON_RESOURCES) {
			fsa.generateFile('''c-code/«resource»''', class.getResourceAsStream('''/resources/c-code/«resource»'''))
		}
	}
	
	def generateCMake(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var fileContent = '''
			cmake_minimum_required(VERSION 3.15)
			project(«program.name.toLowerCase»)
			
			set(CMAKE_C_STANDARD 99)
			set(CMAKE_C_FLAGS "-Wall")
			
			add_executable(«program.name.toLowerCase» generated/main.c generated/proc.c lib/r_io.c lib/r_lib.c usr/usr.c generated/io.c generated/platform.c)
		'''
		fsa.generateFile('''c-code/CMakeLists.txt''', fileContent)
	}

	def generateIO(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
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
				«translateInputPortReading(inPort)»
			«ENDFOR»
		    «FOR physVar : inputVars»
		    	«translateReadingFromInput(physVar)»
		    «ENDFOR»
		}
		
		void Output(void) {
			«FOR physVar : outputVars»
			    «translateReadingFromOutput(physVar)»
		    «ENDFOR»
		    «FOR outPort: program.ports.filter[type == PortType.OUTPUT]»
		 		«translateOutputPortWriting(outPort)»
		    «ENDFOR»
		}
		'''
		fsa.generateFile('''c-code/generated/io.c''', fileContent)
	}
	
	def generatePlatformFile(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val fileContent = '''
		#include <sys/time.h>
		#include <stdio.h>
		#include "../lib/platform.h"
		
		// Dummy realizations when no target platform is specified
		
		INT32_U Get_Time() {
		    struct timeval time;
		    gettimeofday(&time, NULL);
		    return time.tv_sec * 1000 + time.tv_usec / 1000;
		}
		
		INT8 Read_Input8(int addr1, int addr2) {
		    INT8 result;
		    printf("Enter value for %d %d: ", addr1, addr2);
		    scanf("%c", &result);
		    printf("\n");
		    return result;
		}
		
		int Write_Output8(int addr1, int addr2, INT8 data) {
		    printf("Value for %d %d: %c\n", addr1, addr2, data);
		}
		
		INT16 Read_Input16(int addr1, int addr2) {
		    INT16 result;
		    printf("Enter value for %d %d: ", addr1, addr2);
		    scanf("%hd", &result);
		    printf("\n");
		    return result;
		}
		
		int Write_Output16(int addr1, int addr2, INT16 data) {
		    printf("Value for %d %d: %hd\n", addr1, addr2, data);
		}
		'''

		fsa.generateFile('''c-code/generated/platform.c''', fileContent)
	}
	
	def translateInputPortReading(Port port) {
		val portId = identifiersHelper.getPortId(port)
		val portSize = LiteralUtils.parseInteger(port.size)
		return '''«portId» = Read_Input«portSize»(«port.addr1», «port.addr2»);'''
	}
	
	def translateOutputPortWriting(Port port) {
		val portId = identifiersHelper.getPortId(port)
		val portSize = LiteralUtils.parseInteger(port.size)
		return '''Write_Output«portSize»(«port.addr1», «port.addr2», «portId»);'''
	}
	
	def translateReadingFromInput(PhysicalVariable v) {
		val mapping = v.mapping
		val varName = identifiersHelper.getMapping(v) 
		if (mapping.fullMapping) {
			return '''«varName» = «identifiersHelper.getPortId(mapping.port)»;'''
		} else {
			return 
			'''
			if («identifiersHelper.getPortId(mapping.port)» & «generatePortMappingMask(mapping)») {
				«varName» = TRUE;
			}
			else {
				«varName» = FALSE;
			} 
			'''
		}
	}
	
	def translateReadingFromOutput(PhysicalVariable v) {
		val mapping = v.mapping
		val portVariableName = identifiersHelper.getPortId(mapping.port)
		val varName = identifiersHelper.getMapping(v)
		val mask =  generatePortMappingMask(mapping)
		if (mapping.fullMapping) {
			return '''«portVariableName» = «varName»;'''
		} else {
			return 
			'''
			if («varName») {
				«portVariableName» |= «mask»; 
			} else {
				«portVariableName» &= ~«mask»; 
			}
			'''
		}	
	}
	
	def generatePortMappingMask(PortMapping mapping) {
		return '''MASK«mapping.bit»_S«mapping.port.size»'''
	}

	def generateConstantsFile(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val fileContent = '''
			#ifndef _cnst_h
			#define _cnst_h 1
			/*           Constant definitions          */
			«generateConstants(resource)»
			/*                Enums                    */
			«generateEnums(resource)»
			
			«generateClockConst(resource)»
			#endif
		'''
		fsa.generateFile('''c-code/generated/cnst.h''', fileContent)
	}
	
	def generateClockConst(Resource resource) {
		return '''#define _r_CLOCK «translateClockDefinition(program.clock)»'''
	}
	
	def translateClockDefinition(ClockDefinition clock) {
		if (clock.hasTimeFormat) {
			return translateTime(clock.timeValue)
		} 
		return clock.intValue
	}

	def generateConstants(Resource resource) {
		// TODO: check for const expr
		return '''
			«FOR constant : program.consts»
			#define «identifiersHelper.getConstantId(constant)» «translateExpr(constant.value)» 
			«ENDFOR»
		'''
	}

	def generateEnums(Resource resource) {
		return '''
			«FOR en : program.enums»
				enum «identifiersHelper.getEnumId(en)» {
					 «FOR enumMember: en.enumMembers»
					 «identifiersHelper.getEnumMemberId(enumMember)»«IF enumMember.hasValue»=«translateExpr(enumMember.value)»«ENDIF», 
					 «ENDFOR»
				}
			«ENDFOR»
		'''
	}

	def generateVariables(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val fileContent = '''
			/* GVAR.H = Global Variables Image-File. */
			#ifndef _gvar_h
			#define _gvar_h 1
			#include "../lib/r_cnst.h"
			«generateVariables(resource, false)»
			«generatePorts(resource, false)»
			#endif
		'''
		fsa.generateFile('''c-code/generated/gvar.h''', fileContent)
		val externFileContent = '''
			/* xvar.h = Extern Variables Image-File. */
			#ifndef _xvar_h
			#define _xvar_h 1
			#include "../lib/r_cnst.h"
			«generateVariables(resource, true)»
			«generatePorts(resource, true)»
			#endif
		'''
		fsa.generateFile('''c-code/generated/xvar.h''', externFileContent)
	}
	
	def generateVariables(Resource resource, boolean externDef) {
		return '''
			«FOR variable : program.globalVars»
			«IF externDef»extern «ENDIF»«generateGlobalVariableDefinition(variable)»
			«ENDFOR»
			«FOR proc : program.processes»
			«FOR variable: proc.variables»
			«IF externDef»extern «ENDIF»«generateProcessVariableDefinition(proc, variable)»
			«ENDFOR»
			«ENDFOR»
		'''
	}

	def generateProcessVariableDefinition(Process proc, ProcessVariable variable) {
		if (!variable.isImportedList) {
			return '''
				«translateType(variable.type)» «identifiersHelper.getProcessVariableId(proc, variable)»;
			'''
		}
	}

	def generateGlobalVariableDefinition(GlobalVariable variable) {
		return '''
			«translateType(variable.type)» «identifiersHelper.getGlobalVariableId(variable)»;
		'''
	}

	def generatePorts(Resource resource, boolean externDef) {
		return '''
			«FOR reg : program.ports»
			«IF externDef»extern «ENDIF»«translateType(reg.suitableTypeForPort)» «identifiersHelper.getPortId(reg)»;
			«ENDFOR»
		'''
	}

	def generateProcessDefinitions(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
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
		fsa.generateFile('''c-code/generated/proc.h''', fileContent)
	}

	def generateProcessImplementations(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val fileContent = '''
			/* FILE OF PROC-IMAGES OF THE PROJECT */
			#include "ext.h" /* Common files for all generated c-files */
			#include "xvar.h"  /* Var-images */
			«FOR proc : program.processes»
			«translateProcess(proc)»
			«ENDFOR»
		'''
		fsa.generateFile('''c-code/generated/proc.c''', fileContent)
	}

	def generateMain(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val fileContent = '''
			/* MAIN FILE OF THE PROJECT */
			#include "ext.h" /* Common files for all generated c-files */
			#include "proc.h"  /* Process-functions desription */
			#include "gvar.h"  /* Project variables images */
			#include "io.h"    /* Scan-input/output functions */
			#include "../lib/platform.h"
			#include "../lib/r_main.h"  /* Code of the main-function that calls Control_Loop */
			
			void Control_Loop (void)    /* Control algorithm */
			{
				Init_PSW((INT16)(PROCESS_N1), (INT16)PROCESS_Nn);
				INT32_U cur_time = 0, prev_time = 0;
				for (;;) {
					cur_time = Get_Time();
					if (cur_time - prev_time < _r_CLOCK) continue;
					prev_time = cur_time;
					Input();
					«FOR proc : program.processes»
					«identifiersHelper.getProcessFuncId(proc)»(); /* Process «proc.name» */
					«ENDFOR»
					Output();
					Prepare_PSW((INT16)(PROCESS_N1), (INT16)PROCESS_Nn);
				}
			}
			
			int main() {
			    Control_Loop();
			}
		'''

		fsa.generateFile('''c-code/generated/main.c''', fileContent)
	}

	def translateProcess(Process proc) {
		return '''
			void «identifiersHelper.getProcessFuncId(proc)»() { /* Process: «proc.name» */
				switch (Check_State(«proc.index»)) {
					«FOR state : proc.states»
						«translateState(proc, state)»
					«ENDFOR»
				}
			}
		'''
	}

	def translateState(Process proc, State state) {
		return '''
			case «state.index»: { /* State: «state.name» */
				«FOR stat : state.stateFunction.statements»
					«translateStatement(proc, state, stat)»
				«ENDFOR»
				«IF state.timeoutFunction !== null »
					«translateTimeoutFunction(proc, state, state.timeoutFunction)»
				«ENDIF»
				break;
			}
		'''
	}

	def translateTimeoutFunction(Process proc, State state, TimeoutFunction func) {
		return '''
			if (Timeout(«proc.index», «translateTimeout(func)»))
				«translateStatement(proc, state, func.body)»
		'''
	}
	
	def translateCheckStateExpression(CheckStateExpression cse) {
		switch (cse.qualfier) {
			case STOP:
				return '''Is_Stop(«cse.process.index»)'''
			case ERROR:
				return '''Is_Error(«cse.process.index»)'''
			case ACTIVE:
				return '''Is_Active(«cse.process.index»)'''
			case INACTIVE:
				return '''Is_Inactive(«cse.process.index»)'''
		}
	}

	def translateTimeout(TimeoutFunction func) {
		if(func.isClearTimeout) return translateTime(func.time)
		if(func.isReferencedTimeout) identifiersHelper.getMapping(func.ref);
	}

	def String translateStatement(Process proc, State state, EObject statement) {
		switch statement {
			StopProcStat:
				return translateStopProcStat(proc, state, statement)
			SetStateStat:
				return translateSetStateStat(proc, state, statement)
			IfElseStat:
				return translateIfElseStat(proc, state, statement)
			Expression:
				return '''«translateExpr(statement)»;'''
			SwitchStat:
				return translateSwitchCaseStat(proc, state, statement)
			StartProcStat:
				return translateStartProcStat(proc, state, statement)
			ResetStat:
				return translateResetTimer(proc, state)
			RestartStat:
				return translateRestartProcStat(proc)
			CompoundStatement:
				return ''' 
					{
					«FOR stat : statement.statements»
						«translateStatement(proc, state, stat)»
					«ENDFOR»
					}
				'''
		}
	}

	def translateIfElseStat(Process proc, State state, IfElseStat stat) {
		return '''
			if («translateExpr(stat.cond)») 
				«translateStatement(proc, state, stat.then)»
			«IF stat.getElse !== null»	
			else «translateStatement(proc, state, stat.getElse)»
			«ENDIF»
		'''
	}

	def translateResetTimer(Process proc, State state) {
		return '''Reset_Timer(«proc.index»);'''
	}

	def translateSetStateStat(Process proc, State state, SetStateStat sss) {
		if (sss.isNext) {
			return '''Set_State(«proc.index», «state.index + 1»);'''
		}
		return '''Set_State(«proc.index», «sss.state.index»);'''
	}

	def translateStopProcStat(Process proc, State state, StopProcStat sps) {
		val procToStop = sps.selfStop ? proc : sps.process
		return '''
			Set_Stop(«procToStop.index»);
		'''
	}

	def translateStartProcStat(Process proc, State state, StartProcStat sps) {
		return '''
			Set_Start(«sps.process.index»);
		'''
	}

	def translateRestartProcStat(Process proc) {
		return '''
			Set_Start(«proc.index»);
		'''
	}

	def translateSwitchCaseStat(Process proc, State state, SwitchStat stat) {
		return '''
			switch («translateExpr(stat.expr)») {
				«FOR variant : stat.options»
				case («variant.option»):
					«translateStatement(proc, state, stat)»
					«IF variant.hasBreak»break;«ENDIF»
				«ENDFOR»
			}
		'''
	}

	def String translateExpr(EObject expr) {
		switch (expr) {
			InfixOp:
				return '''«expr.op» «identifiersHelper.getMapping(expr.ref)»'''
			PostfixOp:
				return '''«identifiersHelper.getMapping(expr.ref)» «expr.op»'''
			FunctionCall:
				return '''«expr.function.name»(«String.join(",", expr.args.map[translateExpr])»)'''
			IdReference:
				return '''«identifiersHelper.getMapping(expr)»'''
			PrimaryExpression: {
				if (expr.isNestedExpr) return '''(«translateExpr(expr.nestedExpr)»)'''
				if (expr.isBoolean) {
					return translateBoolLiteral(expr.bool)
				}
				if (expr.isReference) {
					return translateExpr(expr.reference)
				}
				if (expr.isTime) {
					return translateTime(expr.time)
				}
				return NodeModelUtils.getNode(expr).text.trim
			}
			UnaryExpression:
				return '''«expr.unaryOp» «translateExpr(expr.right)»'''
			CastExpression:
				return '''(«translateType(expr.type)») «translateExpr(expr.right)»'''
			MultiplicativeExpression:
				return '''«translateExpr(expr.left)» «expr.mulOp» «translateExpr(expr.right)»'''
			AdditiveExpression:
				return '''«translateExpr(expr.left)» «expr.addOp» «translateExpr(expr.right)»'''
			CheckStateExpression:
				return translateCheckStateExpression(expr)
			ShiftExpression:
				return '''«translateExpr(expr.left)» «expr.shiftOp» «translateExpr(expr.right)»'''
			CompareExpression:
				return '''«translateExpr(expr.left)» «expr.cmpOp» «translateExpr(expr.right)»'''
			EqualityExpression:
				return '''«translateExpr(expr.left)» «expr.eqCmpOp» «translateExpr(expr.right)»'''
			BitAndExpression:
				return '''«translateExpr(expr.left)» & «translateExpr(expr.right)»'''
			BitXorExpression:
				return '''«translateExpr(expr.left)» ^ «translateExpr(expr.right)»'''
			BitOrExpression:
				return '''«translateExpr(expr.left)» | «translateExpr(expr.right)»'''
			LogicalAndExpression:
				return '''«translateExpr(expr.left)» && «translateExpr(expr.right)»'''
			LogicalOrExpression:
				return '''«translateExpr(expr.left)» || «translateExpr(expr.right)»'''
			AssignmentExpression: {
				if (expr.hasAssignment)
					return '''«translateExpr(expr.assignVar)» «expr.assignOp» «translateExpr(expr.expr)»'''
				return '''«translateExpr(expr.expr)»'''
			}
		}
	}
	
	def translateTime(String timeLiteral) {
		return '''(INT32_U) «timeLiteral.parseTime»UL'''
	}
	
	def translateType(Type t) {
		return '''«t.getName()»'''
	}
	
	def translateBoolLiteral(Boolean l) {
		return l.booleanValue ? "TRUE" : "FALSE"
	}
}
