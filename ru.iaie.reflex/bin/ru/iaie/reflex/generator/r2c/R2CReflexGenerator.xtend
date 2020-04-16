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

	override void beforeGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		program = resource.getProgram()
	}

	override void afterGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		identifiersHelper.clearCaches()
	}

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		copyResources(program.name.toLowerCase, fsa)
		generateVariables(resource, fsa, context)
		generateConstants(resource, fsa, context)
		generateProcessImplementations(resource, fsa, context)
		generateMain(resource, fsa, context)
	}

	def copyResources(String fileNamePrefix, IFileSystemAccess2 fsa) {
		for (resource : commonResources) {
			fsa.generateFile('''c-code/«resource»''', class.getResourceAsStream('''/resources/c-code/«resource»'''))
		}
	}

	def generateConstants(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val fileContent = '''
			#pragma once
			/*           Constant definitions          */
			«generateConstants(resource)»
			/*                Enums                    */
			«generateEnums(resource)»
		'''
		fsa.generateFile('''c-code/CAcnst.h''', fileContent)
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
			/* CAGVAR.H = Global Variables Image-File. */
			#pragma once
			/*       Process variables     */
			«generateProcessVariables(resource)»
			/*          Input Ports         */
			«generateInputPorts(resource)»
			/*         Output Ports         */
			«generateOutputPorts(resource)»
		'''
		fsa.generateFile('''c-code/CAgvar.cpp''', fileContent)
	}

	// TODO: split to global and process
	def generateProcessVariables(Resource resource) {
		return '''
			«FOR variable: program.globalVars»
				«generateGlobalVariableDefinition(variable)»
			«ENDFOR»
			«FOR proc : program.processes»
				«FOR variable: proc.variables»
					«generateProcessVariableDefinition(proc, variable)»
				«ENDFOR»
			«ENDFOR»
		'''
	}
	
	def generateProcessVariableDefinition(Process proc, ProcessVariable variable) {
		return '''
			«IF (variable instanceof ProgramVariable)»
			«NodeModelUtils.getNode(variable.type).text.trim» «identifiersHelper.getProcessVariableId(proc, variable)»;
			«ENDIF»
			«IF (variable instanceof PhysicalVariable)»
			«variable.type» «identifiersHelper.getProcessVariableId(proc, variable)»;
			«ENDIF»
		'''
	}
	
	def generateGlobalVariableDefinition(GlobalVariable variable) {
		return '''
			«IF (variable instanceof ProgramVariable)»
			«NodeModelUtils.getNode(variable.type).text.trim» «identifiersHelper.getGlobalVariableId(variable)»;
			«ENDIF»
			«IF (variable instanceof PhysicalVariable)»
			«variable.type» «identifiersHelper.getGlobalVariableId(variable)»;
			«ENDIF»
		'''
	}

	def generateInputPorts(Resource resource) {
		// TODO: specify port type
		return '''
			«FOR reg : program.registers»
				«IF reg.type == RegisterType.INPUT»
					char «identifiersHelper.getPortId(reg)»;
				«ENDIF»
			«ENDFOR»
		'''
	}

	def generateOutputPorts(Resource resource) {
		// TODO: specify port type
		return '''
			«FOR reg : program.registers»
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
		return "TODO" 
	}

	def translateSetStateStat(Process proc, State state, SetStateStat sss) {
		if (sss.isNext) {
			return '''Set_State(«identifiersHelper.getProcessId(proc)», «identifiersHelper.getStateId(proc, state)» + 1);'''
		}

		val stateToSet = sss.state
		return '''Set_State(«identifiersHelper.getProcessId(proc)», «identifiersHelper.getStateId(proc, stateToSet)»);'''
	}

	def translateStopProcStat(Process proc, State state, StopProcStat sps) {
		return '''
			Set_Stop(«identifiersHelper.getProcessId(proc)»);
		'''
	}

	def translateStartProcStat(Process proc, State state, StartProcStat sps) {
		// TODO: move to validation checks
		val procToStart = proc.eResource.program.findProcessByName(sps.process.name)
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

	def String translateExpr(EObject expr) {
		switch (expr) {
			InfixOp:
				return '''«expr.op» «identifiersHelper.getId(expr.varId)»'''
			PostfixOp:
				return '''«identifiersHelper.getId(expr.varId)» «expr.op»'''
			FunctionCall:
				return '''«expr.function.name»(«String.join(",", expr.args.map[translateExpr])»)'''
			PrimaryExpression: {
				if(expr.isVariableReference) return identifiersHelper.getId(expr.varId)
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
					return '''«identifiersHelper.getId(expr.assignVar)» «expr.assignOp» «translateExpr(expr.expr)»'''
				return '''«translateExpr(expr.expr)»'''
			}
		}
	}
}
