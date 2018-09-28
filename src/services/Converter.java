package services;

import beans.Result;
import beans.Speed;
import beans.enums.SpeedUnits;
import exceptions.ConverterException;
import services.interfaces.Service;
import support.comparators.SpeedComparator;
import support.comparators.SpeedUnitComparator;
import support.sections.ConverterServices;

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

    public static String speedIn_ms(Speed speed) {
        return speed + " = " + format(SpeedUnits.unitIn_ms(speed)) + " ms";
    }

    public List<Speed> getSortedSpeedsList() {
         return list.stream()
                    .sorted(new SpeedComparator())
                    .sorted(new SpeedUnitComparator())
                    .collect(Collectors.toList());
    }

    @Override
    public List<Result> action(Enum<?> service) {
        List<Result> results = new ArrayList<>();
        String applied;
        Result result;
        for (Speed speed: getSortedSpeedsList()) {
            try {
                applied = (String) ConverterServices.getService(service).getFunction().apply(speed);
                result = new Result(speed.toString(), applied);
            } catch (ConverterException e) {
                result = new Result(speed.toString(), e);
            }
            results.add(result);
        }
        return results;
    }
}