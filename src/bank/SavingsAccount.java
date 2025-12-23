package bank;

public class SavingsAccount extends AbstractBankAccount {
    /**
     * The name of the account owner.
     */
    private String ownerName;

    /**
     * Constructor initializes the savings account with an owner name.
     *
     * @param name - The name of the account owner
     */
    public SavingsAccount(final String name) {
        super();
        this.ownerName = name;

    }

    /**
     * Returns the name of the account owner.
     *
     * @return The owner's name
     */
    public String getOwnerName() {
        return ownerName;
    }

}
