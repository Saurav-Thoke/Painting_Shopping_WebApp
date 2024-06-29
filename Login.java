package com.login;

import java.io.IOException;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDao;

@WebServlet("/Login")
public class Login extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		LoginDao log=new LoginDao();
		if(log.check(email, pass))
		{
			HttpSession session=request.getSession();
			session.setAttribute("username", email);
			response.sendRedirect("index1.jsp");
		}
		else 
			response.sendRedirect("login1.jsp");
	}
	
}
