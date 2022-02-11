package com.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshotUtil {
	

	
	
	public static String captureScreen(WebDriver driver) {
		String destScreenFilePath ="";
		try {
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			destScreenFilePath = System.getProperty("user.dir") + File.separator+ "screens\\ExceptionScreen_"+ System.currentTimeMillis() + ".png";
			System.out.println("Screen shot path: "+ destScreenFilePath);
			FileUtils.copyFile(srcFile, new File(destScreenFilePath));			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return destScreenFilePath;
	}

}
