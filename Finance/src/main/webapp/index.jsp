<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<div class="header-section">
	<nav class="header-nav">
		<ul class="main-menu">
			<li><a href="index.jsp">HOME</li>
			<li><a href="#">AboutUs</li>
			<li><a href="#">Contact Us</li>
			<li><a href="registration.html">Register</li>
			<li><a href="login.do">Login User</li>
			<li><a href="admin.do">Login Admin</li>
			<li><a href="track.do">Track Status</li>
		</ul>
	</nav>
</div>

<!-- For Sliding images -->

<div class="slide-container" style="max-width:500px">
  <img class="mySlides" src="img/1.jpg">
  <img class="mySlides" src="img/2.jpg" >
  <img class="mySlides" src="img/3.jpg"  >
  <!-- <input class="imgBtn" type="submit" name="buy" value="Buy Now" onclick="window.location.href='login.do'"> -->
<!-- <div>
  	<input class="imgBtn" type="submit" name="buy" value="Buy Now">
  </div> -->
</div>
<script>

var myIndex = 0;
carousel();

function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  myIndex++;
  if (myIndex > x.length) {myIndex = 1}    
  x[myIndex-1].style.display = "block";  
  setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>

<div class="footer-section">
</div>
</body>
</html>