package com.l2t.lcj.exceptions;

public class Account {
    private String accNum;
    private String name;
    private double balance;

    public Account(String accNum, String name, double balance) {
        this.accNum = accNum;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount, balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    public void showDetails() {
        System.out.println("Account Number: " + accNum);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }

    // Getters
    public String getAccNum() {
        return accNum;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
}