package com.telemedicine.pageTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.telemedicine.base.Base;
import com.telemedicine.page.Dashboard;
import com.telemedicine.page.IndexPage;
import com.telemedicine.page.LoginPage;
import com.telemedicine.page.PatientProfilePage;
import com.telemedicine.util.Utils;

public class PatientProfilePageTest extends Base {
	IndexPage index;
	LoginPage login;
	Dashboard dashboard;
	PatientProfilePage patientProfile;
	Utils util;
	String sheetname="Sheet3";

	
	public PatientProfilePageTest() {
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
		patientProfile=dashboard.clickOnProfile();
		

	}
	
	@DataProvider
	public Object[][] getPatientdata(){
		Object data[][]=util.ExcelData(sheetname);
		return data;
	}
	
	@Test(dataProvider = "getPatientdata")
	public void createPatientProfile(String Filepath,String PLName,String Pgender,String PatientBDate,String Patientage,String PBloodGroup,String Pcountry,String Pstate,String Pdistrict,String Ptaluk,String Pvillage) throws Exception {
		patientProfile.patientProfile(Filepath,PLName,Pgender, PatientBDate, Patientage,PBloodGroup,Pcountry,Pstate,Pdistrict,Ptaluk,Pvillage);
		//Thread.sleep(2000);
		WebElement toast=driver.findElement(By.cssSelector("div[aria-label=\"Success\"]"));
		new WebDriverWait(driver, Duration.ofMillis(2000)).
		until(ExpectedConditions.elementToBeClickable(toast));
		String actualMessage=toast.getText();
				
		String expectedmsg="Success";
		Assert.assertEquals(actualMessage, expectedmsg);
		
	}
	 
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
 