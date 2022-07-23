package com.UsageListners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



@Listeners(ListnerImplements.class)
public class ListnerUsage1 {
	
	
	
	public static WebDriver driver;
	
	@Test
	public void facebook() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://facebook.com");
		String actualURL=driver.getCurrentUrl();
		
		Assert.assertEquals(actualURL, "http://facebook.com");
		
		
	}
	
	public void Amazon() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://Amazon.in");
		String actualURL=driver.getCurrentUrl();
		
		Assert.assertEquals(actualURL, "http://Amazon.in");
		
	}
	
	

}
