package domain.service_models;

import utils.unit_indentifires.SpeedUnits;

public class Speed extends Essence{
    private SpeedUnits unit;

    public Speed(String value, String unit) {
        super(value);
        this.unit = SpeedUnits.getUnit(unit);
    }

    public Integer getIntValue() {
        return Integer.parseInt(getValue());
    }

    public Double getDoubleValue() {
        return Double.parseDouble(getValue());
    }

    public SpeedUnits getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return getValue() + " " + unit.getName();
    }
}
