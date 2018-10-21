import support.DataReader;
import factories.ServiceFactory;
import support.jgh;
import support.sections.SpeedConversion;
import support.sections.Services;

import java.io.IOException;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

            List<String> list = jgh.file();
            //System.out.println(ServiceFactory.getService(list, Services.CONVERSION).action(SpeedConversion.TO_MS));

    }

    public static List<String> read() throws IOException {
        return new DataReader("in.txt").fileAsList();
    }
}