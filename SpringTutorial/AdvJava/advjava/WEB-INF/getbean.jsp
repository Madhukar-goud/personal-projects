<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Bean JSP</title>
</head>
<body>
<jsp:useBean id="user" class="com.madhukar.advjava.User" scope="session"></jsp:useBean>
<jsp:getProperty property="email" name="user"/>
<jsp:getProperty property="password" name="user"/>
<p/>
Email: <%= user.getEmail() %>
<p/>
Password: <%= user.getPassword() %>
</body>
</html>