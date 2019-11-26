<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/style1.css">
<title>EMI History</title>
</head>
<body>

	<%@ include file="menuUser.html" %>	


<center>
<div style="margin-top: 100px">
<table border="1" >

<h3><b>EMI Plans History </b> </h3>
<tr><th>EMI No</th> <th>Tenure</th> <th>Start Date</th> <th>End Date</th></tr>
<c:forEach items="${installments}" var="install">

<tr><td>${install[0] }</td> <td>${install[3] }</td> <td>${install[5] }</td> <td>${install[6] }</td><td><a href="installhistory.do?emi_no=${install[0]}">Get Details</a></td></tr>

<tr></tr>

</c:forEach>
</table>
</div>
</center>

</body>
</html>