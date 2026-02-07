package com.l2t.lsj.di.invoice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    public String sendInvoice(String invoiceId){
        invoiceService.sendInvoice(invoiceId);
        return "Invoice send successfully";
    }
}
