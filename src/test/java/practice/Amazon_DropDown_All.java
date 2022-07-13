package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_DropDown_All {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("searchDropdownBox")).click();
		
//		String all =driver.findElement(By.xpath("//select[@title='Search in']")).getText();
//		  System.out.println(all);
		  
	 String book = driver.findElement(By.xpath("//option[@value='search-alias=stripbooks']")).getText();
	 System.out.println(book);
	}
}

