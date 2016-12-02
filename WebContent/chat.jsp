<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/chat.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Chat Page</title>
</head>
<body>
	<%
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("index.jsp");
		}
	%>
	U are logged in AS:
	<c:out value="${user.login}" />
	<br> Your passwordHash:
	<c:out value="${user.passHash}" />
	<br> Your email:
	<c:out value="${user.email}" />
	<br> Your ID in DB:
	<c:out value="${user.id}" />
	<br> Your Randomly Generated Nickname for this session:
	<c:out value="${nickname}" />
	<br>



	<div id="wrapper">
		<div id="menu">
			<p class="welcome">
				Welcome, <b>${user.login} (${nickname})</b>
			</p>
			<form action="logout" method="post" class="logout">
				<button type="submit" class="btn btn-danger">Exit</button>
			</form>

			<div style="clear: both"></div>
		</div>

		<div id="chatbox">
			<table class="table table-striped">
				<tbody>
					<tr class="active">
						<td>${nickname}:</td>
						<td>Message</td>
					</tr>
				</tbody>
			</table>
		</div>

		<form name="message" action="">
			<input name="usermsg" type="text" id="usermsg" size="63" /> <input
				name="submitmsg" type="submit" id="submitmsg" value="Send"
				class="btn btn-success" />
		</form>
	</div>
</body>
</html>