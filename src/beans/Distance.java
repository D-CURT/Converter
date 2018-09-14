package beans;

public class Distance extends Essence{

    public Distance(String value, String unit) {
        super(value, unit);
    }

    @Override
    public String toString() {
        return getValue() + "_in_" + getUnit();
    }
}
