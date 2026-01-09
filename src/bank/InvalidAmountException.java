package bank;

/**
 * Exception thrown when an invalid amount
 * (negative or zero) is deposited or withdrawn.
 */
public class InvalidAmountException extends Exception {

    /**
     * This class's serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor with message.
     *
     * @param message The exception message
     */
    public InvalidAmountException(final String message) {
        super(message);
    }
}
