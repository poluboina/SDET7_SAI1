package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_checkbox_click {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin" ,Keys.TAB,Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']//tr[*]"));
		for(WebElement i:ele)
			System.out.println(i.getText());
		
		Thread.sleep(5000);
		for(int i=3;i<=ele.size();i++) {
			WebElement ele1= driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]/td[3]"));
		
			String ele2 = ele1.getText();
			System.out.println(ele2);
			}
		
		for(int i=3;i<=ele.size();i++) {
			WebElement ele1= driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]/td[3]"));
			String ele3 = ele1.getText();
			if(ele3.equalsIgnoreCase("google")) {
				driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]/td[1]")).click();
			}
			
		}
}
}
