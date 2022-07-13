package practice;

import java.time.Duration;
import java.util.Date;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT {
	public static void main(String[] args) {
		Date da=new Date();
//		System.out.println(da);
		String currentDate=da.toString();
//		System.out.println(currentDate);
		String[] str=currentDate.split(" ");
		
//		Wed Jun 22 13:26:11 IST 2022
//		0    1   2   3        4   5
		String day=str[0];
		String month =str[1];
		String date =str[2];
		String year =str[5];	
		String	todayDate=day+" "+month+" "+date+" "+year;
//		System.out.println(todayDate);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		for (int i = 0; i < 11; i++) {
			try {
				driver.findElement(By.xpath("//div[@aria-label='Tue Nov 08 2022']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
			
		}
		
		
		
		
	 
	}
}
