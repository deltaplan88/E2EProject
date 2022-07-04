package com.feniks.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.feniks.utils.TestUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class Listeners extends TestUtils implements ITestListener {

    ExtentReports extent = ExtentReporterNG.getExtentReportObject();
    ExtentTest test;
    ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<ExtentTest>();
    @Override
    public void onTestSuccess(ITestResult result) {
        //threadLocal.get().log(Status.PASS, "Test Passed");
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test =   extent.createTest(result.getMethod().getRealClass().getName());
       // threadLocal.set(test);
    }

    @Override
    public void onTestFailure(ITestResult result)  {

        //threadLocal.get().fail(result.getThrowable());
        test.fail(result.getThrowable());

        try {
            String path = takeAndSaveScreenShot(result.getClass().getName(), driver);
            test.addScreenCaptureFromPath(path, result.getClass().getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onFinish(ITestContext context) {
        extent.flush();


    }


}
