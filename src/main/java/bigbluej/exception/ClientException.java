package bigbluej.exception;

/**
 * @author sMeet, 15.09.15
 */
public class ClientException extends RuntimeException {

    public ClientException() {
    }

    public ClientException(String message) {
        super(message);
    }

    public ClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientException(Throwable cause) {
        super(cause);
    }

    public ClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
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
