package com.Sai.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ObjectRepo.POM.CreateOrgPage;
import com.ObjectRepo.POM.HomePage;
import com.ObjectRepo.POM.OrganizationsInfoPage;
import com.VTiger.generic.BaseUtility;
import com.VTiger.generic.Webdriver_Utility;
import com.github.javafaker.Faker;

public class SaiOrgHeaderVerTC extends BaseUtility{
	
	
	@Test
	
	 public void saiOrgHeaderVerTc() {
	
	
	
	Faker faker=new Faker();
	String orgname = faker.name().lastName();

	Webdriver_Utility webdriver_utillity = new Webdriver_Utility(driver);
	webdriver_utillity.maximumWindow();

	HomePage homepage =new HomePage(driver);
	homepage.getOrglinkbtn().click();

	OrganizationsInfoPage organizationsInfoPage=new	OrganizationsInfoPage(driver);
	organizationsInfoPage.getCreateorglinkbtn().click();

	CreateOrgPage createOrgPage=new CreateOrgPage(driver);
	createOrgPage.getOrgnametxtbox().sendKeys(orgname);

	createOrgPage.getSavebtn().click();
	
	WebElement orgHeaderverify = organizationsInfoPage.getOrgctdhedverfiy();
	
	if(orgHeaderverify.isDisplayed()) {
		
		System.out.println("The Organization Is Verify TC Pass");
	}
	else {
		System.out.println("The Organization Is not  Verify TC Fail");
	}


}
}

