package ru.iaie.reflex.utils;

import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import ru.iaie.reflex.reflex.Type;

@SuppressWarnings("all")
public class TypeUtils {
  private static final Set<Type> UNSIGNED_TYPES = CollectionLiterals.<Type>newHashSet(Type.INT8_U, Type.INT16_U, Type.INT32_U, Type.INT64_U);
  
  private static final Set<Type> INT_TYPES = CollectionLiterals.<Type>newHashSet(Type.INT8_U, Type.INT16_U, Type.INT32_U, Type.INT64_U, Type.INT8, 
    Type.INT16, Type.INT32, Type.INT64);
  
  private static final Set<Pair<Type, Type>> ALLOWED_CASTS = CollectionLiterals.<Pair<Type, Type>>newHashSet(
    Pair.<Type, Type>of(Type.INT8, Type.INT16), 
    Pair.<Type, Type>of(Type.INT16, Type.INT32), 
    Pair.<Type, Type>of(Type.INT32, Type.INT64), 
    Pair.<Type, Type>of(Type.INT8_U, Type.INT16_U), 
    Pair.<Type, Type>of(Type.INT16_U, Type.INT32_U), 
    Pair.<Type, Type>of(Type.INT32_U, Type.INT64_U), 
    Pair.<Type, Type>of(Type.FLOAT, Type.DOUBLE));
  
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
  
  public static boolean canBeCastedTo(final Type from, final Type to) {
    Pair<Type, Type> _mappedTo = Pair.<Type, Type>of(from, to);
    return TypeUtils.ALLOWED_CASTS.contains(_mappedTo);
  }
}
