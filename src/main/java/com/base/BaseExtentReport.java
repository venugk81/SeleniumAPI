//package com.base;
//
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//
//import com.utils.ThreadLocalExtentReportTest;
//
//
//public class BaseExtentReport {
//	
//	//public ExtentReports extentReports;
//	BaseExtentReport(){
//		//extentReports = ThreadLocalExtentReportTest.getExtentReporter();
//	}
//	
//	@BeforeSuite
//	public void beforeSuite() {
//		ThreadLocalExtentReportTest.getExtentReporter();
//	}
//	
//	@AfterSuite
//	public void afterSuite() {
//		ThreadLocalExtentReportTest.flushReport();
//	}
//}
