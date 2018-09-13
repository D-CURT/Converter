package support;

import beans.Essence;
import beans.Speed;
import beans.Time;
import beans.enums.TimeUnits;
import services.Converter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static beans.enums.TimeUnits.isTimeUnit;

public class DataReader {
    private String path;

    public DataReader(String path) {
        this.path = path;
    }

    private List<Essence> fileAsList() throws IOException {
        return Files.readAllLines(Paths.get(path)).stream().map(this::getEssence).collect(Collectors.toList());
    }

    private Essence getEssence(String s) {
        String[] fields = s.split(" ");
        return (isTimeUnit(fields[1])) ? new Time(fields[0], fields[1]) : new Speed(fields[0], fields[1]);
    }

    public Converter getConverter() throws IOException{
        List<Speed> list = new ArrayList<>();
        boolean firstLine = true;
        Time time = null;

        for (Essence essence: fileAsList()) {
            if (firstLine) {
                time = (Time) essence;
                firstLine = false;
            } else list.add((Speed) essence);
        }

        return new Converter(list, time);
    }

}
