package com.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
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
	
	

}
