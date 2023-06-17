package com.telemedicine.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telemedicine.base.Base;
import com.telemedicine.util.Utils;

public class PreviousRecord extends Base{

	@FindBy(xpath = "//span[text()=\"Add Records\"]")
	WebElement add_records;
	
	@FindBy(css = "mat-select[formcontrolname=\"Doc_Type\"]")
	WebElement document_type;
	
	@FindBy(css ="input[formcontrolname=\"documentname\"]")
	WebElement document_name;
	
	@FindBy(css ="input[formcontrolname=\"file\"]")
	WebElement document_upload;
	
	@FindBy(xpath = "//span[text()=\"Save\"]")
	WebElement save;
	
	Utils util=new Utils();
	PreviousRecord(){
		PageFactory.initElements(driver, this);
	}
	
	public void click_on_add_records() {
		
		add_records.click();
		
	}
	
	public void add_record(String Doctype,String DocName,String docPath) {
		
        JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click()", document_type);
		
		List<WebElement> doc_type=driver.findElements(By.tagName("mat-option"));
		
		util.selectValueFromDropDwon(doc_type, Doctype);
		
		document_name.sendKeys(DocName);
		
		document_upload.sendKeys(docPath);
		save.click();
	}
	
}
