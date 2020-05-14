package ru.iaie.reflex.utils

class LiteralUtils {
	def static long parseInteger(String literal) {
		val intRepr = literal.toLowerCase 
		if (intRepr.endsWith("l")) {
			return Long.decode(intRepr.substring(0, intRepr.length - 2))
		}
		if (intRepr.endsWith("u")) {
			return Integer.decode(intRepr.substring(0, intRepr.length - 2))
		}
		return Integer.decode(literal.toLowerCase)
	}
	
	def static hasUnsignedModifier(String literal) {
		return literal.endsWith("L") || literal.endsWith("l") 
	}
	
	def static hasLongModifier(String literal) {
		return literal.endsWith("U") || literal.endsWith("u") 
	}
//	
//	def static long parseTime(String literal) {
//		
//	}
}