package ru.iaie.reflex.generator.r2c

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import ru.iaie.reflex.reflex.Program
import ru.iaie.reflex.reflex.Process
import ru.iaie.reflex.reflex.State
import org.eclipse.emf.ecore.EObject
import ru.iaie.reflex.reflex.StopProcStat
import ru.iaie.reflex.reflex.IfElseStat
import ru.iaie.reflex.reflex.Expression
import ru.iaie.reflex.reflex.SetStateStat
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import ru.iaie.reflex.reflex.SwitchStat
import ru.iaie.reflex.reflex.StatementBlock
import ru.iaie.reflex.reflex.StartProcStat
import ru.iaie.reflex.reflex.LoopStat
import ru.iaie.reflex.reflex.ResetStat
import ru.iaie.reflex.reflex.RestartStat
import ru.iaie.reflex.reflex.TimeoutFunction
import java.util.List
import ru.iaie.reflex.reflex.PrimaryExpression
import ru.iaie.reflex.reflex.ProgramVariable
import ru.iaie.reflex.reflex.RegisterType

class R2CReflexGenerator extends AbstractGenerator {

	IReflexCachedIdentifiersHelper identifiersHelper = new ReflexIdentifiersHelper;
	// AST root element
	Program program;

	// These files are common, they are just need to be copied to target c-code dir 
	// TODO: replace with reading config
	List<String> commonResources = newArrayList("CA_dll_interface.cpp", "CA_dll_interface.h", "CA_queue_const.h",
		"CAio.h", "CAports.h", "CAusr1.cpp", "CAusr1.h", "CAusr2.h", "custom_dll_interface.cpp", "dll_interface.h",
		"LabVIEWData.h", "dll_interface.h", "lib.cpp", "lib.h", "msg_queue.cpp", "msg_queue.h", "proc.h", "R_CNST.H",
		"r_io.cpp", "r_io.h", "r_lib.cpp", "R_LIB.H", "r_main.h")

	override void afterGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		identifiersHelper.clearCaches()
	}
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		program = resource.allContents.toIterable.filter(Program).get(0)

		copyResources(fsa)
		generateVariables(resource, fsa, context)
		generateProcessImplementations(resource, fsa, context)
		generateMain(resource, fsa, context)
	}

	def copyResources(IFileSystemAccess2 fsa) {
		for (resource : commonResources) {
			fsa.generateFile('''c-code/«resource»''', class.getResourceAsStream('''/resources/c-code/«resource»'''))
		}
	}
	
	def generateVariables(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val fileContent = '''
			/*           Variables          */
			/* CAGVAR.H = Global Variables Image-File. */
			#pragma once
			/*       Process variables     */
			«generateProcessVariables()»
			/*          Input Ports         */
			«generateInputPorts()»
			/*         Output Ports         */
			«generateOutputPorts()»
		'''
		fsa.generateFile('''c-code/CAgvar.cpp''', fileContent)	
	}
	
	def generateProcessVariables() {
		return '''
		«FOR proc: program.processes»
		«FOR variable: proc.variables»
		«IF (variable instanceof ProgramVariable)»
		«NodeModelUtils.getNode(variable.type).text.trim» «identifiersHelper.getVariableId(proc, variable)»;
		«ENDIF»
		«ENDFOR»
		«ENDFOR»
		'''
	}
	
	def generateInputPorts() {
		// TODO: specify port type
		return '''
		«FOR reg: program.registers»
		«IF reg.type == RegisterType.INPUT»
		char «identifiersHelper.getPortId(reg)»;
		«ENDIF»
		«ENDFOR»
		'''
	}
	
	def generateOutputPorts(){
		// TODO: specify port type
		return '''
		«FOR reg: program.registers»
		«IF reg.type == RegisterType.OUTPUT»
		char «identifiersHelper.getPortId(reg)»;
		«ENDIF»
		«ENDFOR»
		'''
	}

	def generateProcessImplementations(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val fileContent = '''
			/* FILE OF PROC-IMAGES OF THE PROJECT */
			#include "CAext.h" /* Common files for all generated c-files */
			#include "CAxvar.h"  /* Var-images */
			
			«FOR proc : program.processes»
				«translateProcess(proc)»
			«ENDFOR»
		'''
		fsa.generateFile('''c-code/CA0001.cpp''', fileContent)
	}

	def generateMain(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val fileContent = '''
			/* MAIN FILE OF THE PROJECT */
			#include "CAext.h" /* Common files for all generated c-files */
			#include "CAproc.h"  /* Process-functions desription */
			#include "CAgvar.h"  /* Project variables images */
			#include "CAio.h"    /* Scan-input/output functions */
			void Control_Loop(void);  /* for r_main.h */
			#include "r_main.h"  /* Codes of the main-function that calls Control_Loop */
			
			void Control_Loop (void)    /* Control algorithm */
			{
				Input();
				«FOR proc : program.processes»
					«identifiersHelper.getProcessFuncId(proc)»(); /* Process «proc.name» */
				«ENDFOR»
				Output();
				Prepare_PSW((INT16S)(PROCESS_N1), (INT16S)PROCESS_Nn);
			}
		'''

		fsa.generateFile('''c-code/CAmain.cpp''', fileContent)
	}

	def translateProcess(Process proc) {
		return '''
			void «identifiersHelper.getProcessFuncId(proc)»() { /* Process: «proc.name» */
				switch (Check_State(«identifiersHelper.getProcessId(proc)»)) {
					«FOR state : proc.states»
						«translateState(proc, state)»
					«ENDFOR»
				}
			}
		'''
	}

	def translateState(Process proc, State state) {
		return '''
			case «identifiersHelper.getStateId(proc, state)»: { /* State: «state.name» */
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
			if (Timeout(«identifiersHelper.getProcessId(proc)», «func.time.ticks»))
				«translateStatement(proc, state, func.body)»
		'''
	}

	// TODO: use multiple dispatch
	def String translateStatement(Process proc, State state, EObject statement) {
		if (statement instanceof StopProcStat) {
			return translateStopProcStat(proc, state, statement)
		} else if (statement instanceof SetStateStat) {
			return translateSetStateStat(proc, state, statement)
		} else if (statement instanceof IfElseStat) {
			return '''«translateIfElseStat(proc, state, statement)»'''
		} else if (statement instanceof Expression) {
			return '''«translateExpr(statement)»;'''
		} else if (statement instanceof SwitchStat) {
			return '''«translateSwitchCaseStat(proc, state, statement)»'''
		} else if (statement instanceof StartProcStat) {
			return '''«translateStartProcStat(program, proc, state, statement)»'''
		} else if (statement instanceof LoopStat) {
			return '''«translateLoop(proc, state)»'''
		} else if (statement instanceof ResetStat) {
			return '''«translateResetTimer(proc, state)»'''
		} else if (statement instanceof RestartStat) {
			return '''«translateRestartProcStat(proc)»'''
		} else if (statement instanceof StatementBlock) {
			return '''
				«IF statement.statements.length > 1»{«ENDIF»
				«FOR stat : statement.statements»
					«translateStatement(proc, state, stat)»
				«ENDFOR»
				«IF statement.statements.length > 1»}«ENDIF»
			'''
		}
	}

	def translateIfElseStat(Process proc, State state, IfElseStat stat) {
		return '''
			if («translateExpr(stat.cond)») «translateStatement(proc, state, stat.then)»
			«IF stat.getElse !== null»	
				else «translateStatement(proc, state, stat.getElse)»
			«ENDIF»
		'''
	}

	def translateLoop(Process proc, State state) {
		// TODO: break ?
		return ''''''
	}

	def translateResetTimer(Process proc, State state) {
		return translateLoop(proc, state)
	}

	def translateSetStateStat(Process proc, State state, SetStateStat sss) {
		if (sss.isNext) {
			return '''Set_State(«identifiersHelper.getProcessId(proc)», «identifiersHelper.getStateId(proc, state)» + 1);'''
		}
		val matchingStates = proc.states.filter[state.name.equals(sss.stateId)].toList
		// TODO: check during validation 
		if (matchingStates.isEmpty) {
			return ''''''
		}
		val stateToSet = matchingStates.get(0)
		return '''Set_State(«identifiersHelper.getProcessId(proc)», «identifiersHelper.getStateId(proc, stateToSet)»);'''
	}

	def translateStopProcStat(Process proc, State state, StopProcStat sps) {
		return '''
			Set_Stop(«identifiersHelper.getProcessId(proc)»);
		'''
	}

	def translateStartProcStat(Program prog, Process proc, State state, StartProcStat sps) {
		// TODO: move to validation checks
		val matchingProcs = prog.processes.filter[proc.name.equals(sps.procId)].toList
		if(matchingProcs.isEmpty) return ''''''
		val procToStart = matchingProcs.get(0)
		return '''
			Set_Start(«identifiersHelper.getProcessId(procToStart)»);
		'''
	}

	def translateRestartProcStat(Process proc) {
		return '''
			Set_Start(«identifiersHelper.getProcessId(proc)»);
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

	def translateExpr(Expression expr) {
		// TODO: translate variables in expressions
//		expr.eResource.allContents.filter(PrimaryExpression).forEach[translateId]
		return '''«NodeModelUtils.getNode(expr).text.trim»'''
	}
	
	def translateId(PrimaryExpression e) {
		if (e.varId !== null) {
			e.varId = identifiersHelper.getId(e.varId)
		}
	} 

}
