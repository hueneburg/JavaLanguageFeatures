package feature_exception;

/**
 * Created by armin on 30.07.15.
 */
public class ArgumentNullException extends Exception {
    public ArgumentNullException() {
        super();
    }

    public ArgumentNullException(String message) {
        super(message);
    }

    public ArgumentNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArgumentNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ArgumentNullException(Throwable cause) {
        super(cause);
    }
}
