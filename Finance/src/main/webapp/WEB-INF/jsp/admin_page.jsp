<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.model.Users" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style1.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>View USERS</title>
</head>
<body>

  <%@include file="menuadmin.html" %>


<div style="margin-top: 200px">
<center>
<table border="1">
<tr>
<th>Application-Id </th> <th>First Name</th> <th>Last Name</th> <th>Contact no</th> <th>Email id</th>
<th>Username </th> <th> Address </th> <th> Card Type  </th> <th> Bank </th> <th>Account no</th>
<th>IFSC</th><th>Status</th>
</tr>

</div>

<c:forEach items="${ulist}" var="users">
<div>
  <tr>
  <td><c:out value="${users.app_id}"/></b></td>
  <td><b> <c:out value="${users.fname}"/></b></td>
  <td><c:out value="${users.lname}"/></td>
  <td><c:out value="${users.contact_no}"/></td>
  <td><c:out value="${users.email}"/></td>
   <td><c:out value="${users.username}"/></td>
   <td><c:out value="${users.address}"/></td>
   <td><c:out value="${users.card_type}"/></td>
   <td><c:out value="${users.bank}"/></td>
   <td><c:out value="${users.account_no}"/></td>
  <td> <c:out value="${users.ifsc}"/></td>
  <td> <c:out value="${users.status}"/></td>
  </tr>
</div>
</c:forEach>
</table>
</center>

</body>
</html>