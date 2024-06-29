package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.login.Order;
import com.login.Product;

public class OrderDao {
	
//	public List<Integer> getAllOrderId()
//	{
//		String sql="select pid from Orders";
//		List<Integer> oIds=new ArrayList<Integer>();
//		try {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saurav");
//		PreparedStatement ps=con.prepareStatement(sql);
//		ResultSet rs=ps.executeQuery();
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
//		return oIds;
//	}
		
	public boolean insertOrder(Order model)
	{
		String sql="insert into Orders (userid,pid,o_date) values (?,?,?)";
		boolean result=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saurav");
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, model.getUid());
			ps.setInt(2, model.getPid());
			ps.setString(3, model.getDate());
			ps.executeUpdate();
			result=true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<Order> userOrders(String id)
	{
		List<Order> list=new ArrayList<>();
		try {
			
			String sql="select * from Orders where userid=? ";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saurav");
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Order order=new Order();
				ProductDao productDao=new ProductDao();
				int pId=rs.getInt("pid");
				
				Product product= new Product();
				product=productDao.getSingleProduct(pId);
				order.setPid(pId);
				order.setName(product.getName());
				order.setPrice(product.getPrice());
				order.setSize(product.getSize());
				order.setImage(product.getImage());
				order.setCategory(product.getCategory());
				order.setDate(rs.getString("o_date"));
				list.add(order);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public void cancelOrder(int id)
	{
		try {			
				String sql="delete from Orders where pid=? ";
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saurav");
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
