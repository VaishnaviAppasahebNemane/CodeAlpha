package com.mycompany.codealpha;

import java.util.Scanner;

public class BankingApplication 
{
    static double balance = 0;
    static String accountHolder;

   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Welcome to the Banking Application!");
        System.out.print("Enter your name to create an account: ");
        accountHolder = scanner.nextLine();
        System.out.println("Account successfully created for " + accountHolder + "!\n");

        
        boolean exit = false;
        while (!exit) {
            System.out.println("Please select an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            
            switch (choice) {
                case 1:
                    deposit(scanner);
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the Banking Application. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println(); 
        }

        scanner.close();
    }

    
    public static void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid amount. Deposit must be greater than 0.");
        }
    }

    
    public static void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Transaction failed.");
        } else {
            System.out.println("Invalid amount. Withdrawal must be greater than 0.");
        }
    }

    
    public static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }
}
