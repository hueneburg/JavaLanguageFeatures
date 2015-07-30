package test;

import feature_exception.ArgumentNullException;
import feature_exception.FormatException;
import org.junit.Test;
import string.CSharpFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by armin on 30.07.15.
 */
public class CSharpFormatTest {
    @Test
    public void nothingToDo() {
        String format = "test";
        try {
            assertEquals(CSharpFormat.format(format, ""), "test");
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void escapedBraces() {
        String format = "{{test}}";
        try {
            assertEquals(CSharpFormat.format(format, ""), "{test}");
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void negativeNumber() {
        String format = "{-1} test";
        try {
            assertEquals(CSharpFormat.format(format, ""), "test");
        } catch (FormatException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void numberGreaterThanIndex() {
        String format = "{1} test";
        try {
            assertEquals(CSharpFormat.format(format, ""), " test");
        } catch (FormatException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void argsNull() {
        String format = "test";
        try {
            assertEquals(CSharpFormat.format(format, null), "test");
        } catch (ArgumentNullException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void formatNull() {
        String format = null;

        try {
            assertEquals(CSharpFormat.format(format, ""), "test");
        } catch (ArgumentNullException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void bracesInOpen() {
        String format = "{1{";

        try {
            assertEquals(CSharpFormat.format(format, ""), "test");
        } catch (FormatException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void bracesInStart() {
        String format = "{}";

        try {
            assertEquals(CSharpFormat.format(format, ""), "test");
        } catch (FormatException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void bracesInClosed() {
        String format = "}{";

        try {
            assertEquals(CSharpFormat.format(format, ""), "test");
        } catch (FormatException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void notANumber() {
        String format = "{a}";

        try {
            assertEquals(CSharpFormat.format(format, "test"), "test");
        } catch (FormatException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void charInClosed() {
        String format = "}a}";

        try {
            assertEquals(CSharpFormat.format(format, ""), "test");
        } catch (FormatException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }
}
