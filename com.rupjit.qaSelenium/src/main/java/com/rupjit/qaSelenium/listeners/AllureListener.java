package com.rupjit.qaSelenium.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.rupjit.qaSelenium.base.DriverFactory;
import com.rupjit.qaSelenium.base.TestBase;

import io.qameta.allure.Attachment;

public class AllureListener extends TestBase implements ITestListener{
	
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	// Text attachments for Allure
		@Attachment(value = "Page screenshot", type = "image/png")
		public byte[] saveScreenshotPNG(WebDriver driver) {
			return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		}

		// Text attachments for Allure
		@Attachment(value = "{0}", type = "text/plain")
		public static String saveTextLog(String message) {
			return message;
		}

		// HTML attachments for Allure
		@Attachment(value = "{0}", type = "text/html")
		public static String attachHtml(String html) {
			return html;
		}

	public void onTestStart(ITestResult result) {
		System.out.println("Testcase " +getTestMethodName(result)+" started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcase " +getTestMethodName(result)+" Passed");
		if (driver instanceof WebDriver) {
			saveScreenshotPNG(DriverFactory.getInstance().getDriver());
		}
		// Save a log on allure.
		saveTextLog(getTestMethodName(result) + " Passed and screenshot taken!");	
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Testcase " +getTestMethodName(result)+" Failed");
		//WebDriver driver = DriverFactory.getInstance().getDriver();
		// Allure ScreenShotRobot and SaveTestLog
		if (driver instanceof WebDriver) {
			saveScreenshotPNG(DriverFactory.getInstance().getDriver());
		}
		// Save a log on allure.
		saveTextLog(getTestMethodName(result) + " failed and screenshot taken!");	
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcase " +getTestMethodName(result)+" skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext iTestContext) {
		iTestContext.setAttribute("WebDriver", DriverFactory.getInstance().getDriver());
		
	}

	public void onFinish(ITestContext iTestContext) {
		System.out.println("Test method " + iTestContext.getName()+ " completed");
		
	}

}
