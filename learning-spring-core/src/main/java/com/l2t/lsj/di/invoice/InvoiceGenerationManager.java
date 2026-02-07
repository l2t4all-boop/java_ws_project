package com.l2t.lsj.di.invoice;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.l2t.lsj.di.invoice"})
public class InvoiceGenerationManager {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(InvoiceGenerationManager.class);
        InvoiceController controller = context.getBean(InvoiceController.class);
        controller.sendInvoice("IN-2026-01-1001");

    }
}
