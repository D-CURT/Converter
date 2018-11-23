package utils.unit_indentifires;

import utils.Constants;

import java.util.Arrays;

public enum SpeedUnits {
    KMH(Constants.KMH),
    MPH(Constants.MPH),
    KH(Constants.KN),
    MS(Constants.MS);

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
