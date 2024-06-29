
<%@page import="java.util.List"%>
<%@page import="com.login.dao.OrderDao"%>
<%@page import="com.login.Order" %>
<%@page import="com.login.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>orders</title>
<%@include file="Inc\\header.jsp" %>
</head>
<body>
<%@include file="Inc\\navbar.jsp" %>
<%
	String auth= (String)request.getSession().getAttribute("username");
	List<Order> orders=null;
	if(auth==null)
	{
		response.sendRedirect("login1.jsp"); 
	}
	else
	{
		request.setAttribute("auth",auth);
		 orders=new OrderDao().userOrders(auth);
	}
%>
<div class="container">
	<div class="card-header my-3">All Orders</div>
	<table class="table table-lough">
		<thead>
			<tr>
				<th scope="col">Date</th>
				<th scope="col">Product</th>
				<th scope="col">Name</th>
				<th scope="col">Category</th>
				<th scope="col">Size</th>
				<th scope="col">Price</th>
				<th scope="col">Cancel</th>
			</tr>
		</thead>
		<tbody>
			<%
				if(orders!=null)
				{
					for(Order o:orders)
					{%>
						<tr>
							<td><%=o.getDate()%></td>
							<td><img src="product-imgs//<%=o.getImage() %>" alt="product image" class="img-thumbnail" style="width: 4rem"></td>
							<td><%=o.getName()%></trd>
							<td><%=o.getCategory()%></td>
							<td><%=o.getSize()%></td>
							<td><%=o.getPrice()%></td>
							<td><a class="btn btn-small btn-danger" href="cancelOrder?id=<%=o.getPid() %>">Cancel</a></td>
						</tr>
					<%}
				}%>
			
		</tbody>
	</table>
</div>
<%@include file="Inc\\footer.jsp" %>
</body>
</html>