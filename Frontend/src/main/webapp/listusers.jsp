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


<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


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
					<li><a href="listusers">Home</a></li>
					<li><a href="logout">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>




	<div class="bg-1 text-center">


		<div class="tab">
			<button class="tablinks" onclick="openCity(event, 'List')">List
				projects</button>
			<button class="tablinks" onclick="openCity(event, 'Create')">Create
				Project</button>
			<button class="tablinks" onclick="openCity(event, 'Assign')">Assign
				user</button>
		</div>

		<div id="List" class="tabcontent">

			<c:forEach items="${projectList}" var="projInfo">

				<div class="projectInfo w3-container">

					<form action="deleteProject" method="POST">
						<input type="hidden" name="name" value="${projInfo.projectName}" />
						Project: ${projInfo.projectName}
						<button type="submit" class="btn">
							<i class="fa fa-trash"></i>
						</button>
					</form>
					
					<br />
					Assigned users:
					<br />

					<ul>
						<c:forEach items="${projInfo.employees}" var="employee">
							<li>

								<form action="deleteUserFromProject" method="POST">
									${employee.name}
									<button type="submit" class="btn">
										<i class="fa fa-trash"></i>
									</button>
									<input type="hidden" name="projectName"
										value="${projInfo.projectName}" /> <input type="hidden"
										name="name" value="${employee.email}" />
								</form>
							</li>
						</c:forEach>
					</ul>

				</div>
			</c:forEach>
		</div>

		<div id="Create" class="tabcontent">

			<c:if test="${admin}">
				<form action="createProject" method="POST">

					<div class="form-group" class="col-sm-2">
						<label for="name" class="col-sm-2 col-form-label">Project
							name</label> <input type="text" class="form-control" id="name"
							name="name" />
					</div>

					<div class="form-group" class="col-sm-2">
						<label for="managerEmail" class="col-sm-2 col-form-label">Manager</label>
						<select name="managerEmail" id="managerEmail" class="form-control">
							<c:forEach items="${userList}" var="category">
								<option value="${category.email}">${category.name}</option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group" class="col-sm-2">
						<button type="submit" class="btn">Create project</button>
					</div>
				</form>
			</c:if>
		</div>

		<div id="Assign" class="tabcontent">

			<c:if test="${admin}">
				<form action="asignuserstoproject" method="post">

					<div class="form-group" class="col-sm-2">
						<label for="email" class="col-sm-2 col-form-label">Manager</label>
						<select name="email" id="email" class="form-control">
							<c:forEach items="${userList}" var="category">
								<option value="${category.email}">${category.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group" class="col-sm-2">
						<label for="projectName" class="col-sm-2 col-form-label">Project
							name</label> <select name="projectName" id="projectName"
							class="form-control">
							<c:forEach items="${projectList}" var="categoryProj">
								<option value="${categoryProj.projectName}">${categoryProj.projectName}</option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group" class="col-sm-2">
						<button type="submit" class="btn">Assign user</button>
					</div>
				</form>
			</c:if>
		</div>

	</div>

	<script>
		function openCity(evt, cityName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}
	</script>

	<!-- Footer -->
	<footer class="container-fluid bg-4 text-center"></footer>
</body>
</html>