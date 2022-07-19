package com.groups.parameters;

import org.testng.annotations.Test;

public class Group_Smoke_Regression1 extends Group_Annotations {

	
	@Test(groups="Smoke")
	public void smokeTest1() {
		
		System.out.println("Smoke testCase1 Running");
	}
	
	
	
	
	@Test(groups="Regression")
	public void regressionTest1() {
		System.out.println("Regression testCase1 Running");
	}
	
	
}
