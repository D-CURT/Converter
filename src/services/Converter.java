package services;

import beans.Distance;
import beans.Speed;
import beans.Time;
import beans.enums.SpeedUnits;
import beans.enums.TimeUnits;
import beans.factory.EssenceFactory;
import support.comparators.SpeedComparator;
import support.comparators.SpeedUnitComparator;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.stream.Collectors;

public class Converter {
    private List<Speed> list;
    private Time time;

    private Converter(List<Speed> list, Time time) {
        this.list = list;
        this.time = time;
    }

    public List<Speed> speedsAsList() {
        return list;
    }

    public String speedIn_ms(Speed speed) {
        return speed + " = " + format(SpeedUnits.unitIn_ms(speed.getValue(), speed.getUnit())) + "_in_ms";
    }

    public static Converter getConverter(List<String> lines) {
        List<Speed> list = new ArrayList<>();
        boolean firstLine = true;
        Time time = null;

        for (String line: lines) {
            if (firstLine) {
                time = (Time) EssenceFactory.getEssence(line);
                firstLine = false;
            } else list.add((Speed) EssenceFactory.getEssence(line));
        }

        return new Converter(list, time);
    }

    public List<Speed> getSortedSpeedsList() {
         return list.stream()
                 .sorted(new SpeedComparator())
                 .sorted(new SpeedUnitComparator())
                 .collect(Collectors.toList());
    }

    private Distance getDistance(Speed speed) {
        double value = SpeedUnits.unitIn_ms(speed.getValue(), speed.getUnit()) *
                TimeUnits.unitIn_s(time.getValue(), time.getUnit());
        return new Distance(format(value), "m");
    }

    private Distance[] getDistancesAsArray() {
        return list.stream()
                   .map(this::getDistance)
                   .toArray(Distance[]::new);
    }

    public Distance[] getSortedDistances(boolean reversed) {
        return reversed ? Arrays.stream(getDistancesAsArray())
                                .sorted()
                                .toArray(Distance[]::new)
                        : Arrays.stream(getDistancesAsArray())
                                .sorted(Collections.reverseOrder())
                                .toArray(Distance[]::new);
    }

    private String format(Double n) {
        String format;
        Locale locale = new Locale("en", "UK");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(locale);
        format = n % 1 == 0 ? "##0" : "##0.00";
        DecimalFormat df = new DecimalFormat(format, dfs);
        return df.format(n);
    }
}
