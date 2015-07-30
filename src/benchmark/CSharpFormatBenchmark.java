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
        String a = "{0} this is a test {1} {0}";
        long time = System.nanoTime();
        CSharpFormat.format(a, "a", "b");
        time -= System.nanoTime();
        return time * -1;
    }

    private static long format() {
        String a = "%s this is a test %s %s";
        long time = System.nanoTime();
        String.format(a, "a", "b", "a");
        time -= System.nanoTime();
        return time * -1;
    }

    private static long replace() throws FormatException, ArgumentNullException {
        String a = "{0} this is a test {1} {0}";
        long time = System.nanoTime();
        a.replace("{0}", "a").replace("{1}", "b");
        time -= System.nanoTime();
        return time * -1;
    }
}
