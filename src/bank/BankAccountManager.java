package bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * BankAccountManager manages multiple bank accounts. Provides functionality to
 */
public class BankAccountManager {

    /**
     * Maps account IDs to BankAccount objects.
     */
    private Map<Integer, BankAccount> accounts;

    /**
     * The next available account ID.
     */
    private int nextAccountId;

    /**
     * Constructor initializes accounts with HashMap and nextAccountId with 1.
     */
    public BankAccountManager() {
        this.accounts = new HashMap<>();
        this.nextAccountId = 1;
    }

    /**
     * Adds a new account to the manager.
     *
     * @param account The BankAccount to add
     */
    public void addAccount(final BankAccount account) {
        int accountId = nextAccountId;
        accounts.put(accountId, account);
        nextAccountId++; /* Peer Review: As per documentation,
        this function must be void.*/
    }

    /**
     * Retrieves an account by its ID.
     *
     * @param accountId The account ID
     * @return The BankAccount object, or null if not found
     */
    public BankAccount getAccount(final int accountId) {
        return accounts.get(accountId);
    }


    /**
     * Lists all accounts with their balances.
     */
    public void listAccounts() {
        System.out.println("\n=== Account List ===");
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            System.out.printf("Account ID: %d, Balance: Php %.0f%n",
                    entry.getKey(), entry.getValue().getBalance());
        }
    }

    /**
     * Filters transactions above a certain amount using lambda expression.
     *
     * @param amount The minimum amount to filter
     * @param txList The list of transactions to filter
     * @return Filtered list of transactions
     */
    public List<Transaction> filterTransactionsAbove(final double amount,
            final List<Transaction> txList) {
        return txList.stream().filter(tx -> tx.getAmount() >= amount)
                .collect(Collectors.toList());
    }

    /**
     * Sorts transactions by amount using lambda expression.
     *
     * @param txList The list of transactions to sort
     * @return Sorted list of transactions
     */
    public List<Transaction> sortTransactionsByAmount(
            final List<Transaction> txList) {
        return txList.stream().sorted(
                (tx1, tx2) -> Double.compare(tx1.getAmount(), tx2.getAmount()))
                .collect(Collectors.toList());
    }
}
