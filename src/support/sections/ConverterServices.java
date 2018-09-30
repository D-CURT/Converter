package support.sections;

import beans.Essence;
import beans.Result;
import services.Converter;

import java.util.Arrays;
import java.util.function.Function;

public enum ConverterServices {
    TO_MS(Converter::speedIn_ms);

    private Function<Essence, Result> function;

    ConverterServices(Function<Essence, Result> function) {
        this.function = function;
    }

    public Function<Essence, Result> getFunction() {
        return function;
    }

    public static ConverterServices getService(Enum<?> section) {
        return Arrays.stream(values())
                     .filter(converterServices -> converterServices == section)
                     .findFirst()
                     .orElse(null);
    }
}