package Exceptions;

public class NoPieceMoveException extends Exception {
    public NoPieceMoveException() {
        super();
    }

    public NoPieceMoveException(String message) {
        super(message);
    }

    public NoPieceMoveException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPieceMoveException(Throwable cause) {
        super(cause);
    }
}
