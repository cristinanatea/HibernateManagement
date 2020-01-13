<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>SignUp</title>
</head>
<body>
	<form action="signup" method="post">

		<div>
			<label for="email">Email:</label> <input type="email" id="email" name="email" />
		</div>
		<div>
			<label for="password">Password:</label> <input type="password" id="pwd" name="password" />
		</div>

		<div>
			<label for="name">Name:</label> <input type="name" id="name" name="name" />
		</div>
		<div>
			<label for="phonenumber">PhoneNumber:</label> <input type="phonenumber" id="phonenumber" name="phonenumber" />
		</div>
		<div>
			<label for="company">Company:</label> <input type="company" id="company" name="company" />
		</div>
		<div>
			<label> <input type="checkbox" checked="checked"
				name="remember" style="margin-bottom: 15px"> Remember me</label>
		</div>

		<div>
			<button type="submit" class="signupbtn">Sign Up</button>
		</div>
	</form>

</body>
</html>