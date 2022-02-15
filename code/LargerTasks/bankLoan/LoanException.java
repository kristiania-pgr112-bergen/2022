package LargerTasks.bankLoan;

public class LoanException extends Exception {
    public LoanException() {
        super();
    }

    public LoanException(String message, Throwable cause,
                           boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public LoanException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoanException(String message) {
        super(message);
    }

    public LoanException(Throwable cause) {
        super(cause);
    }
}