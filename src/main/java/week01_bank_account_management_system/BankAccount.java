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

    }

    public void withdraw(double amount) {

    }
}
