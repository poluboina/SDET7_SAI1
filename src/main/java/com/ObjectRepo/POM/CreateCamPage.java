package com.ObjectRepo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCamPage {
	WebDriver driver;
	
	public CreateCamPage(WebDriver driver ) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement firstnamecamp;
	
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement savebtn;

	public WebElement getFirstnamecamp() {
		return firstnamecamp;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}

}