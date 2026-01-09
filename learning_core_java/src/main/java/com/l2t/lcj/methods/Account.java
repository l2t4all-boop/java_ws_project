package com.l2t.lcj.methods;


public class Account {

    private String accNumber;
    private String name;
    private double balance;
    private String email;
    private String mobile;
    private boolean active;

    public Account(String accNumber,String name,double balance){
          this(accNumber,name,balance,"N/A","N/A",false);
    }

    public Account(String accNumber,String name,double balance, String email, String mobile, boolean active){
        this.accNumber = accNumber;
        this.name = name;
        this.balance = balance;
        this.email=email;
        this.mobile = mobile;
        this.active = active;
    }

    public void showDetails(){
        System.out.println("Account number :"+accNumber);
        System.out.println("Name           :"+name);
        System.out.println("Balance        :"+balance);
        System.out.println("Email          :"+email);
        System.out.println("Mobile         :"+mobile);
        System.out.println("Is active      :"+active);
    }


    public static void main(String[] args) {
        Account account1 = new Account("SB10001","Krish",8765);
        account1.showDetails();
        System.out.println("...............................................");
        Account account2 = new Account("SB10002","Manoj",8896540,"manoj@gmail.com","8876543569",true);
        account2.showDetails();

    }

}
