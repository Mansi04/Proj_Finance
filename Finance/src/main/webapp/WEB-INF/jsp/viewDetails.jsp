<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.model.Users" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
</head>
<body>

<%-- <c:forEach items="${ulist}" var="users"> --%>
<div>
<form action="verify.do" method="post">
<input type="hidden" name="app_id" value="${ulist.app_id}">
<table>
<center>
	<%-- <c:param name="app_id" value="${ ulist.app_id}"/> --%>
		  <tr>
		  <td><b>Application Id - <c:out value="${ulist.app_id}"/></b></td></tr>
		  <tr>		 
		  <td><b>First Name - <c:out value="${ulist.fname}"/></b></td></tr>
		  <tr>		 
		  <td><b>Last Name - <c:out value="${ulist.lname}"/></b></td></tr>
		  <tr>
		  <td><b>Contact Number - <c:out value="${ulist.contact_no}"/></b></td></tr>
		  <tr>
		  <td><b>Email -Id - <c:out value="${ulist.email}"/></b></td></tr>
		  <tr>
		  <td><b>UserName - <c:out value="${ulist.username}"/></b></td></tr>
		  <tr>
		  <td><b>Address - <c:out value="${ulist.address}"/></b></td></tr>
		  <tr>
		  <td><b>Card Type - <c:out value="${ulist.card_type}"/></b></td></tr>
		  <tr>
		  <td><b>Bank - <c:out value="${ulist.bank}"/></b></td></tr>
		  <tr>
		  <td><b>Account Number - <c:out value="${ulist.account_no}"/></b></td></tr>
		  <tr>
		  <td><b>IFSC Code - <c:out value="${ulist.ifsc}"/></b></td></tr>
		  <tr>
		  <td><b>Status - <c:out value="${ulist.status}"/></b></td></tr>
		  <tr>
		  <td>
		  <input type="radio" value="approved" name="action">Approved
		  <input type="radio" value="rejected" name="action">Rejected
		  </td>
		  <td>
		  <input type="submit" value="Take Action">
		  </td>
		  </tr>
 </center>
  </table>
</div>


</form>


</body>
</html>