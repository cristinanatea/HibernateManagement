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



	<!-- First Container -->
	<div class="container-fluid bg-1 text-center">

		<form class="form-horizontal" action="login" method="post">
			<div class="form-group">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<input class="form-control" id="email" type="email" name="email"
						placeholder="Email..." value="cristina.natea8@gmail.com">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input class="form-control" id="password" type="password" name="password"
						placeholder="Password..." value="Ausy">
				</div>
			</div>
			
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><c:if
				test="${!empty message}">

				<div class="text-center">

					<c:out value="Error: ${message}" />

				</div>

			</c:if>
						
			<div>
				<button type="submit" class="btn">Login</button>
			</div>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
	</div>

</body>
</html>