package com.telemedicine.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static Properties prop;
	public static WebDriver driver;
	
	public Base() {
		
		try {
			 prop=new Properties();
			FileInputStream file=new FileInputStream("C:\\Users\\VGSL-SW10\\eclipse-workspace\\Telemedicine\\src\\main\\java\\com\\telemedicine\\config\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public static void launchBrowser()   {
		
		
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions op=new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			 driver=new ChromeDriver(op);
		}else if(browsername.equals("firefox")) {
			
			//System.setProperty("webdriver.gecho.driver", "gechodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		} else {
			System.out.println("Invalid browser "+browsername);
			//throw new Exception(browsername+" invalid browserna");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url")); 
	}
}
