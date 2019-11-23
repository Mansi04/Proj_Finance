<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Product Details</title>
</head>
<body>

<center>
<table>
<tr>
	<td>
	<b><img src="${pageContext.request.contextPath}/download/image.do?fileName=${prod.p_image}" height="150" width="150"></b>
	</td>
</tr>
<tr>
	<td>
	<b>Product Id - <c:out value="${prod.pid}"/></b>
	</td>
</tr>
<tr>
	<td>
	<b>Product Name - <c:out value="${prod.pname}"/></b>
	</td>
</tr>
<tr>
	<td>
	<b>Product Category - <c:out value="${prod.pcategory}"/></b>
	</td>
</tr>
<tr>
	<td>
	<b>Specifications - <c:out value="${prod.p_desc}"/></b>
	</td>
</tr>

<tr>
	<td>
	<b>Product Cost - <c:out value="${prod.pcost}"/></b>
	</td>
</tr>
</table>

<!-- Buying Options table -->
<%-- 
<% int cost = (Integer)request.getAttribute("cost"); 
out.println("PCost is  "+cost); %> --%>

<table>
<h3><b>EMI Plans </b> </h3>
<tr><th> Months</th>  <th> Monthly EMI</th> <th>Overall Cost</th></tr>
<tr>
<td> 6 months </td> <td>${prod.sixMonEmi }</td> <td>${prod.pcost}</td>

</table>

</center>

</body>
</html>