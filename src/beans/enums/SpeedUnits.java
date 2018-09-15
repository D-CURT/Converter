package beans.enums;

import beans.Speed;

import java.util.Arrays;

public enum SpeedUnits {
    KMH("kmh", 1),
    MPH("mph", 2),
    KH("kn", 3),
    MS("ms", 4);

    private final String name;
    private final int priority;

    SpeedUnits(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public static SpeedUnits getUnit(String s) {
        return Arrays.stream(values()).filter(speedUnits -> speedUnits.name.equals(s)).findFirst().orElse(null);
    }

    public static double unitIn_ms(Speed speed) {
        switch (speed.getUnit().name) {
            case "kmh" : return speed.getIntValue() * 0.27777777777778;
            case "mph" : return speed.getIntValue() * 0.44704;
            case "kn" : return speed.getIntValue() * 0.51444444444;
            default : return speed.getIntValue();
        }
    }

    public int getPriority() {
        return priority;
    }

    public static boolean isSpeedUnit(String s) {
        return getUnit(s) != null;
    }
}
