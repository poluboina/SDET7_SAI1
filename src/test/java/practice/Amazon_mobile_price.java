package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_mobile_price {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles under 20000",Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='realme']")).click();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@cel_widget_id='MAIN-SEARCH_RESULTS-1']//span[@class='a-price-whole']")).getText();
		System.out.println(str);
//		String str = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']")).getText();
//		System.out.println(str);
//		String a = str.replaceAll(",", "");
//		int i=Integer.parseInt(a);
//		
//		if (i<=20000) {
//			System.out.println("the testcase is passed");
//		}
//		else {
//			System.out.println("the testcase is failed");
//		}
		
	}
}
