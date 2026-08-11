package utils;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentReportManager.setupReport();
    }

    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        ExtentReportManager.createTest(testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentReportManager.getTest()
                .pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTest test = ExtentReportManager.getTest();

        test.fail("Test Failed");

        if (result.getThrowable() != null) {
            test.fail(result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentReportManager.getTest()
                .skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentReportManager.flushReport();
    }
}