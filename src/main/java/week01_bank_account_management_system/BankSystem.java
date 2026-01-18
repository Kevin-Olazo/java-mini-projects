package week01_bank_account_management_system;

import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
    ArrayList<BankAccount> bankAccounts;
    Scanner scanner;

    public BankSystem() {
        this.bankAccounts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        // Creamos una lista de las cuentas

        BankSystem system = new BankSystem();

        BankAccount ba1 = new BankAccount("ASD", "Daniel", 100.00, 1234);
        system.registerAccount(ba1);


        int option = 0;

        while (option != 7) {
            system.showMenu();

            if (system.scanner.hasNextInt()) {
                option = system.scanner.nextInt();
                system.scanner.nextLine();
            } else {
                system.scanner.nextLine();
                System.out.println("Enter a valid option (1-7)");
                continue;
            }
            switch (option) {
                case 1:
                    system.registerNewAccount();
                    break;
                case 2:
                    system.depositMoney();
                    break;
                case 3:
                    system.withdrawMoney();
                    break;
                case 4:
                    system.checkBalance();
                    break;
                case 5:
                    system.updatePIN();
                    break;
                case 6:
                    system.displayAllAccounts();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Enter a valid option (1-7)");
            }
        }

        system.scanner.close();

    }

    // REGISTER NEW ACCOUNT METHOD
    // Registramos un nuevo usuario

    public void registerNewAccount() {
        // Creamos un boolean para utilizar en los bucles
        boolean isValid = false;

        String accountNumber = "";

        while (!isValid) {
            // Ingresamos el numero de cuenta
            System.out.println("Enter account number: ");

            if (scanner.hasNextLine()) {
                accountNumber = scanner.nextLine();

                if (accountNumber == null || accountNumber.trim().isEmpty()) {
                    System.out.println("Enter a valid account number");
                } else {
                    isValid = true;

                }
            }

        }


        isValid = false;

        String name = "";

        while (!isValid) {
            // Ingresamos el numero de cuenta
            System.out.println("Enter name: ");

            if (scanner.hasNextLine()) {
                name = scanner.nextLine();

                if (name == null || name.trim().isEmpty()) {
                    System.out.println("Enter a valid name");
                } else {
                    isValid = true;

                }
            }

        }

        isValid = false;

        // Inicializamos balance como 0.0
        double balance = 0.00;

        // Creamos un while loop, mientras que el usuario ingrese un valor inválido, se repetirá el loop
        while (!isValid) {
            System.out.println("Enter balance: ");

            if (scanner.hasNextDouble()) {
                balance = scanner.nextDouble();
                if (balance < 0) {
                    System.out.println("Balance cannot be negative.");
                    continue;
                } else if (balance < 100) {
                    System.out.println("Minimal opening balance must be 100");
                    continue;
                }
                isValid = true;
            } else {
                System.out.println("Enter a valid number");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }

        // Regresamos el valor a falso
        isValid = false;

        // Inicializamos el PIN
        int pin = 0;

        // Creamos un while loop, mientras que el usuario ingrese un valor inválido, se repetirá el loop
        while (!isValid) {

            System.out.println("Enter your PIN: ");
            if (scanner.hasNextInt()) {
                pin = scanner.nextInt();
                scanner.nextLine();
                if (pin < 1000 || pin > 9999) {
                    System.out.println("PIN must be at least 4 digits");
                    continue;
                }
                isValid = true;
            } else {
                System.out.println("Enter a valid PIN");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }


        // Retornamos una nueva cuenta con los datos ingresados
        registerAccount(new BankAccount(accountNumber, name, balance, pin));
    }

    public void registerAccount(BankAccount account) {
        if (account != null)
            bankAccounts.add(account);
    }


    public void depositMoney() {
        BankAccount account = selectAccount();

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        System.out.println("Enter the amount to deposit:");

        // Validamos que sea número antes de leer
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();

            // PROTEGEMOS EL CODIGO CON TRY-CATCH
            try {
                account.deposit(amount);
                System.out.println("Deposited $" + amount + " to " + account.getAccountNumber());
            } catch (IllegalArgumentException e) {
                System.out.println("Transaction failed: " + e.getMessage());
            }


        } else {
            System.out.println("Invalid number");
            scanner.next();
        }


    }

    public void withdrawMoney() {
        BankAccount account = selectAccount();

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        if (!verifyPIN(account)) {
            System.out.println("Wrong PIN.");
            return;
        }

        System.out.println("Enter the amount to withdraw:");
        if (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.println("Enter a valid amount to withdraw");
            return;
        }

        try {
            double amount = scanner.nextDouble();
            account.withdraw(amount);
            System.out.println("Successfully withdraw $" + amount);
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }


    }


    public void checkBalance() {
        BankAccount account = selectAccount();

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        if (!verifyPIN(account)) {
            System.out.println("Wrong PIN.");
            return;
        }

        account.checkBalance();

    }

    //

    public void updatePIN() {
        BankAccount account = selectAccount();

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        System.out.println("Enter your previous PIN");
        if (scanner.hasNextInt()) {
            int oldPin = scanner.nextInt();
            scanner.nextLine();
            try {
                if (account.validatePIN(oldPin)) {
                    System.out.println("Enter your new PIN");
                    int newPin = scanner.nextInt();
                    scanner.nextLine();
                    account.changePIN(oldPin, newPin);
                    System.out.println("PIN updated successfully!");
                } else {
                    System.out.println("Wrong PIN");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public BankAccount selectAccount() {
        System.out.println("Enter number account:");
        String accNumber = scanner.nextLine();
        return findBankAccount(accNumber);
    }


    public boolean verifyPIN(BankAccount account) {

        for (int attempts = 0; attempts < 3; attempts++) {
            System.out.println("Enter your PIN:");
            if (scanner.hasNextInt()) {
                int pin = scanner.nextInt();
                scanner.nextLine();
                if (account.validatePIN(pin)) {
                    return true;
                }
                System.out.println("Wrong PIN. " + (2 - attempts) + " attempts remaining.");
            } else {
                System.out.println("Invalid input.");
                scanner.next();
            }
        }
        return false;
    }

    // SHOW MENU METHOD
    // Mostramos las opciones al usuario
    public void showMenu() {
        System.out.println("====== MENU =======");
        System.out.println("1. Create new account");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. Check balance");
        System.out.println("5. Change PIN");
        System.out.println("6. Display all accounts");
        System.out.println("7. Exit");
        System.out.println("Choose an option: (1-7)");
    }

    public BankAccount findBankAccount(String accNumber) {
        for (BankAccount ba : bankAccounts) {
            if (ba.getAccountNumber().equals(accNumber)) {
                return ba;
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        if (bankAccounts.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        for (BankAccount ba : bankAccounts) {
            System.out.println(ba.toString());
        }
    }

}
