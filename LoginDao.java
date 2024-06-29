package com.login.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.login.User;

public class LoginDao extends User{

	String sql="select * from ShoppingUser where email=? and pass=?";
	
	public boolean check(String email,String pass) 
	{
		try {
			  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saurav");
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,email);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{			
				return true;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
