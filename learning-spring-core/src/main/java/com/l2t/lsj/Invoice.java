package com.l2t.lsj;


public class Invoice {
    private String id;
    private String account;
    private String amount;
    private String tax;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", amount='" + amount + '\'' +
                ", tax='" + tax + '\'' +
                '}';
    }
}
