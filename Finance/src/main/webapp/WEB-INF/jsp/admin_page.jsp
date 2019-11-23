<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.model.Users" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>View USERS</title>
</head>
<body>
<div class="dash">
  <%@include file="menuadmin.html" %>
</div>

<div>
<table>
<tr>
<th>Application-Id </th> <th>First Name</th> <th>Last Name</th> <th>Contact no</th> <th>Email id</th>
<th>Username </th> <th> Address </th> <th> Card Type  </th> <th> Bank </th> <th>Account no</th>
<th>IFSC</th>
</tr>
</table>
</div>

<c:forEach items="${ulist}" var="users">
<div>
<c:out value="${users.app_id}"/></b>
 <b> <c:out value="${users.fname}"/></b>
 <c:out value="${users.lname}"/>
  <c:out value="${users.contact_no}"/>
  <c:out value="${users.email}"/>
  <c:out value="${users.username}"/>
  <c:out value="${users.address}"/>
  <c:out value="${users.card_type}"/>
  <c:out value="${users.bank}"/>
  <c:out value="${users.account_no}"/>
  <c:out value="${users.ifsc}"/>
</div>
</c:forEach>



</body>
</html>