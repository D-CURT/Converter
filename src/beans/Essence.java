package beans;

public abstract class Essence {
    private String value;
    private String unit;

    public String getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return value + "_in_" + unit;
    }
}
