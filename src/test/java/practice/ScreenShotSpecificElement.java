package practice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotSpecificElement {
	public static void main(String[] args) throws IOException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
//		WebElement ele=driver.findElement(By.xpath("//div[@id='desktop-grid-2']//img"));
		WebElement ele=driver.findElement(By.xpath("//img[@class='landscape-image']"));
		
		
		 File src = ele.getScreenshotAs(OutputType.FILE);
		 	File dest=new File("C:\\ScreenShot\\x4.png");
		 	FileUtils.copyFile(src, dest);
		 
		 
		
	}
}
