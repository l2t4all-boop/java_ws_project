package com.l2t.lcj.oop;

public class CurrentAccount extends  Account{

        private double odAmount;

        public CurrentAccount(String accNumber,String name, double balance, double odAmount){
            super(accNumber,name,balance);
            this.odAmount = odAmount;
        }

        @Override
        public void withdraw(double amount){
            if(amount > (balance + odAmount)){
                System.out.println("You don't have enough funds");
            }else{
                balance -= amount;
            }
        }
}
