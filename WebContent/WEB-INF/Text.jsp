<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="jquery-3.2.1.min.js"></script>
  </head>

     <link rel='stylesheet' href='stylesheet/Chatstyle.css'>
<style>
	$(document).ready(function(){
	 $(#text).keyup(function(event){
	 	newText=event.target.value;
	 	$(#chatcontainer).text(newText);
	 
	 });
	 });
  	

</style>
<body>

	<div id="row">
	<div id="container1">
		<div id="namecontainer">
		
	<p> <c:out value="${name}"/></p>
		
		</div>
			<div id="chatcontainer">
			</div>
	
		<form action="Chatdata" method="post">
    <div id="type" >
		<input type="text" placeholder="Your message" id="text" name="text">
		<button type="Submit" id="button1">
		<span class="glyphicon glyphicon-send" id="send"></span></button>
		</div>
		</form>
	
	</div>
		<div id="online">
			<div id="onlinecontainer">
				<p>ONLINE</p>	
			</div>
		<c:forEach items="${peopleList}" var="list">
		<a href="Chatdata?name= "${list}"><div id="pp"> <c:out value = "${list}"/></div></a>
		</c:forEach>
		</div>
		
	</div>
</body>
</html>>