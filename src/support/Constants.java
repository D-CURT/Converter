package support;

import beans.Essence;
import support.sections.ConverterServices;

import java.util.function.Function;

public class Constants {
    public static final String EMPTY = "";

    public static final Function<Essence, String> TO_MS = ConverterServices.TO_MS.getFunction();
}
