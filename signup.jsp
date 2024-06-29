<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="Inc\\header.jsp" %>
</head>
<body>
<%@include file="Inc\\navbar.jsp" %>
<div class="container">
	<div class="card w-50 mx-auto my-5">
		<div class="card-header text-center">User Sign Up</div>
			<div class="card-body">
				<form action="SignUp" method="post"> 
				
					<div class="form-group">
						<label>Email Address</label>
						<input type="email" class="form-control" name="email" placeholder="Enter email address" required>
			</div>
			<div class="form-group">
						<label>Name</label>
						<input type="text" class="form-control" name="name" placeholder="Enter Name " required>
			</div>
			<div class="form-group">
						<label>Password</label>
						<input type="password" class="form-control" name="pass" placeholder="Enter Password " required>
			</div>
			<div class="form-group">
						<label>Confirm Password</label>
						<input type="password" class="form-control" name="confirmpass" placeholder="Confirm Password " required>
			</div>
			<div class="text-center">
			<button type="submit" class="btn btn-primary">Sign up</button><br>
			
	</div>
</div>
<%@include file="Inc\\footer.jsp" %>
</body>
</html>