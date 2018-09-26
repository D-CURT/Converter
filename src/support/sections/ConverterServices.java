package support.sections;

import beans.Speed;
import beans.enums.SpeedUnits;

import java.util.function.Function;

public enum ConverterServices {
    TO_MS(SpeedUnits::unitIn_ms);

    private Function<Speed, ?> function;

    ConverterServices(Function<Speed, ?> function) {
        this.function = function;
    }


}
