<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
<%@include file="Inc\\header.jsp" %>
</head>
<body>
<%@include file="Inc\\navbar.jsp" %>
<div class="container">
	<div class="card w-50 mx-auto my-5">
		<div class="card-header text-center">User Login</div>
			<div class="card-body">
			
				<form action="Login" method="post"> 
				
					<div class="form-group">
						<label>Email Address</label>
						<input type="email" class="form-control" name="email" placeholder="Enter email address" required>
			</div>
			<div class="form-group">
						<label>Password</label>
						<input type="password" class="form-control" name="pass" placeholder="Enter Password " required>
			</div>
			<div class="text-center">
			<button type="submit" class="btn btn-primary">Login</button><br>
			<a href="signup.jsp">create new account</a>
			
	</div>
</div>
<%@include file="Inc\\footer.jsp" %>
</body>
</html>