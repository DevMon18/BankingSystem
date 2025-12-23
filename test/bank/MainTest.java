package bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class MainTest {
    @BeforeAll
    static void setUpBeforeClass() {
        System.out.println("========== Starting Bank Account Tests ==========");
    }

    @AfterEach
    void tearDown() {
        System.out
                .println("--------------------------------------------------");
    }

    @Test
    @DisplayName("Test Case# 1: Create Savings Account Test")
    /*
     * Description Create a savings account Operations Create an instance of
     * SavingsAccount. Expected Output Displays owner name of account.
     */
    void testCreateSavingsAccount_ShouldReturnOwner() {
        System.out.println("\nTest Case #1: Create Savings Account");
        System.out.println("\t- Creating a new Savings Account for Lyle.");
        SavingsAccount account = new SavingsAccount("Lyle");
        if (account.getOwnerName().equals("Lyle")) {
            System.out.printf("\t[] Account Owner: %s%n",
                    account.getOwnerName());
            System.out.println("\t[] Account has been created successfully.\n");
        }
    }

    @Test
    @DisplayName("Test Case# 2: Deposit Valid Amount Test")
    /*
     * Description Deposit with valid amount Operations Call deposit(1000).
     * Expected Output Deposited: PHP 1000. Just Stick With the Description,
     * Operation and Expected Output
     */
    void testDepositValidAmount_ShouldReturnValidWhenCallingTheSameAmount() {
        System.out.println("\nTest Case #2: Deposit Valid Amount");
        SavingsAccount account = new SavingsAccount("Test User");
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
        System.out.println(
                "\t[] Deposit operation with valid amount handled successfully.\n");
    }

    @Test
    @DisplayName("Test Case #3: Deposit Zero Amount Test")
    /*
     * Description Deposit with zero amount. Operations Call deposit(0).
     * Expected Output The deposit amount must be positive. don't add if else
     */
    void testDepositZeroAmount_ShouldReturnErrorMessage() {
        System.out.println("\nTest Case #3: Deposit Zero Amount");
        SavingsAccount account = new SavingsAccount("Test User");
        account.deposit(0);
        assertEquals(0, account.getBalance());
        System.out.println(
                "\t[] Deposit operation with zero amount handled successfully.\n");
    }

    @Test
    @DisplayName("Test Case #4: Deposit With Negative Amount Test")
    /*
     * Description Deposit with negative amount Operations Call deposit(-500).
     * Expected Output The deposit amount must be positive.
     */
    void testDepositNegativeAmount_ShouldReturnErrorMessage() {
        System.out.println("\nTest Case #4: Deposit Negative Amount");
        SavingsAccount account = new SavingsAccount("Test User");
        account.deposit(-500);
        assertEquals(0, account.getBalance());
        System.out.println(
                "\t[] Deposit operation with negative amount handled successfully.\n");
    }

    @Test
    @DisplayName("Test Case #5: Withdraw with sufficient funds")
    /*
     * Description Withdraw with sufficient funds Operations Call withdraw(500)
     * Expected Output Withdrawn: Php 500.
     */
    void testWithdrawWithSufficientFunds_ShouldReturnValidWhenCallingTheSameAmount() {
        System.out.println("\nTest Case #5: Withdraw with Sufficient Funds");
        SavingsAccount account = new SavingsAccount("Test User");
        account.deposit(1000);
        account.withdraw(500);
        assertEquals(500, account.getBalance());
        System.out.println(
                "\t[] Withdraw operation with sufficient funds handled successfully.\n");
    }

    @Test
    @DisplayName("Test Case #6: Withdraw with insufficient funds")
    /*
     * Description Withdraw with insufficient funds Operations Call
     * withdraw(1500) Expected Output Insufficient balance.
     */
    void testWithdrawWithInsufficientFunds_ShouldReturnErrorMessage() {
        System.out.println("\nTest Case #6: Withdraw with Insufficient Funds");
        SavingsAccount account = new SavingsAccount("Test User");
        account.deposit(1000);
        account.withdraw(1500);
        assertEquals(1000, account.getBalance());
        System.out.println(
                "\t[] Withdraw operation with insufficient funds handled successfully.\n");
    }

    @Test
    @DisplayName("Test Case #7: Withdraw with negative amount")
    /*
     * Description Withdraw with negative amount Operations Call withdraw(-100)
     * Expected Output The withdrawn amount must be positive.
     */
    void testWithdrawWithNegativeAmount_ShouldReturnErrorMessage() {
        System.out.println("\nTest Case #7: Withdraw with Negative Amount");
        SavingsAccount account = new SavingsAccount("Test User");
        account.deposit(1000);
        account.withdraw(-100);
        assertEquals(1000, account.getBalance());
        System.out.println(
                "\t[] Withdraw operation with negative amount handled successfully.\n");
    }

    @Test
    @DisplayName("Test Case #8: Deposit when acount is frozen")
    /*
     * Description Deposit when account is frozen Operations 1. Call
     * freezeAccount() 2. Call deposit(11500) Expected Output Account has been
     * frozen. Account is frozen. Cannot deposit.
     */
    void testDepositWhenAccountIsFrozen_ShouldReturnErrorMessage() {
        System.out.println("\nTest Case #8: Deposit when Account is Frozen");
        SavingsAccount account = new SavingsAccount("Test User");
        account.freezeAccount();
        account.deposit(11500);
        assertEquals(0, account.getBalance());
        System.out.println(
                "\t[] Deposit operation when account is frozen handled successfully.\n");
    }

    @Test
    @DisplayName("Test Case #9: Withdraw when account is frozen")
    /*
     * Description Withdraw when account is frozen Operations Call
     * withdraw(500). Expected Output Account is frozen. Cannot withdraw.
     */
    void testWithdrawWhenAccountIsFrozen_ShouldReturnErrorMessage() {
        System.out.println("\nTest Case #9: Withdraw when Account is Frozen");
        SavingsAccount account = new SavingsAccount("Test User");
        account.freezeAccount();
        account.withdraw(500);
        assertEquals(0, account.getBalance());
        System.out.println(
                "\t[] Withdraw operation when account is frozen handled successfully.\n");
    }

    @Test
    @DisplayName("Test Case #10: Unfreeze account and withdraw")
    /*
     * Description Unfreeze account and withdraw Operations 1. Call
     * unfreezeAccount(). 2. Call withdraw(100). Expected Output Account has
     * been unfrozen. Withdrawn: Php 100.
     */
    void testUnfreezeAccountAndWithdraw_ShouldReturnValidWhenCallingTheSameAmount() {
        System.out.println("\nTest Case #10: Unfreeze Account and Withdraw");
        SavingsAccount account = new SavingsAccount("Test User");
        account.deposit(500);
        account.freezeAccount();
        account.unfreezeAccount();
        account.withdraw(100);
        assertEquals(400, account.getBalance());
        System.out.println(
                "\t[] Unfreeze account and withdraw operation handled successfully.\n");
    }

    @Test
    @DisplayName("Test Case #11: Check account is frozen")
    /*
     * Description Check account is frozen Operations Call isFrozen(). Expected
     * Output False.
     */
    void testCheckAccountIsFrozen_ShouldReturnFalse() {
        System.out.println("\nTest Case #11: Check Account is Frozen");
        SavingsAccount account = new SavingsAccount("Test User");
        assertFalse(account.isFrozen());
        System.out.println(
                "\t[] Check account is frozen operation handled successfully.\n");
    }

    @Test
    @DisplayName("Test Case #12: Check balance after multiple transactions")
    /*
     * Description Check balance after multiple transactions Operations Call
     * getBalance(). Expected Output Balance: Php 400.
     */
    void testCheckBalanceAfterMultipleTransactions_ShouldReturnCorrectBalance() {
        System.out.println(
                "\nTest Case #12: Check Balance after Multiple Transactions");
        SavingsAccount account = new SavingsAccount("Test User");
        account.deposit(1000);
        account.withdraw(300);
        account.withdraw(200);
        assertEquals(500, account.getBalance());
        System.out.println(
                "\t[] Check balance after multiple transactions operation handled successfully.\n");
    }

    // Test case for Main.java main method
    @Test
    @DisplayName("Test Case #13: Main Method Execution Test")
    void testMainMethodExecution_ShouldRunWithoutExceptions() {
        System.out.println("\nTest Case #13: Main Method Execution Test");
        String[] args = {};
        assertDoesNotThrow(() -> Main.main(args));
        System.out.println(
                "\t[] Main method executed without exceptions successfully.\n");
    }

    // Test case for throw new UnsupportedOperationException in Main constructor
    @Test
    @DisplayName("Test Case #14: Main Class Instantiation Test")
    void testMainClassInstantiation_ShouldThrowUnsupportedOperationException()
            throws Exception {
        System.out.println(
                "\nTest Case #14: Executing Main Class Instantiation Test");

        // Use reflection to access private constructor
        Constructor<Main> constructor = Main.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        // Attempt to instantiate and expect exception
        Exception exception = assertThrows(InvocationTargetException.class,
                () -> {
                    constructor.newInstance();
                });

        // Verify the cause is UnsupportedOperationException with correct
        // message
        assertEquals("Utility class", exception.getCause().getMessage());
        assertTrue(
                exception.getCause() instanceof UnsupportedOperationException);
    }
}
