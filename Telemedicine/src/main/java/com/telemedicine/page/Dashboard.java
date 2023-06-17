package com.telemedicine.page;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.telemedicine.base.Base;

public class Dashboard extends Base {
	
	@FindBy(xpath = "//li[@class=\"nav-item ng-star-inserted\"][2]" )
	WebElement patientProfile;
	
	@FindBy(xpath = "//span[text()=\" Patient Appoinment\"]")
	WebElement appointment;
	
	@FindBy(xpath = "//span[text()=\" Previous Record\"]")
	WebElement previous_record;
	
	public Dashboard() {
		PageFactory.initElements(driver, this);
	}
	
	public PatientProfilePage clickOnProfile() throws Exception {
		new WebDriverWait(driver, Duration.ofSeconds(60))
		.until(ExpectedConditions.elementToBeClickable(patientProfile));
		patientProfile.click();
		 Thread.sleep(3000);
		
		return new PatientProfilePage();
		
	}
	
	public PatientAppointmentPage clickOnPatientAppointment() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).
		until(ExpectedConditions.elementToBeClickable(appointment));
		appointment.click();
		return new PatientAppointmentPage();
	}
		
		
	public PreviousRecord click_on_previous_record() throws Exception {
		new WebDriverWait(driver, Duration.ofSeconds(10)).
		until(ExpectedConditions.elementToBeClickable(previous_record));
		previous_record.click();
		Thread.sleep(3000);
		return new PreviousRecord();
		
	}
	
		
	}


