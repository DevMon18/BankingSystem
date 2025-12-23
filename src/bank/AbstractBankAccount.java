package bank;

/**
 * AbstractBankAccount provides shared logic for bank account implementations.
 */
public abstract class AbstractBankAccount implements BankAccount {
    /**
     * The current balance of the account.
     */
    private double balance;
    /**
     * Indicates whether the account is frozen.
     */
    private boolean frozen;

    /**
     * Constructor initializes balance to 0 and frozen status to false.
     */
    public AbstractBankAccount() {
        this.balance = 0;
        this.frozen = false;
    }

    /**
     * Deposits an amount into the account if valid and account is not frozen.
     * @param amount The amount to deposit
     */
    @Override
    public void deposit(final double amount) {
        if (frozen) {
            System.out.println("\t- Account is frozen. Cannot deposit.");
            return;
        }
        if (amount <= 0) {
            System.out.println("\t[] The deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("\t[] Deposited: \tPhp %.0f.%n", amount);
    }

    /**
     * Withdraws an amount from the account if valid and sufficient funds exist.
     * @param amount The amount to withdraw
     * @return
     */
    @Override
    public void withdraw(final double amount) {
        if (frozen) {
            System.out.println("\t- Account is frozen. Cannot withdraw.");
            return;
        }
        if (amount <= 0) {
            System.out.println("\t[]The withdrawn amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("\t[] Insufficient balance.");
            return;
        }
        balance -= amount;
        System.out.printf("\t[] Withdrawn: \tPhp %.0f.%n", amount);
    }

    /**
     * Returns the current balance.
     *
     * @return The current balance
     */
    @Override
    public double getBalance() {
        System.out.printf("\t[] Balance: \tPhp %.0f.%n", balance);
        return balance;
    }

    /**
     * Checks if the account is frozen.
     * @return true if frozen, false otherwise
     */
    @Override
    public boolean isFrozen() {
        return frozen;
    }

    /**
     * Freezes the account, preventing deposits and withdrawals.
     */
    public void freezeAccount() {
        frozen = true;
        System.out.println("\t- Account has been frozen.");
    }

    /**
     * Unfreezes the account, allowing deposits and withdrawals.
     */
    public void unfreezeAccount() {
        frozen = false;
        System.out.println("\t- Account has been unfrozen.");
    }
}
