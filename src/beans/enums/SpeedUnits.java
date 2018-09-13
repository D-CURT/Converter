package beans.enums;

import interfaces.SpeedConversion;

import java.util.Arrays;

public enum SpeedUnits {
    MPH("mph", n -> n * 0.44704),
    KMH("kmh", n -> n * 0.27777777777778),
    KH("kh", n -> n * 0.51444444444),
    MS("ms", n -> n);

    private final String unit;
    private final SpeedConversion function;

    SpeedUnits(String unit, SpeedConversion function) {
        this.unit = unit;
        this.function = function;
    }

    public static SpeedUnits getUnit(String s) {
        return Arrays.stream(values()).filter(speedUnits -> speedUnits.unit.equals(s)).findFirst().orElse(null);
    }

    public static double unitAs_ms(String value, String unit) {
        return getUnit(unit).function.convert(Double.parseDouble(value));
    }

    public static boolean isSpeedUnit(String s) {
        return getUnit(s) != null;
    }
}
