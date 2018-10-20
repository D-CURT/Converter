package support.sections;

import beans.Essence;
import beans.Result;
import services.Converter;

import java.util.Arrays;
import java.util.function.Function;

public enum SpeedConversion {
    TO_MS(Converter::speedTo_ms);

    private Function<Essence, Result> function;

    SpeedConversion(Function<Essence, Result> function) {
        this.function = function;
    }

    public Function<Essence, Result> getFunction() {
        return function;
    }

    public static SpeedConversion getService(Enum<?> section) {
        return Arrays.stream(values())
                     .filter(speedConversion -> speedConversion == section)
                     .findFirst()
                     .orElse(null);
    }
}