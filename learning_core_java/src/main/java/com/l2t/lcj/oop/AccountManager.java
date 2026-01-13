package com.l2t.lcj.oop;

public class AccountManager {
    public static void main(String[] args) {
        Account[] accounts = getAccounts();
        int currentAccountCount = 0;
        int totalAccounts = accounts.length;
        for (Account acc : accounts) {
            acc.showDetails();
            System.out.println("-".repeat(100));
            if (acc instanceof CurrentAccount) {
                currentAccountCount++;
            }
        }
        System.out.println("Total Accounts " + totalAccounts);
        System.out.println("Savings account count :" + (totalAccounts - currentAccountCount));
        System.out.println("Current account count :" + currentAccountCount);
    }

    public static Account[] getAccounts() {
        Account acc1 = new CurrentAccount("CB1001", "L2T", 500000, 50000);
        Account acc2 = new CurrentAccount("CB1003", "INFY", 500000, 50000);
        Account acc3 = new CurrentAccount("CB1002", "KULFY", 500000, 50000);
        Account acc4 = new SavingAccount("SB1002", "Charan", 1500000, 500);
        Account acc5 = new SavingAccount("SB1001", "Krish", 100000, 5000);
        return new Account[]{acc1, acc2, acc3, acc4, acc5};
    }
}
