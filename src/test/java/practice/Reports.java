package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports {
	
//	(path,set theme ,tittle (look and feel))
	
	ExtentSparkReporter reporter;
	
//	attach reports  manual inputs
	
	ExtentReports reports;
	
	
//	to create entities in reports 
	
	ExtentTest test;


	
	
	@Test
	public void reportCreation() throws IOException {
		
		reporter=new ExtentSparkReporter("../SDET7_SAI/SDET7.html");
		reporter.config().setDocumentTitle("Facebook");
		reporter.config().setTheme(Theme.STANDARD);
		
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Tester", "saikrishna yadav");
		reports.setSystemInfo("Application version", "5.4.0");
		reports.setSystemInfo("Browser", "chrome");
		reports.setSystemInfo("environment", "QA");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://facebook.com");
//		Assert.assertFalse(true);

		test=reports.createTest("Facebook456");

		TakesScreenshot screenshot = (TakesScreenshot)driver;
		  java.io.File file = screenshot.getScreenshotAs(OutputType.FILE);
		  String path = ("../SDET7_SAI/ScreenShot/FACEBOOK.png");	
		  File dest = new File(path);
		  FileUtils.copyFile(file, dest);
		  
		  test.addScreenCaptureFromPath(path);


		reports.flush();
		
	}

}
