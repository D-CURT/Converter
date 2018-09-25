package support;

import beans.Essence;
import beans.Speed;
import beans.Time;
import beans.factory.EssenceFactory;
import services.Converter;
import services.DistanceCalculator;

import java.util.ArrayList;
import java.util.List;

public class ServiceCreator {

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

    public static DistanceCalculator getDistanceCalculator(List<String> lines) {
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

        return new DistanceCalculator(list, time);
    }
}
