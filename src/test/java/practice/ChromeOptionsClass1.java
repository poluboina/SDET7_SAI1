package practice;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionsClass1 {
public static void main(String[] args) throws Throwable {
	
	WebDriverManager.chromedriver().setup();
	

	
	ChromeOptions options=new ChromeOptions();
	options.addArguments("start-maximized");
//	options.addArguments("disable-infobars");
	options.addArguments("headless");
	options.addArguments("--incognito");
	DesiredCapabilities capabilites=new DesiredCapabilities();
	capabilites.setCapability(ChromeOptions.CAPABILITY, options);
	options.merge(capabilites);
	
//	capabilites.merge(options);
//	options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
	
//	
	
	
	
	
	options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
	

	
	Thread.sleep(2000);
	WebDriver driver=new ChromeDriver(options);
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.google.com/");
	String title=driver.getTitle();
	System.out.println("page tittle:"+title);
	System.out.println("saikrishna...poluboina");
}
}
