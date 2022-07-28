package com.Vtiger.tstcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ObjectRepo.POM.CreateOrgPage;
import com.ObjectRepo.POM.HomePage;
import com.ObjectRepo.POM.LoginPage;
import com.ObjectRepo.POM.OrganizationsInfoPage;
import com.VTigerTest.generic.Webdriver_Utility;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_Organizatiion_Senario2_TC {
	
	 public static WebDriver driver;
	
	
	
	public static void main(String[] args) throws Throwable {
		
	
		PropertyFile propertyfile = PropertyFile.getObjectProperty();
		
		String BROWSER=	propertyfile.readDatafromPropertyfile("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else {
			System.out.println("invalid input");
			
		}
				
			
		
		
		
	
		Faker faker=new Faker();
		String orgname = faker.name().lastName();
		
		Webdriver_Utility webdriver_utillity = new Webdriver_Utility(driver);
		webdriver_utillity.maximumWindow();
		
		
		
//		driver.manage().window().maximize();
		driver.get(propertyfile.readDatafromPropertyfile("url"));
		
		webdriver_utillity.pageLoadTimeout();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoginPage  loginPage=new LoginPage(driver);
		loginPage.getUsernametextbox().sendKeys(propertyfile.readDatafromPropertyfile("username"));
		loginPage.getPasswordtextbox().sendKeys(propertyfile.readDatafromPropertyfile("password"));
		loginPage.getLoginbtn().click();
			
		
		
//		driver.findElement(By.name("user_name")).sendKeys(propertyfile.readDatafromPropertyfile("username"),Keys.TAB,propertyfile.readDatafromPropertyfile("password"),Keys.TAB,Keys.ENTER);
		
		HomePage homepage =new HomePage(driver);
		homepage.getOrglinkbtn().click();
		
//		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		OrganizationsInfoPage organizationsInfoPage=new	OrganizationsInfoPage(driver);
		organizationsInfoPage.getCreateorglinkbtn().click();
		
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		CreateOrgPage createOrgPage=new CreateOrgPage(driver);
		createOrgPage.getOrgnametxtbox().sendKeys(orgname);
//		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		
		createOrgPage.getSavebtn().click();
//		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		Thread.sleep(3000);
		
		homepage.getOrglinkbtn().click();
		
//		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
//		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname);
		
		organizationsInfoPage.getSearchorgtxtbox().sendKeys(orgname);
		
		Thread.sleep(1000);
		organizationsInfoPage.getSelectorgtypeDD().click();
		
//		WebElement organization_name = driver.findElement(By.xpath("//select[@name='search_field']"));
//		organization_name.click();
//		
		Select s=new Select(organizationsInfoPage.getSelectorgtypeDD());
		s.selectByIndex(1);
		webdriver_utillity.selectDD(organizationsInfoPage.getSelectorgtypeDD(), 1);
		
		Thread.sleep(1000);
		

		
//		driver.findElement(By.xpath("//input[@name='submit']")).click();
		organizationsInfoPage.getSearchorgbtn().click();
		
		Thread.sleep(2000);
		organizationsInfoPage.getCheckboxbtn().click();
		
//		driver.findElement(By.xpath("//input[@name='selected_id']")).click();
////	Thread.sleep(1000);
		organizationsInfoPage.getDeletebtn().click();
		
////	driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
////		
//		Alert alt=driver.switchTo().alert();
//		alt.accept();
		webdriver_utillity.acceptAlert();
		
		Thread.sleep(2000);
		
		WebElement orgnamenotfound = driver.findElement(By.xpath("//span[@class='genHeaderSmall']"));
		
		if(orgnamenotfound.isDisplayed()) {
			System.out.println("TestCase is Passed");
		}
		else {
			System.out.println("TestCase is failed");
		}
		homepage.getSignoutimg().click();
		
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		
		homepage.getSignoutlink().click();
		
//		WebElement signout= driver.findElement(By.xpath("//a[text()='Sign Out']"));
////		Actions act=new Actions(driver);
////		act.moveToElement(signout);
////		signout.click();
//		webdriver_utillity.moveToelement(signout);
//		
//		
////		driver.close();
//		
		webdriver_utillity.closeBrowser();
//		
//		}
}
}
