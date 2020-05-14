package ru.iaie.reflex.typing

import ru.iaie.reflex.reflex.Type
import java.util.Set
import java.util.Map
import ru.iaie.reflex.reflex.EnumMember

class TypeUtils {
	static val Set<Type> UNSIGNED_TYPES = newHashSet(Type.INT8_U, Type.INT16_U, Type.INT32_U, Type.INT64_U)
	static val Set<Type> INT_TYPES = newHashSet(Type.INT8_U, Type.INT16_U, Type.INT32_U, Type.INT64_U, Type.INT8,
		Type.INT16, Type.INT32, Type.INT64, Type.TIME)
		
	static val Map<Type, Integer> TYPE_ORDER = newHashMap(
		Type.BOOL     -> 0,
		Type.INT8     -> 1,
		Type.INT8_U   -> 2,
		Type.INT16    -> 3,
		Type.INT16_U  -> 4,
		Type.INT32    -> 5,
		Type.INT32_U  -> 6,
		Type.TIME     -> 6,
		Type.INT64    -> 7,
		Type.INT64_U  -> 8,
		Type.FLOAT    -> 9,
		Type.DOUBLE   -> 10
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
		return true
	}
	
	def static boolean canBeSafelySignedTo(Type from, Type to) {
		return TYPE_ORDER.get(from) <= TYPE_ORDER.get(to)
	}
	
	def static Type getDefaultIntLiteralType() {
		return Type.INT8
	}
	
	def static Type getDefaultTimeLiteralType() {
		return Type.INT32_U
	}
	
	def static Type getDefaultType(EnumMember em) {
		return Type.INT32
	}
	
	def static Type getDefaultFloatLiteralType() {
		return Type.FLOAT
	}
	
	def static Type max(Type t1, Type t2) {
		return (TYPE_ORDER.get(t1) >= TYPE_ORDER.get(t2)) ? t1 : t2;
	}
	
}
