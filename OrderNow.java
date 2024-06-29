package com.login;



import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.OrderDao;


@WebServlet("/orderNow")
public class OrderNow extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
	{
		try {
			PrintWriter out=response.getWriter();
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-mm-dd");
			Date date=new Date();
			HttpSession session=request.getSession();
			//User user= (User) session.getAttribute("username");
			String user=(String) session.getAttribute("username");
			if(user!=null)
			{
				String productId=request.getParameter("id");
				Order orderModel=new Order();
				orderModel.setUid(user);
				orderModel.setPid(Integer.parseInt(productId));
				orderModel.setDate(formatter.format(date));
				OrderDao orderDao=new OrderDao();
				boolean result=orderDao.insertOrder(orderModel);
				if(result)
				{
					response.sendRedirect("order1.jsp");
				}
				else 
				{
					out.println("order failed");
				}
			}
			
			
			else 
			{
				response.sendRedirect("login1.jsp");
			}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
	{
		doGet(request,response);
	}
	
}
