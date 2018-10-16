package beans.enums;

import java.util.Arrays;

public enum SpeedUnits {
    KMH("kmh"),
    MPH("mph"),
    KH("kn"),
    MS("ms");

    private final String name;

    SpeedUnits(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static SpeedUnits getUnit(String s) {
        return Arrays.stream(values())
                     .filter(speedUnits -> speedUnits.name.equals(s))
                     .findFirst()
                     .orElse(null);
    }

    public static boolean isSpeedUnit(String s) {
        return getUnit(s) != null;
    }
}
