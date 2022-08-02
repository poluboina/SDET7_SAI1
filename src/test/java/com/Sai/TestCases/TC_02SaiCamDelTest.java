	package com.Sai.TestCases;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepo.POM.CampainInfoPage;
import com.ObjectRepo.POM.CreateCamPage;
import com.ObjectRepo.POM.HomePage;
import com.VTigerTest.generic.BaseUtility;
import com.VTigerTest.generic.FakeData;
import com.VTigerTest.generic.Webdriver_Utility;
import com.Vtiger.tstcases.RetryAnalyzer_1;
@Listeners(com.VTigerTest.generic.Listners.class)
public class TC_02SaiCamDelTest extends BaseUtility{

	@Test(groups = "smoke",priority = 2,retryAnalyzer = RetryAnalyzer_1.class)
	public void saiConDelTest() throws Throwable {

		FakeData fakedata = new FakeData();
		String campname = fakedata.companyName();


		Webdriver_Utility webdriver_Utility=new Webdriver_Utility(driver);
			webdriver_Utility.pageLoadTimeout();


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
		Thread.sleep(3000);
		webdriver_Utility.pageLoadTimeout();

		String str =campainInfoPage.getDelheadermsg().getText();
		String s1=(campname);
		
		Thread.sleep(4000);
		if(s1.contains(str)) {
			System.out.println("Campaign is not deleted Test Fail");
		}
		else {
			System.out.println("Campagin is Deleted Test Pass");
		}
	}

}
