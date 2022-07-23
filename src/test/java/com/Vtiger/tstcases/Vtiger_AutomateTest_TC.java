package com.Vtiger.tstcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_AutomateTest_TC {
	public static void main(String[] args) throws Throwable {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin" ,Keys.TAB,Keys.ENTER);
//		driver.findElement(By.name("user_password")).sendKeys("admin",Keys.ENTER);
//		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys("dlf");
		
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		WebElement ele = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele);
		 ele.click();
		
	}

}
