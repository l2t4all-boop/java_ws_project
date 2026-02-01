package com.l2t.lcj.exceptions;

public class InsufficientFundsException extends Exception {
    private double amount;
    private double balance;

    public InsufficientFundsException(double amount, double balance) {
        super("Insufficient funds: attempted to withdraw " + amount + " but balance is " + balance);
        this.amount = amount;
        this.balance = balance;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public double getDeficit() {
        return amount - balance;
    }
}