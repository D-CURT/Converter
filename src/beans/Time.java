package beans;

import beans.enums.TimeUnits;

public class Time extends Essence{
    private TimeUnits unit;

    public Time(String value, String unit) {
        super(value);
        this.unit = TimeUnits.getUnit(unit);
    }

    public TimeUnits getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
