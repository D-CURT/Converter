package domain.service_beans;

public class Distance extends Essence implements Comparable<Distance>{
    private String unit;

    public Distance(String value, String unit) {
        super(value);
        this.unit = unit;
    }

    public Double getDoubleValue() {
        return Double.parseDouble(getValue());
    }

    @Override
    public String toString() {
        return getValue() + "_in_" + unit;
    }

    @Override
    public int compareTo(Distance o) {
        return getDoubleValue().compareTo(o.getDoubleValue());
    }
}
