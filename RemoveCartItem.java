package com.login;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/removeCartItem")
public class RemoveCartItem extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException
	{
		
		try {
			String id=request.getParameter("id");
			if(id!=null)
			{
				ArrayList<Product> cart_list=(ArrayList<Product>) request.getSession().getAttribute("items");
				if(cart_list !=null)
				{
					for(Product p:cart_list)
					{
						if(p.getId()==Integer.parseInt(id))
						{
							cart_list.remove(cart_list.indexOf(p));
							break;
						}	
					}
					response.sendRedirect("cart1.jsp");
				}
				
			}
			else
			{
				response.sendRedirect("cart1.jsp");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
