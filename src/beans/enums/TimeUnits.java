package beans.enums;

import interfaces.UnitConversion;

import java.util.Arrays;

public enum TimeUnits {
    H("h", n -> n * 3600),
    M("m", n -> n * 60),
    S("s", n -> n);

    private final String value;
    private final UnitConversion function;

    TimeUnits(String value, UnitConversion function) {
        this.value = value;
        this.function = function;
    }

    public String getValue() {
        return value;
    }

    public static TimeUnits getUnit(String s) {
        return Arrays.stream(values()).filter(timeUnits -> timeUnits.value.equals(s)).findFirst().orElse(null);
    }

    public static double unitIn_s(String value, String unit) {
        return getUnit(unit).function.convert(Double.parseDouble(value));
    }

    public static boolean isTimeUnit(String s) {
        return getUnit(s) != null;
    }
}
