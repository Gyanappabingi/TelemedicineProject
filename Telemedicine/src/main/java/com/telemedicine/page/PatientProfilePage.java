package com.telemedicine.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.telemedicine.base.Base;
import com.telemedicine.util.Utils;

public class PatientProfilePage extends Base {
	
	
	
	@FindBy(xpath = "//mat-icon[@class=\"mat-icon notranslate material-icons mat-icon-no-color\" and text()=\"edit\"]")
	WebElement editbutton;
	
	@FindBy(xpath = "//input[@type=\"file\"]")
	WebElement fileUpload;

	@FindBy(css = "input[formcontrolname=\"Lastname\"]")
	WebElement lastName;
	
	@FindBy(id = "mat-select-value-1")
	WebElement gender;
	
	
	@FindBy(css = "input[formcontrolname=\"DOB\"]")
	WebElement date;
	
	@FindBy(css = "input[formcontrolname=\"Age\"]")
	WebElement age;
	
	@FindBy(xpath = "//div[@class=\"mat-select-value ng-tns-c164-22\"]")
	WebElement bloodGroup;
	
	@FindBy(xpath = "//div[@class=\"mat-select-value ng-tns-c164-24\"]")
	WebElement countryName;
	
	@FindBy(css = "mat-select[formcontrolname=\"State_Id_FK\"]")
	WebElement stateName;
	
	@FindBy(css = "mat-select[id=\"district\"]")
	WebElement district;
	
	@FindBy(css = "mat-select[id=taluk]")
	WebElement taluk;
	
	@FindBy(css = "mat-select[formcontrolname=\"Gram_Id_FK\"]")
	WebElement village;
	
	@FindBy(xpath = "//span[text()=\"Update\"]")
	WebElement updateButton;
	

	Utils util=new Utils() ;
	
	public PatientProfilePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void patientProfile(String path,String lName,String patientgender,String Bdate,String Page,String  bloodGrp,String patientCountry,String patientState,String patientDistrict,String patienttaluk,String patientVillage) throws Exception {
		editbutton.click();
		
		fileUpload.sendKeys(path);
		
		lastName.clear();
		lastName.sendKeys(lName);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).
		until(ExpectedConditions.elementToBeClickable(gender));
		
		js.executeScript("arguments[0].click()", gender);
		
		List<WebElement> genderoption=driver.findElements(By.tagName("mat-option"));
        util.selectValueFromDropDwon(genderoption, patientgender);
		
		date.sendKeys(Bdate);
		
		age.sendKeys(Page);
		
		bloodGroup.click();
		
		List<WebElement> bGroupoption=driver.findElements(By.tagName("mat-option"));
		util.selectValueFromDropDwon(bGroupoption, bloodGrp);
		
		countryName.click();
		
		List<WebElement> countryoption=driver.findElements(By.tagName("mat-option"));
		util.selectValueFromDropDwon(countryoption, patientCountry);
    
	
		js.executeScript("arguments[0].scrollIntoView();", updateButton);
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).
		until(ExpectedConditions.elementToBeClickable(stateName));
		
		stateName.click();
		
		List<WebElement> stateoption=driver.findElements(By.tagName("mat-option"));
		util.selectValueFromDropDwon(stateoption, patientState);

		new WebDriverWait(driver, Duration.ofSeconds(10)).
		until(ExpectedConditions.elementToBeClickable(district));
		
		js.executeScript("arguments[0].click()", district);
		
		List<WebElement> districtoption=driver.findElements(By.tagName("mat-option"));
		util.selectValueFromDropDwon(districtoption, patientDistrict);

		new WebDriverWait(driver, Duration.ofSeconds(10)).
		until(ExpectedConditions.elementToBeClickable(taluk));
		
		js.executeScript("arguments[0].click()", taluk);
		
		List<WebElement> talukoption=driver.findElements(By.tagName("mat-option"));
		util.selectValueFromDropDwon(talukoption, patienttaluk);

		new WebDriverWait(driver, Duration.ofSeconds(10)).
		until(ExpectedConditions.elementToBeClickable(village));
		
		js.executeScript("arguments[0].click()", village);
	
		List<WebElement> villageoption=driver.findElements(By.tagName("mat-option"));
		util.selectValueFromDropDwon(villageoption, patientVillage);
		
		js.executeScript("arguments[0].click()", updateButton);
		
	}
}
