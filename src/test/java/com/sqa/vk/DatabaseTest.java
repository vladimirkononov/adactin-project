package com.sqa.vk;

import java.sql.*;

public class DatabaseTest {

	public void databaseTest() throws ClassNotFoundException, SQLException {
		// Step1
		Class.forName("com.mysql.jdbc.Driver");
		// Step2
		Connection dbconn = DriverManager.getConnection("jdbc:mysql://localhost:8889/sqadb", "root", "root");
		// Step3
		Statement stmt = dbconn.createStatement();
		// Step4
		ResultSet rs = stmt.executeQuery("select root, root");
		while (rs.next()) {
			String userName = rs.getString(1);
			String userPass = rs.getString(2);
			System.out.println("user =" + userName + " password = " + userPass);
		}
		// Step5
		rs.close();
		stmt.close();
		dbconn.close();
	}
}