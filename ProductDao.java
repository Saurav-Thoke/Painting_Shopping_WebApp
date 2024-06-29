package com.login.dao;
import com.login.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ProductDao {
	
		
		String sql="select * from Products";
	public List<Product> getAllProducts()
	{
		List<Product> products=new ArrayList<Product>();
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saurav");
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product temp=new Product();
				temp.setId(rs.getInt("id"));
				temp.setName(rs.getString("name"));
				temp.setCategory(rs.getString("category"));
				temp.setSize(rs.getString("psize"));
				temp.setPrice(rs.getInt("price"));
				temp.setImage(rs.getString("image"));
				
				products.add(temp);
			}
		}catch(Exception e)
			{
				e.printStackTrace();
			}
		
		return products;
	}
	public List<Product> getCartProducts(ArrayList<Product> cartList)
	{
		List<Product> products=new ArrayList<>();
		
		try {
			
			if(cartList.size()>0)
			{
				for(Product p:cartList)
				{
					String s="select * from Products where id=?";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saurav");
					PreparedStatement ps=con.prepareStatement(s);
					ps.setInt(1, p.getId());
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						Product temp=new Product();
						temp.setId(rs.getInt("id"));
						temp.setName(rs.getString("name"));
						temp.setCategory(rs.getString("category"));
						temp.setSize(rs.getString("psize"));
						temp.setPrice(rs.getInt("price"));
						temp.setImage(rs.getString("image"));
						
						products.add(temp);
					}
				}
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return products;
	}
	
	public int getTotalCartPrice(ArrayList<Product>cartList)
	{
		int sum=0;
		try {
			if(cartList.size()>0)
			{
				for(Product p:cartList)
				{
					String s="select price from Products where id=?";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost :1521:xe","system","saurav");
					PreparedStatement ps=con.prepareStatement(s);
					ps.setInt(1,p.getId());
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						sum+=rs.getInt("price");
					}
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return sum;
	}
	
	
	public Product getSingleProduct(int id)
	{
		Product row=new Product();
		try {
			String sql="select * from Products where id=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost :1521:xe","system","saurav");
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				//row=new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getInt("price"));
				row.setImage(rs.getString("image"));
				row.setSize(rs.getString("psize"));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return row;
	}
}


