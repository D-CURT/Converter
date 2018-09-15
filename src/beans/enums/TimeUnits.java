package beans.enums;

import beans.Time;
import interfaces.UnitConversion;

import java.util.Arrays;

public enum TimeUnits {
    H("h", n -> n * 3600),
    M("m", n -> n * 60),
    S("s", n -> n);

    private final String name;
    private final UnitConversion function;

    TimeUnits(String name, UnitConversion function) {
        this.name = name;
        this.function = function;
    }

    public String getName() {
        return name;
    }

    public static TimeUnits getUnit(String s) {
        return Arrays.stream(values()).filter(timeUnits -> timeUnits.name.equals(s)).findFirst().orElse(null);
    }

    public static double unitIn_s(Time time) {
        return getUnit(time.getUnit().name).function.convert(Double.parseDouble(time.getValue()));
    }

    public static boolean isTimeUnit(String s) {
        return getUnit(s) != null;
    }
}
