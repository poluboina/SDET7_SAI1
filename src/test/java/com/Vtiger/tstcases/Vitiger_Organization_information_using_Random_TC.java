package com.Vtiger.tstcases;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ObjectRepo.POM.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vitiger_Organization_information_using_Random_TC {
	public static void main(String[] args) throws Throwable {
		Random random=new Random();
		int i = random.nextInt(100);
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		
		LoginPage loginpage = new LoginPage( driver);
		loginpage.getUsernametextbox();
		loginpage.getPasswordtextbox();
		loginpage.getLoginbtn();
		
//		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.TAB,Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys("saikrishna"+""+i);
//		driver.findElement(By.name("industry")).click();
//		driver.findElement(By.xpath("//option[@value='Chemicals']")).click();
		
		
		driver.findElement(By.xpath("//select[@name='industry']")).click();
		WebElement ele1 = driver.findElement(By.xpath("//select[@name='industry']"));
		Select s=new Select(ele1);
//		s.selectByValue("Chemicals");
		s.selectByIndex(4);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click(); 
		 String str= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
//		System.out.println(str);
		String s1 = ("saikrishna"+""+i);
		if(str.contains(s1)) {
			System.out.println("The organization is verifed");
		}
		
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		  WebElement ele =driver.findElement(By.xpath("//a[text()='Sign Out']"));
		  Actions act=new Actions(driver);  
		  act.moveToElement(ele);
		  ele.click(); 
		  driver.close();
		 
	}
	

}
