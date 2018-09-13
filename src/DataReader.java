import beans.Essence;
import beans.Speed;
import beans.Time;
import services.Converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static beans.enums.TimeUnits.isTimeUnit;

public class DataReader {
    private String path;

    public DataReader(String path) {
        this.path = path;
    }

    public Essence readLine(String s) {
        String[] separated = s.split(" ");
        if (isTimeUnit(separated[1])) {
            return new Time(separated[0], separated[1]);
        }
        return new Speed(separated[0], separated[1]);
    }

    public Converter getEssenceList() {
        List<Speed> list = new ArrayList<>();
        String line;
        boolean firstLine = true;
        Essence essence;
        Time time = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while ((line = reader.readLine()) != null) {
                essence = readLine(line);
                if (firstLine) {
                    time = (Time) essence;
                    firstLine = false;
                }
                //noinspection ConstantConditions
                list.add((Speed) essence);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Converter(list, time);
    }

}
