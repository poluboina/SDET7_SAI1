package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICC_Cricket {
	public static void main(String[] args) throws Throwable {
		WebDriver driver; 
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/");
		WebElement ele = driver.findElement(By.xpath("(//div[@role='button' ])[8]"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		WebElement overviewbutton = driver.findElement(By.xpath("//a[text()='Overview']"));
		overviewbutton.click();
		driver.findElement(By.xpath("(//a[@class='btn'])[2]")).click();
		Thread.sleep(5000);
		String text = driver.findElement(By.xpath("//table[@class='table']")).getText();
		System.out.println(text);
		driver.close();
	}

}
