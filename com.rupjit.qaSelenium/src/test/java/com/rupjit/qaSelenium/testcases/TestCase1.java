package com.rupjit.qaSelenium.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.rupjit.qaSelenium.base.TestBase;
@Listeners({com.rupjit.qaSelenium.listeners.AllureListener.class})
public class TestCase1 extends TestBase{

	@Test
	public static void testLogin() throws InterruptedException {
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(7000);
		//MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		//MyLogger.info("testing testLogin()");
	}
	
	@Test
	public static void testFBLogin() throws InterruptedException {
		driver.navigate().to("https://www.facebook.com/");
		Thread.sleep(7000);
		Assert.assertEquals(1, 2);
		//MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		//MyLogger.info("testing testFBLogin()");
	}
}
