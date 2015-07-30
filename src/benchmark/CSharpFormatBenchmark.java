package benchmark;

import feature_exception.ArgumentNullException;
import feature_exception.FormatException;
import string.CSharpFormat;

/**
 * Created by armin on 30.07.15.
 */
public class CSharpFormatBenchmark {

    public static void run() throws FormatException, ArgumentNullException {
        long time = 0;
        for (int i = 0; i < 1000; i++) {
            time += vsJavaFormat();
        }
        System.out.println("CSharpFormat vs JavaFormat: " + time + "ns less needed");

        time = 0;
        for (int i = 0; i < 1000; i++) {
            time += vsJavaFormat();
        }
        System.out.println("CSharpFormat vs JavaReplace: " + time + "ns less needed");
    }

    public static long vsJavaFormat() throws FormatException, ArgumentNullException {
        String a = "%s this is a test %s";
        long timeJava = System.nanoTime();
        String.format(a, "a", "b");
        timeJava -= System.nanoTime();
        timeJava *= -1;
        a = "{0} this is a test {1}";
        long timeCSharp = System.nanoTime();
        CSharpFormat.format(a, "a", "b");
        timeCSharp -= System.nanoTime();
        timeCSharp *= -1;
        return timeJava - timeCSharp;
    }

    public static long vsJavaReplace() throws FormatException, ArgumentNullException {
        String a = "%s this is a test %s %s";
        long timeJava = System.nanoTime();
        a.replace("%s", "a");
        timeJava -= System.nanoTime();
        timeJava *= -1;
        a = "{0} this is a test {0} {0}";
        long timeCSharp = System.nanoTime();
        CSharpFormat.format(a, "a");
        timeCSharp -= System.nanoTime();
        timeCSharp *= -1;
        return timeJava - timeCSharp;
    }
}
