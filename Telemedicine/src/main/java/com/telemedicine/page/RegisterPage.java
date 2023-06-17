package com.telemedicine.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telemedicine.base.Base;

public class RegisterPage extends Base {
	
	@FindBy(xpath = "//input[@type=\"text\"]")
	WebElement patientname;
	
	@FindBy(xpath = "(//input[@type=\"text\"])[2]")
	WebElement mobilenumber;
	
	@FindBy(xpath = "(//input[@type=\"text\"])[3]")
	WebElement email;
	
	@FindBy(xpath = "//input[@type=\"password\"]")
	WebElement password;
	
	@FindBy(xpath = "(//input[@type=\"password\"])[2]")
	WebElement confirmpassword; 
	
	@FindBy(xpath = "//label[@class=\"mat-checkbox-layout\"]")
	WebElement checkboxRememberme;
	
	@FindBy(css = "button[color=\"primary\"]")
	WebElement registerbtn;
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle() {
		return driver.getTitle();
	}

	public LoginPage patientRegisterTest(String pname,String patientmobile,String pemail,String pw,String cnfpw) {
		patientname.sendKeys(pname);
		mobilenumber.sendKeys(patientmobile);
		email.sendKeys(pemail);
		password.sendKeys(pw);
		confirmpassword.sendKeys(cnfpw);
		checkboxRememberme.click();
		registerbtn.click();
		return new LoginPage();
		
	}
	
}
