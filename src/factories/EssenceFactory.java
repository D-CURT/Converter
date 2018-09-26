package factories;

import beans.Distance;
import beans.Essence;
import beans.Speed;
import beans.Time;

import static beans.enums.SpeedUnits.isSpeedUnit;
import static beans.enums.TimeUnits.isTimeUnit;

public class EssenceFactory {
    public static Essence getEssence(String s) {
        String[] fields = s.split(" ");
        return (isTimeUnit(fields[1])) ? new Time(fields[0], fields[1]) :
                isSpeedUnit(fields[1]) ? new Speed(fields[0], fields[1])
                        : new Distance(fields[0], fields[1]);
    }
}
