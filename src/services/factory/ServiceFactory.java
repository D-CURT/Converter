package services.factory;

import domain.service_beans.Essence;
import domain.service_beans.factory.EssenceFactory;
import domain.service_beans.Speed;
import domain.service_beans.Time;
import services.Converter;
import services.Calculator;
import services.interfaces.Service;
import utils.sections.Services;

import java.util.ArrayList;
import java.util.List;

public class ServiceFactory {

    public static Service getService(List<String> lines, Services section) {
        return section == Services.CONVERSION ? new Converter(lines) : getDistanceCalculator(lines);
    }

    /*private static Converter getConverter(List<String> lines) {
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

    private static Calculator getDistanceCalculator(List<String> lines) {
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

        return new Calculator(list, time);
    }
}
