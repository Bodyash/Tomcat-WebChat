<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
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

		<form action="register" method="post">
			<div class="form-group">

				<center>
					<h1>Registration form</h1>
				</center>
				
					<center><h2>${msg}</h2></center>
				<div class="input-group">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-user"></span></span> <input type="text"
						class="form-control" id="login" name="login"
						placeholder="Username">
				</div>
				<br>
				<div class="form-group has-feedback">
					<div class="input-group">
						<span class="input-group-addon"><span
							class="glyphicon glyphicon-lock"></span></span> <input type="password"
							class="form-control" id="pass" name="pass" placeholder="Password">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon"><span
							class="glyphicon glyphicon-lock"></span></span> <input type="password"
							class="form-control" id="pass-repeat" name="passrepeat"
							placeholder="Repeat Password">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon"><span
							class="glyphicon glyphicon-envelope"></span></span> <input type="email"
							class="form-control" id="email" name="email" placeholder="E-mail">
					</div>
				</div>
				<div class="btn-group">
					<button type="submit" class="btn btn-primary">Register</button>
				</div>
			</div>

		</form>
	</div>
	<!-- Looking for source of this page? Contact me: vk.com/id20444094 or 0637129869 -->
</body>
</html>