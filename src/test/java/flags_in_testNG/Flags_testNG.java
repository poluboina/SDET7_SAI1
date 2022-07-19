package flags_in_testNG;

import org.testng.annotations.Test;

public class Flags_testNG {
	@Test(priority = 2)
	public void activateSimCard() {
		System.out.println("activate sim card");
	}
	@Test(priority = 1)
	public void bySimCard() {   
		System.out.println("bysimcard");
		
	}
	@Test(priority = 3)
	public void customerSupport() {
		System.out.println("Customer Support");
	}

	@Test(dependsOnMethods = "bySimCard")
	public void activateSimCard1() {
		System.out.println("activate sim card1");
	}
	
	
	@Test(enabled =false)
	public void customerSupport1() {
		System.out.println("Customer Support");
	}

	@Test(enabled = true)
	public void bySimCard1() {
		System.out.println("bysimcard1");
		
	}
	
	@Test(invocationCount  = 3)
	public void customerSupport2() {
		System.out.println("Customer Support2");
	}
}
