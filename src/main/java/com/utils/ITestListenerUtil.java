package com.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerUtil implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart Test in suite started" + result.getStatus());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess Test in suite started" + result.getStatus());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure test failed" + result.getStatus());
	}

	

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestFailure Test skipped" + result.getStatus());
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout Test failed with timeout" + result.getStatus());
		onTestFailure(result);
	}
	public void onStart(ITestContext context) {
		
		System.out.println("onStart Test onStart" + context.getOutputDirectory());
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish Test in onFinish" + context.getName());
	}

}
