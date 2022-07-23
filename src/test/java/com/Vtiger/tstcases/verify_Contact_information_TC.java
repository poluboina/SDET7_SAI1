package com.Vtiger.tstcases;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.formula.ThreeDEval;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ObjectRepo.POM.ContactInfoPage;
import com.ObjectRepo.POM.CreateContPage;
import com.ObjectRepo.POM.HomePage;
import com.ObjectRepo.POM.LoginPage;
import com.VTiger.generic.FakeData;
import com.VTiger.generic.Webdriver_Utility;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class verify_Contact_information_TC {
	public static void main(String[] args) throws Throwable {

		WebDriver driver = null;
		Faker faker=new Faker();
		String contname = faker.name().firstName();
		Random random=new Random();
		int num = random.nextInt(20);


		WebDriverManager.chromedriver().setup();

		PropertyFile propertyfile = PropertyFile.getObjectProperty();

		String BROWSER=	propertyfile.readDatafromPropertyfile("browser");

		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}
		else if (BROWSER.equalsIgnoreCase("edge")) {

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}
		else {
			System.out.println("invalid input");

		}
		
		Webdriver_Utility webdriver_Utility=new Webdriver_Utility(driver);

		webdriver_Utility.pageLoadTimeout();

		webdriver_Utility.maximumWindow();

		driver.get(propertyfile.readDatafromPropertyfile("url"));




		LoginPage loginPage=new LoginPage(driver);
		loginPage.getUsernametextbox().sendKeys(propertyfile.readDatafromPropertyfile("username"));
		loginPage.getPasswordtextbox().sendKeys(propertyfile.readDatafromPropertyfile("password"));
		loginPage.getLoginbtn().click();
		//		driver.findElement(By.name("user_name")).sendKeys(propertyfile.readDatafromPropertyfile("username"),Keys.TAB,propertyfile.readDatafromPropertyfile("password"),Keys.TAB,Keys.ENTER);

		HomePage homePage=new HomePage(driver);
		homePage.getContlinkbtn().click();

		//		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		ContactInfoPage contactInfoPage=new ContactInfoPage(driver);
		contactInfoPage.getCreatecontlinkbtn().click();

		//		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//		
		Thread.sleep(2000);

		//		driver.findElement(By.xpath("//select[@name='salutationtype']")).click();

		//		WebElement ele = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		//		ele.click();
		CreateContPage createContPage=new CreateContPage(driver);
		createContPage.getFirstNameDD().click();
		Thread.sleep(1000);
//
//		Select s=new Select(createContPage.getFirstNameDD());
//		s.selectByIndex(1);
		
		webdriver_Utility.selectDD(createContPage.getFirstNameDD(), 1);
	

		

			createContPage.getFirstname().sendKeys(contname);

				driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(contname);

				driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
				
				String mainId=driver.getWindowHandle();
				Set<String> allId = driver.getWindowHandles();
				for(String i:allId) {
					//if(!mainId.equals(i)) {
						driver.switchTo().window(i);
					}
					Thread.sleep(5000);
		//			System.out.println("=====");
					WebElement ele1=driver.findElement(By.xpath("//a[@id='3']"));
					ele1.click();
					driver.switchTo().window(mainId);
					Thread.sleep(2000);

		createContPage.getLastname().sendKeys(contname);

		//			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(contname);

		createContPage.getSavebtn().click();

		//			driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		//			
		//		WebElement	ele=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		//			

		if(contactInfoPage.getVerifyheadertext().isDisplayed()){
			System.out.println("The Contact is verifed");
		}
		else {
			System.out.println("The contact is not verifed");
		}
		//			Thread.sleep(2000);
		//			
		homePage.getSignoutimg().click();

		//			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();

		homePage.getSignoutlink().click();

		//			WebElement signout= driver.findElement(By.xpath("//a[text()='Sign Out']"));
		//			Actions act=new Actions(driver);
		//			act.moveToElement(signout);
		//			signout.click();

		driver.close();
	}
	//	
	//	



}




