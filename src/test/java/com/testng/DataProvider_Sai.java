package com.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Sai {
	@Test(dataProvider = "getvalue")
	public void testmmt(String src ,String dest) {
		System.out.println(src +" ----> "+dest);
		
	}
	
	@DataProvider
	public Object[][] getvalue() {
		Object [][] array=new Object [5][2];
		array [1][0]="HYd";
		array [1][1]="BANG";
		
		array [2][0]="MUM";
		array [2][1]="DEL";
			
		array [3][0]="CHEENI";
		array [3][1]="GOA";
			
		array [4][0]="PUNA";
		array [4][1]="MUM";
		
		
		return array;
	}

}
