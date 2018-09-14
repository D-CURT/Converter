package beans;

public class Distance extends Essence implements Comparable<Distance>{

    public Distance(String value, String unit) {
        super(value, unit);
    }

    @Override
    public String toString() {
        return getValue() + "_in_" + getUnit();
    }

    @Override
    public int compareTo(Distance o) {
        return getValue().compareTo(o.getValue());
    }
}
