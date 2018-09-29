package factories;

import beans.Essence;
import beans.Speed;
import beans.Time;
import services.Converter;
import services.DistanceCalculator;
import services.interfaces.Service;
import support.sections.Services;

import java.util.ArrayList;
import java.util.List;

public class ServiceFactory {

    /*public static Service getService(List<String> lines, Services section) {
        return section == Services.CONVERT ? getConverter(lines) : getDistanceCalculator(lines);
    }

    private static Converter getConverter(List<String> lines) {
        List<Speed> list = new ArrayList<>();
        boolean firstLine = true;
        Essence essence;

        for (String line: lines) {
            essence = EssenceFactory.getEssence(line);
            if (firstLine) firstLine = false;
            else list.add((Speed) essence);
        }

        return new Converter(list);
    }*/

    private static DistanceCalculator getDistanceCalculator(List<String> lines) {
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
