package com.l2t.lcj.assignment.reports;

public class JsonReport implements Report {
    @Override
    public void downloadReport() {
        System.out.println("Requested for JSON download");
    }
}
