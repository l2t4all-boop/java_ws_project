package com.l2t.lcj.assignment.reports;

public class AssignmentQuestion {

    public static void main(String[] args) {

        // Create all types of report classes
        // Based user input (Report type) we need to get Report object and invoke download report method

        Report report = getReport(ReportType.JSON);
        report.downloadReport();
    }

    // Factory method
    public static Report getReport(ReportType reportType){
        // Logic
        return null;
    }
}
