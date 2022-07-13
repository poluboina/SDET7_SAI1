package practice;

import java.awt.Window;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Addto_cart {
	private static final boolean String = false;

	public static void main(String[] args) throws Throwable {
		
	
	WebDriver driver;
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.flipkart.com");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	driver.findElement(By.name("q")).sendKeys("redmi Note 10 Pro",Keys.ENTER);
	driver.findElement(By.xpath("//div[@class='_4rR01T']")).click();
	String mainId = driver.getWindowHandle();
	Set<String> allId = driver.getWindowHandles();

	for(String i:allId) {
		if(!mainId.equals(i)) {
			driver.switchTo().window(i);
		}
	}
	Thread.sleep(2000);
	String ele = driver.findElement(By.xpath("//span[@class='B_NuCI']/ancestor::div[@class='_1YokD2 _3Mn1Gg col-8-12']/descendant::div[@class='_30jeq3 _16Jk6d']")).getText();
//	System.out.println(ele);
	String ele1 = ele.replaceAll("[^a-zA-Z0-9]", "");
//	System.out.println(ele1); String convert to integer
	int ele2 = Integer.parseInt(ele1);
	System.out.println(ele2);
	driver.findElement(By.xpath("//*[name()='svg' and @class='_1KOMV2']")).click();
	Thread.sleep(2000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	
	jse.executeScript("window.scrollBy(0,2000)");
	driver.findElement(By.xpath("//input[@class='_253qQJ']")).click();
	driver.findElement(By.xpath("//button[text()='+']")).click();
	Thread.sleep(2000);
	String finalprice = driver.findElement(By.xpath("//div[text()='Total Amount']/ancestor::div[@class='_35mLK5']/descendant::div[@class='Ob17DV _3X7Jj1']")).getText();
//	System.out.println(finalprice);
	String final_price1 = finalprice.replaceAll("[^a-zA-Z0-9]", "");
	int final_price2 = Integer.parseInt(final_price1);
	System.out.println(final_price2);

}
} 
