import beans.Speed;
import beans.Time;
import beans.enums.SpeedUnits;
import beans.enums.TimeUnits;
import services.Converter;
import services.factory.ConverterFactory;
import support.DataReader;

import java.io.IOException;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        try {
            System.out.println("task 1:");

            System.out.println("Reading a file and creating a list of strings...");
            List<String> list = new DataReader(args[0]).fileAsList();
            System.out.println("Creating a converter, which contains a speeds list and time, received from file, as fields...");
            Converter converter = ConverterFactory.getConverter(list);

            System.out.println("\ntask 2:");

            System.out.println("Outputting of the speeds list to console:");
            converter.speedsAsList().forEach(speed -> System.out.println(converter.speedAs_ms(speed)));

            System.out.println(converter.getDistance(new Time("1", "h"), new Speed("120", "kmh")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
