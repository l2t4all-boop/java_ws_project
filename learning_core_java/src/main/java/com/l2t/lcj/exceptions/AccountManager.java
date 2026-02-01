package com.l2t.lcj.exceptions;

public class AccountManager {
    public static void main(String[] args) {
        Account account = new Account("ACC001", "John Doe", 1000.0);

        System.out.println("=== Initial Account Details ===");
        account.showDetails();

        System.out.println("\n=== Deposit 500 ===");
        account.deposit(500);
        account.showDetails();

        System.out.println("\n=== Withdraw 300 ===");
        try {
            account.withdraw(300);
            account.showDetails();
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Withdraw 2000 (should fail) ===");
        try {
            account.withdraw(2000);
            account.showDetails();
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Deficit amount: " + e.getDeficit());
        }

        System.out.println("\n=== Final Account Details ===");
        account.showDetails();
    }
}