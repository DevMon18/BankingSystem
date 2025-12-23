package bank;

public final class Main {
    /**
     * Private constructor to prevent instantiation of utility class.
     */
    Main() {
        throw new UnsupportedOperationException("Utility class");
    }
    /**
     * Main method to demonstrate the SavingsAccount functionality.
     *
     * @param args Command line arguments
     */
    public static void main(final String[] args) {
        // Create a new SavingsAccount for "Alice"
        SavingsAccount aliceAccount = new SavingsAccount("Alice");

        final double amountDepositedAcc1 = 1000;
        final double amountWithdrawnAcc1 = 500;
        final double amountDepositedAcc2 = 1000;
        final double amountWithdrawnAcc2 = 500;
        // Owner's name
        System.out.printf("Account Owner: %s%n", aliceAccount.getOwnerName());
        // Deposit PHP 1000 into Alice's account
        aliceAccount.deposit(amountDepositedAcc1);
        // Withdraw PHP 500 from Alice's account
        aliceAccount.withdraw(amountWithdrawnAcc1);
        // Print the current balance of Alice's account
        aliceAccount.getBalance();
        System.out.printf("==============================================\n");

        // Create a frozen account for "Bob"
        SavingsAccount bobAccount = new SavingsAccount("Bob");
        System.out.printf("Account Owner: %s%n", bobAccount.getOwnerName());
        bobAccount.getOwnerName();
        // Manually freeze Bob's account for demonstration
        bobAccount.freezeAccount();
        // Attempt to deposit into the frozen account
        bobAccount.deposit(amountDepositedAcc2);
        // Attempt to withdraw from the frozen account
        bobAccount.withdraw(amountWithdrawnAcc2);
    }
}
