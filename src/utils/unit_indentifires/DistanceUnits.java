package utils.unit_indentifires;

import java.util.Arrays;

public enum DistanceUnits {
    KILOMETER("km"),
    MILE("ml"),
    KNOT("kt"),
    METER("m");

    private final String name;

    DistanceUnits(String name) {
        this.name = name;
    }

    public static DistanceUnits getUnit(String s) {
        return Arrays.stream(values())
                     .filter(distanceUnits -> distanceUnits.name.equals(s))
                     .findFirst()
                     .orElse(null);
    }

    public static boolean isDistanceUnit(String s) {
        return getUnit(s) != null;
    }
}
