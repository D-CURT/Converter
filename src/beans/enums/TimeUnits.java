package beans.enums;

import interfaces.UnitConversion;

import java.util.Arrays;

public enum TimeUnits {
    H("h", n -> n * 3600),
    M("m", n -> n * 60),
    S("s", n -> n);

    private final String unit;
    private final UnitConversion function;

    TimeUnits(String unit, UnitConversion function) {
        this.unit = unit;
        this.function = function;
    }

    public static TimeUnits getUnit(String s) {
        return Arrays.stream(values()).filter(timeUnits -> timeUnits.unit.equals(s)).findFirst().orElse(null);
    }

    public static double unitAs_s(String value, String unit) {
        return getUnit(unit).function.convert(Double.parseDouble(value));
    }

    public static boolean isTimeUnit(String s) {
        return getUnit(s) != null;
    }
}
