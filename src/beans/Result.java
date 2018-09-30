package beans;

import static support.Constants.EMPTY;
import static support.Constants.NEGATIVE;
import static support.Constants.SPACE;

public class Result {
    private String input;
    private String unit;
    private String value;
    private String error;
    private int groupIndex;

    public Result(String input, String value, String unit, int groupIndex) {
        this.input = input;
        this.value = value;
        this.unit = unit;
        this.groupIndex = groupIndex;
    }

    public Result(String input, String error) {
        this.input = input;
        this.error = error;
        value = EMPTY + NEGATIVE;
        groupIndex = NEGATIVE;
    }

    public Double getDoubleValue() {
        return Double.parseDouble(value);
    }

    public int getGroupIndex() {
        return groupIndex;
    }

    private boolean hasError() {
        return error != null;
    }

    @Override
    public String toString() {
        return hasError() ? input + " - " + error
                          : input + " = " + value + SPACE + unit;
    }
}