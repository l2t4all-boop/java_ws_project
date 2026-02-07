package com.l2t.lsj.di.java;

import org.springframework.stereotype.Component;


public class EmailService {

    public void sendEmail(InvoiceDetails invoiceDetails){
        //LOGIC
        System.out.println("Sending invoice details via email");
    }

}
