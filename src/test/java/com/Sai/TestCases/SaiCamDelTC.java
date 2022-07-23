package com.Sai.TestCases;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ObjectRepo.POM.CampainInfoPage;
import com.ObjectRepo.POM.CreateCamPage;
import com.ObjectRepo.POM.HomePage;
import com.VTiger.generic.FakeData;
import com.VTiger.generic.Webdriver_Utility;
import com.VTiger.generic.BaseUtility;

public class SaiCamDelTC extends BaseUtility{

	@Test
	public void saiConDelTc() throws Throwable {

		FakeData fakedata = new FakeData();
		String campname = fakedata.companyName();


		Webdriver_Utility webdriver_Utility=new Webdriver_Utility(driver);



		HomePage homepage=new HomePage(driver);

		homepage.getCreatecamdrglinkbtn().click();

		homepage.getClickcamlinkbtn().click();
		
		Thread.sleep(2000);
		
		homepage.getCreatecamplinkbtn().click();
		
		

		CreateCamPage createcampage= new CreateCamPage(driver);	
		createcampage.getFirstnamecamp().sendKeys(campname);
		createcampage.getSavebtn().click();
		
		Thread.sleep(2000);

		homepage.getCampginlinkbtn().click();
		

		CampainInfoPage campainInfoPage=new CampainInfoPage(driver);
		campainInfoPage.getSearchboxcamp().sendKeys(campname);

		campainInfoPage.getClickcampDDlinkbtn().click();

		webdriver_Utility.selectDD(campainInfoPage.getClickcampDDlinkbtn(),1 );

		campainInfoPage.getClicksearchbtn().click();

		Thread.sleep(2000);

		campainInfoPage.getCheckboxbtn().click();

		campainInfoPage.getDeletebtn().click();

		webdriver_Utility.acceptAlert();

		String str =campainInfoPage.getDelheadermsg().getText();
		String s1=(campname);
		if(s1.contains(str)) {
			System.out.println("Campaign is not deleted Test Fail");
		}
		else {
			System.out.println("Campagin is Deleted Test Pass");
		}
	}

}
