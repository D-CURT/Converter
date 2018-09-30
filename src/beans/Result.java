package beans;

import exceptions.ConverterException;

import static support.Constants.NEGATIVE;

public class Result {
    private String input;
    private String result;
    private ConverterException error;
    private Double convertedValue;
    private int groupIndex;

    public Result(String input, String result) {
        this.input = input;
        this.result = result;

    }

    public Result(String input, ConverterException error) {
        this.input = input;
        this.error = error;
        convertedValue = (double) NEGATIVE;
        groupIndex = NEGATIVE;
    }

    private boolean hasError() {
        return error != null;
    }

    @Override
    public String toString() {
        return hasError() ? input + " - " + error.getMessage() : result;
    }
}
