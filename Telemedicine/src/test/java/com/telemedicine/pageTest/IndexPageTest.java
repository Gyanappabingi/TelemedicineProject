package com.telemedicine.pageTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.telemedicine.base.Base;
import com.telemedicine.page.IndexPage;

public class IndexPageTest extends Base {
	IndexPage indexpage;
	public IndexPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws Throwable {
		launchBrowser();
		indexpage=new IndexPage();
	}
	
	@Test
	public void clickOnpatientTest() {
		indexpage.clickOnPatient();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
