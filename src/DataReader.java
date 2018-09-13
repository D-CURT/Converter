import beans.Essence;
import beans.Speed;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private String path;

    public DataReader(String path) {
        this.path = path;
    }

    public List<Speed> getEssenceList() {
        List<Speed> list = new ArrayList<>();
        String[] values;
        String line;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while ((line = reader.readLine()) != null) {
                values = line.split(" ");
                list.add(new Speed(values[0], values[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

}
