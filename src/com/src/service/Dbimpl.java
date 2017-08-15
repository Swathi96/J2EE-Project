package com.src.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dbimpl implements DbIntr {
	private static Connection con;
	static{
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:h2:~/test","sa","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public List<String> dBCall() throws SQLException{
		Statement stmt=con.createStatement();
		ResultSet rs= stmt.executeQuery("Select name from people");
		List<String> n1=new ArrayList<>();
		while(rs.next()){
			
			n1.add(rs.getString(1));
			
		}
		return n1;
		
		
		
		
	}
}
