package support.implementations;

import beans.Essence;
import beans.Speed;
import beans.Time;
import beans.factory.EssenceFactory;
import services.Converter;
import services.DistanceCalculator;
import support.sections.Services;

import java.util.ArrayList;
import java.util.List;

public class ServiceImplementation {

    public ServiceImplementation implement(List<String> lines, Services section) {
        return section == Services.CONVERT ? getConverter(lines) : getDistanceCalculator(lines);
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
