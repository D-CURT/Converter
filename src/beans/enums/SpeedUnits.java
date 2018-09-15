package beans.enums;

import beans.Speed;
import interfaces.UnitConversion;

import java.util.Arrays;

public enum SpeedUnits {
    KMH("kmh", n -> n * 0.27777777777778, 1),
    MPH("mph", n -> n * 0.44704, 2),
    KH("kn", n -> n * 0.51444444444, 3),
    MS("ms", n -> n,  4);

    private final String name;
    private final UnitConversion function;
    private final int priority;

    SpeedUnits(String name, UnitConversion function, int priority) {
        this.name = name;
        this.function = function;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public static SpeedUnits getUnit(String s) {
        return Arrays.stream(values()).filter(speedUnits -> speedUnits.name.equals(s)).findFirst().orElse(null);
    }

    public static double unitIn_ms(Speed speed) {
        return getUnit(speed.getUnit().name).function.convert(Double.parseDouble(speed.getValue()));
    }

    public int getPriority() {
        return priority;
    }

    public static boolean isSpeedUnit(String s) {
        return getUnit(s) != null;
    }
}
