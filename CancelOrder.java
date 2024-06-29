package com.login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.OrderDao;

@WebServlet("/cancelOrder")
public class CancelOrder extends HttpServlet{
		
		public void doGet(HttpServletRequest request,HttpServletResponse response)
		{
			try {
				
				String id=request.getParameter("id");
				if(id!=null)
				{
					OrderDao od=new OrderDao();
					od.cancelOrder(Integer.parseInt(id));
				}
				response.sendRedirect("order1.jsp");
				
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