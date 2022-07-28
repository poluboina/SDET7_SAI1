package com.Sai.TestCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepo.POM.CampainInfoPage;
import com.ObjectRepo.POM.CreateCamPage;
import com.ObjectRepo.POM.HomePage;
import com.VTigerTest.generic.BaseUtility;
import com.VTigerTest.generic.FakeData;
import com.Vtiger.tstcases.RetryAnalyzer_1;

@Listeners(com.VTigerTest.generic.Listners.class)
public class TC_05SaiCampHeaderVerTest extends BaseUtility {
	@Test(priority = 5,retryAnalyzer = RetryAnalyzer_1.class)
	public void saiCampHeaderVerTest() throws InterruptedException   {
		

		FakeData fakedata = new FakeData();
		String campname = fakedata.companyName();


		HomePage homepage=new HomePage(driver);

		homepage.getCreatecamdrglinkbtn().click();

		homepage.getClickcamlinkbtn().click();
		
		Thread.sleep(2000);
		
		homepage.getCreatecamplinkbtn().click();
		
		CreateCamPage createcampage= new CreateCamPage(driver);	
		createcampage.getFirstnamecamp().sendKeys(campname);
		createcampage.getSavebtn().click();
		
		CampainInfoPage campainInfoPage=new CampainInfoPage(driver);
		WebElement orghedvertext = campainInfoPage.getCamphedVertext();
		
		if(orghedvertext.isDisplayed()) {
			System.out.println("The camp is verifed TC Pass");
		}
		else {
			System.out.println("The camp is not verifed TC Fail");
		}
		
	}

}
