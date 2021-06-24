package com.rupjit.qaSelenium.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	public static WebDriver driver;
	
	
	@BeforeMethod
	public static void launchBrowser() {
		DriverFactory.getInstance().setDriver(new BrowserFactory().createBrowserInstance("chrome"));
		driver=DriverFactory.getInstance().getDriver();
	}
	
	
	@AfterMethod
	public static void closeBrowser() {
		DriverFactory.getInstance().closeBrowser();
	}
	
	public static String getScreenhot(WebDriver driver,String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
                //after execution, you could see a folder "TestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/target/TestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
