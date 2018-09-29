package support.sections;

import beans.Essence;
import beans.Speed;
import beans.enums.SpeedUnits;
import services.Converter;

import java.util.Arrays;
import java.util.function.Function;

public enum ConverterServices {
    TO_MS(Converter::speedIn_ms);

    private Function<Essence, String> function;

    ConverterServices(Function<Essence, String> function) {
        this.function = function;
    }

    public Function<Essence, String> getFunction() {
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
