<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
       <%@ page import="com.model.Users" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/style1.css">
<title>LTI PayEase</title>
</head>
<body>
<div style="margin-top: 200px">
	<%@ include file="loginUsermenu.html" %>	
	<table>
	
	<tr><td>${users.app_id}</td></tr>
	<tr><td>${status}</td></tr>
	</table>
</div>
</body>
</html>