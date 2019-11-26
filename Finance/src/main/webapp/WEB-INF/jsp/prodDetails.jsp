<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page import="com.model.ProdEmi" %>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/style1.css">
<title>Product Details</title>
<!-- <script type="text/javascript">
	function show()
	{
		var option = document.getElementById("emi").value;
		 var n1=document.getElementById('id1');
		 n1.innerHTML=" ";
		 n1.innerHTML=" Your Option selected is"+option;
	}
</script>
 -->
</head>
<body>
<%@ include file="menuUser.html" %>	
<div style="margin-top: 100px;">
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


<table>
<h3><b>EMI Plans </b> </h3>
<tr><th> Months</th>  <th> Monthly EMI</th> <th>Overall Cost</th></tr>
<%-- <tr>
<% ProdEmi prodemi = new ProdEmi();
	int cost = prodemi.getPcost();
	if(cost < 50000)
	{
%> --%>
<form action="payment.do" method="post">
<input type="hidden" name="pid" value="${prod.pid}">
<input type="hidden" name="user_id" value="${ulist.app_id}">
<input type="hidden" name="pcost" value="${prod.pcost}">
<c:if test="${prod.pcost < 50000}">
	<tr>
	<div id="6mon">
	<td><input type="radio" name="emi" id="emi" value="3:${prod.threeMonEmi}">  3 months </td>
	 <td>${prod.threeMonEmi }</td> <td>${prod.pcost}</td></tr>
	<tr>
	
	<td><input type="radio" name="emi" id="emi" value="6:${prod.sixMonEmi }">  6 months </td> 
	<td>${prod.sixMonEmi }</td> <td>${prod.pcost}</td></tr>
	</div>
	</c:if>
<c:if test="${prod.pcost > 50000  && prod.pcost <70000}">
<div id="9mon">

<tr>
	<td> <input type="radio" name="emi" id="emi" value="3:${prod.threeMonEmi}"> 3 months </td> 
	<td>${prod.threeMonEmi }</td> <td>${prod.pcost}</td></tr>
	<tr>
	<td>
	<input type="radio" name="emi" id="emi" value="6:${prod.sixMonEmi}">6 months </td> 
	<td>${prod.sixMonEmi }</td> <td>${prod.pcost}</td></tr>
	<tr>
	<td> <input type="radio" name="emi" id="emi" value="9:${prod.nineMonEmi}"> 9 months </td> 
	<td>${prod.nineMonEmi }</td> <td>${prod.pcost}</td></tr></div>
</c:if>
<c:if test="${prod.pcost > 70000 }">
	<div id="12mon">
	<tr>
	<td> <input type="radio" name="emi" id="emi" value="3:${prod.threeMonEmi }"> 3 months </td> 
	<td>${prod.threeMonEmi }</td> <td>${prod.pcost}</td></tr>
	<tr>
	<td> <input type="radio" name="emi" id="emi" value="6:${prod.sixMonEmi}"> 6 months </td> 
	<td>${prod.sixMonEmi }</td> <td>${prod.pcost}</td></tr>
	<tr>
	<td> <input type="radio" name="emi" id="emi" value="9:${prod.nineMonEmi}"> 9 months </td> 
	<td>${prod.nineMonEmi }</td> <td>${prod.pcost}</td></tr>
	<tr>
	<td> <input type="radio" name="emi" id="emi" value="12:${prod.twelveMonEmi}"> 12 months </td> 
	<td>${prod.twelveMonEmi }</td> <td>${prod.pcost}</td></tr></div>


</c:if>


</table>

<input type="submit" value="Proceed To Pay">
</form>
<!-- <div id="id1">

</div> -->
</center>
</div>
</body>
</html>