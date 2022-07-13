package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDatapropfile {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		FileInputStream fis=new FileInputStream("../SDET7_SAI/SDET7.PROPERTIES.txt");
		Properties prop=new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("browser"));
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().create();
			driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().create();
			driver=new FirefoxDriver();
		}
		else 
		{
			System.out.println("no browser value is given");
		}
		driver.get(prop.getProperty("url"));
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("pwd")).sendKeys(prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//div[text()='Login '] ")).click();
	}
}

