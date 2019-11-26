<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/style1.css">
<title>Payment</title>
</head>
<body>
<table>
	<%@ include file="menuUser.html" %>	
<div style="margin-top: 100px;margin-left: 150px;">
<% String emiplan = request.getParameter("emi");
	String emis[] = emiplan.split(":");
%>
	<tr><th><%out.println("\nTenure - "+emis[0]);%></th></tr>

	<tr><th><%out.println("\nInstallment Amount- "+emis[1]);%></th></tr>

</div>	
</table>
</body>
</html>