package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static void setupReport() {

        String reportPath = System.getProperty("user.dir")
                + "/reports/ExtentReport.html";

        ExtentSparkReporter reporter =
                new ExtentSparkReporter(reportPath);

        reporter.config().setDocumentTitle("API Automation Test Report");
        reporter.config().setReportName("E-Commerce API Automation");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Project", "API Automation Framework");
        extent.setSystemInfo("Tester", "Youssef Shahat");
        extent.setSystemInfo("Framework", "REST Assured + TestNG");
    }

    public static void createTest(String testName) {

        test = extent.createTest(testName);
    }

    public static ExtentTest getTest() {

        return test;
    }

    public static void flushReport() {

        if (extent != null) {
            extent.flush();
        }
    }
}