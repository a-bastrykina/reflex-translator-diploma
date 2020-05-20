package ru.iaie.reflex.typing

import ru.iaie.reflex.reflex.Type
import java.util.Set
import java.util.Map
import ru.iaie.reflex.reflex.EnumMember

class TypeUtils {
	static val Set<Type> UNSIGNED_TYPES = newHashSet(Type.INT8_U, Type.INT16_U, Type.INT32_U, Type.INT64_U)
	static val Set<Type> INT_TYPES = newHashSet(Type.INT8_U, Type.INT16_U, Type.INT32_U, Type.INT64_U, Type.INT8,
		Type.INT16, Type.INT32, Type.INT64, Type.TIME)
	static val Set<Type> FLOAT_TYPES = newHashSet(Type.FLOAT, Type.DOUBLE);

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
	
	static val Map<Type, Integer> INT_TYPE_SIZES = newHashMap(
		Type.INT8     -> 8,
		Type.INT8_U   -> 8,
		Type.INT16    -> 16,
		Type.INT16_U  -> 16,
		Type.INT32    -> 32,
		Type.INT32_U  -> 32,
		Type.TIME     -> 32,
		Type.INT64    -> 64,
		Type.INT64_U  -> 64
	) 

	def static boolean isUnsigned(Type type) {
		return UNSIGNED_TYPES.contains(type)
	}

	def static boolean isIntType(Type type) {
		return INT_TYPES.contains(type)
	}
	
	def static boolean isFloatType(Type type) {
		return FLOAT_TYPES.contains(type)
	}
	
	def static boolean isBoolType(Type type) {
		return type == Type.BOOL
	}
	
	def static int getSize(Type type) {
		if (isIntType(type)) {
			return INT_TYPE_SIZES.get(type)
		}
		throw new IllegalArgumentException('''Type size is undefined for «type»''');
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
		if (t1.isIntType && t2.isIntType) {
			if (t1.size == t2.size) {
				if (t1.signed) return t1;
				if (t2.signed) return t2;
			}
		}
		return (TYPE_ORDER.get(t1) >= TYPE_ORDER.get(t2)) ? t1 : t2;
	}
	
	def static isCompitableInArithmeticExpression(Type t1, Type t2) {
		if (t1.isIntType && t2.isIntType) return true;
		if (t1.isFloatType && t2.isFloatType) return true;
		if (t1.isBoolType && t2.isBoolType) return true;
	}
		
	def static isCompitableInLogicalExpression(Type t1, Type t2) {
		return true;
	}
	
	enum OperationType {
		ARITHMETIC, LOGICAL, BIT, COMPARE, EQ
	}
	
	static def doUnaryTypeChecking(OperationType opType, Type type) {
		switch opType {
			case ARITHMETIC: {
				type.isBoolType throw new TypeIssue("Arithmetic operation on boolean type")
			}
			case LOGICAL: {}
			case BIT: {}
			case COMPARE: {}
			case EQ: {}
		}
	}

	static def doBinaryTypeChecking(OperationType opType, Type type1, Type type2) {
		switch opType {
			case ARITHMETIC: {
				if (type1.isBoolType || type2.isBoolType) { 
					throw new TypeIssue("Arithmetic operation on boolean type")
				}
				if ((type1.isIntType && type2.isFloatType) || (type2.isIntType && type1.isFloatType)) { 
					throw new TypeIssue("Arithmetic operation between float and integer type")
				}
			}
			case COMPARE: {
				if (type1.isBoolType || type2.isBoolType) { 
					throw new TypeIssue("Comparison operation on boolean type")
				}
			}
			case EQ: {
				if ((type1.isIntType && type2.isFloatType) || (type2.isIntType && type1.isFloatType)) { 
					throw new TypeIssue("Equality operation between float and integer type")
				}
			}
			case LOGICAL: {}
			case BIT: {}
		}
	}
	
	static class TypeIssue extends Exception {
		new (String message) {
			super(message)
		}	
	}
	
}
