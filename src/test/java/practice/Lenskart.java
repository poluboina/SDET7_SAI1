package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lenskart {
	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.lenskart.com/");
//		driver.findElement(By.xpath("//input[@name='q']")).click();
//		 String str=driver.findElement(By.xpath("//a[text()='Eyeglasses']")).getText();
//		 System.out.println(str);
		
		/*
		 * String
		 * str=driver.findElement(By.xpath("//ul[@class='trending_list menu-link']")).
		 * getText(); System.out.println(str);
		 */
//		String str = driver.findElement(By.xpath("//a[text()='Do More, Be More']")).getAttribute("title");
//		System.out.println(str);
		String str = driver.findElement(By.xpath("//a[text()='Quality']")).getAttribute("title");
		System.out.println(str);
	}
}
