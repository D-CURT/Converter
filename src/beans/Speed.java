package beans;

public class Speed extends Essence{
    private String value;
    private String unit;

    public Speed(String value, String unit) {
        this.value = value.trim();
        this.unit = unit.trim();
    }

    public int getIntValue() {
        return Integer.parseInt(value);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
