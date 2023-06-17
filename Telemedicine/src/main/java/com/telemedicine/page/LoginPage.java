package com.telemedicine.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telemedicine.base.Base;

public class LoginPage extends Base {

	@FindBy(xpath = "//input[@type=\"text\"]")
	WebElement username;
	
	@FindBy(xpath = "//input[@type=\"password\"]")
	WebElement password;
	
	@FindBy(css = "span.mat-checkbox-inner-container")
	WebElement checkbox;
	
	@FindBy(xpath =  "//*[text()=\"Login\"]")
	WebElement loginbtn;
	
	@FindBy(xpath = "(//span[@class=\"mat-button-wrapper\"])[2]")
	WebElement registerbtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public RegisterPage clickOnRegister() {
		registerbtn.click();
		return new RegisterPage();
		
	}
	
	public Dashboard login(String un,String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		checkbox.click();
		loginbtn.click();
		return new Dashboard();
		
	}
}
