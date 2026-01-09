package bank;

import java.util.ArrayList;
import java.util.List;

/**
 * AbstractBankAccount provides shared logic for bank account implementations.
 * This class implements the BankAccount interface and provides common
 * functionality for managing balance, freeze status, and transaction history.
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
     * List of all transactions performed on this account.
     */
    private List<Transaction> transactionHistory;

    /**
     * Constructor initializes balance to 0, frozen status to false, and
     * transactionHistory as an empty ArrayList.
     */
    public AbstractBankAccount() {
        this.balance = 0;
        this.frozen = false;
        this.transactionHistory = new ArrayList<>();
    }

    /**
     * Deposits an amount into the account if valid and account is not frozen.
     *
     * @param amount The amount to deposit
     */
    @Override
    public synchronized void deposit(final double amount)
            throws InvalidAmountException, AccountFrozenException {
        try {
            if (frozen) {
                throw new AccountFrozenException(
                        "Account is frozen. " + "Cannot deposit.");
            }

            if (amount <= 0) {
                throw new InvalidAmountException(
                        "The deposited amount must be positive.");
            }

            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));
            System.out.printf("Deposited: Php %.0f.%n", amount);
        } catch (InvalidAmountException | AccountFrozenException e) {
            e.printStackTrace(); // Rethrow the exception to be handled by the
                                 // caller
        }
    }

    /**
     * Withdraws an amount from the account if valid and sufficient funds exist.
     *
     * @param amount The amount to withdraw
     */
    @Override
    public synchronized void withdraw(final double amount)
            throws InvalidAmountException, InsufficientFundsException,
            AccountFrozenException {
        try {
            if (frozen) {
                throw new AccountFrozenException(
                        "Account is frozen. " + "Cannot withdraw.");
            }

            if (amount <= 0) {
                throw new InvalidAmountException(
                        "The withdrawn amount must be positive.");
            }

            if (amount > balance) {
                throw new InsufficientFundsException(
                        "Insufficient funds for this withdrawal.");
            }

            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount));
            System.out.printf("Withdrawn: Php %.0f.%n", amount);
        } catch (InvalidAmountException | InsufficientFundsException
                | AccountFrozenException e) {
            e.printStackTrace(); // Rethrow the exception to be handled by the
                                 // caller
        }
    }

    /**
     * Returns the current balance.
     *
     * @return The current balance
     */
    @Override
    public double getBalance() {
        return balance;
    }

    /**
     * Checks if the account is frozen.
     *
     * @return true if frozen, false otherwise
     */
    @Override
    public boolean isFrozen() {
        return frozen;
    }

    /**
     * Freezes the account, preventing deposits and withdrawals.
     */
    @Override
    public void freezeAccount() {
        frozen = true;
        System.out.println("Account has been frozen.");
    }

    /**
     * Unfreezes the account, allowing deposits and withdrawals.
     */
    @Override
    public void unfreezeAccount() {
        frozen = false;
        System.out.println("Account has been unfrozen.");
    }

    /**
     * Returns all transactions with String-based types.
     *
     * @return List of transactions
     */
    @Override
    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }
}
