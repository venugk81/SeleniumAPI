package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ThreadLocalExtentReportTest {

	private static ExtentReports extReports;
	private static ExtentSparkReporter spark;
	private static ThreadLocal<ExtentTest> extentTest;

	private ThreadLocalExtentReportTest() {

	}

	public static ExtentReports getExtentReporter() {
		if (extReports == null) {
			extReports = new ExtentReports();
			String reportPath = System.getProperty("user.dir") + "/reports/extent-report-thread-local.html";
			spark = new ExtentSparkReporter(reportPath);
			spark.config().setReportName("This is a Report Name");
			spark.config().setDocumentTitle("Document Title");
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setEncoding("utc-8");
			extReports.attachReporter(spark);
		}
		return extReports;
	}
	
	public static ExtentTest getExtentTestRef(String strTestName) {
		extentTest = ThreadLocal.withInitial(()-> getExtentReporter().createTest(strTestName));
		return extentTest.get();
	}
	

	public static void flushReport() {
		extReports.flush();
	}

}
