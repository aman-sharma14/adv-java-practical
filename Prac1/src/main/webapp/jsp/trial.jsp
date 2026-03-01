<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="test" uri="/WEB-INF/Substr.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Good Morning
<br>
<font color = "blue">
	<test:substring input="GOODMORNING" start ="1" end="6"/>
	</font>

</body>
</html>