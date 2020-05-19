package ru.iaie.reflex.utils;

@SuppressWarnings("all")
public class LiteralUtils {
  private static final int MILLIS_PER_SECOND = 1000;
  
  private static final int MILLIS_PER_MINUTE = (60 * LiteralUtils.MILLIS_PER_SECOND);
  
  private static final int MILLIS_PER_HOUR = (60 * LiteralUtils.MILLIS_PER_MINUTE);
  
  private static final int MILLIS_PER_DAY = (24 * LiteralUtils.MILLIS_PER_HOUR);
  
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
  
  public static long parseTime(final String literal) {
    String rest = literal.toLowerCase().substring(2, literal.length());
    int index = 0;
    long millis = 0;
    if (((index = rest.indexOf("d")) > 0)) {
      final long dayCount = LiteralUtils.parseInteger(rest.substring(0, index));
      long _millis = millis;
      millis = (_millis + (dayCount * LiteralUtils.MILLIS_PER_DAY));
      int _length = rest.length();
      int _minus = (_length - 1);
      boolean _equals = (index == _minus);
      if (_equals) {
        return millis;
      }
      rest = rest.substring((index + 1), rest.length());
    }
    if (((index = rest.indexOf("h")) > 0)) {
      final long dayCount_1 = LiteralUtils.parseInteger(rest.substring(0, index));
      long _millis_1 = millis;
      millis = (_millis_1 + (dayCount_1 * LiteralUtils.MILLIS_PER_DAY));
      int _length_1 = rest.length();
      int _minus_1 = (_length_1 - 1);
      boolean _equals_1 = (index == _minus_1);
      if (_equals_1) {
        return millis;
      }
      rest = rest.substring((index + 1), rest.length());
    }
    if (((index = rest.indexOf("m")) > 0)) {
      if (((index != (rest.length() - 1)) && (!Character.valueOf(rest.charAt((index + 1))).toString().equals("s")))) {
        final long minCount = LiteralUtils.parseInteger(rest.substring(0, index));
        long _millis_2 = millis;
        millis = (_millis_2 + (minCount * LiteralUtils.MILLIS_PER_MINUTE));
        int _length_2 = rest.length();
        int _minus_2 = (_length_2 - 1);
        boolean _equals_2 = (index == _minus_2);
        if (_equals_2) {
          return millis;
        }
        rest = rest.substring((index + 1), rest.length());
      }
    }
    if (((index = rest.indexOf("s")) > 0)) {
      boolean _equals_3 = Character.valueOf(rest.charAt((index - 1))).toString().equals("m");
      boolean _not = (!_equals_3);
      if (_not) {
        final long secCount = LiteralUtils.parseInteger(rest.substring(0, index));
        long _millis_3 = millis;
        millis = (_millis_3 + (secCount * LiteralUtils.MILLIS_PER_SECOND));
        int _length_3 = rest.length();
        int _minus_3 = (_length_3 - 1);
        boolean _equals_4 = (index == _minus_3);
        if (_equals_4) {
          return millis;
        }
        rest = rest.substring((index + 1), rest.length());
      }
    }
    if (((index = rest.indexOf("ms")) > 0)) {
      final long msCount = LiteralUtils.parseInteger(rest.substring(0, index));
      long _millis_4 = millis;
      millis = (_millis_4 + msCount);
    }
    return millis;
  }
}
