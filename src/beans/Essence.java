package beans;

public abstract class Essence {
    private String value;
    private String unit;

    @Override
    public String toString() {
        return value + "_in_" + unit;
    }
}
