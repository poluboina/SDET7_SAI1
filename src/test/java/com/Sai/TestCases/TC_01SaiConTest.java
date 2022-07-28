package com.Sai.TestCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepo.POM.ContactInfoPage;
import com.ObjectRepo.POM.CreateContPage;
import com.ObjectRepo.POM.HomePage;
import com.VTigerTest.generic.BaseUtility;
import com.VTigerTest.generic.Webdriver_Utility;
import com.Vtiger.tstcases.RetryAnalyzer_1;
import com.github.javafaker.Faker;

@Listeners(com.VTigerTest.generic.Listners.class)
public class TC_01SaiConTest extends BaseUtility {
	@Test(priority =1,retryAnalyzer = RetryAnalyzer_1.class)
	public void saiConTest() throws IOException, InterruptedException  {
	
		
		Faker faker=new Faker();
		String contname = faker.name().firstName();
//		Random random=new Random();
//		int num = random.nextInt(20);
		
		
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


