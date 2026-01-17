package week01_bank_account_management_system;

import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {

    public static void main(String[] args) {
        // Creamos una lista de las cuentas
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();

        // Creamos un nuevo scanner para recibir los datos del usuario
        Scanner scanner = new Scanner(System.in);

        // Mostramos el menu
        showMenu();

        // Recibimos la opción del usuario
        int option = scanner.nextInt();
        scanner.nextLine(); // clear the buffer

        // Dependiendo de la opción seleccionada, ejecutamos el método
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

        // Ingresamos el numero de cuenta
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();

        // Ingresamos el nombre
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        double balance = 0.00;
        boolean isValid = false;

        while (!isValid) {

            System.out.println("Enter balance: ");

            if (scanner.hasNextDouble()) {
                balance = scanner.nextDouble();
                isValid = true;
            } else {
                System.out.println("Enter a valid number");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }

        int PIN = 0;

        while (!isValid) {

            System.out.println("Enter your PIN: ");

            if (scanner.hasNextInt()) {
                balance = scanner.nextInt();
                isValid = true;
            } else {
                System.out.println("Enter a valid PIN");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }

        scanner.nextLine();

        scanner.close(); // Cerramos el scanner.
        // Retornamos una nueva cuenta con los datos ingresados
        return new BankAccount(accountNumber, name, balance, PIN);


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
