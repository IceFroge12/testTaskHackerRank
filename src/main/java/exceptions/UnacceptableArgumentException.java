package exceptions;

/**
 * Created by yuriygubar on 7/6/17.
 */
public class UnacceptableArgumentException extends Exception {

    public UnacceptableArgumentException(String message) {
        super(message);
    }

    public UnacceptableArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
