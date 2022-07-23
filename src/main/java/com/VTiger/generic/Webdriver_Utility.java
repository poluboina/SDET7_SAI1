package com.VTiger.generic;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver_Utility {

	 WebDriver driver;
		
	public 	Webdriver_Utility(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	public void maximumWindow() {
		
		driver.manage().window().maximize();
	}

	
	public void pageLoadTimeout() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void waitandclick(WebElement element) {
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public void selectDD(String visibletext,WebElement element ){
		Select select=new Select(element);
		select.selectByVisibleText(visibletext);
		
	}
	
	
	public void selectDD(WebElement element,String value ){
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	
	public void selectDD(WebElement element,int index ){
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void moveToelement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void dragAndDrop(WebElement source,WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
		
	}
	
	public void switchtoinsidewindow() {
		String mainId=driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		for(String i:allId) {
			if(!mainId.equals(i)) {
				driver.switchTo().window(i);
			}
		}
	}
	
	
	}



