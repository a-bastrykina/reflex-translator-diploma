package ru.iaie.reflex.generator.r2c

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import ru.iaie.reflex.reflex.Program
import ru.iaie.reflex.reflex.Process
import java.util.HashMap
import java.util.Map
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

class R2CReflexGenerator extends AbstractGenerator {
	Map<String, String> procIdentifiers = new HashMap
	Map<String, String> stateIdentifiers = new HashMap

	Program program;

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		program = resource.allContents.toIterable.filter(Program).get(0)
		val fileContent = translateProgram(program)

		fsa.generateFile('''«program.name.toLowerCase».cpp''', fileContent)
	}

	def translateProgram(Program prog) {
		return '''
			#include <stdio.h>
			#include <stdlib.h>
			«generateProgramInfo(prog)»
			int main() {
				while (1) {
					int i = 0;
					for (; i < «ReflexIdentifiers.PROC_COUNT_VAR»; i++) {
						«FOR proc : prog.processes»
							«translateProcess(proc)»
						«ENDFOR»
					}
				}
			}
		'''
	}

	def translateProcess(Process proc) {
		return '''
			switch («ReflexIdentifiers.PROC_STATES_ARRAY_NAME»[«getProcessId(proc)»]) {
				«FOR state : proc.states»
					«translateState(proc, state)»
				«ENDFOR»
			}
		'''
	}

	def getProcessId(Process proc) {
		if (!procIdentifiers.containsKey(proc.name)) {
			val id = proc.name.toUpperCase
			procIdentifiers.put(proc.name, id)
		}
		return procIdentifiers.get(proc.name)
	}

	def generateProcessesEnum(Program prog) {
		return '''
			enum «ReflexIdentifiers.PROC_ENUM_ID» {
				«FOR proc : prog.processes»
					«getProcessId(proc)»,
				«ENDFOR»
			}
		'''
	}

	def getStateId(Process proc, State state) {
		val key = '''«proc.name».«state.name»'''
		if (!stateIdentifiers.containsKey(key)) {
			val id = '''«proc.name.toUpperCase»_«state.name.toUpperCase»'''
			stateIdentifiers.put(key, id)
		}
		return stateIdentifiers.get(key)
	}

	def generateStateEnum(Process proc) {
		return '''
			enum «proc.name»_STATES {
				«FOR state : proc.states»
					«getStateId(proc, state)»,
				«ENDFOR»
				«proc.name.toUpperCase»«ReflexIdentifiers.STOP_STATE_ID_SUFFIX»,
				«proc.name.toUpperCase»«ReflexIdentifiers.ERR_STATE_ID_SUFFIX»	
			}
		'''
	}

	def generateTimers(Program prog) {
		return '''
			int «ReflexIdentifiers.TIMER_ARRAY_NAME»[«ReflexIdentifiers.PROC_COUNT_VAR»];
		'''
	}

	def generateStatesArray(Program prog) {
		return '''
			int «ReflexIdentifiers.PROC_STATES_ARRAY_NAME»[«ReflexIdentifiers.PROC_COUNT_VAR»];
		'''
	}

	def generateProgramInfo(Program prog) {
		return '''
			int «ReflexIdentifiers.PROC_COUNT_VAR» = «prog.processes.length»;
			«generateTimers(prog)»
			«generateStatesArray(prog)»
			«generateProcessesEnum(prog)»
			«FOR proc : prog.processes»
				«generateStateEnum(proc)»
			«ENDFOR»
		'''
	}

	def translateState(Process proc, State state) {
		return '''
			case «getStateId(proc, state)»: {
			«FOR stat : state.stateFunction.statements»
				«translateStatement(proc, state, stat)»
				«IF state.timeoutFunction != null»
					«translateTimeoutFunction(proc, state, state.timeoutFunction)»
				«ENDIF»
			«ENDFOR»
				break;
			}
		'''
	}

	def translateTimeoutFunction(Process proc, State state, TimeoutFunction func) {
		return '''
			if («ReflexIdentifiers.TIMER_ARRAY_NAME»[«getProcessId(proc)»] >= TODO_Time)
				«translateStatement(proc, state, func.body)»
		'''

	}

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
			return '''«translateResetTimer(proc)»'''
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
		return translateResetTimer(proc);
	}

	def translateResetTimer(Process proc) {
		return '''«ReflexIdentifiers.TIMER_ARRAY_NAME»[«getProcessId(proc)»] =  0;''';
	}

	def translateSetStateStat(Process proc, State state, SetStateStat sss) {
		// TODO: check index (possible validation check)
		return '''
			«IF sss.isNext»
				«ReflexIdentifiers.PROC_STATES_ARRAY_NAME»[«getProcessId(proc)»] =  «getStateId(proc, state)» + 1;
			«ELSE»
				«ReflexIdentifiers.PROC_STATES_ARRAY_NAME»[«getProcessId(proc)»] =  «proc.name.toUpperCase»_«sss.stateId.toUpperCase»;
			«ENDIF»
			«translateResetTimer(proc)»
		'''
	}

	def translateStopProcStat(Process proc, State state, StopProcStat sps) {
		return '''
			«ReflexIdentifiers.PROC_STATES_ARRAY_NAME»[«getProcessId(proc)»] =  «proc.name.toUpperCase»«ReflexIdentifiers.STOP_STATE_ID_SUFFIX»;
		'''
	}

	def translateStartProcStat(Program prog, Process proc, State state, StartProcStat sps) {
		val matchingProcs = prog.processes.filter[proc.name.equals(sps.procId)].toList
		if(matchingProcs.isEmpty) return ''''''
		val procToStart = matchingProcs.get(0)
		return '''
			«ReflexIdentifiers.PROC_STATES_ARRAY_NAME»[«getProcessId(procToStart)»] =  «getStateId(procToStart, procToStart.states.get(0))»;
			«translateResetTimer(procToStart)»
		'''
	}

	def translateRestartProcStat(Process proc) {
		return '''
			«ReflexIdentifiers.PROC_STATES_ARRAY_NAME»[«getProcessId(proc)»] =  «getStateId(proc, proc.states.get(0))»
			«translateResetTimer(proc)»
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
		return '''«NodeModelUtils.getNode(expr).text.trim»'''
	}

}