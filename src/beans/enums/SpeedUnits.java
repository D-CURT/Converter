package beans.enums;

import java.util.Arrays;

public enum SpeedUnits {
    MPH("mph"),
    KMH("kmh"),
    KH("kh"),
    MS("ms");

    private final String unit;

    SpeedUnits(String unit) {
        this.unit = unit;
    }

    public static SpeedUnits getUnit(String s) {
        return Arrays.stream(values()).filter(speedUnits -> speedUnits.unit.equals(s)).findFirst().orElse(null);
    }

    public static boolean isSpeedUnit(String s) {
        return getUnit(s) != null;
    }
}
