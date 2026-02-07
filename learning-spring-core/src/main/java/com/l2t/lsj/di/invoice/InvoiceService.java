package com.l2t.lsj.di.invoice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceService {


    private final InvoiceRepo invoiceRepo;
    private final WhatsAppService whatsAppService;
    private final EmailService emailService;

    public void sendInvoice(String invoiceId){
         InvoiceDetails invoiceDetails = invoiceRepo.getInvoiceDetails(invoiceId);
         whatsAppService.sendMessage(invoiceDetails);
         emailService.sendEmail(invoiceDetails);
    }


}
