package services;

import beans.Result;
import beans.Speed;
import beans.enums.SpeedUnits;
import services.interfaces.Service;
import support.comparators.SpeedComparator;
import support.comparators.SpeedUnitComparator;
import support.sections.Operations;
import support.sections.Services;

import java.util.*;
import java.util.stream.Collectors;

import static support.Formatter.format;

public class Converter implements Service {
    private List<Speed> list;

    public Converter(List<Speed> list) {
        this.list = list;
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

    @Override
    public Result action(Services section, Operations service) {
        return null;
    }
}