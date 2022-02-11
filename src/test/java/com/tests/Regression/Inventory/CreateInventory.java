package com.tests.Regression.Inventory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.base.BaseClass;
import com.base.BasePage;
import com.utils.ThreadLocalExtentReportTest;

public class CreateInventory extends BasePage{
	
	ExtentTest extentTest;
	WebDriver driver; 
	

	@BeforeMethod
	public void beforeMethod() {
		extentTest = ThreadLocalExtentReportTest.getExtentTestRef("CreateInventory");
		extentTest.assignAuthor("Venu").assignDevice(prop.getProperty("browser")).assignCategory("Regression");
		driver = getWebdriverInstance();
	}
	
	@Test
	public void Method() {
		System.out.println("testing done 1..");
		extentTest.pass("test is passe d 1");
		extentTest.info("Test info step of second test: 1");
		extentTest.pass("Test info step of second test: 1");
		extentTest.pass("Test info step of second test: 1");
		extentTest.pass("Test info step of second test: 1");
		extentTest.info("Test info step of second test: 1");
	}
	
	@AfterMethod
	public void afterMethod() {
		closeDriver(); 
	}
}
