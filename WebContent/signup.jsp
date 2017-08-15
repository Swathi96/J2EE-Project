<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' href='stylesheet/style.css'>
<title>Insert title here</title>
</head>
<body>
<!--<form method="post" action="Register">
		<div class="main">
        Name:<input type="text" name="name" /><br/>
       
        Password:<input type="text" name="pass" /><br/>
        <input type="submit" value="Register" />
        </div>
        </form>-->
        <form action="Register" method="post" id="form1">
  <div class="login-form">
     <h1>Register</h1>
     <div class="form-group ">
	  <i class="fa fa-user"></i>
       <input type="text" class="form-control" placeholder="Username" name="name" id="username">
      <p style="color:red;">${errors['username']}</p>
     </div>
     <div class="form-group log-status">
	  <i class="fa fa-lock"></i>
       <input type="password" name="pass" class="form-control" placeholder="Password" id="password">
      <p>${errors['password']}</p>
     </div>
    
      <div class="formb">
	
	<input type="submit" value="Register" class="enter">
    
    </div>
   </div>
	</form>
</body>
</html>