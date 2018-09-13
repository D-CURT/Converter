package services.factory;

import beans.Speed;
import beans.Time;
import beans.factory.EssenceFactory;
import services.Converter;

import java.util.ArrayList;
import java.util.List;

public class ConverterFactory {
    public static Converter getConverter(List<String> lines) {
        List<Speed> list = new ArrayList<>();
        boolean firstLine = true;
        Time time = null;

        for (String line: lines) {
            if (firstLine) {
                time = (Time) EssenceFactory.getEssence(line);
                firstLine = false;
            } else list.add((Speed) EssenceFactory.getEssence(line));
        }

        return new Converter(list, time);
    }
}
