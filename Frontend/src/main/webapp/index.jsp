<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  

  <link href="<c:url value="/style.css" />" rel="stylesheet">

</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-default">
  <div class="container">
    <div class="logo">
      <a class="navbar-brand" href="#"><img src="butterfly.jpg" width="60" height="60" style="display:inline""></a>
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
  <h3 class="margin">Hello!</h3>
  <img src="cristina.jpg" class="img-responsive img-circle margin" style="display:inline"  width="350" height="350">
  <h3>I am the software that simplifies your bussiness</h3>
</div>

<!-- Second Container -->
<div class="container-fluid bg-2 text-center">
  <h3 class="margin">Discover more!</h3>
  <p>Ausy scheduling software makes it faster and easier than ever to build schedules and share them with employees and keep your workforce in the know. </p>
</div>

<!-- Footer -->
<footer class="container-fluid bg-4 text-center"></footer>
 
</body>
</html>