package bank;

/**
 * Transaction class represents a bank transaction.
 */
public class Transaction {

    /**
     * The type of transaction (e.g., "Deposit", "Withdraw").
     */
    private String type;

    /**
     * The amount of the transaction.
     */
    private double amount;

    /**
     * Constructor initializes type and amount.
     * @param type1   The type of transaction
     * @param amount1 The amount of transaction
     */
    public Transaction(final String type1, final double amount1) {
        this.type = type1;
        this.amount = amount1;
    }

    /**
     * Returns the type of the transaction.
     *
     * @return The transaction type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the transaction amount.
     *
     * @return The transaction amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns the type and amount in String format.
     *
     * @return String representation of the transaction
     */
    @Override
    public String toString() {
        return String.format("%s: Php %.0f", type, amount);
    }
}
