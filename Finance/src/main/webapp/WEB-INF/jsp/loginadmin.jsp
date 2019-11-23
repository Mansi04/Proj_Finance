<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Admin Login</title>
</head>
<body>

<div class="dash">
	<%@ include file="loginUsermenu.html" %>	
</div>
<div id="adminlogin" class="animate form">
    <center>Login For Admin</center>
	<form modelAttribute="admin"  action="adminProcess.do"	method="post">
		<table align="center">
			<tr>
				<td>Username: </td>
				<td><input type="text" name="username" id="username" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><input type="submit" class="submitLogin"  name="login" value="Login"></td>
			</tr>

			<tr></tr>
		</table>
	</form>	
</div>

</body>
</html>