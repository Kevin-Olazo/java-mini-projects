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
            case 1 :
                BankAccount registerAccount = registerNewAccount();
                bankAccounts.add(registerAccount);

        }


        System.out.println(option);


    }

    public static BankAccount registerNewAccount() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("Enter balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter your PIN: ");
        int PIN = scanner.nextInt();
        scanner.nextLine();

        BankAccount newAccount = new BankAccount(accountNumber, name, balance, PIN);

        return newAccount;

    }



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
