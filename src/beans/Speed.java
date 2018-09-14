package beans;

public class Speed extends Essence{
    public Speed(String value, String unit) {
        super(value, unit);
    }

    public Integer getIntValue() {
        return Integer.parseInt(getValue());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
