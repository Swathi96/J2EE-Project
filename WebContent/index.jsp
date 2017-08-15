<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html >
<head>
  <meta charset="UTF-8">
  <title>ChatApp</title>
  
  
  <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
<link rel='stylesheet' href='stylesheet/style.css'>
   
<style>
$(document).ready(function(){

	$("username")






});




</style>
  
</head>

<body>
	<form action="LoginPage" method="post" id="form1">
  <div class="login-form">
     <h1>ChatApp</h1>
     <div class="form-group ">
	  <i class="fa fa-user"></i>
       <input type="text" class="form-control" placeholder="Username" name="username" id="username">
      <p style="color:red;">${errors['username']}</p>
     </div>
     <div class="form-group log-status">
	  <i class="fa fa-lock"></i>
       <input type="password" name="password" class="form-control" placeholder="Password" id="password">
      <p>${errors['password']}</p>
     </div>
    
      <div class="formb">
	<div class="row1"> <a href="signup.jsp"><button type="button"  >Sign-Up</button></a></div>
	<input type="submit" value="Enter" class="enter">
    
    </div>
   </div>
	</form>
</body>
</html>
