package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Print_SwitchToOneWindowToAnotherWindow {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles",Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='OnePlus']/..//div")).click();
		/*
		 * // String str=driver.findElement(By.
		 * xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).getText()
		 * ; // System.out.println(str);
		 */		driver.findElement(By.xpath("//span[text()='OnePlus Nord CE 2 Lite 5G (Black Dusk, 6GB RAM, 128GB Storage)']")).click();
		Set<String> win = driver.getWindowHandles();
		String a=driver.getWindowHandle();
		System.out.println(driver.getTitle());
		for(String i:win) {
			if(!i.equals(a)) {
				driver.switchTo().window(i);
			}
		}
		System.out.println(driver.getTitle());
		
		
		
		
	}
}
