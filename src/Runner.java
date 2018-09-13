import services.factory.ConverterFactory;
import support.DataReader;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        try {
            System.out.println(ConverterFactory.getConverter(new DataReader(args[0]).fileAsList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
