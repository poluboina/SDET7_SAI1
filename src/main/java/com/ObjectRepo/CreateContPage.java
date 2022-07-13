package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContPage {
	WebDriver driver;
	
	public CreateContPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//select[@name='salutationtype']")
	 private WebElement firstNameDD;

	public WebElement getFirstNameDD() {
		return firstNameDD;
	}

	@FindBy(xpath="//input[@name='firstname']")
	 private WebElement firstname;

	public WebElement getFirstname() {
		return firstname;
	}
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastname;

	public WebElement getLastname() {
		return lastname;
	}
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement savebtn;

	public WebElement getSavebtn() {
		return savebtn;
	}
}

