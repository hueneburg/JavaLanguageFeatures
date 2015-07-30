package feature_exception;

/**
 * Created by armin on 30.07.15.
 */
public class FormatException extends Exception {
    public FormatException() {
        super();
    }

    public FormatException(String message) {
        super(message);
    }

    public FormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FormatException(Throwable cause) {
        super(cause);
    }
}
