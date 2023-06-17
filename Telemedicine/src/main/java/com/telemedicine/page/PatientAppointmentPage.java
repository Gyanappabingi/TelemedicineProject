package com.telemedicine.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.telemedicine.base.Base;
import com.telemedicine.util.Utils;

public class PatientAppointmentPage extends Base {
	
	@FindBy(xpath = "//mat-icon[text()=\"add\"]")
	WebElement fixAppointment;
	
	@FindBy(css = "input[formcontrolname=\"Height\"]")
	WebElement height;
	
	@FindBy(css = "input[formcontrolname=\"Weight\"]")
	WebElement weight;
	
	@FindBy(css = "mat-select[formcontrolname=\"complaint\"]")
	WebElement complaints;
	
	@FindBy(css = "mat-select[formcontrolname=\"symptoms\"]")
	WebElement symptoms;
	
	@FindBy(css = "mat-select[formcontrolname=\"diseasesDtl\"]")
	WebElement present_illeness;
	
	@FindBy(css = "mat-select[formcontrolname=\"allergySigns_DTL\"]")
	WebElement allergy_signs;
	
	@FindBy(css = "input[formcontrolname=\"select_day\"]")
	WebElement consultation_date;
	
	@FindBy(css = "input[formcontrolname=\"select_FrmTime\"]")
	WebElement from_time;
	
	@FindBy(css = "input[formcontrolname=\"select_toTime\"]")
	WebElement to_time;
	
	@FindBy(xpath = "//span[text()=\"Select Doctor\"]")
	WebElement select_doctor;
	
	@FindBy(xpath = "//span[text()=\"Clinical Doctors\"]")
	WebElement clinical_doctors;
	
	@FindBy(xpath = "//mat-label[text()=\"Clinical Doctor\"]")
	WebElement clinical_doctors_dropdown;
	
	@FindBy(xpath = "//span[text()=\"Hospital Doctors\"]")
	WebElement hospital_doctors;
	
	@FindBy(xpath = "//mat-label[text()=\"Hospital\"]")
	WebElement hospital;
	
	@FindBy(xpath = "//mat-label[text()=\"Hospital Doctor\"]")
	WebElement hospital_doctor_dropdown;
	
	@FindBy(xpath = "//span[text()=\"Book Appoinment \"]")
	WebElement book_Appointment;
	
	Utils util=new Utils();
	
	public PatientAppointmentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void fixAppointment(String Pheight,String Pweight,String Pcomplaint,String Psymptoms,String Pillness,String Pallergy,String PCdate,String fromtime,String totime,String hsptl,String hsptlDoctor) {
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", fixAppointment);
		
		height.sendKeys(Pheight);
		
		weight.sendKeys(Pweight);
		
		//complaints.click();
		js.executeScript("arguments[0].click()", complaints);
		
		List<WebElement> complaintOptions=driver.findElements(By.tagName("mat-option"));
		util.selectValueFromDropDwon(complaintOptions, Pcomplaint);
		
		WebElement element=driver.switchTo().activeElement();
		element.sendKeys(Keys.ESCAPE);
		
		symptoms.click();
		
		List<WebElement> symptomsOptions=driver.findElements(By.tagName("mat-option"));
		util.selectValueFromDropDwon(symptomsOptions, Psymptoms);
		
		element.sendKeys(Keys.ESCAPE);
		
		present_illeness.click();
		List<WebElement> illnessOptions=driver.findElements(By.tagName("mat-option"));
		util.selectValueFromDropDwon(illnessOptions, Pillness);
		element.sendKeys(Keys.ESCAPE);
		
		allergy_signs.click();
		List<WebElement> allergyOptions=driver.findElements(By.tagName("mat-option"));
		util.selectValueFromDropDwon(allergyOptions, Pallergy);
		element.sendKeys(Keys.ESCAPE);
		
		js.executeScript("arguments[0].scrollIntoView();", select_doctor);
		
		
		util.explicit_Wait(driver, consultation_date);
		
		consultation_date.sendKeys(PCdate);
		
		from_time.sendKeys(fromtime);
		to_time.sendKeys(totime);
		
		js.executeScript("arguments[0].click()", select_doctor);
		
		//clinical_doctors.click();
		
		/*js.executeScript("arguments[0].click()", clinical_doctors);
		new WebDriverWait(driver, Duration.ofSeconds(10)).
		until(ExpectedConditions.elementToBeClickable(clinical_doctors_dropdown));
		
		js.executeScript("arguments[0].click()", clinical_doctors_dropdown);
		//clinical_doctors_dropdown.click();
		
		List<WebElement> clndoctors=driver.findElements(By.tagName("mat-option"));
		util.selectValueFromDropDwon(clndoctors, clinicDoctor);
		*/
		
		js.executeScript("arguments[0].click()", hospital_doctors);
		
		util.explicit_Wait(driver, hospital);
		
		js.executeScript("arguments[0].click()", hospital);
		//hospital.click();
		List<WebElement> hsptldropdown=driver.findElements(By.tagName("mat-option"));
		util.selectValueFromDropDwon(hsptldropdown, hsptl);
		
		util.explicit_Wait(driver, hospital_doctor_dropdown);
		
		js.executeScript("arguments[0].click()", hospital_doctor_dropdown);
		//hospital_doctor_dropdown.click();
		
		List<WebElement> hsptldoctorsdropdown=driver.findElements(By.tagName("mat-option"));
		util.selectValueFromDropDwon(hsptldoctorsdropdown, hsptlDoctor);
		
		book_Appointment.click();
		
		//new WebDriverWait(driver, Duration.ofSeconds(10)).
		//until(ExpectedConditions.alertIsPresent()).accept();
	}
}
