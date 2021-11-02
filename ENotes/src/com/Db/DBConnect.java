package com.Db;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect {
	private final String jdbcURL = "jdbc:mysql://localhost:3306/enotes";
	private final String name="root";
	private final String password="password";
	private final String driver= "com.mysql.jdbc.Driver";
	
	
	public DbConnect()
	{ }
		public Connection getConnection() {
			Connection conn = null;
		try {
			
				Class.forName(driver);
			    conn=DriverManager.getConnection(jdbcURL, name, password);
			
			}
		 catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return conn;
	
  }

}
