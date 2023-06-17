package com.telemedicine.pageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.telemedicine.base.Base;
import com.telemedicine.page.Dashboard;
import com.telemedicine.page.IndexPage;
import com.telemedicine.page.LoginPage;
import com.telemedicine.page.PatientAppointmentPage;
import com.telemedicine.util.Utils;

public class PatientAppointmentPageTest extends Base {
	IndexPage index;
	LoginPage login;
	Dashboard dashboard;
	PatientAppointmentPage patientAppointment;
	Utils util;
	String sheetname="Sheet4";

	public PatientAppointmentPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws Throwable {
		launchBrowser();
		index=new IndexPage();
		login=new LoginPage();
		dashboard=new Dashboard();
		login=index.clickOnPatient();
		dashboard=login.login(prop.getProperty("username"), prop.getProperty("password"));
		patientAppointment=dashboard.clickOnPatientAppointment();

	}
	
	@DataProvider
	public Object[][] get_Appointment_data(){
		Object data[][]=util.ExcelData(sheetname);
		return data;
	}
	
	@Test(dataProvider = "get_Appointment_data")
	public void fix_Appointment_Test(String height,String weight,String complaints,String symptoms,String illness,String allergy,String date,String PFromTime,String PToTime,String hospitals,String hospitalDoctor) throws Exception  {
		patientAppointment.fixAppointment(height,weight,complaints,symptoms,illness,allergy,date,PFromTime,PToTime,hospitals,hospitalDoctor);
		Thread.sleep(3000);
		WebElement toast=driver.findElement(By.xpath("//div[text()=\" Appoinment fixed Successfully. \"]"));
		String actualMessage=toast.getText();
		String expectedMessage="Appoinment fixed Successfully.";
		Assert.assertEquals(actualMessage, expectedMessage);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
 