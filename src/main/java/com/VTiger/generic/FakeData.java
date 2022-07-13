package com.VTiger.generic;

import com.github.javafaker.Faker;

/**
	 * @author saikr
	 * @description  : This class is going to create Fake Data which
	 * is required for test Execution.
	 * 
	 */
	public class FakeData {
		
	Faker faker=new Faker();
	
	
	/**
	 * @author saikr
	 * @Description  : This method is going to return in  fake random firstname for the Test Execution 
 	 * @return String random name 
	 * 
	 */

	public String firstName() {
		return faker.name().firstName();
	}
	
	/**
	 * @author saikr
	 * @description : This method is going to return in random lastname for the Test Execution 
	 * @return String random lastname
	 */
	
	public String lastName() {
		return faker.name().lastName();
		
	}
	
	
	/**
	 * @author saikr
	 * @description :This method is going to return CompanyName for the Test Execution 
	 * @return String Random Company 
	 */
	
	public String orgname() {
		return faker.company().name();
	}
	
	 
	/**
	 * @author saikr
	 * @description :This method is going to return CompanyName for the Test Execution 
	 * @return String Random Company
	 */
	
	public String companyName() {
		return faker.company().name();
	}
	
	
}
