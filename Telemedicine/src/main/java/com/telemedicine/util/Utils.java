package com.telemedicine.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.telemedicine.base.Base;

public class Utils extends Base {
	public static String path="C:\\Users\\VGSL-SW10\\eclipse-workspace\\Telemedicine\\src\\main\\java\\com\\telemedicine\\testdata\\TestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static Object[][] ExcelData(String sheetname) {
		FileInputStream file = null;
		try {
			 file=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetname);
		Object data[][]= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
	}
	//To Select Value From  DropDown.
	
	public void selectValueFromDropDwon(List<WebElement> elements,String value) {
		for(int i=0;i<elements.size();i++) {
			if(elements.get(i).getText().contains(value)) {
				elements.get(i).click();
				break;
			}
		
		}
		
	}
	
	//Explicitly Wait
	
	public void explicit_Wait(WebDriver driver,WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).
		until(ExpectedConditions.elementToBeClickable(element));
	}
}
 