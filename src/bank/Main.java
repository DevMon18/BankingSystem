package bank;

import java.util.List;

public final class Main {

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private Main() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Main method to demonstrate the SavingsAccount functionality.
     *
     * @param args Command line arguments
     *
     */
    @SuppressWarnings("null")
    public static void main(final String[] args) throws InvalidAmountException,
            AccountFrozenException, InsufficientFundsException {
        // Create a new SavingsAccount for "Alice"
        SavingsAccount aliceAccount = new SavingsAccount("Alice");

        final double amountDepositedAcc1 = 1000;
        final double depositLargeAmount = 1500;
        final double withdrawNegativeAmount = -100;
        final double anotherDepositedAmount = 500;
        final double withdrawPositiveAmount = 100;
        final double transactionHistoryTestAmount = 500;
        final double depositedAmount = 100;
        final double zeroAmount = 0;

        // TC 1: Add savings account to Bank Manager
        BankAccountManager bankManager = new BankAccountManager();
        bankManager.addAccount(aliceAccount);
        System.out.println("Test Case 1: Add Savings Account to Bank Manager");
        // TC 2: Deposit with valid amount (1000)
        System.out.println("\nTest Case 2: Deposit with valid amount");
        aliceAccount.deposit(amountDepositedAcc1);
        System.out.printf("Balance after deposit: Php %.0f%n",
                aliceAccount.getBalance());

        // TC 5: Withdraw with sufficient funds using the variable above
        System.out.println("\nTest Case 5: Withdraw with sufficient funds");
        aliceAccount.withdraw(anotherDepositedAmount);

        // TC 8: Deposit when account is frozen
        System.out.println("\nTest Case 8: Deposit when account is frozen");
        aliceAccount.freezeAccount();

        // TC 10: Unfreeze account and perform valid withdrawal (100)
        System.out.println("Unfreezing Account");
        aliceAccount.unfreezeAccount();
        System.out.println("\nTest Case 10: Withdraw with sufficient funds");
        aliceAccount.withdraw(withdrawPositiveAmount);

        // TC 11: Check balance after transactions
        System.out.println("\nTest: Check Balance After Transactions");
        System.out.printf("Current Balance: Php %.0f%n",
                aliceAccount.getBalance());

        // TC 12: Filter transaction history above a certain amount
        System.out.println("\nTest 7: Transactions above Php 500:");
        List<Transaction> history = aliceAccount.getTransactionHistory();
        BankAccountManager manager = new BankAccountManager();
        List<Transaction> filtered = manager
                .filterTransactionsAbove(transactionHistoryTestAmount, history);
        filtered.forEach(System.out::println);
        if (filtered.isEmpty()) {
            System.out.println("No transactions above Php 500 found.");
        }
        // Missing test case for filtering on a negative amount.

        // TC 13: Sort transaction history by amount
        System.out.println("\nTest: Transactions Sorted by Amount:");
        List<Transaction> sorted = manager.sortTransactionsByAmount(history);
        sorted.forEach(System.out::println);

        // TC 14: Invalid Account Access
        System.out.println("\nTest: Invalid Account Access");
        BankAccount invalidAccount = null;
        try {
            invalidAccount.deposit(depositedAmount);
        } catch (NullPointerException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // View Alice Balance
        System.out.println(
                "\nAlice's Final Balance: Php " + aliceAccount.getBalance());

        /*
         * THIS SECTION CONTAINS TEST CASES THAT HAS EX
         */
        // TC 3: Deposit with zero amount (0) dont use try catch
        System.out.println("\nTest Case 3: Deposit with zero amount");
        aliceAccount.deposit(zeroAmount);

        // TC 4: Deposit with negative amount using the variable above
        System.out.println("\nTest Case 4: Deposit with negative amount");
        aliceAccount.deposit(withdrawNegativeAmount);

        // TC 6: Withdraw with insufficient funds using the variable above
        // (1500)
        System.out.println("\nTest Case 6: Withdraw with insufficient funds");
        aliceAccount.withdraw(depositLargeAmount);

        // TC 7: Withdraw with negative amount using the variable above (-100)
        System.out.println("\nTest Case 7: Withdraw with negative amount");
        aliceAccount.withdraw(withdrawNegativeAmount);

        // TC 9: Withdraw when account is frozen
        System.out.println("\nTest Case 9: Withdraw when account is frozen");
        aliceAccount.freezeAccount();
        aliceAccount.withdraw(depositedAmount); // Peer Review: Does not freeze
                                                // account
                                                // Should raise exception
                                                // because
                                                // account is frozen

    }

}
