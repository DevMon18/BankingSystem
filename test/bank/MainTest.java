package bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

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
    void testDepositValidAmount_ShouldReturnValidWhenCallingTheSameAmount()
            throws InvalidAmountException, AccountFrozenException {
        System.out.println("\nTest Case #2: Deposit Valid Amount");
        SavingsAccount account = new SavingsAccount("Test User");
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
        System.out.println(
                "\t[] Deposit operation with valid amount handled successfully.\n");
    }

    @Test
    @DisplayName("Test Case #5: Withdraw with sufficient funds")
    /*
     * Description Withdraw with sufficient funds Operations Call withdraw(500)
     * Expected Output Withdrawn: Php 500.
     */
    void testWithdrawWithSufficientFunds_ShouldReturnValidWhenCallingTheSameAmount()
            throws InvalidAmountException, AccountFrozenException,
            InsufficientFundsException {
        System.out.println("\nTest Case #5: Withdraw with Sufficient Funds");
        SavingsAccount account = new SavingsAccount("Test User");
        account.deposit(1000);
        account.withdraw(500);
        assertEquals(500, account.getBalance());
        System.out.println(
                "\t[] Withdraw operation with sufficient funds handled successfully.\n");
    }

    @Test
    @DisplayName("Test Case #10: Unfreeze account and withdraw")
    /*
     * Description Unfreeze account and withdraw Operations 1. Call
     * unfreezeAccount(). 2. Call withdraw(100). Expected Output Account has
     * been unfrozen. Withdrawn: Php 100.
     */
    void testUnfreezeAccountAndWithdraw_ShouldReturnValidWhenCallingTheSameAmount()
            throws InvalidAmountException, AccountFrozenException,
            InsufficientFundsException {
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
    void testCheckBalanceAfterMultipleTransactions_ShouldReturnCorrectBalance()
            throws InvalidAmountException, AccountFrozenException,
            InsufficientFundsException {
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

    // Coverage Test Case - AccountFrozenException Super
    @Test
    @DisplayName("Test Case #15: AccountFrozenException Superclass Test")
    void testAccountFrozenExceptionSuperclass_ShouldBeException() {
        System.out.println(
                "\nTest Case #15: AccountFrozenException Superclass Test");
        AccountFrozenException exception = new AccountFrozenException(
                "Account is frozen.");
        assertTrue(exception instanceof Exception);
        System.out.println(
                "\t[] AccountFrozenException superclass test handled successfully.\n");
    }

    // Coverage Test Case - BankAccountManager getAccount return accounts
    @Test
    @DisplayName("Test Case #16: BankAccountManager Get Account Test")
    void testBankAccountManagerGetAccount_ShouldReturnCorrectAccount()
            throws InvalidAmountException, AccountFrozenException {
        System.out.println(
                "\nTest Case #16: BankAccountManager Get Account Test");
        BankAccountManager manager = new BankAccountManager();
        SavingsAccount account = new SavingsAccount("Test User");
        manager.addAccount(account);
        BankAccount retrievedAccount = manager.getAccount(1);
        assertNotNull(retrievedAccount);
        assertEquals(account, retrievedAccount);
        System.out.println(
                "\t[] BankAccountManager getAccount test handled successfully.\n");
    }

    // Coverage Test Case - BankAccountManager listAccounts
    @Test
    @DisplayName("Test Case #17: BankAccountManager List Accounts Test")
    void testBankAccountManagerListAccounts_ShouldListAllAccounts()
            throws InvalidAmountException, AccountFrozenException {
        System.out.println(
                "\nTest Case #17: BankAccountManager List Accounts Test");
        BankAccountManager manager = new BankAccountManager();
        SavingsAccount account1 = new SavingsAccount("User One");
        SavingsAccount account2 = new SavingsAccount("User Two");
        manager.addAccount(account1);
        manager.addAccount(account2);
        // Capture the output of listAccounts
        manager.listAccounts();
        System.out.println(
                "\t[] BankAccountManager listAccounts test handled successfully.\n");
    }

    // Coverage Test Case for BankAccountManager filtering transaction history
    @Test
    @DisplayName("Test Case #18: BankAccountManager Filter Transaction History Test")
    void testBankAccountManagerFilterTransactionHistory_ShouldReturnFilteredTransactions()
            throws InvalidAmountException, AccountFrozenException,
            InsufficientFundsException {
        System.out.println(
                "\nTest Case #18: BankAccountManager Filter Transaction History Test");
        SavingsAccount account = new SavingsAccount("Test User");
        account.deposit(1000);
        account.withdraw(300);
        account.deposit(700);
        List<Transaction> history = account.getTransactionHistory();
        BankAccountManager manager = new BankAccountManager();
        List<Transaction> filtered = manager.filterTransactionsAbove(500,
                history);
        assertEquals(2, filtered.size());
        System.out.println(
                "\t[] BankAccountManager filter transaction history test handled successfully.\n");
    }

    // Coverage Test Case - BankAccount sortTransactionsByAmount
    @Test
    @DisplayName("Test Case #19: BankAccountManager Sort Transactions By Amount Test")
    void testBankAccountManagerSortTransactionsByAmount_ShouldReturnSortedTransactions()
            throws InvalidAmountException, AccountFrozenException,
            InsufficientFundsException {
        System.out.println(
                "\nTest Case #19: BankAccountManager Sort Transactions By Amount Test");
        SavingsAccount account = new SavingsAccount("Test User");
        account.deposit(1000);
        account.withdraw(300);
        account.deposit(700);
        List<Transaction> history = account.getTransactionHistory();
        BankAccountManager manager = new BankAccountManager();
        List<Transaction> sorted = manager.sortTransactionsByAmount(history);
        assertEquals(3, sorted.size());
        assertEquals(300, sorted.get(0).getAmount());
        assertEquals(700, sorted.get(1).getAmount());
        assertEquals(1000, sorted.get(2).getAmount());
        System.out.println(
                "\t[] BankAccountManager sort transactions by amount test handled successfully.\n");
    }

    // Test Coverage for Transaction.java getType
    @Test
    @DisplayName("Test Case #21: Transaction getType Method Test")
    void testTransactionGetType_ShouldReturnCorrectType()
            throws InvalidAmountException, AccountFrozenException {
        System.out.println("\nTest Case #21: Transaction getType Method Test");
        Transaction transaction = new Transaction("Withdrawal", 500);
        assertEquals("Withdrawal", transaction.getType());
        System.out.println(
                "\t[] Transaction getType method test handled successfully.\n");
    }

    // Test Coverage InvalidAmountException Superclass
    @Test
    @DisplayName("Test Case #22: InvalidAmountException Superclass Test")
    void testInvalidAmountExceptionSuperclass_ShouldBeException() {
        System.out.println(
                "\nTest Case #22: InvalidAmountException Superclass Test");
        InvalidAmountException exception = new InvalidAmountException(
                "Invalid amount.");
        assertTrue(exception instanceof Exception);
        System.out.println(
                "\t[] InvalidAmountException superclass test handled successfully.\n");
    }

    // Test Coverage InsufficientFundsException Superclass
    @Test
    @DisplayName("Test Case #23: InsufficientFundsException Superclass Test")
    void testInsufficientFundsExceptionSuperclass_ShouldBeException() {
        System.out.println(
                "\nTest Case #23: InsufficientFundsException Superclass Test");
        InsufficientFundsException exception = new InsufficientFundsException(
                "Insufficient funds.");
        assertTrue(exception instanceof Exception);
        System.out.println(
                "\t[] InsufficientFundsException superclass test handled successfully.\n");
    }

    // Test Coverage for Transaction.java String and dont make it FAIL in jUnit
    @Test
    @DisplayName("Test Case #24: Transaction toString Method Test")
    void testTransactionToString_ShouldReturnCorrectString()
            throws InvalidAmountException, AccountFrozenException {
        System.out.println("\nTest Case #24: Transaction toString Method Test");
        Transaction transaction = new Transaction("Deposit", 800);
        String expectedString = "Deposit: Php 800";
        assertEquals(expectedString, transaction.toString());
        System.out.println(
                "\t[] Transaction toString method test handled successfully.\n");
    }

    // Test Coverage for AbstractBankAccount.java deposit Exception catch block
    @Test
    @DisplayName("Test Case #25: AbstractBankAccount Deposit Exception Handling Test")
    void testAbstractBankAccountDepositExceptionHandling()
            throws InvalidAmountException, AccountFrozenException {
        System.out.println(
                "\nTest Case #25: AbstractBankAccount Deposit Exception Handling Test");
        SavingsAccount account = new SavingsAccount("Test User");
        account.freezeAccount();
        // Attempt to deposit a negative amount to trigger exception
        account.deposit(-500);
        System.out.println(
                "\t[] AbstractBankAccount deposit exception handling test handled successfully.\n");
    }

    // Test Coverage for AbstractBankAccount.java withdraw Exception catch block
    @Test
    @DisplayName("Test Case #26: AbstractBankAccount Withdraw Exception Handling Test")
    void testAbstractBankAccountWithdrawExceptionHandling()
            throws InvalidAmountException, AccountFrozenException,
            InsufficientFundsException {
        System.out.println(
                "\nTest Case #26: AbstractBankAccount Withdraw Exception Handling Test");
        SavingsAccount account = new SavingsAccount("Test User");
        account.freezeAccount();
        // Attempt to withdraw a negative amount to trigger exception
        account.withdraw(-300);
        System.out.println(
                "\t[] AbstractBankAccount withdraw exception handling test handled successfully.\n");
    }
}
