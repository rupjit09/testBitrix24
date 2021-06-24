package com.rupjit.qaSelenium.rough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rupjit.qaSelenium.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test1 extends TestBase{
 
	@BeforeMethod
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	@Test
	public static void testLogin() {
		driver.navigate().to("https://www.google.com/");
	}
	
	@AfterMethod
	public static void closeBrowser() {
		driver.quit();
	}
}
