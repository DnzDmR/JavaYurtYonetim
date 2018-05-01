package com.deniz.connection;

import java.sql.Connection;
import java.sql.DriverManager;
 

 public class DatabaseConnection {

	public static Connection getConnection()
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","deniz","123");
			return con;
		} catch (Exception e) { e.printStackTrace(); return null;}
	}
}
