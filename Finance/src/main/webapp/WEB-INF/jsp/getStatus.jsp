<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/style1.css">
</head>
<body>
  <%@include file="menuUser.html" %>

<div style="margin-top: 200px">
<form action="trackStatus.do" method="post">
Applicant Id : <input type="text" name="app_id" id="app_id">
<br>
<br>
<input type="submit" value="Track Status">
</form>
</div>
</body>
</html>