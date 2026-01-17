package week01_bank_account_management_system;

import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {

    public static void main(String[] args) {
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);

        showMenu();

        int option = scanner.nextInt();
        scanner.nextLine(); // clear the buffer

        switch (option) {
            case 1:
                BankAccount registerAccount = registerNewAccount();
                bankAccounts.add(registerAccount);

        }


        System.out.println(option);


    }

    // REGISTER NEW ACCOUNT METHOD
    // Registramos un nuevo usuario

    public static BankAccount registerNewAccount() {
        // Creamos un scanner
        Scanner scanner = new Scanner(System.in);

        // try-catch
        try {
            // Ingresamos el numero de cuenta
            System.out.println("Enter account number: ");
            String accountNumber = scanner.nextLine();

            // Ingresamos el nombre
            System.out.println("Enter name: ");
            String name = scanner.nextLine();

            // Ingresamos el balance
            System.out.println("Enter balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine();

            // Ingresamos el PIN
            System.out.println("Enter your PIN: ");
            int PIN = scanner.nextInt();
            scanner.nextLine();

            // Retornamos una nueva cuenta con los datos ingresados
            return new BankAccount(accountNumber, name, balance, PIN);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        scanner.close(); // Cerramos el scanner.

        return null;
    }

    // SHOW MENU METHOD
    // Mostramos las opciones al usuario

    public static void showMenu() {
        System.out.println("====== MENU =======");
        System.out.println("1. Create new account");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. Check balance");
        System.out.println("5. Change PIN");
        System.out.println("6. Display all accounts");
        System.out.println("7. Exit");
    }
}
