package practice;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecuteor_practise {
	
	
	public static void main(String[] args) throws Throwable {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
//		ChromeOptions opt=new ChromeOptions();
//		opt.addArguments("start-maximized");
//		opt.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		driver.get("https://www.facebook.com/freecrm/");
		Thread.sleep(2000);
		
		
		
		
		
		driver.findElement(By.name("email")).sendKeys("saikrishnapoluboina47444@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("krishnaP@123");
		
		
		
//		twoways of finding login //2 one 
		
//		driver.findElement(By.xpath("//span[text()='Log In']/ancestor::div[@class='rq0escxv l9j0dhe7 du4w35lb']/descendant::span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5'][2]")).click();
		WebElement loginBtn = driver.findElement(By.xpath("(//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5'])[2]"));
		
		js.executeScript("argument[0].click();", loginBtn);
		
//		js.executeScript("alert("welcome to login");");
		
		
		
		
		}
		
}


