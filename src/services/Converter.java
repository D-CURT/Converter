package services;

import beans.Essence;
import beans.Result;
import beans.Speed;
import beans.enums.SpeedUnits;
import exceptions.ConverterException;
import factories.EssenceFactory;
import services.interfaces.Service;
import support.comparators.ResultComparator;
import support.comparators.GroupComparator;

import java.util.*;
import java.util.stream.Collectors;

import static support.Formatter.format;
import static support.sections.ConverterServices.getService;

public class Converter implements Service {
    private List<String> strings;

    public Converter(List<String> strings) {
        this.strings = strings;
    }

    public static Result speedIn_ms(Essence essence) {
        if (essence instanceof Speed) {

            Speed speed = (Speed) essence;
            return new Result(speed.toString(), format(SpeedUnits.unitIn_ms(speed)),
                    "ms", SpeedUnits.getUnit(speed.getUnit().getName()).ordinal());
        }
        throw new ConverterException("Conversion failed!");
    }

    private List<Result> getSortedResults(List<Result> list) {
         return list.stream()
                    .sorted(new ResultComparator())
                    .sorted(new GroupComparator())
                    .collect(Collectors.toList());
    }

    @Override
    public List<Result> action(Enum<?> service) {
        return getSortedResults(strings.stream()
                      .map(s -> convert(s, service))
                      .collect(Collectors.toList()));
    }

    private Result convert(String s, Enum<?> service) {
        Essence essence;
        try {
            essence = EssenceFactory.getEssence(s);
            return getService(service).getFunction().apply(essence);
        } catch (ConverterException e) {
            return new Result(s, e.getMessage());
        }
    }
}