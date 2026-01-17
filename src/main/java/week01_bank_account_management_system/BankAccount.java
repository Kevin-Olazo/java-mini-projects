package week01_bank_account_management_system;

public class BankAccount {
    // PRIVATE FIELDS
    private String accountNumber;
    private String holderName;
    private double balance;
    private int PIN;

    // CONSTRUCTOR
    public BankAccount(String accountNumber, String holderName, double balance, int PIN) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.PIN = PIN;
    }

    // PUBLIC METHODS
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Error. Enter a valid amount to deposit");

        }
        this.balance = this.balance + amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Error. Enter a valid amount to withdraw");
        } else if (amount > this.balance) {
            throw new IllegalArgumentException("Error. Not enough funds.");
        }
        this.balance = this.balance - amount;
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + this.balance );

    }

    public void changePIN(int oldPIN, int newPIN) {
        if (validatePIN(oldPIN)){
            this.PIN = newPIN;
        }
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public boolean validatePIN(int pin) {
        return pin == this.PIN;
    }

    @Override
    public String toString() {
        return "Account number: " + getAccountNumber() + " Account holder: " + getHolderName();
    }
}
