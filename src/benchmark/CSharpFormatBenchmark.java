package benchmark;

import feature_exception.ArgumentNullException;
import feature_exception.FormatException;
import string.CSharpFormat;

/**
 * Created by armin on 30.07.15.
 */
public class CSharpFormatBenchmark {

    public static void run() throws FormatException, ArgumentNullException {
        long custom = 0;
        for (int i = 0; i < 1000; i++) {
            custom += custom();
        }

        long format = 0;
        for (int i = 0; i < 1000; i++) {
            format += format();
        }

        long replace = 0;
        for (int i = 0; i < 1000; i++) {
            replace += replace();
        }
        System.out.println("CSharpFormat: " + custom + "ns needed");
        System.out.println("JavaFormat  : " + format + "ns needed");
        System.out.println("JavaReplace : " + replace + "ns needed");
    }

    private static long custom() throws FormatException, ArgumentNullException {
        String a = "{4}{2}{5}{5}{1}{4}{2}{4}{4}{1}{0}{2}{3}{1}{1}{0}{3}{0}{1}{0}{1}{1}{1}{1}{1}{4}{4}{0}{2}{5}";
        long time = System.nanoTime();
        CSharpFormat.format(a, "a", "b", "c", "d", "e", "f");
        time -= System.nanoTime();
        return time * -1;
    }

    private static long format() {
        String a = "%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s";
        long time = System.nanoTime();
        String.format(a, "e", "c", "f", "f", "b", "e", "c", "e", "e", "b", "a", "c", "d", "b", "b", "a", "d", "a", "b",
                "a", "b", "b", "b", "b", "b", "e", "e", "a", "c", "f");
        time -= System.nanoTime();
        return time * -1;
    }

    private static long replace() throws FormatException, ArgumentNullException {
        String a = "{4}{2}{5}{5}{1}{4}{2}{4}{4}{1}{0}{2}{3}{1}{1}{0}{3}{0}{1}{0}{1}{1}{1}{1}{1}{4}{4}{0}{2}{5}";
        long time = System.nanoTime();
        a.replace("{0}", "a").replace("{1}", "b").replace("{2}", "c").replace("{3}", "d").replace("{4}", "e").replace("{5}", "f");
        time -= System.nanoTime();
        return time * -1;
    }
}
