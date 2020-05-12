package ru.iaie.reflex.utils;

@SuppressWarnings("all")
public class LiteralUtils {
  public static long parseInteger(final String literal) {
    final String intRepr = literal.toLowerCase();
    boolean _endsWith = intRepr.endsWith("l");
    if (_endsWith) {
      int _length = intRepr.length();
      int _minus = (_length - 2);
      return (Long.decode(intRepr.substring(0, _minus))).longValue();
    }
    boolean _endsWith_1 = intRepr.endsWith("u");
    if (_endsWith_1) {
      int _length_1 = intRepr.length();
      int _minus_1 = (_length_1 - 2);
      return (Integer.decode(intRepr.substring(0, _minus_1))).intValue();
    }
    return (Integer.decode(literal.toLowerCase())).intValue();
  }
  
  public static boolean hasUnsignedModifier(final String literal) {
    return (literal.endsWith("L") || literal.endsWith("l"));
  }
  
  public static boolean hasLongModifier(final String literal) {
    return (literal.endsWith("U") || literal.endsWith("u"));
  }
}
