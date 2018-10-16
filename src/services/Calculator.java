package services;

import beans.Distance;
import beans.Result;
import beans.Speed;
import beans.Time;
import beans.enums.TimeUnits;
import factories.EssenceFactory;
import services.interfaces.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static support.Formatter.format;

public class Calculator implements Service {
    private List<Speed> list;
    private Time time;

    public Calculator(List<Speed> list, Time time) {
        this.list = list;
        this.time = time;
    }

    private Distance getDistanceIn_m(Speed speed) {
        double value = Converter.speedIn_ms(speed).getDoubleValue() * TimeUnits.unitIn_s(time);
        return (Distance) EssenceFactory.getEssence(format(value) + " m");
    }

    private Distance[] getDistancesAsArray() {
        return list.stream()
                   .map(this::getDistanceIn_m)
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

    @Override
    public List<Result> action(Enum<?> service) {
        return null;
    }
}
