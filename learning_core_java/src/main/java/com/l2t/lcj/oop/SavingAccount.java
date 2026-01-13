package com.l2t.lcj.oop;

public class SavingAccount extends Account {
    private double minBalance;

    public SavingAccount(String accNumber,String name, double balance, double minBalance){
        super(accNumber,name,balance);
        this.minBalance = minBalance;
    }

    @Override
    public void withdraw(double amount){
        if(amount > (balance - minBalance)){
            System.out.println("You don't have enough funds");
        }else{
            balance -= amount;
        }
    }
}
