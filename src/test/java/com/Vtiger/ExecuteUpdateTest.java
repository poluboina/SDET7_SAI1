package com.Vtiger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateTest {
	@Test
	public void executeUpdateTest() throws Throwable
	{
		//		step=2  connect to database 
		Connection con=null;
		try {
			
//		step=1 Register driver
			Driver dref=new Driver();
			DriverManager.registerDriver(dref);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			
//		step=3 create statement 
			Statement stmt = con.createStatement();
//		step=4 Execute update
			int result = stmt.executeUpdate(" insert into students_info(regno,firstname,middlename,lastname) values('7 ','sai','krishna','h');");
			System.out.println(result);
			if(result==1) {
				System.out.println("Data is Added ");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			finally {
//			step=5 Close the connection
				
				con.close();
			}
	}
			
}

