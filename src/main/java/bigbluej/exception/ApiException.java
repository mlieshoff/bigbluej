package bigbluej.exception;

/**
 * @author sMeet, 15.09.15
 */
public class ApiException extends RuntimeException {

    public ApiException() {
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    // ----- STATIC ACCESSOR ---------------------------------------------------------------------------------------- //

    // ----- TO BE IMPLEMENTED BY SUBCLASSES ------------------------------------------------------------------------ //

    // ----- OVERWRITTEN METHODS ------------------------------------------------------------------------------------ //

    // ----- GETTERS / SETTER --------------------------------------------------------------------------------------- //

    // ----- INTERNAL HELPER ---------------------------------------------------------------------------------------- //

    // ----- HELPER CLASSES ----------------------------------------------------------------------------------------- //

    // ----- DEPENDENCY INJECTION ----------------------------------------------------------------------------------- //

}
