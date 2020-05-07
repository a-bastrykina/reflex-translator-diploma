package ru.iaie.reflex.generator;

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

import static extension ru.iaie.reflex.utils.ReflexModelUtil.*

import ru.iaie.reflex.generator.r2c.IReflexCachedIdentifiersHelper
import ru.iaie.reflex.reflex.Program
import ru.iaie.reflex.reflex.ProcessVariable
import ru.iaie.reflex.reflex.Process
import ru.iaie.reflex.reflex.ProgramVariable
import ru.iaie.reflex.reflex.PhysicalVariable
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

class ImperativeLangGenerator extends AbstractGenerator {
	
	IReflexCachedIdentifiersHelper identifiersHelper;
	ITranslationStrategy strategy;
	ISourceBuilder builder;
	// AST root element
	Program program;

	override void beforeGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		program = resource.getProgram()
	}

	override void afterGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		identifiersHelper.clearCaches()
	}

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
//		generateVariables(resource, fsa, context)
		generateConstantDefinitions()
//		generateProcessImplementations(resource, fsa, context)
		generateInput(resource, fsa, context)
		generateOutput(resource, fsa, context)
		builder.build();
	}

	def generateInput(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		
	}
	
	def generateOutput(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		
	}

	def generateConstantDefinitions() {
		builder.withConstantDefinitions('''
			«FOR constant : program.consts»
			«strategy.translateConstDefinition(constant)»«strategy.separator»
			«ENDFOR»
		''')
	}

	def generateEnumDefifinions() {
		builder.withEnumDefinitions('''
			«FOR en : program.enums»
				«strategy.translateEnumDefinition(en)»
			«ENDFOR»
		''')
	}

	// TODO: split to global and process
	def generateProcessVarDefifinitions(Resource resource) {
		builder.withGlobalVariableDefinitions('''
			«FOR proc : program.processes»
				«FOR variable: proc.variables»
					«strategy.translateProcessVarDefinition(proc, variable)»
				«ENDFOR»
			«ENDFOR»
		''')
	}
	
	def generateGlobalVarDefinitions(Resource resource) {
		builder.withProcessVariableDefinitions('''
			«FOR variable: program.globalVars»
				«strategy.translateGlobalVarDefinition(variable)»
			«ENDFOR»
		''')
	}
//	
//	def generateGlobalVariableDefinition(GlobalVariable variable) {
//		return '''
//			«IF (variable instanceof ProgramVariable)»
//			«NodeModelUtils.getNode(variable.type).text.trim» «identifiersHelper.getGlobalVariableId(variable)»;
//			«ENDIF»
//			«IF (variable instanceof PhysicalVariable)»
//			«variable.type» «identifiersHelper.getGlobalVariableId(variable)»;
//			«ENDIF»
//		'''
//	}
//
//	def generateInputPorts(Resource resource) {
//		// TODO: specify port type
//		return '''
//			«FOR reg : program.registers»
//				«IF reg.type == RegisterType.INPUT»
//					char «identifiersHelper.getPortId(reg)»;
//				«ENDIF»
//			«ENDFOR»
//		'''
//	}
//
//	def generateOutputPorts(Resource resource) {
//		// TODO: specify port type
//		return '''
//			«FOR reg : program.registers»
//				«IF reg.type == RegisterType.OUTPUT»
//					char «identifiersHelper.getPortId(reg)»;
//				«ENDIF»
//			«ENDFOR»
//		'''
//	}
//
//	def generateProcessImplementations(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
//		val fileContent = '''
//			/* FILE OF PROC-IMAGES OF THE PROJECT */
//			#include "CAext.h" /* Common files for all generated c-files */
//			#include "CAxvar.h"  /* Var-images */
//			
//			«FOR proc : program.processes»
//				«translateProcess(proc)»
//			«ENDFOR»
//		'''
//		fsa.generateFile('''c-code/CA0001.cpp''', fileContent)
//	}
//
//	def generateMain(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
//		val fileContent = '''
//			/* MAIN FILE OF THE PROJECT */
//			#include "CAext.h" /* Common files for all generated c-files */
//			#include "CAproc.h"  /* Process-functions desription */
//			#include "CAgvar.h"  /* Project variables images */
//			#include "CAio.h"    /* Scan-input/output functions */
//			void Control_Loop(void);  /* for r_main.h */
//			#include "r_main.h"  /* Codes of the main-function that calls Control_Loop */
//			
//			void Control_Loop (void)    /* Control algorithm */
//			{
//				Input();
//				«FOR proc : program.processes»
//					«identifiersHelper.getProcessFuncId(proc)»(); /* Process «proc.name» */
//				«ENDFOR»
//				Output();
//				Prepare_PSW((INT16S)(PROCESS_N1), (INT16S)PROCESS_Nn);
//			}
//		'''
//
//		fsa.generateFile('''c-code/CAmain.cpp''', fileContent)
//	}
//
//	def translateProcess(Process proc) {
//		return '''
//			void «identifiersHelper.getProcessFuncId(proc)»() { /* Process: «proc.name» */
//				switch (Check_State(«identifiersHelper.getProcessId(proc)»)) {
//					«FOR state : proc.states»
//						«translateState(proc, state)»
//					«ENDFOR»
//				}
//			}
//		'''
//	}
//
//	def translateState(Process proc, State state) {
//		return '''
//			case «identifiersHelper.getStateId(proc, state)»: { /* State: «state.name» */
//			«FOR stat : state.stateFunction.statements»
//				«translateStatement(proc, state, stat)»
//			«ENDFOR»
//			«IF state.timeoutFunction !== null »
//				«translateTimeoutFunction(proc, state, state.timeoutFunction)»
//			«ENDIF»
//				break;
//			}
//		'''
//	}
//
//	def translateTimeoutFunction(Process proc, State state, TimeoutFunction func) {
//		return '''
//			if (Timeout(«identifiersHelper.getProcessId(proc)», «translateTimeout(func)»))
//				«translateStatement(proc, state, func.body)»
//		'''
//	}
//	
//	def translateTimeout(TimeoutFunction func) {
//		if (func.isClearTimeout) return func.time.ticks
//		if (func.isReferencedTimeout) identifiersHelper.getId(func.ref.resolveName);
//	}
//
//	def String translateStatement(Process proc, State state, EObject statement) {
//		switch statement {
//			StopProcStat:
//				return translateStopProcStat(proc, state, statement)
//			SetStateStat:
//				return translateSetStateStat(proc, state, statement)
//			IfElseStat:
//				return translateIfElseStat(proc, state, statement)
//			Expression:
//				return '''«translateExpr(statement)»;'''
//			SwitchStat:
//				return translateSwitchCaseStat(proc, state, statement)
//			StartProcStat:
//				return translateStartProcStat(proc, state, statement)
//			ResetStat:
//				return translateResetTimer(proc, state)
//			RestartStat:
//				return translateRestartProcStat(proc)
//			StatementBlock:
//				return '''
//					«IF statement.statements.length > 1»{«ENDIF»
//					«FOR stat : statement.statements»
//						«translateStatement(proc, state, stat)»
//					«ENDFOR»
//					«IF statement.statements.length > 1»}«ENDIF»
//				'''
//		}
//	}
//
//	def translateIfElseStat(Process proc, State state, IfElseStat stat) {
//		return '''
//			if («translateExpr(stat.cond)») «translateStatement(proc, state, stat.then)»
//			«IF stat.getElse !== null»	
//				else «translateStatement(proc, state, stat.getElse)»
//			«ENDIF»
//		'''
//	}
//
//	def translateResetTimer(Process proc, State state) {
//		return '''Reset_Timer(«identifiersHelper.getProcessId(proc)»);''' 
//	}
//
//	def translateSetStateStat(Process proc, State state, SetStateStat sss) {
//		if (sss.isNext) {
//			return '''Set_State(«identifiersHelper.getProcessId(proc)», «identifiersHelper.getStateId(proc, state)» + 1);'''
//		}
//
//		val stateToSet = sss.state
//		return '''Set_State(«identifiersHelper.getProcessId(proc)», «identifiersHelper.getStateId(proc, stateToSet)»);'''
//	}
//
//	def translateStopProcStat(Process proc, State state, StopProcStat sps) {
//		return '''
//			Set_Stop(«identifiersHelper.getProcessId(proc)»);
//		'''
//	}
//
//	def translateStartProcStat(Process proc, State state, StartProcStat sps) {
//		// TODO: move to validation checks
//		val procToStart = proc.eResource.program.findProcessByName(sps.process.name)
//		return '''
//			Set_Start(«identifiersHelper.getProcessId(procToStart)»);
//		'''
//	}
//
//	def translateRestartProcStat(Process proc) {
//		return '''
//			Set_Start(«identifiersHelper.getProcessId(proc)»);
//		'''
//	}
//
//	def translateSwitchCaseStat(Process proc, State state, SwitchStat stat) {
//		return '''
//			switch («translateExpr(stat.expr)») {
//				«FOR variant : stat.options»
//					case («variant.option»):
//						«translateStatement(proc, state, stat)»
//						«IF variant.hasBreak»break;«ENDIF»
//				«ENDFOR»
//			}
//		'''
//	}
//
//	def String translateExpr(EObject expr) {
//		switch (expr) {
//			InfixOp:
//				return '''«expr.op» «identifiersHelper.getId(expr.varId)»'''
//			PostfixOp:
//				return '''«identifiersHelper.getId(expr.varId)» «expr.op»'''
//			FunctionCall:
//				return '''«expr.function.name»(«String.join(",", expr.args.map[translateExpr])»)'''
//			IdReference:
//				return expr.resolveName
//			PrimaryExpression: {
//				if(expr.isNestedExpr) return '''(«translateExpr(expr.nestedExpr)»)'''
//				return NodeModelUtils.getNode(expr).text.trim
//			}
//			UnaryExpression:
//				return '''«expr.unaryOp» «translateExpr(expr.right)»'''
//			CastExpression:
//				return '''(«NodeModelUtils.getNode(expr.type).text.trim») «translateExpr(expr.right)»'''
//			MultiplicativeExpression:
//				return '''«translateExpr(expr.left)» «expr.mulOp» «translateExpr(expr.right)»'''
//			AdditiveExpression:
//				return '''«translateExpr(expr.left)» «expr.addOp» «translateExpr(expr.right)»'''
//			ShiftExpression:
//				return '''«translateExpr(expr.left)» «expr.shiftOp» «translateExpr(expr.right)»'''
//			CompareExpression:
//				return '''«translateExpr(expr.left)» «expr.cmpOp» «translateExpr(expr.right)»'''
//			EqualityExpression:
//				return '''«translateExpr(expr.left)» «expr.eqCmpOp» «translateExpr(expr.right)»'''
//			BitAndExpression:
//				return '''«translateExpr(expr.left)» & «translateExpr(expr.right)»'''
//			BitXorExpression:
//				return '''«translateExpr(expr.left)» ^ «translateExpr(expr.right)»'''
//			BitOrExpression:
//				return '''«translateExpr(expr.left)» | «translateExpr(expr.right)»'''
//			LogicalAndExpression:
//				return '''«translateExpr(expr.left)» && «translateExpr(expr.right)»'''
//			LogicalOrExpression:
//				return '''«translateExpr(expr.left)» || «translateExpr(expr.right)»'''
//			AssignmentExpression: {
//				if (expr.hasAssignment)
//					return '''«identifiersHelper.getId(expr.assignVar)» «expr.assignOp» «translateExpr(expr.expr)»'''
//				return '''«translateExpr(expr.expr)»'''
//			}
//		}
//	}

}
