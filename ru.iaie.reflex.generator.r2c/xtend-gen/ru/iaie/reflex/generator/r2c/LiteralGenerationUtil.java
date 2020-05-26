package ru.iaie.reflex.generator.r2c;

import org.eclipse.xtend2.lib.StringConcatenation;
import ru.iaie.reflex.reflex.ClockDefinition;
import ru.iaie.reflex.reflex.Type;
import ru.iaie.reflex.utils.LiteralUtils;
import ru.iaie.reflex.utils.ReflexModelUtil;

@SuppressWarnings("all")
public class LiteralGenerationUtil {
  public static String translateTime(final String timeLiteral) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(INT32_U) ");
    long _parseTime = LiteralUtils.parseTime(timeLiteral);
    _builder.append(_parseTime);
    _builder.append("UL");
    return _builder.toString();
  }
  
  public static String translateType(final Type t) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = t.getName();
    _builder.append(_name);
    return _builder.toString();
  }
  
  public static String translateBoolLiteral(final Boolean l) {
    String _xifexpression = null;
    boolean _booleanValue = l.booleanValue();
    if (_booleanValue) {
      _xifexpression = "TRUE";
    } else {
      _xifexpression = "FALSE";
    }
    return _xifexpression;
  }
  
  public static String translateClockDefinition(final ClockDefinition clock) {
    boolean _hasTimeFormat = ReflexModelUtil.hasTimeFormat(clock);
    if (_hasTimeFormat) {
      return LiteralGenerationUtil.translateTime(clock.getTimeValue());
    }
    return clock.getIntValue();
  }
}
