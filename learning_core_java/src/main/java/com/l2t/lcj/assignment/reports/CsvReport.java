package com.l2t.lcj.assignment.reports;

public class CsvReport implements Report {
    @Override
    public void downloadReport() {
        System.out.println("Requested for CSV download");
    }
}
