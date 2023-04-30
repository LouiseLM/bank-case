package nl.bankcase.utils.exceptions;

public class IllegalWithdrawalException extends RuntimeException{
    public IllegalWithdrawalException() {
    }

    public IllegalWithdrawalException(String message) {
        super(message);
    }

    public IllegalWithdrawalException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalWithdrawalException(Throwable cause) {
        super(cause);
    }

    public IllegalWithdrawalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
