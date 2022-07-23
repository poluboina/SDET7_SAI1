package Assertion_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion1 {
	@Test
	public void H() {
		
		System.out.println("lanch browser");
		
		System.out.println("url");
		
		String expected="get Title";
		String actual="get Title";
		
		SoftAssert softassert=new SoftAssert();
		
		softassert.assertEquals(false, true);
		
		
		
		System.out.println("login page should be displayed");
		
		System.out.println("Home Page Should be displayed");
		
		System.out.println("create contact in home page");
		
		
		softassert.assertAll();
		
		Assert.assertEquals(actual, expected);
		
	}

}
