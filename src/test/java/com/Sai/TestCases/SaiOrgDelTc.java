package com.Sai.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.ObjectRepo.POM.CampainInfoPage;
import com.ObjectRepo.POM.CreateOrgPage;
import com.ObjectRepo.POM.HomePage;
import com.ObjectRepo.POM.OrganizationsInfoPage;
import com.VTiger.generic.BaseUtility;
import com.VTiger.generic.Webdriver_Utility;
import com.github.javafaker.Faker;

public class SaiOrgDelTc extends BaseUtility {





	@Test
	public void createOrgTest() throws InterruptedException
	{

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

		Thread.sleep(3000);

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

		webdriver_utillity.acceptAlert();

		Thread.sleep(2000);

		WebElement orgHeader = organizationsInfoPage.getDeleorgverifyheader();

		if(orgHeader.isDisplayed()) {
			System.out.println("TestCase is Passed");
		}
		else {
			System.out.println("TestCase is failed");
		}

	}
}

