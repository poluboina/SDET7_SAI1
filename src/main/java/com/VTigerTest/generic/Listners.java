package com.VTigerTest.generic;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listners extends BaseUtility  implements ITestListener{
	

	

	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
		test=reports.createTest(result.getMethod().getMethodName());
	
	}

	public void onTestSuccess(ITestResult result) {
		

		test.log(Status.PASS,result.getMethod().getMethodName()+" got pass");
		test.log(Status.PASS, result.getThrowable());
		
		
		String screenshotpath;
		try {
			screenshotpath=BaseUtility.screenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshotpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void onTestFailure(ITestResult result) {
		
		
		test.log(Status.FAIL,result.getMethod().getMethodName()+" got Fail");
		test.log(Status.FAIL, result.getThrowable());
		
		
		String screenshotpath;
		try {
			screenshotpath=BaseUtility.screenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshotpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP,result.getMethod().getMethodName()+" got Skip");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		
		reporter = new ExtentSparkReporter(IAutoconstants.extentreportpath);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("VTIGER APP");
		reporter.config().setReportName("CRM Report");

		reports= new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Build", "15.5.3");
		reports.setSystemInfo("Created by", "Testing SDET_7 Team");

	}

	public void onFinish(ITestContext context) {
	
		reports.flush();
	}

}
