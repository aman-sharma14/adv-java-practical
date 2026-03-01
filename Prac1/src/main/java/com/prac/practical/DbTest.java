package com.prac.practical;

import java.sql.*;

public class DbTest{
	public static void main (String [] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tyit","root","root");
			
			System.out.println("Cnnetction Successful");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}