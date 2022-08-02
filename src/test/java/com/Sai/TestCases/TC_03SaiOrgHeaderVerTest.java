package com.Sai.TestCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepo.POM.CreateOrgPage;
import com.ObjectRepo.POM.HomePage;
import com.ObjectRepo.POM.OrganizationsInfoPage;
import com.VTigerTest.generic.BaseUtility;
import com.VTigerTest.generic.Webdriver_Utility;
import com.Vtiger.tstcases.RetryAnalyzer_1;
import com.github.javafaker.Faker;
@Listeners(com.VTigerTest.generic.Listners.class)
public class TC_03SaiOrgHeaderVerTest extends BaseUtility{
	
	
	@Test(groups = "regression",priority = 3,retryAnalyzer = RetryAnalyzer_1.class)
	
	 public void saiOrgHeaderVerTest() throws InterruptedException {
	
	
	
	Faker faker=new Faker();
	String orgname = faker.name().lastName();

	Webdriver_Utility webdriver_utillity = new Webdriver_Utility(driver);
	webdriver_utillity.maximumWindow();

	webdriver_utillity.pageLoadTimeout();
	
	HomePage homepage =new HomePage(driver);
	homepage.getOrglinkbtn().click();

	OrganizationsInfoPage organizationsInfoPage=new	OrganizationsInfoPage(driver);
	organizationsInfoPage.getCreateorglinkbtn().click();
	
	Thread.sleep(2000);
	
	CreateOrgPage createOrgPage=new CreateOrgPage(driver);
	createOrgPage.getOrgnametxtbox().sendKeys(orgname);

	createOrgPage.getSavebtn().click();
	
	
	
	
	Thread.sleep(5000);
	WebElement orgHeaderverify = organizationsInfoPage.getOrgctdhedverfiy();
	
	Thread.sleep(2000);
	
	if(orgHeaderverify.isDisplayed()) {
		
		System.out.println("The Organization Is Verify TC Pass");
	}
	else {
		System.out.println("The Organization Is not  Verify TC Fail");
	}


}
}

