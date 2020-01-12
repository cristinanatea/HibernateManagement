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
		<!-- if this is login for update, ignore remember me check -->
		
			<tr>
				<td></td>
				<td>Remember Me: <input type="checkbox" name="remember-me" /></td>
			</tr>
	

		<div>
			<button type="submit">Submit</button>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</body>
</html>