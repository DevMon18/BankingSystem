package bank;

/**
 * Exception thrown when a withdrawal exceeds the available balance.
 */
public class InsufficientFundsException extends Exception {

    /**
     * This class's serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor with message.
     *
     * @param message The exception message
     */
    public InsufficientFundsException(final String message) {
        super(message);
    }
}
