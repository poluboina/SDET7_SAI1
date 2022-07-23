package com.ObjectRepo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampainInfoPage {
	
WebDriver driver;
	
	

	public   CampainInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createcamlinkbtn;
	
	public WebElement getCreatecamlinkbtn() {
		return createcamlinkbtn;
		
	}
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchboxcamp;
	
	@FindBy(id ="bas_searchfield")
	private WebElement clickcampDDlinkbtn;

	public WebElement getSearchboxcamp() {
		return searchboxcamp;
	}

	public WebElement getClickcampDDlinkbtn() {
		return clickcampDDlinkbtn;
	}
	
		
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement clicksearchbtn;

	public WebElement getClicksearchbtn() {
		return clicksearchbtn;
	}
	
	
	@FindBy(xpath="//input[@name='selected_id']")
	private WebElement campcheckboxbtn;
	
	public WebElement getCheckboxbtn() {
		return campcheckboxbtn;
	}
	
	@FindBy (xpath="//input[@class='crmbutton small delete']")
	private WebElement deletebtn;
	
	public WebElement getDeletebtn() {
		return deletebtn;
	}
	
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement delheadermsg;
	
	
	public WebElement getDelheadermsg() {
		return delheadermsg;
	}

	

	
	


}
