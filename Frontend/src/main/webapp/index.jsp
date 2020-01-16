<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>Bootstrap Theme Simply Me</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
  body {
    font: 30px Comic Sans MS, sans-serif;
    line-height: 1.8;
    background-color: #b0988c;
    
  }
  p {font-size: 16px;}
  .margin {margin-bottom: 45px;}
  .bg-1 { 
    background-color: #68463c; 
    color: #b0988c;
  }
  .bg-2 { 
    background-color: #68463c;
    color:#b0988c;
  }

  .container-fluid {
    padding-top: 70px;
    padding-bottom: 70px;
  }
  .navbar {
    padding-top: 15px;
    padding-bottom: 15px;
    border: 0;
    border-radius: 0;
    margin-bottom: 0;
    font-size: 12px;
    letter-spacing: 5px;
	background-color: #b0988c;
	
  }
  .navbar-nav  li a:hover {
    color: yellow !important;
  }
  .navbar-nav  li a {
    color: white !important;
	font-weight: bold;
  }
  .navbar-toggle{
   font-style:Helvetica;
  }
  .navbar-brand>img {
    display: block;
	border-radius: 50%;
	margin-top:-30px;
	margin-bottom:-10px;
}
 .glyphicon glyphicon-search{
     background-color:#b0988c;

 }
 .btn btn-default btn-lg{
     background-color:#b0988c;
 }
 .btn btn-default btn-lg{
     background-color:#b0988c;
 }
 
 .logo {
     position: absolute;
     left: 20px;
     top: 20px;
 }

  </style>
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
        <li><a href="listusers">Home</a></li>
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
<footer class="container-fluid bg-4 text-center"></footer
 
</body>
</html>