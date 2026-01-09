package bank;


public class AccountFrozenException extends Exception {

    /**
     * This class's serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor with message.
     *
     * @param message The exception message
     */
    public AccountFrozenException(final String message) {
        super(message);
    }
}
