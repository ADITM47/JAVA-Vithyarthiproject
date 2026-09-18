// Author: Adit Mehta
// Registration: 25BAI10756
// Project: Bank Management System

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    // We use ArrayLists instead of standard arrays because they can grow or shrink automatically.
    // These three lists work together. For example, index 0 in all three lists belongs to the first customer.
    static ArrayList<Integer> accountNumbers = new ArrayList<>();
    static ArrayList<String> accountNames = new ArrayList<>();
    static ArrayList<Double> accountBalances = new ArrayList<>();

    // A single Scanner used everywhere to read what the user types on the keyboard.
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Bank Management System!");

        int choice = 0;
        
        // This loop keeps the menu running until the user types '6' to exit.
        while (choice != 6) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Show All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            // We read the whole line as text, then convert it to a number.
            // This prevents a common beginner bug where the 'Enter' key gets stuck in the scanner.
            choice = Integer.parseInt(scanner.nextLine());

            // A 'switch' statement is a much cleaner way to handle menus than many if/else blocks.
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    showAllAccounts();
                    break;
                case 6:
                    System.out.println("Thank you for using the Bank Management System. Goodbye!");
                    break;
                default:
                    // This runs if the user types a number like 7, 8, or -1.
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

 
    // HELPER METHOD: FIND ACCOUNT
    
    // This searches our list of account numbers. 
    // If it finds a match, it returns the 'index' (the position in the list, like 0, 1, or 2).
    // If it doesn't find the account, it returns -1 (since lists can't have a -1 position).
    static int findAccount(int accNumber) {
        for (int i = 0; i < accountNumbers.size(); i++) {
            if (accountNumbers.get(i) == accNumber) {
                return i; // Found it! Return the position.
            }
        }
        return -1; // Loop finished without finding it.
    }

   
    // MODULE 1: ACCOUNT MANAGEMENT
   
    static void createAccount() {
        System.out.print("Enter a new account number: ");
        int accNumber = Integer.parseInt(scanner.nextLine());

        // We use our helper method here. If it returns anything other than -1, the account already exists.
        if (findAccount(accNumber) != -1) {
            System.out.println("Error: That account number already exists!");
            return; // Stops the method right here so we don't create a duplicate.
        }

        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial deposit amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        // Add the data to the end of our three lists. 
        // Because we add them at the same time, they will all share the same index position.
        accountNumbers.add(accNumber);
        accountNames.add(name);
        accountBalances.add(amount);

        System.out.println("Success! Account created.");
    }

  
    // MODULE 2: TRANSACTION PROCESSING
  
    static void depositMoney() {
        System.out.print("Enter account number: ");
        int accNumber = Integer.parseInt(scanner.nextLine());
        
        // Find where this account lives in our lists
        int index = findAccount(accNumber);

        if (index == -1) {
            System.out.println("Error: Account not found.");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amount = Double.parseDouble(scanner.nextLine());

        // Get the old balance, add the new amount, and save it back to the list.
        double oldBalance = accountBalances.get(index);
        double newBalance = oldBalance + amount;
        accountBalances.set(index, newBalance);

        System.out.println("Deposit successful. New balance: $" + newBalance);
    }

    static void withdrawMoney() {
        System.out.print("Enter account number: ");
        int accNumber = Integer.parseInt(scanner.nextLine());
        
        int index = findAccount(accNumber);

        if (index == -1) {
            System.out.println("Error: Account not found.");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double amount = Double.parseDouble(scanner.nextLine());

        double currentBalance = accountBalances.get(index);
        
        // Rule check: Make sure they have enough money before letting them withdraw.
        if (amount > currentBalance) {
            System.out.println("Error: Insufficient balance. You only have $" + currentBalance);
            return;
        }

        // Subtract the money and update the list.
        double newBalance = currentBalance - amount;
        accountBalances.set(index, newBalance);

        System.out.println("Withdrawal successful. New balance: $" + newBalance);
    }

    // MODULE 3: REPORTING
    
    static void checkBalance() {
        System.out.print("Enter account number: ");
        int accNumber = Integer.parseInt(scanner.nextLine());
        
        int index = findAccount(accNumber);

        if (index == -1) {
            System.out.println("Error: Account not found.");
            return;
        }

        // Grab the balance from the list using the index we found.
        System.out.println("Current balance: $" + accountBalances.get(index));
    }

    static void showAllAccounts() {
        // If the list size is 0, no one has created an account yet.
        if (accountNumbers.isEmpty()) {
            System.out.println("No accounts found in the system.");
            return;
        }

        System.out.println("\n--- All Registered Accounts ---");
        
         // A simple loop that counts from 0 up to the number of accounts we have.
        for (int i = 0; i < accountNumbers.size(); i++) {
            System.out.println("Account Number : " + accountNumbers.get(i));
            System.out.println("Holder Name    : " + accountNames.get(i));
            System.out.println("Balance        : $" + accountBalances.get(i));
            System.out.println("-------------------------------");
        }
    }
}
