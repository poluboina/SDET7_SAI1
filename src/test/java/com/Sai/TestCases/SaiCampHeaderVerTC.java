package com.Sai.TestCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ObjectRepo.POM.CampainInfoPage;
import com.ObjectRepo.POM.CreateCamPage;
import com.ObjectRepo.POM.HomePage;
import com.VTiger.generic.BaseUtility;
import com.VTiger.generic.FakeData;

public class SaiCampHeaderVerTC extends BaseUtility {
	@Test
	public void saiCampHeaderVerTc() throws InterruptedException   {
		

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
