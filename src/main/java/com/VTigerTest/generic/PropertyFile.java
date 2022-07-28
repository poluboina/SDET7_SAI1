package com.VTigerTest.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertyFile implements IAutoconstants {
	public static  PropertyFile propertyfile;

	private PropertyFile() {

	}



	public static PropertyFile getObjectProperty() {
		propertyfile = new PropertyFile();
		return propertyfile;
	}



	public  String readDatafromPropertyfile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IAutoconstants.propertyfilepath);
		Properties prop=new Properties();
		prop.load(fis);

		return prop.getProperty(key);


	}
}
