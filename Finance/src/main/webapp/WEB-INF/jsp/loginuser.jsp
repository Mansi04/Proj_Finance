<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">

<title>User Login</title>

<!-- Validation for Login -->
<script>
function valid(){
      var uname = document.getElementById('username').value;
      var pass = document.getElementById('password').value;

      var n1=document.getElementById('id1');
      var n2=document.getElementById('id2');  
      var n3=document.getElementById('id3');  
      n3.innerHTML="";

      var regex_uname= /^[a-zA-Z]{5,}$/;
      n1.innerHTML='';
      n2.innerHTML='';
      var flag=true;
      if(uname=='')
      {
        n1.innerHTML='Please enter Username';
        return false;
      }
      else{
        if(regex_uname.test(uname)==false)
        {
          n1.innerHTML='Not a valid username';
          flag=false;
        }
        
        
      }
      if(pass=='')
      {
        n2.innerHTML='Please enter Password';
        return false;
      }
      return flag;
  }
</script>
<!-- Validation end  for Login -->
</head>
<body>
 <div class="dash">
	<%@ include file="loginUsermenu.html" %>
</div>
<div id="adminlogin">
    <center>Login For User</center>
	<form modelAttribute="user"  action="loginProcess.do"	method="post" onsubmit="return valid();">
		<table align="center">
			<tr>
				<td>Username: </td>
				<td><input type="text" name="username" id="username" />
				<div id="id1"></div>
				</td>
				
			</tr>
			
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" id="password" />
				<div id="id2"></div>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td align="left"><input type="submit" class="submitLogin"  name="login" value="Login" ></td>
			</tr>

			<tr>
			<td align="left">
			<div id="id3">
			${status}
			</div>
			</td>
			</tr>
			
		</table>
	</form>
	
</div>

</body>

</html>