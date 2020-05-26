package ru.iaie.reflex.generator.r2c

import org.eclipse.emf.ecore.EObject
import ru.iaie.reflex.reflex.Expression
import ru.iaie.reflex.reflex.IfElseStat
import ru.iaie.reflex.reflex.Process
import ru.iaie.reflex.reflex.ResetStat
import ru.iaie.reflex.reflex.RestartStat
import ru.iaie.reflex.reflex.SetStateStat
import ru.iaie.reflex.reflex.StartProcStat
import ru.iaie.reflex.reflex.State
import ru.iaie.reflex.reflex.StopProcStat
import ru.iaie.reflex.reflex.SwitchStat
import ru.iaie.reflex.reflex.TimeoutFunction

import static extension ru.iaie.reflex.utils.ReflexModelUtil.*

import ru.iaie.reflex.reflex.CheckStateExpression
import ru.iaie.reflex.reflex.CompoundStatement
import ru.iaie.reflex.generator.r2c.interfaces.IReflexIdentifiersHelper

class ProcessGenerator {

	Process proc
	IReflexIdentifiersHelper identifiersHelper
	ExpressionGenerator expressionGenerator
	
	new(Process process, IReflexIdentifiersHelper identifiersHelper) {
		this.proc = process
		this.identifiersHelper = identifiersHelper
		expressionGenerator = new ExpressionGenerator(identifiersHelper)
	}

	def generate() {
		return '''
			void «identifiersHelper.getProcessFuncId(proc)»() { /* Process: «proc.name» */
				switch (Check_State(«proc.index»)) {
					«FOR state : proc.states»
						«translateState(state)»
					«ENDFOR»
				}
			}
		'''
	}

	def translateState(State state) {
		return '''
			case «state.index»: { /* State: «state.name» */
				«FOR stat : state.stateFunction.statements»
					«translateStatement(state, stat)»
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
				«translateStatement(state, func.body)»
		'''
	}

	def translateTimeout(TimeoutFunction func) {
		if(func.isClearTimeout) return LiteralGenerationUtil.translateTime(func.time)
		if(func.isReferencedTimeout) identifiersHelper.getMapping(func.ref);
	}



	def String translateStatement(State state, EObject statement) {
		switch statement {
			StopProcStat:
				return translateStopProcStat(statement)
			SetStateStat:
				return translateSetStateStat(state, statement)
			IfElseStat:
				return translateIfElseStat(state, statement)
			Expression:
				return '''«expressionGenerator.generate(statement)»;'''
			SwitchStat:
				return translateSwitchCaseStat(state, statement)
			StartProcStat:
				return translateStartProcStat(statement)
			ResetStat:
				return translateResetTimer()
			RestartStat:
				return translateRestartProcStat()
			CompoundStatement:
				return ''' 
					{
					«FOR stat : statement.statements»
						«translateStatement(state, stat)»
					«ENDFOR»
					}
				'''
		}
	}

	def translateIfElseStat(State state, IfElseStat stat) {
		return '''
			if («expressionGenerator.translateExpr(stat.cond)») 
				«translateStatement(state, stat.then)»
			«IF stat.getElse !== null»	
				else «translateStatement(state, stat.getElse)»
			«ENDIF»
		'''
	}

	def translateSwitchCaseStat(State state, SwitchStat stat) {
		return '''
			switch («expressionGenerator.translateExpr(stat.expr)») {
				«FOR variant : stat.options»
					case («expressionGenerator.translateExpr(variant.option)»): {
						«FOR statement: variant.statements» 
							«translateStatement(state, statement)»
						«ENDFOR»
						«IF variant.hasBreak»break;«ENDIF»
						}
				«ENDFOR»
				«IF stat.hasDefaultOption»default: {
						«FOR statement: stat.defaultOption.statements» 
							«translateStatement(state, statement)»
						«ENDFOR»
						«IF stat.defaultOption.hasBreak»break;«ENDIF»
					}
				«ENDIF»
			}
		'''
	}

	def translateResetTimer() {
		return '''Reset_Timer(«proc.index»);'''
	}

	def translateSetStateStat(State state, SetStateStat sss) {
		if (sss.isNext) {
			return '''Set_State(«proc.index», «state.index + 1»);'''
		}
		return '''Set_State(«proc.index», «sss.state.index»);'''
	}

	def translateStopProcStat(StopProcStat sps) {
		val procToStop = sps.selfStop ? proc : sps.process
		return '''
			Set_Stop(«procToStop.index»);
		'''
	}

	def translateStartProcStat(StartProcStat sps) {
		return '''
			Set_Start(«sps.process.index»);
		'''
	}

	def translateRestartProcStat() {
		return '''
			Set_Start(«proc.index»);
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
}
