package beans;

import exceptions.ConverterException;

public class Result {
    private String input;
    private String result;
    private ConverterException error;

    public Result(String input, String result) {
        this.input = input;
        this.result = result;
    }

    public Result(String input, ConverterException error) {
        this.input = input;
        this.error = error;
    }

    private boolean hasError() {
        return error != null;
    }

    @Override
    public String toString() {
        return hasError() ? input + " - " + error.getMessage() : result;
    }
}
