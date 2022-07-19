package com.testng;

import org.testng.annotations.DataProvider;

import com.VTiger.generic.ExcelUsage;


public class DataProvider_Excel {
	ExcelUsage excelUsage =new ExcelUsage();
	
	
	@DataProvider 
	public  Object[][] getvalue() throws Throwable {
		
		int rowcount=excelUsage.getLastRowcount ("../SDET7_SAI/SDET7.xlsx", "Sheet2");
		
		Object [][] arr=new Object [rowcount+1][2];
		
		for(int i=0;i<rowcount;i++) {
			
			arr[i][0]=excelUsage.readDataFromExcel("../SDET7_SAI/SDET7.xlsx", "Sheet2", i, 0);
			arr[i][1]=excelUsage.readDataFromExcel("../SDET7_SAI/SDET7.xlsx", "Sheet2", i, 1);
		}
		
		return arr;
		
	}
}
