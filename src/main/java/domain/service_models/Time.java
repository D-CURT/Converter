package domain.service_models;

import utils.unit_indentifires.TimeUnits;

public class Time extends Essence{
    private TimeUnits unit;

    public Time(String value, String unit) {
        super(value);
        this.unit = TimeUnits.getUnit(unit);
    }

    public int getIntValue() {
        return Integer.parseInt(getValue());
    }

    public TimeUnits getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return getValue() + " " + getUnit();
    }
}
