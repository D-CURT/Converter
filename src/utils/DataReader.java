package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataReader {
    private String path;

    public DataReader(String path) {
        this.path = path;
    }

    public List<String> fileAsList() throws IOException {
        return Files.readAllLines(Paths.get(path));
    }
}
