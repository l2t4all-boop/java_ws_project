package com.l2t.lsj.di.java;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvoiceService {


    private  final InvoiceRepo invoiceRepo;
    private  final WhatsAppService whatsAppService;
    private  final EmailService emailService;

    public void sendInvoice(String invoiceId){
         InvoiceDetails invoiceDetails = invoiceRepo.getInvoiceDetails(invoiceId);
         whatsAppService.sendMessage(invoiceDetails);
         emailService.sendEmail(invoiceDetails);
    }


}
