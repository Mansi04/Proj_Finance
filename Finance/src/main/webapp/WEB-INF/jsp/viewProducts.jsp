
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/style1.css">
<title>Products</title>
</head>
<body>

	<%@ include file="menuUser.html" %>	

<c:forEach items="${plist}" var="products">
<div style="margin-top: 100px">
<table>
<tr>
<td>
<b>Product Id: <c:out value="${products.pid}"/></b><br>
Product Category:  <c:out value="${products.pcategory}"/></b><br>
Product Name: <c:out value="${products.pname}"/></b><br>
Cost:  <c:out value="${products.pcost}"/></b><br></td>
<td><img src="${pageContext.request.contextPath}/download/image.do?fileName=${products.p_image}" height="250" width="400"><br>
</td></tr>
<form action="prod.do" method="post">
<input type="hidden" name="pid" value="${products.pid}">
<td><input type="submit" value="Shop Now"></td>
</form>
</table>
</div>
</c:forEach>

</body>
</html>