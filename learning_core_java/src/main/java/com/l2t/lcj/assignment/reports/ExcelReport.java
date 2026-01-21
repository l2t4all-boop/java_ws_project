package com.l2t.lcj.assignment.reports;

public class ExcelReport implements Report {
    @Override
    public void downloadReport() {
        System.out.println("Requested for Excel download");
    }
}
