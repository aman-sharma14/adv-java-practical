<%@ page language="java" import="java.sql.*, java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");
int uid = Integer.parseInt(id);
String pwd = request.getParameter("pwd");

try{
	Class.forName("org.mariadb.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tyit","root","root");
	
	PreparedStatement ps = connection.prepareStatement("select * from auth where uid=? and password=?");
	
	ps.setInt(1,uid);
	ps.setString(2,pwd);
	
	ResultSet rs = ps.executeQuery();
	
	//while(rs.next()){
		//out.println("Your Role "+rs.getString("role"));
	//}
	if(rs.next()){
		out.println("Your Role "+rs.getString("role"));
	}
	else{
		out.println("Wrong password");
	}
}
catch(Exception e){
	e.printStackTrace();
	
}

%>
</body>
</html>