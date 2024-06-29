<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"  %>
<%@ page import="com.login.*" %>
<%@ page import="com.login.dao.*" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>

<%@include file="Inc\\header.jsp"%>

<!-- To include another file -->
</head>
<body>
	<%@include file="Inc\\navbar.jsp"%>
	<%
	if (request.getSession().getAttribute("username") == null) 
	{
		response.sendRedirect("login1.jsp");
	}
	
	ProductDao pd=new ProductDao();
	List<Product> products=pd.getAllProducts();
	%>


	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
		
		
		<%
			if(!products.isEmpty())
			{
				for(Product p:products)
				{%>
					<div class="col-md-3">
					<div class="card w-100" style="width: 18rem;">
						<img class="card-img-top" src="product-imgs//<%=p.getImage() %>" alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title"><%=p.getName() %></h5>
							<h6 class="price">Price:Rs <%=p.getPrice() %></h6>
							<h6 class="category">Category:<%=p.getCategory() %></h6>
							<h6 class="size">Size:<%=p.getSize() %></h6>
							<div class="mt-3 d-flex justify-content-between">
								<a href="cart?id=<%=p.getId() %>" class="btn btn-primary">Add to cart</a>
								<a href="orderNow?id=<%=p.getId() %>" class="btn btn-primary">Buy now</a>
							</div>	
						</div>
					</div>
				</div>
				<%}
			}
		%>
			
		</div>

	</div>
	<%@include file="Inc\\footer.jsp"%>
</body>
</html>