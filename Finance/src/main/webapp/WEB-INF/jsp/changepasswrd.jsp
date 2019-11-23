<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Change Password </title>
</head>
<body>

<div class="dash">
	<%@ include file="menuUser.html" %>	
</div>

<div class="column side2">
    <center>Password Update</center>
	<form id="changepasswrd"  action="changepasswrd.do"	method="post">
		<table align="center">
			<tr>
				<td>Old Password: </td>
				<td><input type="password" name="opassword" id="opassword" /></td>
			</tr>
			<tr>
				<td>New Password:</td>
				<td><input type="password" name="npassword" id="npassword" /></td>
			</tr>
			<tr>
				<td>Re-type Password:</td>
				<td><input type="password" name="rpassword" id="rpassword" /></td>
			</tr>			
			<tr>
				<td></td>
				<td align="left"><input type="submit" class="submitLogin" name="Update_Password" value="Update Password"></td>
			</tr>
			<tr>
			<td>${message}</td>
			</tr>
		</table>
	</form>
	
</div>
</body>
</html>