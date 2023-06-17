package com.telemedicine.pageTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.telemedicine.base.Base;
import com.telemedicine.page.Dashboard;
import com.telemedicine.page.IndexPage;
import com.telemedicine.page.LoginPage;
import com.telemedicine.util.Utils;

public class LoginPageTest extends Base {
	LoginPage loginpage;
	IndexPage indexpage;
	Dashboard homepage;
	Utils util;
	String sheetname="Sheet1";
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws Throwable {
		launchBrowser();
		indexpage=new IndexPage();
		loginpage=new LoginPage();
 
	}
	
	@DataProvider(name = "getExcelTestData")
	public Object[][] getExcelTestData(){
		Object data[][]=util.ExcelData(sheetname);
		return data;
	}
	@Test(priority = 1,dataProvider = "getExcelTestData")
	public void loginTest(String username,String password) throws InterruptedException {
		indexpage.clickOnPatient();
		homepage=loginpage.login(username,password);
		Thread.sleep(2000);
		String currenturl=driver.getCurrentUrl();
		String expectedurl="http://192.168.1.252:8042/#/base/dashboard";
		Assert.assertEquals(currenturl, expectedurl);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
