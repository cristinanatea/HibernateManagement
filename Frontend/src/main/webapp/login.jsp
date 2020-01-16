<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>
	<form action="login" method="post">
		<div>
			<label for="email">Email:</label> <input type="email" id="email"
				name="email" value="cristina.natea8@gmail.com" />
		</div>
		<div>
			<label for="pwd">Password:</label> <input type="password" id="pwd"
				name="password" value="Ausy" />
		</div>

		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><c:if
			test="${!empty message}">
			<div class="text-center">
				<c:out value="Error: ${message}" />
			</div>
		</c:if>


		<div>
			<button type="submit">Submit</button>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</body>
</html>