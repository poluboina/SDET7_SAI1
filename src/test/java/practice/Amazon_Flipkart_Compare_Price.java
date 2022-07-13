package practice;

import java.time.Duration;
import java.util.Set;

import org.apache.poi.ddf.EscherColorRef.SysIndexProcedure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Flipkart_Compare_Price {
	public static void main(String[] args) throws Throwable {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriver driver1 = driver.switchTo().newWindow(WindowType.TAB);
		driver1.get("https://www.flipkart.com");
		driver1.manage().window().maximize();
		driver1.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver1.findElement(By.name("q")).sendKeys("redmi Note 10 Pro");
		driver1.findElement(By.xpath("//button[@type='submit']")).click();
		driver1.findElement(By.xpath("//div[text()='REDMI Note 10 Pro (Glacial Blue, 128 GB)']")).click();

		/*
		 * String mainId = driver1.getWindowHandle();
		 * Set<String>allID=driver1.getWindowHandles(); for(String i:allID) {
		 * if(!i.equals(mainId)) { driver1.switchTo().window(i); } } driver1.close();
		 */
			  Thread.sleep(1000);
		   String str = driver1.findElement(By.xpath("//div[@class='_4rR01T']/ancestor::div[@class='_13oc-S']/descendant::div[@class='_30jeq3 _1_WHN1']")).getText();
		  
		  String str2 = str.replaceAll("[^a-zA-Z0-9]", ""); 
		  int i=Integer.parseInt(str2);
		  System.out.println(i);
		  
		 
		  
		  driver1=driver1.switchTo().newWindow(WindowType.TAB);
		  driver1.get("https://www.amazon.in");
		  Thread.sleep(1000);
		  WebElement ele = driver1.findElement(By.id("twotabsearchtextbox"));
		  driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  Actions act=new Actions(driver1);
		  act.moveToElement(ele). build().perform();
		  ele.sendKeys("redmi Note 10 Pro",Keys.ENTER);
		  driver1.findElement(By.xpath("//span[@class='a-truncate-cut']")).click();
		  String str3 = driver1.findElement(By.xpath("//span[@class='a-truncate-cut']/ancestor::div[@class='a-section acs-product-block acs-product-block--default']/descendant::span[@class='a-price-whole']")).getText();
//		  System.out.println(str3);	
		  String str4 = str3.replaceAll(",", "");
		  int j=Integer.parseInt(str4);
		  System.out.println(j);
		  
		 
		  String mainId = driver1.getWindowHandle(); 
			Set<String>allID=driver1.getWindowHandles(); 
			for(String a:allID) {
				if(!a.equals(mainId)) {
				  driver1.switchTo().window(a);
				  } 
				}
			driver1.close();
			if(i>j) {
				System.out.println("To print the lowest price :"+i);
			}
				else if(i<j){
					System.out.println("To print the lowest price :"+j);
					
				}
				else {
					System.out.println("To print the same price "+i);
				
			}
				 
	
	}

}
