import utils.DataReader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

            List<String> list = jgh.file();
            //System.out.println(ServiceFactory.getService(list, Services.CONVERSION).action(SpeedConversion.TO_MS));

    }

    public static List<String> read() throws IOException {
        return new DataReader("in.txt").fileAsList();
    }
}