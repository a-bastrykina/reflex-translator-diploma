package ru.iaie.reflex.generator.r2c

import java.util.List
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
import ru.iaie.reflex.reflex.PhysicalVariable
import ru.iaie.reflex.reflex.PostfixOp
import ru.iaie.reflex.reflex.PrimaryExpression
import ru.iaie.reflex.reflex.Process
import ru.iaie.reflex.reflex.Program
import ru.iaie.reflex.reflex.ProgramVariable
import ru.iaie.reflex.reflex.RegisterType
import ru.iaie.reflex.reflex.ResetStat
import ru.iaie.reflex.reflex.RestartStat
import ru.iaie.reflex.reflex.SetStateStat
import ru.iaie.reflex.reflex.ShiftExpression
import ru.iaie.reflex.reflex.StartProcStat
import ru.iaie.reflex.reflex.State
import ru.iaie.reflex.reflex.StatementBlock
import ru.iaie.reflex.reflex.StopProcStat
import ru.iaie.reflex.reflex.SwitchStat
import ru.iaie.reflex.reflex.TimeoutFunction
import ru.iaie.reflex.reflex.UnaryExpression

import static extension ru.iaie.reflex.utils.ExpressionUtil.*
import static extension ru.iaie.reflex.utils.ReflexModelUtil.*
import ru.iaie.reflex.reflex.ProcessVariable
import ru.iaie.reflex.reflex.GlobalVariable
import ru.iaie.reflex.reflex.IdReference
import ru.iaie.reflex.reflex.CheckStateExpression

// TODO: abstract class with same doGenerate and abstract
// 		generateVariables(resource, fsa, context)
//		generateConstants(resource, fsa, context)
//		generateProcessImplementations(resource, fsa, context)
//		generateMain(resource, fsa, context)
//
//
class R2CReflexGenerator extends AbstractGenerator {

// TODO: move to singleton with configuration
	IReflexCachedIdentifiersHelper identifiersHelper = new ReflexIdentifiersHelper;
// AST root element
	Program program;

// These files are common, they are just need to be copied to target c-code dir 
// TODO: replace with reading config
// TODO: move to singleton with configuration
	List<String> commonResources = newArrayList("io.h", "ports.h", "usr.cpp", "usr.h", "proc.h",
		"r_cnst.h", "r_io.cpp", "r_io.h", "r_lib.cpp", "r_lib.h", "r_main.h")

	override void beforeGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		program = resource.getProgram()
	}

	override void afterGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		identifiersHelper.clearCaches()
	}

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		copyResources(program.name.toLowerCase, fsa)
		generateVariables(resource, fsa, context)
		generateConstantsFile(resource, fsa, context)
		generateProcessImplementations(resource, fsa, context)
		generateInput(resource, fsa, context)
		generateOutput(resource, fsa, context)
		generateMain(resource, fsa, context)
	}

	def copyResources(String fileNamePrefix, IFileSystemAccess2 fsa) {
		for (resource : commonResources) {
			fsa.generateFile('''c-code/«resource»''', class.getResourceAsStream('''/resources/c-code/«resource»'''))
		}
	}

	def generateInput(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		// TODO
	}

	def generateOutput(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		// TODO
	}

// TODO: rename
	def generateConstantsFile(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val fileContent = '''
			#pragma once
			/*           Constant definitions          */
			«generateConstants(resource)»
			/*                Enums                    */
			«generateEnums(resource)»
		'''
		fsa.generateFile('''c-code/cnst.h''', fileContent)
	}

	def generateConstants(Resource resource) {
		// TODO: check for const expr
		return '''
			«FOR constant : program.consts»
				#define «identifiersHelper.getConstantId(constant)» /*«constant.name»*/ «translateExpr(constant.constValue)» 
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
			/*           Variables          */
			/* GVAR.H = Global Variables Image-File. */
			#pragma once
			/*       Process variables     */
			«generateProcessVariables(resource, false)»
			/*          Input Ports         */
			«generateInputPorts(resource, false)»
			/*         Output Ports         */
			«generateOutputPorts(resource, false)»
		'''
		fsa.generateFile('''c-code/gvar.cpp''', fileContent)
		val externFileContent = '''
			/*           Variables          */
			/* xvar.h = Extern Variables Image-File. */
			#pragma once
			/*       Process variables     */
			«generateProcessVariables(resource, true)»
			/*          Input Ports         */
			«generateInputPorts(resource, true)»
			/*         Output Ports         */
			«generateOutputPorts(resource, true)»
		'''
		fsa.generateFile('''c-code/xvar.h''', externFileContent)
	}

	// TODO: split to global and process
	def generateProcessVariables(Resource resource, boolean externDef) {
		return '''
			«FOR variable : program.globalVars»
				«IF externDef»extern«ENDIF» «generateGlobalVariableDefinition(variable, externDef)»
			«ENDFOR»
			«FOR proc : program.processes»
				«FOR variable: proc.variables»
					«IF externDef»extern«ENDIF» «generateProcessVariableDefinition(proc, variable, externDef)»
				«ENDFOR»
			«ENDFOR»
		'''
	}

	def generateProcessVariableDefinition(Process proc, ProcessVariable variable, boolean externDef) {
		return '''
			«IF (variable instanceof ProgramVariable)»
				// TODO: fix type getting
				«IF externDef»extern«ENDIF» «NodeModelUtils.getNode(variable.type).text.trim» «identifiersHelper.getProcessVariableId(proc, variable)»;
			«ENDIF»
			«IF (variable instanceof PhysicalVariable)»
				«IF externDef»extern«ENDIF» «variable.type» «identifiersHelper.getProcessVariableId(proc, variable)»;
			«ENDIF»
		'''
	}

	def generateGlobalVariableDefinition(GlobalVariable variable, boolean externDef) {
		return '''
			«IF (variable instanceof ProgramVariable)»
				«IF externDef»extern«ENDIF» «NodeModelUtils.getNode(variable.type).text.trim» «identifiersHelper.getGlobalVariableId(variable)»;
			«ENDIF»
			«IF (variable instanceof PhysicalVariable)»
				«IF externDef»extern«ENDIF» «variable.type» «identifiersHelper.getGlobalVariableId(variable)»;
			«ENDIF»
		'''
	}

	def generateInputPorts(Resource resource, boolean externDef) {
		// TODO: specify port type
		return '''
			«FOR reg : program.registers»
				«IF reg.type == RegisterType.INPUT»
					«IF externDef»extern«ENDIF» char «identifiersHelper.getPortId(reg)»;
				«ENDIF»
			«ENDFOR»
		'''
	}

	def generateOutputPorts(Resource resource, boolean externDef) {
		// TODO: specify port type
		return '''
			«FOR reg : program.registers»
				«IF reg.type == RegisterType.OUTPUT»
					«IF externDef»extern«ENDIF» char «identifiersHelper.getPortId(reg)»;
				«ENDIF»
			«ENDFOR»
		'''
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
		fsa.generateFile('''c-code/proc.cpp''', fileContent)
	}

	def generateMain(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val fileContent = '''
			/* MAIN FILE OF THE PROJECT */
			#include "ext.h" /* Common files for all generated c-files */
			#include "proc.h"  /* Process-functions desription */
			#include "gvar.h"  /* Project variables images */
			#include "io.h"    /* Scan-input/output functions */
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

		fsa.generateFile('''c-code/main.cpp''', fileContent)
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
			if (Timeout(«identifiersHelper.getProcessId(proc)», «translateTimeout(func)»))
				«translateStatement(proc, state, func.body)»
		'''
	}
	
	def translateStateStopCheck(Process proc) {
		return '''Check_State(«identifiersHelper.getProcessId(proc)») == STATE_OF_STOP'''
	}
	
	def translateStateErrorCheck(Process proc) {
		return '''Check_State(«identifiersHelper.getProcessId(proc)») == STATE_OF_ERROR'''
	}
	
	def translateCheckStateExpression(CheckStateExpression cse) {
		switch (cse.qualfier) {
			case STOP:
				return translateStateStopCheck(cse.process)
			case ERROR:
				return translateStateErrorCheck(cse.process)
			case ACTIVE:
				return '''!(«translateStateStopCheck(cse.process)» || «translateStateErrorCheck(cse.process)»)'''
			case INACTIVE:
				return '''(«translateStateStopCheck(cse.process)» || «translateStateErrorCheck(cse.process)»)'''
		}
	}

	def translateTimeout(TimeoutFunction func) {
		if(func.isClearTimeout) return func.time.ticks
		if(func.isReferencedTimeout) identifiersHelper.getId(func.ref.resolveName);
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
			StatementBlock:
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

	def translateResetTimer(Process proc, State state) {
		return '''Reset_Timer(«identifiersHelper.getProcessId(proc)»);'''
	}

	def translateSetStateStat(Process proc, State state, SetStateStat sss) {
		if (sss.isNext) {
			return '''Set_State(«identifiersHelper.getProcessId(proc)», «identifiersHelper.getStateId(proc, state)» + 1);'''
		}
		return '''Set_State(«identifiersHelper.getProcessId(proc)», «identifiersHelper.getStateId(proc, sss.state)»);'''
	}

	def translateStopProcStat(Process proc, State state, StopProcStat sps) {
		val procToStop = sps.selfStop ? proc : sps.process
		return '''
			Set_Stop(«identifiersHelper.getProcessId(procToStop)»);
		'''
	}

	def translateStartProcStat(Process proc, State state, StartProcStat sps) {
		return '''
			Set_Start(«identifiersHelper.getProcessId(sps.process)»);
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

	def String translateExpr(EObject expr) {
		switch (expr) {
			InfixOp:
				return '''«expr.op» «identifiersHelper.getId(expr.varId)»'''
			PostfixOp:
				return '''«identifiersHelper.getId(expr.varId)» «expr.op»'''
			FunctionCall:
				return '''«expr.function.name»(«String.join(",", expr.args.map[translateExpr])»)'''
			IdReference:
				return '''«identifiersHelper.getId(expr.resolveName)»'''
			PrimaryExpression: {
				if(expr.isNestedExpr) return '''(«translateExpr(expr.nestedExpr)»)'''
				return NodeModelUtils.getNode(expr).text.trim
			}
			UnaryExpression:
				return '''«expr.unaryOp» «translateExpr(expr.right)»'''
			CastExpression:
				return '''(«NodeModelUtils.getNode(expr.type).text.trim») «translateExpr(expr.right)»'''
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
}
