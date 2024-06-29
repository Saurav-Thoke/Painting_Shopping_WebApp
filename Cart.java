package com.login;

import java.io.PrintWriter;
import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/cart")
public class Cart extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException
	{
		response.setContentType("text/html;charset=UTF-8");
		
		
		try {
			PrintWriter out=response.getWriter();
			ArrayList<Product> cartList=new ArrayList<>();
			int id=Integer.parseInt(request.getParameter("id"));
			Product p=new Product();
			p.setId(id);
			
			
			HttpSession session=request.getSession();
			
			ArrayList<Product> items=(ArrayList<Product>)session.getAttribute("items");
			if(items==null)
			{
				cartList.add(p);
				session.setAttribute("items",cartList);
				response.sendRedirect("index1.jsp");
			}
			else 
			{
				cartList=items;
				boolean exist=false;
				for(Product pro:items)
				{
					if(pro.getId()==id)
					{
						exist=true;
						out.println("<h3 style='color:crimson;text-align:center'>Item already exists in Cart.<a href='cart1.jsp'>Go to Cart</a></h3>");
					}
				}
				
				if(!exist)
				{
					cartList.add(p);
					response.sendRedirect("index1.jsp");
				}
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
