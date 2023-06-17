package com.telemedicine.pageTest;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.telemedicine.base.Base;
import com.telemedicine.page.Dashboard;
import com.telemedicine.page.IndexPage;
import com.telemedicine.page.LoginPage;
import com.telemedicine.page.PreviousRecord;
import com.telemedicine.util.Utils;

public class PreviousRecordTest extends Base{

	IndexPage index;
	LoginPage login;
	Dashboard dashboard;
	PreviousRecord previousRecords;
	String sheetname="Sheet5";
	Utils util;
	public PreviousRecordTest(){
		super();
	}
	@BeforeMethod
	public void setUp() throws Exception   {
		
		launchBrowser();
		 index=new IndexPage();
		
		 login=new LoginPage();
		 dashboard=new Dashboard();
		login=index.clickOnPatient();
		dashboard=login.login(prop.getProperty("username"), prop.getProperty("password"));
		previousRecords=dashboard.click_on_previous_record();
	}
	
	@DataProvider
	public Object[][] getRecordsExcel(){
		Object data[][]=util.ExcelData(sheetname);
		return data;
	}
	
	@Test(dataProvider = "getRecordsExcel")
	public void add_Record_Test(String d_type, String d_name, String d_path)   {
		previousRecords.click_on_add_records();
		
		previousRecords.add_record(d_type, d_name, d_path);
		
		WebElement toast=driver.findElement(By.xpath("//div[text()=\" Record Inserted Successfully \"]"));
		
		util.explicit_Wait(driver, toast);
		
		String actualMessage=toast.getText();
		
		String expectedmsg="Record Inserted Successfully";
		
		System.out.println(actualMessage);
		 
		assertEquals(actualMessage, expectedmsg);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
