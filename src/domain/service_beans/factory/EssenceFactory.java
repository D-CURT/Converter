package domain.service_beans.factory;

import domain.service_beans.Distance;
import domain.service_beans.Essence;
import domain.service_beans.Speed;
import domain.service_beans.Time;
import utils.exceptions.ConverterException;

import static utils.unit_indentifires.DistanceUnits.isDistanceUnit;
import static utils.unit_indentifires.SpeedUnits.isSpeedUnit;
import static utils.unit_indentifires.TimeUnits.isTimeUnit;
import static utils.Constants.EMPTY;
import static utils.Constants.SPACE;

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
