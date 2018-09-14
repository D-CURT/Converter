package beans.enums;

import interfaces.UnitConversion;

import java.util.Arrays;

public enum SpeedUnits {
    KMH("kmh", n -> n * 0.27777777777778, 1),
    MPH("mph", n -> n * 0.44704, 2),
    KH("kh", n -> n * 0.51444444444, 3),
    MS("ms", n -> n,  4);

    private final String unit;
    private final UnitConversion function;
    private final int priority;

    SpeedUnits(String unit, UnitConversion function, int priority) {
        this.unit = unit;
        this.function = function;
        this.priority = priority;
    }

    public static SpeedUnits getUnit(String s) {
        return Arrays.stream(values()).filter(speedUnits -> speedUnits.unit.equals(s)).findFirst().orElse(null);
    }

    public static double unitIn_ms(String value, String unit) {
        return getUnit(unit).function.convert(Double.parseDouble(value));
    }

    public int getPriority() {
        return priority;
    }

    public static boolean isSpeedUnit(String s) {
        return getUnit(s) != null;
    }
}
