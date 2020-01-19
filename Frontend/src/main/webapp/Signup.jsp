<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<!-- Theme Made By www.w3schools.com - No Copyright -->
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<link href="<c:url value="/style.css" />" rel="stylesheet">

</head>
<body>

	<!-- Navbar -->
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="logo">
				<a class="navbar-brand" href="#"><img src="butterfly.jpg"
					width="60" height="60" style="display: inline""></a>
			</div>
			<div class="menu collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="Signup.jsp">SignUp</a></li>
					<li><a href="login.jsp">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>




	<div class="container-fluid bg-1 text-center">

		<form class="form-horizontal" action="signup" method="post">
			<div class="form-group">
				<label class="col-sm-2 col-form-label">Email:</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email" name="email" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 col-form-label">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd" name="password" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 col-form-label">Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 col-form-label">PhoneNumber:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="phonenumber" name="phonenumber" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 col-form-label">Company:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="company" name="company" />
				</div>
			</div>

			<div>
				<button type="submit" class="btn">Sign Up</button>
			</div>
		</form>
	</div>



	<!-- Footer -->
	<footer class="container-fluid bg-4 text-center"></footer>
</body>
</html>