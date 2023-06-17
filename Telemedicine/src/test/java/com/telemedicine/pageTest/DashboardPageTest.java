package com.telemedicine.pageTest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.telemedicine.base.Base;
import com.telemedicine.page.Dashboard;
import com.telemedicine.page.IndexPage;
import com.telemedicine.page.LoginPage;
import com.telemedicine.page.PatientProfilePage;

public class DashboardPageTest extends Base {
	IndexPage index;
	LoginPage login;
	Dashboard dashboard;
	PatientProfilePage patientProfile;
	
	
	public DashboardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Throwable {
		launchBrowser();
		index=new IndexPage();
		login=new LoginPage();
		login=index.clickOnPatient();
		dashboard=login.login(prop.getProperty("username"), prop.getProperty("password"));
		//Thread.sleep(3000);
	}
	
	@Test
	public void clickOnPatientPF() throws Exception    {
		patientProfile=dashboard.clickOnProfile();
    
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
