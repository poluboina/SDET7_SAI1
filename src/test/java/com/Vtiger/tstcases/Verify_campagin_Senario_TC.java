package com.Vtiger.tstcases;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.VTiger.generic.FakeData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_campagin_Senario_TC {

	public static void main(String[] args) throws Throwable {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();


		FakeData fakedata = new FakeData();
		String campname = fakedata.companyName();

		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.TAB,Keys.ENTER);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campname);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click(); 


		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(campname);


		Thread.sleep(2000);
		WebElement campaign_name = driver.findElement(By.id("bas_searchfield"));
		campaign_name.click();
		Select s=new Select(campaign_name);
		s.selectByIndex(1);
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='selected_id']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		Alert alt=driver.switchTo().alert();
		alt.accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();

		String str = driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).getText();
		String s1=(campname);
		if(str.contains(s1)) {
			System.out.println("Campaign is not deleted Test Fail");
		}
		else {
			System.out.println("Campagin is Deleted Test Pass");
		}





		//		WebElement signout= driver.findElement(By.xpath("//a[text()='Sign Out']"));
		//		Actions act=new Actions(driver);
		//		act.moveToElement(signout);
		//		signout.click();
		//		driver.close();


	}

}
