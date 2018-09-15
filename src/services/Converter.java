package services;

import beans.Distance;
import beans.Essence;
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
        return speed + " = " + format(SpeedUnits.unitIn_ms(speed)) + "_in_ms";
    }

    public static Converter getConverter(List<String> lines) {
        List<Speed> list = new ArrayList<>();
        boolean firstLine = true;
        Essence essence;
        Time time = null;

        for (String line: lines) {
            essence = EssenceFactory.getEssence(line);
            if (firstLine) {
                time = (Time) essence;
                firstLine = false;
            } else list.add((Speed) essence);
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
        double value = SpeedUnits.unitIn_ms(speed) * TimeUnits.unitIn_s(time);
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
        final String empty = "";
        String pattern0 = "##0";
        String pattern1 = "##0.0";
        String pattern2 = "##0.00";
        Locale locale = new Locale("en", "UK");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(locale);
        format = n % 1 == 0 ? pattern0 : pattern2;
        DecimalFormat df = new DecimalFormat(format, dfs);
        String tmp = df.format(n);
        n = Double.parseDouble(tmp);
        format = (n * 1000 % 1000) < 5 ? pattern0 : (n * 1000 % 100) < 5 ? pattern1 : empty;
        if (format.equals(empty)) return tmp;
        else {
            df.applyPattern(format);
            return df.format(n);
        }
    }
}