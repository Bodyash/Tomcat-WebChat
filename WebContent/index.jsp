<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/login.css">
<link rel="icon" type="image/ico"
	href="https://raw.githubusercontent.com/ankurp/WebChat/master/public/images/favicon.ico">
</head>
<body>

	<!-- Looking for source of this page? Contact me: vk.com/id20444094 or 0637129869 -->
	<a href="https://github.com/Bodyash/Tomcat-WebChat"><img
		src="http://icons.iconarchive.com/icons/limav/flat-gradient-social/512/Github-icon.png"
		width="100"></a>
	<div class="container">
		<form action="login" method="post">
			<center>
				<h1>Welcome to WebChat</h1>
			</center>
			<center><h2>${msg}</h2></center>
			<div class="form-group">
				<label for="login">Login</label>
				<div class="input-group">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-user"></span></span> <input type="text"
						class="form-control" id="login" name="login" placeholder="Login">
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="pass">Password</label>
				<div class="input-group">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-lock"></span></span> <input type="password"
						class="form-control" id="pass" name="pass" placeholder="Password">
				</div>
			</div>
			<div class="btn-group">
				<button type="submit" class="btn btn-success">Login</button>
				<a href="register.jsp" class="btn btn-primary">Register</a>
			</div>
		</form>
	</div>

	<!-- Looking for source of this page? Contact me: vk.com/id20444094 or 0637129869 -->
</body>
</html>