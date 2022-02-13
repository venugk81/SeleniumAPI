package com.tests.api;

import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.common.Inventory.Inventory;
import com.aventstack.extentreports.ExtentTest;
import com.base.BaseClass;
import com.utils.ReadTokensFromFile;
import com.utils.ReportExtentStep;
import com.utils.ThreadLocalExtentReportTest;

import io.restassured.RestAssured;

public class CreateInventoryRecord extends BaseClass {

	Map<String, String> tokens;
	ExtentTest extentTest;
	Inventory inv;

	@BeforeMethod
	public void beforeMethod() {
		tokens = ReadTokensFromFile.getTokens();
		RestAssured.baseURI = "https://api.github.com/";
		extentTest = ThreadLocalExtentReportTest.getExtentTestRef("Create Inventory API Testing");
		extentTest.assignAuthor("Gopi").assignDevice("Firefox").assignCategory("Smoke");
	}

	@Test
	public void testing() {
		try {
			ReportExtentStep.passStep("Test started", extentTest);
			inv = new Inventory(extentTest);
			inv.createInventory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void aftermethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.fail(result.getThrowable());
		}
	}

}
