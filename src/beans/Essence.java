package beans;

public abstract class Essence {
    private String value;
    private String unit;

    public Essence(String value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public String getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
