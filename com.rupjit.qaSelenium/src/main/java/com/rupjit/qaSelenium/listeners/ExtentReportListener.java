package com.rupjit.qaSelenium.listeners;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.rupjit.qaSelenium.base.DriverFactory;
import com.rupjit.qaSelenium.base.ExtentFactory;
import com.rupjit.qaSelenium.base.ExtentReportSetup;
import com.rupjit.qaSelenium.base.TestBase;

public class ExtentReportListener extends TestBase implements ITestListener{

	static ExtentReports report;
	   ExtentTest test;
	   
public void onTestStart(ITestResult result) {
	//before each test case
	test = report.createTest(result.getMethod().getMethodName());
	ExtentFactory.getInstance().setExtent(test);
}

public void onTestSuccess(ITestResult result) {
	ExtentFactory.getInstance().getExtentTest().log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+ " is Passed.");
	//ExtentFactory.getInstance().removeExtentObject();
	//add screenshot for failed test.
		String screenshotPath="";
		try {
			long nanos = java.lang.System.nanoTime();
			long threadId = Thread.currentThread().getId();
			screenshotPath=getScreenhot(DriverFactory.getInstance().getDriver(), result.getMethod().getMethodName()+"_"+nanos+"_"+threadId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ExtentFactory.getInstance().getExtentTest().addScreenCaptureFromPath(screenshotPath, "Test case success screenshot");
			ExtentFactory.getInstance().removeExtentObject();

		} catch (IOException e) {
			e.printStackTrace();
		}
}

public void onTestFailure(ITestResult result) {
	ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+ " is Failed.");
	ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, result.getThrowable());
	
	//add screenshot for failed test.
	String screenshotPath="";
	try {
		long nanos = java.lang.System.nanoTime();
		long threadId = Thread.currentThread().getId();
		screenshotPath=getScreenhot(DriverFactory.getInstance().getDriver(), result.getMethod().getMethodName()+"_"+nanos+"_"+threadId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		ExtentFactory.getInstance().getExtentTest().addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");
		ExtentFactory.getInstance().removeExtentObject();

	} catch (IOException e) {
		e.printStackTrace();
	}
	

}

public void onTestSkipped(ITestResult result) {
	ExtentFactory.getInstance().getExtentTest().log(Status.SKIP, "Test Case: "+result.getMethod().getMethodName()+ " is skipped.");
	ExtentFactory.getInstance().removeExtentObject();
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
}

public void onTestFailedWithTimeout(ITestResult result) {
}

public void onStart(ITestContext context) {
	try {
		 report = ExtentReportSetup.setupExtentReport();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void onFinish(ITestContext context) {
	//close extent
	report.flush();
}

}
