package com.ObjectRepo.POM;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {

	WebDriver driver;
	
	public  OrganizationsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath="//img[@title='Create Organization...']")       //(//a[.='Organizations'])[1]
	private WebElement createorglinkbtn;

	public WebElement getCreateorglinkbtn() {
		return createorglinkbtn;
	}

	@FindBy(name="search_text")
	private WebElement searchorgtxtbox;           //img[@title='Create Organization...']

	@FindBy(id="bas_searchfield")
	private WebElement selectorgtypeDD;


	public WebElement getSearchorgtxtbox() {
		return searchorgtxtbox;
	}


	public WebElement getSelectorgtypeDD() {
		return selectorgtypeDD;
	}


	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchorgbtn;
	
	public WebElement getSearchorgbtn() {
		return searchorgbtn;
	}


	@FindBy(xpath="//a[@title='Organizations']")
	private WebElement searchedorgname;


	public WebElement getSearchedorgname() {
		return searchedorgname;
	}
	
	@FindBy(xpath="//input[@name='selected_id']")
	private WebElement checkboxbtn;
	
	public WebElement getCheckboxbtn() {
		return checkboxbtn;
	}
	
	@FindBy (xpath="//input[@class='crmbutton small delete']")
	private WebElement deletebtn;
	
	public WebElement getDeletebtn() {
		return deletebtn;
	}
	
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement deleorgverifyheader;

	public WebElement getDeleorgverifyheader() {
		return deleorgverifyheader;
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgctdhedverfiy;

	public WebElement getOrgctdhedverfiy() {
		return orgctdhedverfiy;
	}
	
	
	
		
}
