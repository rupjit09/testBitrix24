package com.rupjit.qaSelenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rupjit.qaSelenium.base.DriverFactory;
import com.rupjit.qaSelenium.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[text()='CRM']")
	WebElement crm;
	
	public HomePage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}
	
	public String getHomePageTitle() {
		String HomePageTitle=DriverFactory.getInstance().getDriver().getTitle();
		return HomePageTitle;
	}
	public CRM_Page moveToCRMpage() {
		crm.click();
		return new CRM_Page();
		
	}
}
