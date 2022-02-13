package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.base.BasePage;
import com.utils.ReportExtentStep;


public class OnlineShoppingPage{
	WebDriver driver;
	BasePage page;
	RediffHomePage rediffHomePage;
	ExtentTest extentTest;
	
	@FindBy(xpath="//img[@title='Online Shopping Site in India']")
	WebElement imgShoppingLogo;
	
	@FindBy(xpath="//div[@class='product_box']//img")
	WebElement imgFirstProduct;
	
	@FindBy(id="popular_cat")
	WebElement divCategories;	
	
	@FindBy(xpath="//div[@class='categoryFilter']")
	WebElement divCategoryFilter;	
	
	@FindBy(xpath="//div[@class='div_grid_prdbox']//img")
	WebElement imgFirstProductFromSubCategory;
	
	@FindBy(id="home_page")
	WebElement divProductDetailsHomePage;
	
	@FindBy(xpath="//div[text()='This product is not available with us']")
	WebElement divProdNotAvailable;
	
	@FindBy(xpath="//h1[@itemprop='name']/span")
	WebElement spnProductName;
	
	@FindBy(id="prod_prcs")
	WebElement spnProdPrice;
	
	@FindBy(id="inputPincode")
	WebElement pinCode;
	
	@FindBy(xpath="//input[@value='Buy now']")
	WebElement btnBuyNow;
	
	public OnlineShoppingPage(WebDriver _driver, ExtentTest extentTest) {
		driver= _driver;
		PageFactory.initElements(driver, this);
		this.extentTest = extentTest;
		page = new BasePage();
		page.isElementDisplayed(imgFirstProduct, 10);
	}
	
	
	public void SelectProductByCategory(String category, String subCategory) {
		try {
			selectFirstProductBySubcatogory(category, subCategory);				
			extentTest.pass("Selected product: "+ category + " and subcategory: "+ subCategory);
		}catch(Exception oExp) {
			page.attachScreenshotToExtentReport(extentTest);
			Assert.fail("Failed to select first product by category and sub-category");
		}
	}
	
	public void selectFirstProductBySubcatogory(String category, String subCategory) {
		try {
			page.isElementDisplayed(divCategories, 10);			
			WebElement eleCategory = driver.findElement(By.xpath("//h3/a[text()='"+ category +"']"));
			page.click(eleCategory, "Category: "+ category);
			page.isElementDisplayed(divCategoryFilter, 10);
			WebElement eleSubCategory = driver.findElement(By.xpath("//div[@class='catFilterWrapper']//a[contains(text(), '"+ subCategory+"')]"));
			page.click(eleSubCategory, "Sub Category: "+ subCategory);
			page.isElementDisplayed(imgFirstProductFromSubCategory, 10);
			page.click(imgFirstProductFromSubCategory, "Select First Product");		
			page.isElementDisplayed(divProductDetailsHomePage, 10);			
		}catch(Exception oExp) {
//			page.attachScreenshotToExtentReport(extentTest);
//			extentTest.fail("Failed to select first prodcut by category");
//			Assert.fail("Failed to navigate to first product by category and sub-category");
			ReportExtentStep.failStep("Failed to select first prodcut by category", oExp.getMessage(), extentTest);
		}
	}
	
	public void addProductToCart() {
		page.getText(spnProductName, "Product Name");
		page.getAttribute(spnProdPrice, "content", "Product price");
		page.click(btnBuyNow, "Buy Now");		
	}
	
	
	
	
}
