package com.ObjectRepo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;
	
	 public ContactInfoPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	 
	 
	 
	 @FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	 	private	WebElement createcontlinkbtn;

	public WebElement getCreatecontlinkbtn() {
		return createcontlinkbtn;
	}
	
	@FindBy(xpath="bas_searchfield")
	private WebElement selectDDlinkbtn;
	 
	public WebElement getSelectDDlinkbtn() {
		return selectDDlinkbtn;
	}



	@FindBy(xpath="//span[@class='dvHeaderText']")
	 private WebElement verifyheadertext;

	public WebElement getVerifyheadertext() {
		return verifyheadertext;
	}
}
