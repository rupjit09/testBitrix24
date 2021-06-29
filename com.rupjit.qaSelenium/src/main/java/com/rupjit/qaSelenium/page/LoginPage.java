package com.rupjit.qaSelenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.rupjit.qaSelenium.base.DriverFactory;
import com.rupjit.qaSelenium.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(id="login")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Next')]")
	WebElement NEXT_Button;
	
	public LoginPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}
	
	public String validateLoginPageTitle() {
		return DriverFactory.getInstance().getDriver().getTitle();
	}
	
	public HomePage login(String un,String pwd) throws Exception{
		username.sendKeys(un);
		waitForVisibilityOfElement(NEXT_Button);
		NEXT_Button.click();
		password.sendKeys(pwd);
		waitForVisibilityOfElement(NEXT_Button);
		NEXT_Button.click();
		return new HomePage();
	}
	
}
