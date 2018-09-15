package beans;

import beans.enums.SpeedUnits;

public class Speed extends Essence{
    private SpeedUnits unit;

    public Speed(String value, String unit) {
        super(value);
        this.unit = SpeedUnits.getUnit(unit);
    }

    public Integer getIntValue() {
        return Integer.parseInt(getValue());
    }

    public SpeedUnits getUnit() {
        return unit;
    }

    public int getUnitPriority() {
        return unit.getPriority();
    }

    @Override
    public String toString() {
        return super.toString() + " " + unit.getValue();
    }
}
