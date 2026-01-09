package bank;

public interface BankAccount {
    /**
     * Deposits the specified amount into the account.
     *
     * @param amount
     */
    void deposit(double amount)
            throws InvalidAmountException, AccountFrozenException;

    /**
     * Withdraws the specified amount from the account.
     *
     * @param amount
     *
     */
    void withdraw(double amount) throws InvalidAmountException,
            InsufficientFundsException, AccountFrozenException;

    /**
     * Gets the current balance of the account.
     *
     * @return The current balance
     */
    double getBalance();

    /**
     * Checks if the account is frozen.
     *
     * @return true if the account is frozen, false otherwise
     */
    boolean isFrozen();

    /**
     * Freezes the account.
     */
    void freezeAccount();

    /**
     * Unfreezes the account.
     */
    void unfreezeAccount();

    /**
     * Gets the transaction history of the account.
     * @return List of transactions
     */
    java.util.List<Transaction> getTransactionHistory();
}
