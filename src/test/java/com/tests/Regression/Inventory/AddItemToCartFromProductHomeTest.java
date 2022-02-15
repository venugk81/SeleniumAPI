package com.tests.Regression.Inventory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.base.BasePage;
import com.pages.OnlineShoppingPage;
import com.pages.RediffHomePage;
import com.pages.RegisterUserPage;
import com.utils.CaptureScreenshotUtil;
import com.utils.ThreadLocalExtentReportTest;

public class AddItemToCartFromProductHomeTest extends BasePage{

	RegisterUserPage registerPage;
	RediffHomePage homePage;
	OnlineShoppingPage shoppingPage;
	WebDriver driver;
	ExtentTest extentTest;
	
	public AddItemToCartFromProductHomeTest() {		
		super();		
	}
	
	@BeforeMethod
	public void setUp() {
		extentTest = ThreadLocalExtentReportTest.getExtentTestRef("AddItemToCartFromProductHomeTest 1");
		extentTest.assignAuthor("Gopi").assignDevice("Firefox").assignCategory("Smoke");
		driver = getWebdriverInstance();
		registerPage = new RegisterUserPage(driver, extentTest);				
	}
	
	@Test
	public void test() throws Exception {
		System.out.println("I am in Login Test java");
		homePage = registerPage.navigateToRediffHome();
//		ReportExtentStep.failStep("testing step failure static method", "intentional failure exception", extentTest);
		extentTest.pass("Navigated to Rediff Home successfully");
		shoppingPage = homePage.navigateToOnlineShoppingPage();
		extentTest.pass("Navigated toOnline Shopping successfully");
		shoppingPage.SelectProductByCategory("Bags and Luggage", "Travel Bags ");
		extentTest.pass("Selected products by Category and Sub-Category");
//					Assert.fail("===========Script failed explicitly- AddItemToCartFromProductHomeTest");					
	}
	
	@AfterMethod
	public void afterTest(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.FAILURE){
            String screenShotPath = CaptureScreenshotUtil.captureScreen(driver);
            extentTest.fail(result.getThrowable());
            extentTest.addScreenCaptureFromPath(screenShotPath);    
            
            ////OR call like this:
//            attachScreenshotToExtentReport(extentTest, result);
        }
		closeDriver();
	}
}
