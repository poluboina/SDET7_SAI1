package com.Sai.TestCases;

import java.io.IOException;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.ObjectRepo.POM.ContactInfoPage;
import com.ObjectRepo.POM.CreateContPage;
import com.ObjectRepo.POM.HomePage;
import com.VTiger.generic.BaseUtility;
import com.VTiger.generic.Webdriver_Utility;
import com.github.javafaker.Faker;

public class SaiConTC extends BaseUtility {
	@Test
	public void saiConTC() throws IOException, InterruptedException  {
		
		
		Faker faker=new Faker();
		String contname = faker.name().firstName();
		Random random=new Random();
		int num = random.nextInt(20);
		
		Webdriver_Utility webdriver_utillity = new Webdriver_Utility(driver);
		
		
		
		HomePage homePage=new HomePage(driver);
		homePage.getContlinkbtn().click();
		
		
		ContactInfoPage contactInfoPage=new ContactInfoPage(driver);
		contactInfoPage.getCreatecontlinkbtn().click();
		
		
		Thread.sleep(2000);
		
		
			CreateContPage createContPage=new CreateContPage(driver);
			createContPage.getFirstNameDD().click();
			
			Thread.sleep(3000);
			
			webdriver_utillity.selectDD(createContPage.getFirstNameDD(),1);
			
		
			Thread.sleep(5000);
			
			createContPage.getFirstname().sendKeys(contname);
			
			
		
			
//		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(contname);
			
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
//		
//		String mainId=driver.getWindowHandle();
//		Set<String> allId = driver.getWindowHandles();
//		for(String i:allId) {
//			if(!mainId.equals(i)) {
//				driver.switchTo().window(i);
//			}
//			Thread.sleep(5000);
////			System.out.println("=====");
//			WebElement ele1=driver.findElement(By.xpath("//a[@id='3']"));
//			ele1.click();
//			driver.switchTo().window(mainId);
//			Thread.sleep(2000);
			
			createContPage.getLastname().sendKeys(contname);
			createContPage.getSavebtn().click();
			
			
			
		if(contactInfoPage.getVerifyheadertext().isDisplayed()){
			System.out.println("The Contact is verifed");
		}
		else {
			System.out.println("The contact is not verifed");
		}
			
	}
	
}


