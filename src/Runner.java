import support.DataReader;
import factories.ServiceFactory;
import support.sections.ConverterServices;
import support.sections.Services;

import java.io.IOException;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        try {
            List<String> list = new DataReader(args[0]).fileAsList();

            System.out.println(ServiceFactory.getService(list, Services.CONVERSION).action(ConverterServices.TO_MS));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
