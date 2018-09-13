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

    public boolean readLine(String s) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s != null;
    }

    public Converter getConverter() {
        List<Speed> list = new ArrayList<>();
        String line;
        boolean firstLine = true;
        Essence essence;
        Time time = null;

        return new Converter(list, time);
    }

}
