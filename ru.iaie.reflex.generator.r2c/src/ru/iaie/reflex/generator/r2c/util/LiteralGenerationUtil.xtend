package ru.iaie.reflex.generator.r2c.util

import ru.iaie.reflex.utils.LiteralUtils
import ru.iaie.reflex.reflex.Type
import ru.iaie.reflex.reflex.ClockDefinition
import static extension ru.iaie.reflex.utils.ReflexModelUtil.*


class LiteralGenerationUtil {
		
	def static translateTime(String timeLiteral) {
		return '''(INT32_U) «LiteralUtils.parseTime(timeLiteral)»UL'''
	}
	
	def static translateType(Type t) {
		return '''«t.getName()»'''
	}
	
	def static translateBoolLiteral(Boolean l) {
		return l.booleanValue ? "TRUE" : "FALSE"
	}
	
	def static translateClockDefinition(ClockDefinition clock) {
		if (clock.hasTimeFormat) {
			return LiteralGenerationUtil.translateTime(clock.timeValue)
		} 
		return clock.intValue
	}
	
}