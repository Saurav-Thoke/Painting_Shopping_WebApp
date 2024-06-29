<%@page import="com.login.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.login.dao.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>cart</title>
<%@include file="Inc\\header.jsp" %>
</head>
<body>
<%@include file="Inc\\navbar.jsp" %>
<%
	
	if(request.getSession().getAttribute("username")==null)
	{
		response.sendRedirect("login1.jsp"); 
	}


	ArrayList<Product>cart_list=(ArrayList<Product>)session.getAttribute("items");
	List<Product> cartItem=null;
	int total=0;
	if(cart_list!=null)
	{
		ProductDao pd=new ProductDao();
		cartItem=pd.getCartProducts(cart_list);
		total=pd.getTotalCartPrice(cart_list);
		request.setAttribute("items",cart_list);
		request.setAttribute("total",total);
	}
	
%>
<div class="container">
	<div class="d-flex py-3">
<%if(cart_list!=null)
	{
		if(total!=0)
		{%>
			
			
		<h3>Total Price in Cart : Rs <%=total %></h3>
		<a class="mx-3 btn btn-primary" href="">Check Out</a>
	</div>
	<table class="table table-lough">
		<thead>
			<tr>
				<th scope="col">Product</th>
				<th scope="col">Name</th>
				<th scope="col">Category</th>
				<th scope="col">Price</th>
				<th scope="col">Size</th>
				<th scope="col">Buy Now</th>
				<th scope="col">Remove</th>
			</tr>
		</thead>
		<% }else
		{%>
			<h3 style="color:crimson">Nothing to show in Cart </h3>
		<%}
		%>
	
		
		<tbody>
		<% if(cart_list!=null)
			{
				for(Product pro:cartItem)
				{%>
					<tr>
					
					<td><img src="product-imgs//<%=pro.getImage() %>" alt="product image" class="img-thumbnail" style="width: 4rem"></td>
					<td><%=pro.getName() %></td>
					<td><%=pro.getCategory() %></td>
					<td><%=pro.getPrice() %></td>
					<td><%=pro.getSize() %></td>
					<td>
						<form action="orderNow" method="post" class="form-inline">
							<input type="hidden" name="id" value="<%=pro.getId() %>" class="form-input">
							<button type="submit" class="btn btn-primary">Buy Now</button></td>
						</form>
						
					<td><a class="btn btn-small btn-danger" href="removeCartItem?id=<%=pro.getId()%>">Remove</a></td>
				</tr>
				<%}
				}%>
			
		</tbody>
	</table>
<%}else
	{%>
			<h3 style="color:crimson">Nothing to show in Cart </h3>
	<%}%>
</div>

<%@include file="Inc\\footer.jsp" %>
</body>
</html>