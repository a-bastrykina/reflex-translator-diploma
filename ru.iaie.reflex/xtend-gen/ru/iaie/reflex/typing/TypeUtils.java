package ru.iaie.reflex.typing;

import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import ru.iaie.reflex.reflex.EnumMember;
import ru.iaie.reflex.reflex.Type;

@SuppressWarnings("all")
public class TypeUtils {
  private static final Set<Type> UNSIGNED_TYPES = CollectionLiterals.<Type>newHashSet(Type.INT8_U, Type.INT16_U, Type.INT32_U, Type.INT64_U);
  
  private static final Set<Type> INT_TYPES = CollectionLiterals.<Type>newHashSet(Type.INT8_U, Type.INT16_U, Type.INT32_U, Type.INT64_U, Type.INT8, 
    Type.INT16, Type.INT32, Type.INT64, Type.TIME);
  
  private static final Map<Type, Integer> TYPE_ORDER = CollectionLiterals.<Type, Integer>newHashMap(
    Pair.<Type, Integer>of(Type.BOOL, Integer.valueOf(0)), 
    Pair.<Type, Integer>of(Type.INT8, Integer.valueOf(1)), 
    Pair.<Type, Integer>of(Type.INT8_U, Integer.valueOf(2)), 
    Pair.<Type, Integer>of(Type.INT16, Integer.valueOf(3)), 
    Pair.<Type, Integer>of(Type.INT16_U, Integer.valueOf(4)), 
    Pair.<Type, Integer>of(Type.INT32, Integer.valueOf(5)), 
    Pair.<Type, Integer>of(Type.INT32_U, Integer.valueOf(6)), 
    Pair.<Type, Integer>of(Type.TIME, Integer.valueOf(6)), 
    Pair.<Type, Integer>of(Type.INT64, Integer.valueOf(7)), 
    Pair.<Type, Integer>of(Type.INT64_U, Integer.valueOf(8)), 
    Pair.<Type, Integer>of(Type.FLOAT, Integer.valueOf(9)), 
    Pair.<Type, Integer>of(Type.DOUBLE, Integer.valueOf(10)));
  
  public static boolean isUnsigned(final Type type) {
    return TypeUtils.UNSIGNED_TYPES.contains(type);
  }
  
  public static boolean isIntType(final Type type) {
    return TypeUtils.INT_TYPES.contains(type);
  }
  
  public static boolean isSigned(final Type type) {
    boolean _isUnsigned = TypeUtils.isUnsigned(type);
    return (!_isUnsigned);
  }
  
  public static boolean canBeSafelyCastedTo(final Type from, final Type to) {
    return true;
  }
  
  public static boolean canBeSafelySignedTo(final Type from, final Type to) {
    Integer _get = TypeUtils.TYPE_ORDER.get(from);
    Integer _get_1 = TypeUtils.TYPE_ORDER.get(to);
    return (_get.compareTo(_get_1) <= 0);
  }
  
  public static Type getDefaultIntLiteralType() {
    return Type.INT8;
  }
  
  public static Type getDefaultTimeLiteralType() {
    return Type.INT32_U;
  }
  
  public static Type getDefaultType(final EnumMember em) {
    return Type.INT32;
  }
  
  public static Type getDefaultFloatLiteralType() {
    return Type.FLOAT;
  }
  
  public static Type max(final Type t1, final Type t2) {
    Type _xifexpression = null;
    Integer _get = TypeUtils.TYPE_ORDER.get(t1);
    Integer _get_1 = TypeUtils.TYPE_ORDER.get(t2);
    boolean _greaterEqualsThan = (_get.compareTo(_get_1) >= 0);
    if (_greaterEqualsThan) {
      _xifexpression = t1;
    } else {
      _xifexpression = t2;
    }
    return _xifexpression;
  }
}
