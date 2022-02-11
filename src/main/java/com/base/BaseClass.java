package com.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.config.ConfigProp;
import com.utils.ThreadLocalExtentReportTest;
import com.utils.WebDriverEventListenerUtil;


public class BaseClass {
	
	public WebDriver driver;
	public String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
	public static Properties prop;
	
	
	public BaseClass() {
		try {
			prop = ConfigProp.getConfig();
		}catch(Exception oExp) {
			oExp.printStackTrace();
		}
	}
	
	@BeforeSuite
	public void beforeSuite() {
		ThreadLocalExtentReportTest.getExtentReporter();
	}
	
	@AfterSuite
	public void afterSuite() {
		ThreadLocalExtentReportTest.flushReport();
	}
	
	
	
	public WebDriver getWebdriverInstance() {
		
		if(prop.getProperty("browser").equals("chrome")) {
					
			System.setProperty("webdriver.chrome.driver", chromePath);
//			System.setProperty("webdriver.chrome.logfile", "Testlog.txt");	// for logs 
			driver = new ChromeDriver();
			//Configure WebDriver Event Listener which listens to all the webdriver actions/events..
			EventFiringWebDriver _driver = new EventFiringWebDriver(driver);
			//This class implements web driver event listener interface methods..
			WebDriverEventListenerUtil driverEventListenerUtil = new WebDriverEventListenerUtil();
			//Register the class with even firing web driver
			_driver.register(driverEventListenerUtil);
			//Assign it to the driver.. Rest of the flow remains same.. 
			driver = _driver;
			System.out.println("Driver is launched for browser: "+ prop.getProperty("browser"));
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		return driver;
	}
	
	public void navigateToURL(String configUrlProp) {
		driver.get(prop.getProperty(configUrlProp));
		System.out.println("Driver is launched and navigated to UR: "+ prop.getProperty(configUrlProp));
	}
	
	public void closeDriver() {
		driver.close();
		driver.quit();
	}
	
	/*
	public void sendText(WebElement ele, String text) {
		try {
			ele.sendKeys(text);
			System.out.println("successfully text is sent..");
		}catch(Exception oExp) {
			oExp.printStackTrace();
			Assert.fail("Failed to set text in the text field.");
		}
	}
	
	public void sendText(WebElement ele, String text, String reportStep) {
		try {
			ele.sendKeys(text);
			System.out.println("Successfully text is typed in the field: "+ reportStep);
		}catch(Exception oExp) {
			oExp.printStackTrace();
			Assert.fail("Failed to set text in the text field: "+ reportStep);
		}
	}
	
	public void click(WebElement ele) {
		try {
			ele.click();
			System.out.println("Clicked on element.");
		}catch(Exception oExp) {
			oExp.printStackTrace();
			Assert.fail("Failed to click on the element");
		}
	}
	
	public void click(WebElement ele, String reportStep) {
		try {
			ele.click();
			System.out.println("Clicked on element: "+ reportStep);
		}catch(Exception oExp) {
			oExp.printStackTrace();
			Assert.fail("Failed to click on the element: "+ reportStep);
		}
	}
	
	public boolean isElementDisplayed(WebElement ele, long iwait) {
		try {
			System.out.println("Is element displayed??");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(iwait));
			wait.until(ExpectedConditions.visibilityOf(ele));
		}catch(Exception oExp) {
			return false;
		}
		return true;
	}
	
	public WebElement elementToBeClickable(WebElement element, long iwait) {
		WebElement ele;
		try {
			System.out.println("Wait for the element clickable..");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(iwait));
			ele = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Exception oExp) {
			return null;
		}
		return ele;
	}
	
	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select;
		try {
			if(isElementDisplayed(element, 5)) {
				select = new Select(element);
				select.selectByVisibleText(visibleText);
				System.out.println("Visible text: "+ visibleText +" is selected successfully");
			}
		}catch(Exception oExp) {
			Assert.fail("Failed to select visible text in the dropdown: "+ visibleText);
		}
	}
	
	
	public String getAttribute(WebElement element, String attributeProp, String strElementName) {
		String strAttributeValue="";
		try {
			strAttributeValue = element.getAttribute(attributeProp);
			System.out.println("Attribute value of the element: "+ strAttributeValue );
		}catch(Exception oExp) {
			oExp.printStackTrace();
			Assert.fail("Failed to get attribute of the element: "+ strElementName);
		}
		return strAttributeValue;
	}
	
	public String getText(WebElement element, String strElementName) {
		String strAttributeValue="";
		try {
			strAttributeValue = element.getText();
			System.out.println("Text of the " +strElementName + ": "+  strAttributeValue);
		}catch(Exception oExp) {
			oExp.printStackTrace();
			Assert.fail("Failed to get text of the element: "+ strElementName);
		}
		return strAttributeValue;
	}
	
	
	
	*/
	
	
	/*
	 * public static void main(String[] args) { BasePage b = new BasePage();
	 * System.out.println(prop.getProperty("url")); }
	 */

}
