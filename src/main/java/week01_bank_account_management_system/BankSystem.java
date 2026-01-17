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
        system.getBankAccounts().add(ba1);


        int option = 0;

        while (option != 7) {
            system.showMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    system.registerNewAccount();
                    break;
                case 2:
                    depositMoney(bankAccounts);
                    break;
                case 3:
                   withdrawMoney(bankAccounts);
                    break;
                case 4:
                    checkBalance();
                    break;
                case 6:
//                    displayAllAccounts();
                    break;
                case 7:
//                    exit();
                    break;
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
                    scanner.next();
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
                if (PIN <= 0) {
                    System.out.println("Enter a valid PIN");
                    scanner.next();
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
       bankAccounts.add(new BankAccount(accountNumber, name, balance, PIN)) ;
    }


    public void depositMoney(ArrayList<BankAccount> bankAccounts) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe el numero de cuenta a la que deseas depositar:");
        BankAccount ba = null;

        String accountNumber = scanner.nextLine();

        for (BankAccount bas : bankAccounts) {
            if (accountNumber.equals(bas.getAccountNumber())) {
                ba = bas;
                break;
            } else {
                System.out.println("No existe ese numero de cuenta");
            }
        }

        if (ba != null) {
            System.out.println("Escribe el monto a depositar:");
            double amount = scanner.nextDouble();
            ba.deposit(amount);
        }
        scanner.nextLine();

    }

    public void withdrawMoney(ArrayList<BankAccount> bankAccounts) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe el numero de cuenta a la que deseas depositar:");
        BankAccount ba = null;

        String accountNumber = scanner.nextLine();

        for (BankAccount bas : bankAccounts) {
            if (accountNumber.equals(bas.getAccountNumber())) {
                ba = bas;
                break;
            } else {
                System.out.println("No existe ese numero de cuenta");
            }
        }

        if (ba != null) {
            System.out.println("Escribe el monto a retirar:");
            double amount = scanner.nextDouble();
            ba.withdraw(amount);
        }
        scanner.nextLine();

    }

    public void checkBalance(){

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

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}
