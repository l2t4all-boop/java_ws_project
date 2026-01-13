package com.l2t.lcj.oop;

public class Account {

    String accNumber;
    String name;
    double balance;

    public Account(String accNumber, String name, double balance) {
        this.accNumber = accNumber;
        this.name = name;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("You don't sufficient funds to withdraw");
        } else {
            this.balance -= amount;
        }
    }

    public void showDetails(){
        System.out.println("Account num: "+accNumber);
        System.out.println("Name       :"+name);
        System.out.println("Balance    :"+balance);
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
}
