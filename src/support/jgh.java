package support;

import java.io.IOException;
import java.util.List;

public class jgh {
    public static List<String> file() {
        try {
            return new DataReader("in.txt").fileAsList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
