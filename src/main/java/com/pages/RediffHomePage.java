package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.base.BasePage;

public class RediffHomePage{
	WebDriver driver;
	BasePage page;
	ExtentTest extentTest;
	
	@FindBy(xpath="//a[text()='Sign in']")
	WebElement lnkSignin;
	
	@FindBy(xpath="//a[text()='Create Account']")
	WebElement lnkCreateAccount;
	
	
	@FindBy(xpath="//a[@title='Online Shopping']")
	WebElement lnkOnlineShopping;
	
	
	public RediffHomePage(WebDriver _driver, ExtentTest extentTest) {
		driver= _driver;
		this.extentTest = extentTest;
		PageFactory.initElements(driver, this);
		page = new BasePage();		
		page.isElementDisplayed(lnkOnlineShopping, 10);
		this.extentTest.pass("Home Page is loaded");
	}
	
	
	public OnlineShoppingPage navigateToOnlineShoppingPage() {
		page.click(lnkOnlineShopping, "Online Shopping Link");
		extentTest.pass("clicked on Online Shopping Link");
		return new OnlineShoppingPage(driver, extentTest);
	}
	
	
	
	
}
