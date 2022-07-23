package com.Vtiger.tstcases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;


public class ExecuteQueryTest {
	@Test
	public void executequerytest() throws Throwable{
		//step=1 Register the driver
		Driver def=new Driver();
		DriverManager.registerDriver(def);
//		step=2 connect to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
//	step=3 create Statement
		Statement stmt = con.createStatement();
		
		
//		step=4  ExcuteQuery 
			ResultSet result = stmt.executeQuery("select * from students_info ");
			
			
			while(result.next())
			{
				System.out.println(result.getString(1)+""+result.getString(2));
				
			}
//			step=5 close connection with database 
			con.close();
			
	}
}
	 
	
	

