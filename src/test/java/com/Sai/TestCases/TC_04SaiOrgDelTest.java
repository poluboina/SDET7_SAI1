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
public class TC_04SaiOrgDelTest extends BaseUtility {





	@Test(groups = "regression",priority = 4,retryAnalyzer = RetryAnalyzer_1.class)
	public void createOrgTest() throws Throwable
	{

		Faker faker=new Faker();
		String orgname = faker.name().lastName();

		Webdriver_Utility webdriver_utillity = new Webdriver_Utility(driver);
		webdriver_utillity.maximumWindow();
		webdriver_utillity.pageLoadTimeout();

		HomePage homepage =new HomePage(driver);
		homepage.getOrglinkbtn().click();
	
		OrganizationsInfoPage organizationsInfoPage=new	OrganizationsInfoPage(driver);
		organizationsInfoPage.getCreateorglinkbtn().click();

		CreateOrgPage createOrgPage=new CreateOrgPage(driver);
		createOrgPage.getOrgnametxtbox().sendKeys(orgname);

		createOrgPage.getSavebtn().click();

		Thread.sleep(4000);

		homepage.getOrglinkbtn().click();


		try {
			organizationsInfoPage.getSearchorgtxtbox().sendKeys(orgname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(1000);
		organizationsInfoPage.getSelectorgtypeDD().click();

		webdriver_utillity.selectDD(organizationsInfoPage.getSelectorgtypeDD(), 1);

		Thread.sleep(1000);

		organizationsInfoPage.getSearchorgbtn().click();

		Thread.sleep(2000);
		organizationsInfoPage.getCheckboxbtn().click();

		organizationsInfoPage.getDeletebtn().click();
		Thread.sleep(2000);
		
		webdriver_utillity.pageLoadTimeout();
		
		webdriver_utillity.acceptAlert();

		Thread.sleep(3000);

		WebElement orgHeader = organizationsInfoPage.getDeleorgverifyheader();
		Thread.sleep(2000);
	
		if(orgHeader.isDisplayed()) {
			System.out.println("TestCase is Passed");
		}
		else {
			System.out.println("TestCase is failed");
		}

	}
}

