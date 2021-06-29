package com.rupjit.qaSelenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rupjit.qaSelenium.base.DriverFactory;
import com.rupjit.qaSelenium.base.TestBase;

public class CRM_Page extends TestBase{
	
	@FindBy(xpath="//span[text()='Contacts' and @class='main-buttons-item-text-title']")
	WebElement contactPageTab;

	public CRM_Page() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}
	//navigate to Contacts tab
	public CRM_Contacts_Page moveToCRM_Contact() {
		waitForVisibilityOfElement(contactPageTab);
		contactPageTab.click();	
		return new CRM_Contacts_Page();
	}
}
