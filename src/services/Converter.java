package services;

import beans.Speed;
import beans.Time;
import beans.enums.SpeedUnits;
import beans.enums.TimeUnits;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

public class Converter {
    private List<Speed> list;
    private Time time;

    public Converter(List<Speed> list, Time time) {
        this.list = list;
        this.time = time;
    }

    public List<Speed> speedsAsList() {
        return list;
    }

    public String speedAs_ms(Speed speed) {
        return speed + " = " + format(SpeedUnits.unitAs_ms(speed.getValue(), speed.getUnit())) + "_in_ms";
    }

    public String getDistance(Time time, Speed speed) {
        return format(SpeedUnits.unitAs_ms(speed.getValue(), speed.getUnit()) *
                TimeUnits.unitAs_s(time.getValue(), time.getUnit())) + "_in_m";
    }

    private String format(Double n) {
        String format;
        Locale locale = new Locale("en", "UK");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(locale);
        format = n % 1 == 0 ? "##0" : "##0.00";
        DecimalFormat df = new DecimalFormat(format, dfs);
        return df.format(n);
    }
}
