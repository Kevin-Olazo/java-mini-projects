package week01_bank_account_management_system;

import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
    ArrayList<BankAccount> bankAccounts;

    public BankSystem() {
        this.bankAccounts = new ArrayList<>();
    }

    public static void main(String[] args) {
        // Creamos una lista de las cuentas

        // Creamos un nuevo scanner para recibir los datos del usuario
        Scanner scanner = new Scanner(System.in);

        BankSystem system = new BankSystem();

        BankAccount ba1 = new BankAccount("ASD", "Daniel", 100.00, 123);
        system.registerAccount(ba1);


        int option = 0;

        while (option != 7) {
            system.showMenu();
            option = scanner.nextInt();
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
                    system.changePIN();
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

        scanner.close();

    }

    // REGISTER NEW ACCOUNT METHOD
    // Registramos un nuevo usuario

    public void registerNewAccount() {
        // Creamos un scanner
        Scanner scanner = new Scanner(System.in);

        // Ingresamos el numero de cuenta
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();

        // Ingresamos el nombre
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        // Inicializamos balance como 0.0
        double balance = 0.00;

        // Creamos un boolean para utilizar en los bucles
        boolean isValid = false;

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
        int PIN = 0;

        // Creamos un while loop, mientras que el usuario ingrese un valor inválido, se repetirá el loop
        while (!isValid) {

            System.out.println("Enter your PIN: ");

            if (scanner.hasNextInt()) {

                PIN = scanner.nextInt();

                if (PIN < 0) {
                    System.out.println("PIN cannot be negative");
                    continue;
                }


                if (PIN < 1000) {
                    System.out.println("PIN must be at least 4 digits");
                    continue;
                }
                isValid = true;
            } else {
                System.out.println("Enter a valid PIN");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }

        scanner.nextLine();

        // Retornamos una nueva cuenta con los datos ingresados
        registerAccount(new BankAccount(accountNumber, name, balance, PIN));
    }

    public void registerAccount(BankAccount account) {
        if (account != null)
            bankAccounts.add(account);
    }


    public void depositMoney() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number account:");
        String accNumber = scanner.nextLine();

        BankAccount account = findBankAccount(accNumber);

        if (account != null) {
            System.out.println("Enter the amount to deposit:");
            double amount = scanner.nextDouble();

            account.deposit(amount);
            System.out.println("Deposited $" + amount + " to " + account.getAccountNumber());
        } else {
            System.out.println("Account not found");
        }
    }

    public void withdrawMoney() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number account:");
        String accNumber = scanner.nextLine();

        BankAccount account = findBankAccount(accNumber);

        if (account != null) {
            System.out.println("Enter the amount to withdraw:");
            double amount = scanner.nextDouble();

            account.withdraw(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    public void checkBalance() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number account:");
        String accNumber = scanner.nextLine();

        BankAccount account = findBankAccount(accNumber);

        if (account != null) {
            System.out.println("Enter your PIN:");
            int pin = scanner.nextInt();
            account.checkBalance(pin);
        } else {
            System.out.println("Account not found");
        }
    }

    //

    public void changePIN() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number account:");
        String accNumber = scanner.nextLine();

        BankAccount account = findBankAccount(accNumber);

        if (account != null) {
            System.out.println("Enter your previous PIN");
            int oldPIN = scanner.nextInt();
            if (account.validatePIN(oldPIN)) {
                System.out.println("Enter your new PIN");
                int newPIN = scanner.nextInt();
                account.changePIN(oldPIN, newPIN);
                System.out.println("PIN updated successfully!");
            } else {
                System.out.println("Wrong PIN");
            }

        }


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
        for (BankAccount ba : bankAccounts) {
            System.out.println(ba.toString());
        }
    }


}
