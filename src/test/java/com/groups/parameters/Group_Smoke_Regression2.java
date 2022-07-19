package com.groups.parameters;

import org.testng.annotations.Test;

public class Group_Smoke_Regression2  extends Group_Annotations{

	
	@Test(groups="Smoke")
	public void smokeTest2() {
		System.out.println("Smoke testcase2 Running");
	}
	
	
	@Test(groups="Regression")
	public void regressionTest2() {
		System.out.println("Regression testcase2 Running");
	}
}
