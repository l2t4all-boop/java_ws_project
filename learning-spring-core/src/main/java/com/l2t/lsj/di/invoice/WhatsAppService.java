package com.l2t.lsj.di.invoice;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class WhatsAppService {

    public void sendMessage(InvoiceDetails invoiceDetails){
        //LOGIC
        System.out.println("Sending invoice details via whatsapp");
    }
}
