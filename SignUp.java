package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String cpass=request.getParameter("confirmpass");
		
		String sql="insert  into ShoppingUser (email,name,pass) values(?,?,?)";
		if(cpass.equals(pass))
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saurav");
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,email);
				ps.setString(2,name);
				ps.setString(3,pass);
				int res=ps.executeUpdate();
				HttpSession session=request.getSession();
				if(res!=0)
				{	request.getSession().setAttribute("auth", session);
					response.sendRedirect("login1.jsp");
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else 
			response.sendRedirect("signup.jsp");
	}

}
