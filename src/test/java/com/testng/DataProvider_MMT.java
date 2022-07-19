package com.testng;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider_MMT {
	@Test(dataProvider = "getvalue")
	public void test1(String src,String dest) throws InterruptedException {
		
	
	ChromeOptions options=new ChromeOptions();
	
	options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver(options);
	driver.get("https://www.makemytrip.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	Thread.sleep(2000);
	
	driver.switchTo().frame("notification-frame-~19713b227");
	driver.findElement(By.xpath("//a[@class='close']")).click();
	
	Thread.sleep(3000);
	driver.switchTo().defaultContent();
	
	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	
	
	 Thread.sleep(3000);
//	 String src="BANG";
//	 String dest="MUM";
	 
	 System.out.println(src +"---->"+dest);
	 
	 driver.findElement(By.xpath("//label[@for='fromCity']")).sendKeys(src);
	 
//	 driver.findElement(By.xpath("//div[text()='BANG']")).click();
	 driver.findElement(By.xpath("//div[.='"+src+"']")).click();
	 
	 driver.findElement(By.xpath("//label[@for='toCity']")).sendKeys(dest);
	 
//	 driver.findElement(By.xpath("//div[text()='MUM']")).click();
	 driver.findElement(By.xpath("//div[.='"+dest+"']")).click();
	 
	 driver.findElement(By.xpath("//label[.='departure']")).click();
	 
	 driver.findElement(By.xpath("//div[@aria-label='Fri Jul 15 2022']")).click();
	 	Thread.sleep(3000);
	}
	
	
	@DataProvider
	public Object[][] getvalue() {
		Object [][] array=new Object [5][2];
		array [1][0]="HYd";
		array [1][1]="BAN";
		
		array [2][0]="BOM";
		array [2][1]="DEL";
			
		array [3][0]="MAA";
		array [3][1]="GOI";
			
		array [4][0]="PNQ";
		array [4][1]="BOM";
		
		
		return array;
	}

}

