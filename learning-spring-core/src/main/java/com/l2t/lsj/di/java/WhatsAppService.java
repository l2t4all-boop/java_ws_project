package com.l2t.lsj.di.java;

import org.springframework.stereotype.Component;


public class WhatsAppService {

    public void sendMessage(InvoiceDetails invoiceDetails){
        //LOGIC
        System.out.println("Sending invoice details via whatsapp");
    }
}
