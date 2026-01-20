package com.l2t.lcj.assignment.reports;

public class PdfReport implements Report{
    @Override
    public void downloadReport() {
        System.out.println("Requested for pdf download");
    }
}
