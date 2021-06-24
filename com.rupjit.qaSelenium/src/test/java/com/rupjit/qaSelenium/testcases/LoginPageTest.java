package com.rupjit.qaSelenium.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.rupjit.qaSelenium.base.TestBase;
import com.rupjit.qaSelenium.page.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	
	@Test
	public void loginPageTitleTest() {
		loginpage=new LoginPage(); 
		String title=loginpage.validateLoginPageTitle();
		System.out.println("TITLE="+title);
		//Assert.assertEquals(title, "Arena");
	}
	
	@Test
	public void loginTest() throws Exception {
		loginpage=new LoginPage(); 
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void loginFailTest() throws Exception {
		loginpage=new LoginPage(); 
		loginpage.login("admin", "noasd");
		Assert.assertEquals("A", "B");
	}
}
