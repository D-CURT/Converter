package beans;

public abstract class Essence {
    private String value;
    private String unit;

    public Essence(String value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return value + " " + unit + " = " + value + "_in_" + unit;
    }
}
