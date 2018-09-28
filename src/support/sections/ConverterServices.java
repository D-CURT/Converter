package support.sections;

import beans.Speed;
import beans.enums.SpeedUnits;
import services.Converter;

import java.util.Arrays;
import java.util.function.Function;

public enum ConverterServices {
    TO_MS(Converter::speedIn_ms);

    private Function<Speed, String> function;

    ConverterServices(Function<Speed, String> function) {
        this.function = function;
    }

    public Function<Speed, ?> getFunction() {
        return function;
    }

    public static ConverterServices getService(Enum<?> section) {
        return Arrays.stream(values())
                     .filter(converterServices -> converterServices == section)
                     .findFirst()
                     .orElse(null);
    }

    public static boolean isConverterService(Enum<?> section) {
        return getService(section) != null;
    }
}
