package services;

import beans.Essence;
import beans.Result;
import beans.Speed;
import beans.enums.SpeedUnits;
import exceptions.ConverterException;
import factories.EssenceFactory;
import services.interfaces.Service;
import support.DataReader;
import support.comparators.ResultComparator;
import support.comparators.GroupComparator;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static support.Formatter.format;

public class Converter implements Service {
    private List<String> strings;

    public Converter() {
    }

    public Converter(List<String> strings) {
        this.strings = strings;
    }

    private Result speedTo_kmh(Essence essence) {
        if (essence instanceof Speed) {

            Speed speed = (Speed) essence;
            SpeedUnits unit = speed.getUnit();
            return new Result(speed.toString(),
                    format(SpeedUnitConversion.toKMH(speed)),
                    "kmh", SpeedUnits.getUnit(unit.getName()).ordinal());
        }
        throw new ConverterException("Conversion failed!");
    }

    private Result speedTo_mph(Essence essence) {
        if (essence instanceof Speed) {

            Speed speed = (Speed) essence;
            SpeedUnits unit = speed.getUnit();
            return new Result(speed.toString(),
                    format(SpeedUnitConversion.toMPH(speed)),
                    "mph", SpeedUnits.getUnit(unit.getName()).ordinal());
        }
        throw new ConverterException("Conversion failed!");
    }

    private Result speedTo_kn(Essence essence) {
        if (essence instanceof Speed) {

            Speed speed = (Speed) essence;
            SpeedUnits unit = speed.getUnit();
            return new Result(speed.toString(),
                    format(SpeedUnitConversion.toKN(speed)),
                    "kn", SpeedUnits.getUnit(unit.getName()).ordinal());
        }
        throw new ConverterException("Conversion failed!");
    }

    private Result speedTo_ms(Essence essence) {
        if (essence instanceof Speed) {

            Speed speed = (Speed) essence;
            SpeedUnits unit = speed.getUnit();
            return new Result(speed.toString(),
                       format(SpeedUnitConversion.toMS(speed)),
                      "ms", SpeedUnits.getUnit(unit.getName()).ordinal());
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
    public List<Result> action(Enum<?> service) throws IOException {
        return getSortedResults(strings.stream()
                      .map(s -> convert(s, service))
                      .collect(Collectors.toList()));
    }

    private Result convert(String s, Enum<?> service) {
        Essence essence;
        boolean speeds = service.getClass() == SpeedUnitConversion.class;
        try {
            essence = EssenceFactory.getEssence(s);
            switch (service.ordinal()) {
                case 0: return speeds ? speedTo_kmh(essence) : speedTo_ms(essence);
                case 1: return speeds ? speedTo_mph(essence) : speedTo_ms(essence);
                case 2: return speeds ? speedTo_kn(essence) : speedTo_ms(essence);
                case 3: return speeds ? speedTo_ms(essence) : speedTo_ms(essence);
                default: throw new ConverterException("Operation is not agreed!");
            }

        } catch (ConverterException e) {
            return new Result(s, e.getMessage());
        }
    }

    public enum SpeedUnitConversion {
        KMH(SpeedUnits.KMH,
            Speed::getDoubleValue, speed -> speed.getDoubleValue() / 1.609,
            speed -> speed.getDoubleValue() / 1.852,
            speed -> speed.getDoubleValue() * 3600 / 1000),
        MPH(SpeedUnits.MPH,
            speed -> speed.getDoubleValue() * 1.609, Speed::getDoubleValue,
            speed -> speed.getDoubleValue() * 1.151,
            speed -> speed.getDoubleValue() * 3600 / 1609),
        KN(SpeedUnits.KH,
            speed -> speed.getDoubleValue() * 1.852,
            speed -> speed.getDoubleValue() / 1.151,
            Speed::getDoubleValue, speed -> speed.getDoubleValue() * 3600 / 1852),
        MS(SpeedUnits.MS,
            speed -> speed.getDoubleValue() / 3600 * 1000,
            speed -> speed.getDoubleValue() / 3600 * 1609,
            speed -> speed.getDoubleValue() / 3600 * 1852, Speed::getDoubleValue);

        private final SpeedUnits identifier;
        private final Function<Speed, Double> toKMH;
        private final Function<Speed, Double> toMPH;
        private final Function<Speed, Double> toKN;
        private final Function<Speed, Double> toMS;

        SpeedUnitConversion(SpeedUnits identifier,
                            Function<Speed, Double> toKMH, Function<Speed, Double> toMPH,
                            Function<Speed, Double> toKN, Function<Speed, Double> toMS) {
            this.identifier = identifier;
            this.toKMH = toKMH;
            this.toMPH = toMPH;
            this.toKN = toKN;
            this.toMS = toMS;
        }

        private static SpeedUnitConversion conversion(SpeedUnits units) {
            return Arrays.stream(values())
                         .filter(speedConversion -> speedConversion.identified(units))
                         .findFirst()
                         .orElseThrow(() -> new ConverterException("The unit is not agreed!"));
        }

        private boolean identified(SpeedUnits unit) {
            return identifier == unit;
        }

        public static Double toKMH(Speed speed) {
            return conversion(speed.getUnit()).toKMH.apply(speed);
        }

        public static Double toMPH(Speed speed) {
            return conversion(speed.getUnit()).toMPH.apply(speed);
        }

        public static Double toKN(Speed speed) {
            return conversion(speed.getUnit()).toKN.apply(speed);
        }

        public static Double toMS(Speed speed) {
            return conversion(speed.getUnit()).toMS.apply(speed);
        }
    }
}