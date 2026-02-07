package com.l2t.lsj.di.java;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {


    @Bean
    public InvoiceController invoiceController(){
        return new InvoiceController(invoiceService());
    }

    @Bean
    public InvoiceService invoiceService(){
      return new InvoiceService(invoiceRepo(),whatsAppService(),emailService());

    }

    @Bean
    public InvoiceRepo invoiceRepo(){
        return new InvoiceRepo();
    }

    @Bean
    public EmailService emailService(){
        return new EmailService();
    }

    @Bean
    public WhatsAppService whatsAppService(){
        return new WhatsAppService();
    }
}
