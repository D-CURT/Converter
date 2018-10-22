package utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Formatter {
    public static String format(Double n) {
        String format;
        Locale locale = new Locale("en", "UK");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(locale);
        format = getFormat(n, false);
        DecimalFormat df = new DecimalFormat(format, dfs);
        String result = df.format(n);
        n = Double.parseDouble(result);
        if (n * 1000 % 1000 == 0) {
            df.applyPattern(getFormat(n, true));
            return df.format(n);
        }
        return result;
    }

    private static String getFormat(Double n, boolean alter) {
        return n % 1 == 0 || alter ? "##0" : "##0.00";
    }
}
