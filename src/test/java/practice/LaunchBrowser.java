package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	public static void main(String[] args) {
//		WebDriverManager.chromedriver().setup();
		WebDriver driver=WebDriverManager.chromedriver().create();
//		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
	}
}
