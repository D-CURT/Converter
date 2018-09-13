package beans.enums;

import java.util.Arrays;

public enum TimeUnits {
    H("h"),
    M("m"),
    S("s");

    private final String unit;

    TimeUnits(String unit) {
        this.unit = unit;
    }

    public static TimeUnits getUnit(String s) {
        return Arrays.stream(values()).filter(timeUnits -> timeUnits.unit.equals(s)).findFirst().orElse(null);
    }

    public static boolean isTimeUnit(String s) {
        return getUnit(s) != null;
    }
}
