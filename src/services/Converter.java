package services;

import beans.Essence;
import beans.Result;
import beans.Speed;
import beans.Time;
import beans.enums.SpeedUnits;
import exceptions.ConverterException;
import factories.EssenceFactory;
import services.interfaces.Service;
import support.comparators.SpeedComparator;
import support.comparators.SpeedUnitComparator;
import support.sections.ConverterServices;

import java.util.*;
import java.util.stream.Collectors;

import static support.Formatter.format;
import static support.sections.ConverterServices.isConverterService;

public class Converter implements Service {
    private List<String> strings;
    private List<Speed> list;

    /*public Converter(List<Speed> list) {
        this.list = list;
    }*/

    public Converter(List<String> strings) {
        this.strings = strings;
    }

    public List<Speed> speedsAsList() {
        return list;
    }

    public static String speedIn_ms(Essence essence) {
        return essence + " = " + format(SpeedUnits.unitIn_ms(castToSpeed(essence))) + " ms";
    }

    public List<Speed> getSortedSpeedsList() {
         return list.stream()
                    .sorted(new SpeedComparator())
                    .sorted(new SpeedUnitComparator())
                    .collect(Collectors.toList());
    }

    @Override
    public List<Result> action(Enum<?> service) {
        return strings.stream()
                      .map(s -> convert(s, service))
                      .collect(Collectors.toList());
    }

    private Result convert(String s, Enum<?> service) {
        Essence essence;
        String applied;
        try {
            essence = EssenceFactory.getEssence(s);
            applied = ConverterServices.getService(service).getFunction()
                    .apply(essence);
            return new Result(s, applied);
        } catch (ConverterException e) {
            return new Result(s, e);
        }
    }

    private static Speed castToSpeed(Essence essence) {
        try {
            return (Speed) essence;
        } catch (ClassCastException e) {
            throw new ConverterException("Conversion failed.");
        }
    }
}