package utils.sections;

import utils.exceptions.ConverterException;

import java.util.Arrays;

public enum Services {
    CONVERSION("conversion"),
    CALCULATION("calculation");

    private final String name;

    Services(String name) {
        this.name = name;
    }

    public static Services getServiceType(String service) {
        return Arrays.stream(values())
                     .filter(services -> services.name.equals(service))
                     .findFirst()
                     .orElseThrow(() -> new ConverterException("Unknown service!"));
    }
}
