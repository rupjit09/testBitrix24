package com.rupjit.qaSelenium.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rupjit.qaSelenium.base.TestBase;
import com.rupjit.qaSelenium.page.CRM_Page;
import com.rupjit.qaSelenium.page.LoginPage;

public class CRM_PageTest extends TestBase{

	CRM_Page crm_page;
	@BeforeMethod
	public void setup() throws Exception {
		crm_page=new LoginPage().login(prop.getProperty("username"), prop.getProperty("password")).moveToCRMpage();
	}
	
	@Test
	public void moveToCRM_ContactsPage() {
		crm_page.moveToCRM_Contact();
	}
}
