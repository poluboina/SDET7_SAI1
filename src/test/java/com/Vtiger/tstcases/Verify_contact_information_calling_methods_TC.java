package com.Vtiger.tstcases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.VTigerTest.generic.FakeData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_contact_information_calling_methods_TC {
	
	public static void main(String[] args) throws Throwable {
		
	
	
	
	FakeData fakedata = new FakeData();
	String campname = fakedata.companyName();
	
	PropertyFile propertyfile = PropertyFile.getObjectProperty();
	String BROWSER = propertyfile.readDatafromPropertyfile("browser");
	
	WebDriver driver;
	
	if(BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	else if (BROWSER.equalsIgnoreCase("edge")) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	else {
		System.out.println("invalid input");
		
	}
	
	
	WebDriverManager.chromedriver().setup();

	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(propertyfile.readDatafromPropertyfile("url"));
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.name("user_name")).sendKeys(propertyfile.readDatafromPropertyfile("username"),Keys.TAB,propertyfile.readDatafromPropertyfile("password"),Keys.TAB,Keys.ENTER);
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//select[@name='salutationtype']")).click();
	WebElement ele = driver.findElement(By.xpath("//select[@name='salutationtype']"));
	ele.click();
	Select s=new Select(ele);
	s.selectByIndex(1);
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(campname);
	driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	
	String mainId=driver.getWindowHandle();
	Set<String> allId = driver.getWindowHandles();
	for(String i:allId) {
		//if(!mainId.equals(i)) {
			driver.switchTo().window(i);
		}
		Thread.sleep(5000);
//		System.out.println("=====");
		WebElement ele1=driver.findElement(By.xpath("//a[@id='3']"));
		ele1.click();
		driver.switchTo().window(mainId);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(campname);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		WebElement signout= driver.findElement(By.xpath("//a[text()='Sign Out']"));
		Actions act=new Actions(driver);
		act.moveToElement(signout);
		signout.click();
		driver.close();
	}



	
	
}


