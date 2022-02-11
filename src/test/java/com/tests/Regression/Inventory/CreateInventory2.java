package com.tests.Regression.Inventory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.base.BaseClass;
import com.base.BasePage;
import com.utils.ThreadLocalExtentReportTest;

public class CreateInventory2 extends BasePage{
	
	public ExtentTest extentTest;
	WebDriver driver; 

	@BeforeMethod
	public void beforeMethod() {
		extentTest = ThreadLocalExtentReportTest.getExtentTestRef("CreateInventory");
		extentTest.assignAuthor("Venu").assignDevice(prop.getProperty("browser")).assignCategory("Regression");
		driver = getWebdriverInstance();
	}
	
	@Test
	public void Method() {
		System.out.println("testing done..");
		extentTest.pass("test is passed");
		extentTest.info("Test info step of second test: 2");
		extentTest.pass("Test info step of second test: 2");
		extentTest.pass("Test info step of second test: 2");
		extentTest.pass("Test info step of second test: 2");
		extentTest.info("Test info step of second test: 2");
	}
	
	@AfterMethod
	public void afterMethod() {
		closeDriver(); 
	}
}
