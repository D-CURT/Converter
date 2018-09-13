package support;

import beans.Speed;
import beans.Time;
import services.Converter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private String path;

    public DataReader(String path) {
        this.path = path;
    }

    private String readLine() {
        String s = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public Converter getConverter() {
        List<Speed> list = new ArrayList<>();
        String[] fields;
        String line;
        boolean firstLine = true;
        Time time = null;

        while ((line = readLine()) != null) {
            fields = line.split(" ");
            if (firstLine) {
                time = new Time(fields[0], fields[1]);
                firstLine = false;
            } else list.add(new Speed(fields[0], fields[1]));
        }

        return new Converter(list, time);
    }

}
