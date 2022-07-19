package parameter;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class para_Annotations {

	public class Annotations {
		@BeforeSuite
		public void beforeSuite() {
			System.out.println("beforeSuite");
		}
		@BeforeTest
		public void beforeTest() {
			System.out.println("beforeTest");
			
		}
		@BeforeClass
		public void beforeclas() {
			System.out.println("beforeclass");
		}
		@BeforeMethod
		public void beforeMethod() {
			System.out.println("beforeMethod");
		}
		@AfterClass
		
		public void AfterClass() {
			System.out.println("AfterClass");
		}
		
		@AfterTest
		public void afterTest() {
			System.out.println("AfterTest");
			
		}
		
		@AfterMethod
		public void afterMethod() {
			System.out.println("AfterMethod");
		}
		
		@AfterSuite
		public void afterSuite() {
			System.out.println("AfterSuite");
		}
		
	}

}


