<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="test" uri="/WEB-INF/formatter.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String res = (String) session.getAttribute("res");
	%>
	<h3 style="color:red;">Raw Session Data: <%= res %></h3>
	<h1>Welcome</h1>
	<h2>Your Department is: <test:formatter input="<%= res %>" /> </h2>
</body>
</html>