import beans.Distance;
import services.Converter;
import services.DistanceCalculator;
import support.DataReader;
import support.ServiceCreator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        try {
            System.out.println("task 1:");

            System.out.println("Reading a file and creating a list of strings...");
            List<String> list = new DataReader(args[0]).fileAsList();

            System.out.println("Creating a converter, which contains a speeds list and a time, received from the file, as fields...");
            Converter converter = ServiceCreator.getConverter(list);

            System.out.println("\ntask 2:");

            System.out.println("Outputting of the speeds list to console:");
            converter.speedsAsList().forEach(speed -> System.out.println(converter.speedIn_ms(speed)));

            System.out.println("\ntask 3:");

            System.out.println("Getting of a sorted distances array from the converter...");
            DistanceCalculator calculator = ServiceCreator.getDistanceCalculator(list);
            Distance[] sortedDistances = calculator.getSortedDistances(false);

            System.out.println("Outputting of the sorted distances array:");
            Arrays.stream(sortedDistances).forEach(System.out::println);

            System.out.println("\ntask 4:");

            System.out.print("Has the array one or more values from 500 to 501 meters: ");
            boolean flag = false;
            for (Distance distance: sortedDistances) {
                double value = distance.getDoubleValue();
                if (value >= 500 && value <= 501) flag = true;
            }
            System.out.println(flag ? "yes" : "no");

            System.out.println("\ntask 5:");

            System.out.println("Outputting of the sorted speeds list:");
            converter.getSortedSpeedsList().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
