package com.l2t.lcj.enumsandarrays;

public class AccountManager {

    public static void main(String[] args) {

        Account[] accounts = getAllAccounts();
        // Get me the total balance of all accounts

        double totalAmount = 0;
        for (Account acc : accounts) {
            totalAmount += acc.getBalance();
        }

        System.out.printf("Accounts count :%s\nTotal Balance :%s", accounts.length, totalAmount);


    }

    private static Account[] getAllAccounts() {
        Account acc1 = new Account("SB1234567890", "Krish", 50000);
        Account acc2 = new Account("SB2234567899", "Charan", 150000);
        Account acc3 = new Account("SB5234567899", "Manoj", 150000);
        Account acc4 = new Account("SB3234567899", "John", 350000);
        Account acc5 = new Account("SB6234567899", "Aadhya", 250000);
        return new Account[]{acc1, acc2, acc3, acc4, acc5};
    }

}
