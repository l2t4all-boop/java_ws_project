package com.l2t.lsj.di.java;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InvoiceDetails {

    private String id;
    private String username;
    private String email;
    private double invoiceAmount;
    private String mobile;

}
