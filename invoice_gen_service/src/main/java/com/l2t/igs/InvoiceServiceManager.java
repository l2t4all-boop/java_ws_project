package com.l2t.igs;

import com.l2t.igs.service.InvoiceService;
import com.l2t.igs.service.InvoiceServiceImpl;

public class InvoiceServiceManager {
    public static void main(String[] args) {

        InvoiceService invoiceService = new InvoiceServiceImpl();
        invoiceService.generateAndSentInvoices();
    }
}
