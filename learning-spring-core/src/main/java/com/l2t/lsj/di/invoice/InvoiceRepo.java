package com.l2t.lsj.di.invoice;

import org.springframework.stereotype.Repository;

@Repository
public class InvoiceRepo {

    public InvoiceDetails getInvoiceDetails(String invoiceId){
        // Logic
        System.out.println("Getting invoice details");
        InvoiceDetails invoiceDetails =
                InvoiceDetails
                        .builder()
                        .invoiceAmount(500)
                        .id("IN-2026-01-1001")
                        .email("krish@gmail.com")
                        .mobile("9876543210")
                        .build();
        return invoiceDetails;
    }
}
