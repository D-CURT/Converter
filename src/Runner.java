import support.DataReader;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        try {
            System.out.println(new DataReader(args[0]).getConverter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
