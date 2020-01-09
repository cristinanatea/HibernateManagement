<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>

</head>
<body>

<form action="asignuserstoproject" method="post">

	<select name="email">
		<c:forEach items="${userList}" var="category">
			<option value="${category.email}">${category.name}</option>
		</c:forEach>
	</select>

	<select name="projectName">
		<c:forEach items="${projectList}" var="categoryProj">
			<option value="${categoryProj.projectName}">${categoryProj.projectName}</option>
		</c:forEach>
	</select>
	
	<button type="submit">Submit</button>
</form>
<br/>
<br/>

		<c:forEach items="${projectList}" var="projInfo">
			Project: ${projInfo.projectName}<br />
			<ul>
				<c:forEach items="${projInfo.employeeNames}" var="employee">
					<li>${employee}</li>
				</c:forEach>
			</ul>
		</c:forEach>

</body>
</html>