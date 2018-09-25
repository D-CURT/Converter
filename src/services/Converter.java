package services;

import beans.Speed;
import beans.Time;
import beans.enums.SpeedUnits;
import support.comparators.SpeedComparator;
import support.comparators.SpeedUnitComparator;

import java.util.*;
import java.util.stream.Collectors;

import static support.TextFormatter.format;

public class Converter {
    private List<Speed> list;
    private Time time;

    public Converter(List<Speed> list, Time time) {
        this.list = list;
        this.time = time;
    }

    public List<Speed> speedsAsList() {
        return list;
    }

    public String speedIn_ms(Speed speed) {
        return speed + " = " + format(SpeedUnits.unitIn_ms(speed)) + " ms";
    }

    public List<Speed> getSortedSpeedsList() {
         return list.stream()
                 .sorted(new SpeedComparator())
                 .sorted(new SpeedUnitComparator())
                 .collect(Collectors.toList());
    }
}