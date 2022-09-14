package ma.insea.comptecqrses.commonapi.exceptions;

public class CannotCreateAccountException extends RuntimeException {
    public CannotCreateAccountException(String message) {
        super(message);
    }
}
