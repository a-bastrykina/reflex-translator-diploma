package ru.iaie.reflex.typing

import ru.iaie.reflex.reflex.Type
import java.util.Set

class TypeUtils {
	static val Set<Type> UNSIGNED_TYPES = newHashSet(Type.INT8_U, Type.INT16_U, Type.INT32_U, Type.INT64_U)
	static val Set<Type> INT_TYPES = newHashSet(Type.INT8_U, Type.INT16_U, Type.INT32_U, Type.INT64_U, Type.INT8,
		Type.INT16, Type.INT32, Type.INT64)
		
	static val Set<Pair<Type, Type>>  ALLOWED_CASTS = newHashSet(
		Type.INT8 -> Type.INT16,
		Type.INT16 -> Type.INT32,
		Type.INT32 -> Type.INT64,
		Type.INT8_U -> Type.INT16_U,
		Type.INT16_U -> Type.INT32_U,
		Type.INT32_U -> Type.INT64_U,
		Type.FLOAT -> Type.DOUBLE
	) 

	def static boolean isUnsigned(Type type) {
		return UNSIGNED_TYPES.contains(type)
	}

	def static boolean isIntType(Type type) {
		return INT_TYPES.contains(type)
	}

	def static boolean isSigned(Type type) {
		return !isUnsigned(type)
	}
	
	def static boolean canBeSafelyCastedTo(Type from, Type to) {
		return ALLOWED_CASTS.contains(from -> to)
	}
}
