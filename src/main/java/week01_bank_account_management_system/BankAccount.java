package week01_bank_account_management_system;

public class BankAccount {
    private final static double MIN_BALANCE = 100.00;
    private final static int MIN_PIN = 1000;
    private final static int MAX_PIN = 9999;

    // PRIVATE FIELDS
    private String accountNumber;
    private String holderName;
    private double balance;
    private int pin;

    // CONSTRUCTOR
    public BankAccount(String accountNumber, String holderName, double balance, int pin) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        this.accountNumber = accountNumber;

        if (holderName == null || holderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.holderName = holderName;

        if (balance < MIN_BALANCE ) {
            throw new IllegalArgumentException("Minimum balance of $100.00");
        }
        this.balance = balance;

        if (pin < MIN_PIN || pin > MAX_PIN) {
            throw new IllegalArgumentException("PIN must be 4 digits");
        }

        this.pin = pin;
    }

    // PUBLIC METHODS
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Error. Enter a valid amount to deposit");

        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Enter a valid amount to withdraw");
        } else if (amount > this.balance) {
            throw new IllegalArgumentException("Not enough funds.");
        }
        this.balance -= amount;
    }

    public void checkBalance() {
        System.out.printf("Current balance: $%.2f%n", this.balance);
    }

    public void changePIN(int oldPin, int newPin) {
        if (validatePIN(oldPin)) {
            if (newPin < MIN_PIN || newPin > MAX_PIN) {
                throw new IllegalArgumentException("Pin must be 4 digits");
            }
            this.pin = newPin;
        }
    }

    public boolean validatePIN(int pin) {
        return pin == this.pin;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }


    @Override
    public String toString() {
        return "Account number | " + getAccountNumber() + " Account holder | " + getHolderName();
    }
}
