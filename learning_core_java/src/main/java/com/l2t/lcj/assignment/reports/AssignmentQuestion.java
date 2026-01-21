package com.l2t.lcj.assignment.reports;

public class AssignmentQuestion {

    public static void main(String[] args) {
        Report report = getReport(ReportType.JSON);
        report.downloadReport();
    }

    public static Report getReport(ReportType reportType){
        return switch (reportType) {
            case PDF -> new PdfReport();
            case EXCEL -> new ExcelReport();
            case JSON -> new JsonReport();
            case CSV -> new CsvReport();
            default -> throw new IllegalArgumentException("Unsupported report type: " + reportType);
        };
    }
}
