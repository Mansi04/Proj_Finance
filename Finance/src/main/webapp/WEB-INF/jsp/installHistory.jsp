<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Installment History</title>
</head>
<body>
<div class="dash">
	<%@ include file="menuUser.html" %>	
</div>

<center>
<table>

<h3><b>History </b> </h3>
<tr><th> Installment No</th>  <th>EMI No</th> <th>Number of Installments</th> <th>Installment Amount</th> <th>Due Date</th></tr>
<c:forEach items="${installments}" var="install">

<tr><td>${install[0] }</td> <td>${install[1] }</td> <td>${install[2] }</td> <td>${install[3] }</td><td>${install[4]}</td></tr>
<tr></tr>

</c:forEach>
</table>
</center>

</body>
</html>