package com.Vtiger.tstcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	
	public static PropertyFile propertyfile;
	
	private PropertyFile() {
		
	}
		
	
	
	public static PropertyFile getObjectProperty() {
		PropertyFile propertyfile = new PropertyFile();
			return propertyfile;
	}
	

public String readDatafromPropertyfile(String key) throws IOException {
	FileInputStream fis=new FileInputStream("../SDET7_SAI/SDET7.PROPERTIES.txt");
	Properties prop=new Properties();
	prop.load(fis);
	
	return prop.getProperty(key);
	
}
}



 