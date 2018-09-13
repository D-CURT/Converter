package beans;

public class Time extends Essence{
    private String value;
    private String unit;

    public Time(String value, String unit) {
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
        return super.toString();
    }
}
