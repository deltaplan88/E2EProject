package com.feniks.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporterNG {
    static ExtentReports  extentReport;
    public  static ExtentReports getExtentReportObject() {

        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
        reporter.config().setReportName("My First Report");
        reporter.config().setDocumentTitle("My DOc Title");
        extentReport = new ExtentReports();
        extentReport.attachReporter(reporter);
        extentReport.setSystemInfo("tester", "Alex");
        return extentReport;
    }

}
