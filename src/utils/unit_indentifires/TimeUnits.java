package utils.unit_indentifires;

import domain.Time;

import java.util.Arrays;

public enum TimeUnits {
    HOUR("h"),
    MIN("min"),
    SEC("sec");

    private final String name;

    TimeUnits(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static TimeUnits getUnit(String s) {
        return Arrays.stream(values()).filter(timeUnits -> timeUnits.name.equals(s)).findFirst().orElse(null);
    }

    public static double unitIn_s(Time time) {
        switch (time.getUnit().name) {
            case "h" : return time.getIntValue() * 3600;
            case "min" : return time.getIntValue() * 60;
            default : return time.getIntValue();
        }
    }

    public static boolean isTimeUnit(String s) {
        return getUnit(s) != null;
    }
}
