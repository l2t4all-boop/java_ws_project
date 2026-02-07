package com.l2t.lsj.di.java;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    public String sendInvoice(String invoiceId){
        invoiceService.sendInvoice(invoiceId);
        return "Invoice send successfully";
    }
}
