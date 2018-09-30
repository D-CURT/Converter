package factories;

import beans.Distance;
import beans.Essence;
import beans.Speed;
import beans.Time;
import exceptions.ConverterException;

import static beans.enums.DistanceUnits.isDistanceUnit;
import static beans.enums.SpeedUnits.isSpeedUnit;
import static beans.enums.TimeUnits.isTimeUnit;
import static support.Constants.EMPTY;
import static support.Constants.SPACE;

public class EssenceFactory {
    public static Essence getEssence(String s) {
        validate(s);
        String[] fields = s.split(SPACE);
        if (isTimeUnit(fields[1])) return new Time(fields[0], fields[1]);
        if (isSpeedUnit(fields[1])) return new Speed(fields[0], fields[1]);
        if (isDistanceUnit(fields[1])) return new Distance(fields[0], fields[1]);
        throw new ConverterException("Unknown unit!");
    }

    private static void validate(String s) {
        if (s.equals(EMPTY)) throw new ConverterException("Input is empty!");
        if (!s.contains(SPACE)) throw new ConverterException("Unavailable format!");
    }
}
