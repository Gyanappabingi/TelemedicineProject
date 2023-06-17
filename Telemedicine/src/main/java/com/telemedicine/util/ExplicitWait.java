package com.telemedicine.util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.telemedicine.base.Base;

public class ExplicitWait extends Base {

	
	public  void wait(WebDriver driver,WebElement element) {
		WebDriverWait mywait= (WebDriverWait) new WebDriverWait(driver, Duration.ofMillis(2000)).
				until(ExpectedConditions.elementToBeClickable(element));
	}
}
