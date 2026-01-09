package com.l2t.lcj.enumsandarrays;

public class Account {

    private String accNumber;
    private String name;
    private double balance;


    public Account(String accNumber, String name, double balance){
        this.accNumber = accNumber;
        this.name = name;
        this.balance = balance;
    }

    public void showDetails() {
        System.out.println("Account number :" + maskAccountNumber(accNumber));
        System.out.println("Name           :" + name);
        showBalance();
    }

    public void withdraw(double amount){
        if(balance < amount){
            System.out.println("Sorry! you don't have sufficient funds!");
            showBalance();
        }else{
            balance -= amount;
            showBalance();
        }
    }
    public void deposit(double amount){
        balance += amount;
        showBalance();
    }

    public void showBalance(){
        System.out.println("Account "+maskAccountNumber(accNumber)+" has balance "+balance);
    }

    public String maskAccountNumber(String accNumber){
        return "********"+accNumber.substring(accNumber.length()-3);
    }

    public void setName(String name){
        this.name = name;
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
