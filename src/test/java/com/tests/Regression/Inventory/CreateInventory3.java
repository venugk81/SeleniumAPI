package com.tests.Regression.Inventory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.base.BaseClass;
import com.base.BasePage;
import com.utils.ThreadLocalExtentReportTest;

public class CreateInventory3 extends BasePage{
	
	public ExtentTest extentTest;
	WebDriver driver; 

	@BeforeMethod
	public void beforeMethod() {
		extentTest = ThreadLocalExtentReportTest.getExtentTestRef("CreateInventory3");
		extentTest.assignAuthor("Gopi").assignDevice("Firefox").assignCategory("Smoke");
		driver = getWebdriverInstance();
		
	}
	
	@Test
	public void Method() {
		System.out.println("testing done 3..");
		extentTest.pass("test is passe d 1");
		extentTest.info("Test info step of second test: 3");
		extentTest.pass("Test info step of second test: 3");
		extentTest.pass("Test info step of second test: 3");
		extentTest.pass("Test info step of second test: 3");
		extentTest.info("Test info step of second test: 3");
	}
	
	@AfterMethod
	public void afterMethod() {
		closeDriver(); 
	}
}
