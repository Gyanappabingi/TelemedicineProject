package com.telemedicine.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telemedicine.base.Base;

public class IndexPage extends Base {

	@FindBy(xpath = "//*[text()=\"Login\"]")
	WebElement login;
	
	@FindBy(xpath = "//*[text()=\"Patient\"]")
	WebElement patient;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnPatient() {
		Actions action=new Actions(driver);
		action.moveToElement(login).build().perform();
		patient.click();
		return new LoginPage();
	}
}
