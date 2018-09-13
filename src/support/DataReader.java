package support;

import beans.Speed;
import beans.Time;
import services.Converter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private String path;

    public DataReader(String path) {
        this.path = path;
    }

    private List<String> fileAsList() throws IOException {
        return new ArrayList<>(Files.readAllLines(Paths.get(path)));
    }

    public Converter getConverter() throws IOException{
        List<Speed> list = new ArrayList<>();
        String[] fields;
        List<String> essences = fileAsList();
        boolean firstLine = true;
        Time time = null;

        for (String line: essences) {
            fields = line.split(" ");
            if (firstLine) {
                time = new Time(fields[0], fields[1]);
                firstLine = false;
            } else list.add(new Speed(fields[0], fields[1]));
        }

        return new Converter(list, time);
    }

}
