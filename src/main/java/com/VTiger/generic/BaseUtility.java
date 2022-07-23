package com.VTiger.generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.ObjectRepo.POM.HomePage;
import com.ObjectRepo.POM.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtility {

	public static WebDriver driver;
	
	PropertyFile propertyFile = PropertyFile.getObjectProperty();		
	
	

	@BeforeSuite
	public void connectDatabase() {

		System.out.println("Database is coonected");	
	}

	@BeforeClass
	public void lanchBrowser() throws Throwable {



		String BROWSER=propertyFile.readDatafromPropertyfile("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();

		}
		else {
			System.out.println("invalid input");
		}
	
	
	
		Webdriver_Utility dUtil=new Webdriver_Utility(driver);
		dUtil.maximumWindow();
		dUtil.pageLoadTimeout();
		driver.get(propertyFile.readDatafromPropertyfile("url"));
		
	}

	@BeforeMethod
	public void login() throws IOException {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.getUsernametextbox().sendKeys(PropertyFile.getObjectProperty().readDatafromPropertyfile("username"));
		loginpage.getPasswordtextbox().sendKeys(PropertyFile.getObjectProperty().readDatafromPropertyfile("password"));
		loginpage.getLoginbtn().click();

	}
	
	@AfterMethod
	public void logout() {

		HomePage homepage = new HomePage(driver);
		homepage.getSignoutimg().click();
		homepage.getSignoutlink();
	}

	@AfterClass
	public void closingBrowser() 
	{
		Webdriver_Utility dUtil=new Webdriver_Utility(driver);
		dUtil.closeBrowser();
	}

	@AfterSuite
	public void closeDatabase() {

		System.out.println("closeDataBase");
	}

}

