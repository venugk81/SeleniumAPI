package com.utils;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class ReportExtentStep {


	public static void passStep(String stepDescription, ExtentTest extentTest) {
		extentTest.pass(stepDescription);
	}
	
	public static void inforStep(String stepDescription, ExtentTest extentTest) {
		extentTest.info(stepDescription);
	}
	
	public static void failStep(String stepDescription, String exception, ExtentTest extentTest) {		
		extentTest.fail(stepDescription + "\nException: "+ exception);
		Assert.fail(stepDescription + "\nException: "+ exception);
	}
	
	public static void warningStep(String stepDescription, String exception, ExtentTest extentTest) {		
		extentTest.warning(stepDescription + "\nException: "+ exception);
	}
}
