package beans;

public class Result {
    private String input;
    private Double result;
    private String error;

    public Result(String input, Double result) {
        this.input = input;
        this.result = result;
    }

    public Result(String input, String error) {
        this.input = input;
        this.error = error;
    }
}
