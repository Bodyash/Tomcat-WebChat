<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if (request.getSession().getAttribute("user") == null){
	response.sendRedirect("index.jsp");
} %>
U are logged in AS: <c:out value="${user.login}"/><br>
Your passwordHash: <c:out value="${user.passHash}"/><br>
Your email: <c:out value="${user.email}"/><br>
Your ID in DB: <c:out value="${user.id}"/><br>
Your Randomly Generated Nickname for this session: <c:out value="${nickname}"/><br>
<form action="logout" method="post">
<button type="submit" class="btn btn-warning">Logout</button>
</form>
</body>
</html>