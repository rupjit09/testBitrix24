package com.rupjit.qaSelenium.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rupjit.qaSelenium.base.TestBase;
import com.rupjit.qaSelenium.page.HomePage;
import com.rupjit.qaSelenium.page.LoginPage;

public class HomePageTest extends TestBase{

	HomePage homepage;
	
	@BeforeMethod
	public void login() throws Exception {
		homepage=new LoginPage().login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageTitle() {
		String HomePageTitle=homepage.getHomePageTitle();
		System.out.println("HomePageTitle="+HomePageTitle);
	}
	@Test
	public void moveToCRMPage() {
		homepage.moveToCRMpage();
		
	}
}
