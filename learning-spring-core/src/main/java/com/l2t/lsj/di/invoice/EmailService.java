package com.l2t.lsj.di.invoice;

import org.springframework.stereotype.Component;

@Component
public class EmailService {

    public void sendEmail(InvoiceDetails invoiceDetails){
        //LOGIC
        System.out.println("Sending invoice details via email");
    }

}
