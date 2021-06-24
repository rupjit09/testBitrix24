package com.rupjit.qaSelenium.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rupjit.qaSelenium.base.TestBase;
//@Listeners({com.rupjit.qaSelenium.listeners.ExtentReportListener.class})
public class TestCase1 extends TestBase{

	@Test
	public static void testLogin() {
		driver.navigate().to("https://www.google.com/");
		//MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		//MyLogger.info("testing testLogin()");
	}
	
	@Test
	public static void testFBLogin() {
		driver.navigate().to("https://www.facebook.com/");
		Assert.assertEquals(1, 2);
		//MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		//MyLogger.info("testing testFBLogin()");
	}
}
