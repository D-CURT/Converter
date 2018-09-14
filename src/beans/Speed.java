package beans;

import beans.enums.SpeedUnits;

public class Speed extends Essence{
    private SpeedUnits speedUnit;

    public Speed(String value, String unit) {
        super(value, unit);
        speedUnit = SpeedUnits.getUnit(unit);
    }

    public Integer getIntValue() {
        return Integer.parseInt(getValue());
    }

    public SpeedUnits getSpeedUnit() {
        return speedUnit;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
