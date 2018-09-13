import support.DataReader;

public class Runner {
    public static void main(String[] args) {
        System.out.println(new DataReader(args[0]).getConverter());
    }
}
