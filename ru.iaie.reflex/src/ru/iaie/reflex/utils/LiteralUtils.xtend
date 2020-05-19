package ru.iaie.reflex.utils

class LiteralUtils {
	static val MILLIS_PER_SECOND = 1000;
	static val MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;
	static val MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;
	static val MILLIS_PER_DAY = 24 * MILLIS_PER_HOUR;

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

	def static long parseTime(String literal) {
		var rest = literal.toLowerCase.substring(2, literal.length)
		var int index;
		var long millis = 0;

		if ((index = rest.indexOf("d")) > 0) {
			val dayCount = parseInteger(rest.substring(0, index))
			millis += dayCount * MILLIS_PER_DAY;
			if(index == rest.length - 1) return millis;
			rest = rest.substring(index + 1, rest.length)
		}

		if ((index = rest.indexOf("h")) > 0) {
			val dayCount = parseInteger(rest.substring(0, index))
			millis += dayCount * MILLIS_PER_DAY;
			if(index == rest.length - 1) return millis;
			rest = rest.substring(index + 1, rest.length)
		}

		if ((index = rest.indexOf("m")) > 0) {
			if (index != rest.length - 1 && !rest.charAt(index + 1).toString.equals("s")) {
				val minCount = parseInteger(rest.substring(0, index))
				millis += minCount * MILLIS_PER_MINUTE;
				if(index == rest.length - 1) return millis;
				rest = rest.substring(index + 1, rest.length)
			}
		}

		if ((index = rest.indexOf("s")) > 0) {
			if (!rest.charAt(index - 1).toString.equals("m")) {
				val secCount = parseInteger(rest.substring(0, index))
				millis += secCount * MILLIS_PER_SECOND;
				if(index == rest.length - 1) return millis;
				rest = rest.substring(index + 1, rest.length)
			}
		}

		if ((index = rest.indexOf("ms")) > 0) {
			val msCount = parseInteger(rest.substring(0, index))
			millis += msCount;
		}

		return millis;
	}
}
