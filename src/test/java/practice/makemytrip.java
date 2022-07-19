package practice;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class makemytrip {
	public static void main(String[] args) throws Throwable {
		
		ChromeOptions options=new ChromeOptions();
		
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		
		driver.switchTo().frame("notification-frame-~19713b227");
		driver.findElement(By.xpath("//a[@class='close']")).click();
		
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		 Thread.sleep(3000);
		 String src="BANG";
		 String dest="MUM";
		 
		 driver.findElement(By.xpath("//label[@for='fromCity']")).sendKeys(src);
		 driver.findElement(By.xpath("//div[text()='BLR']")).click();
		 
		 driver.findElement(By.xpath("//label[@for='toCity']")).sendKeys(dest);
		 driver.findElement(By.xpath("//div[text()='BOM']")).click();
		 
		 driver.findElement(By.xpath("//label[@for='departure']")).click();
		 
		 driver.findElement(By.xpath("//div[@aria-label='Fri Jul 15 2022']")).click();
		 	
		
		
		
	}

}
