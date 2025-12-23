package bank;

public interface BankAccount {
    /**
     * Deposits the specified amount into the account.
     *
     * @param amount
     */
    void deposit(double amount);

    /**
     * Withdraws the specified amount from the account.
     *
     * @param amount
     */
    void withdraw(double amount);

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
}
