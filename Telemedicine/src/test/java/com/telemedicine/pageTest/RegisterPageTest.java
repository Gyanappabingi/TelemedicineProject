package com.telemedicine.pageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.telemedicine.base.Base;
import com.telemedicine.page.IndexPage;
import com.telemedicine.page.LoginPage;
import com.telemedicine.page.RegisterPage;
import com.telemedicine.util.Utils;

public class RegisterPageTest extends Base {

	IndexPage indexpage;
	LoginPage loginpage;
	RegisterPage registerpage;
	Utils util;
	String sheetname="Sheet2";
	public RegisterPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Throwable {
		launchBrowser();
		indexpage=new IndexPage();
		loginpage=new LoginPage();
		registerpage=new RegisterPage();
		
	}
	@DataProvider(name = "registerdata")
	public Object[][] getExcelTestData(){
		Object data1[][]=util.ExcelData(sheetname);
		return data1;
	}
	@Test
	public void TitleTest() {
		indexpage.clickOnPatient();
		loginpage.clickOnRegister();
		String actualTitle=registerpage.validateTitle();
		String expectedTitle="TeleMed";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test(priority=1,dataProvider = "registerdata")
	public void RegisterTest(String Patientname,String patientmobile,String patientemail,String password,String confirmpassword) throws Exception {
		
		indexpage.clickOnPatient();
		loginpage.clickOnRegister();
		
		Thread.sleep(2000);
		
		registerpage.patientRegisterTest(Patientname, patientmobile, patientemail, password, confirmpassword);
		
		Thread.sleep(2000);
		
		String actulurl=driver.getCurrentUrl();
		String expectedurl="http://192.168.1.252:8042/#/auth/login";
		
		Assert.assertEquals(actulurl, expectedurl);
		
		//String toastTitle=driver.findElement(By.xpath("//div[@id=\"toast-container\"]")).getText();
		
		//String expectedTitle="Error\r\n"
			//	+ "User PhoneNumber Already Exists";
	 	//Assert.assertEquals(toastTitle, expectedTitle);
	}
	 
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
