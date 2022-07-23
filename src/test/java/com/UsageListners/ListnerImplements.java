package com.UsageListners;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class ListnerImplements implements ITestListener {

	
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test Started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("TC pass");
		
	}

	public void onTestFailure(ITestResult result) {
		
		
		System.out.println("TC fail");
			TakesScreenshot tc=(TakesScreenshot)ListnerUsage1.driver;
			File src = tc.getScreenshotAs(OutputType.FILE);
			String pathOfScreenShot="../SDET7_SAI/screenshot/"+result.getMethod().getMethodName()+".png";
			File dest = new File(pathOfScreenShot);
			try {
				com.google.common.io.Files.copy(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test Case Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		
		System.out.println("Test case On start");
	}

	public void onFinish(ITestContext context) {
	
		System.out.println("Test Case At last");
	}
	



}
