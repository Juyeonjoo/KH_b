<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
	<h1><%= request.getRequestURI() %></h1>
	
	<form action="/user/loginPost" method="post" style="width: 300px" >
		<fieldset style="border: 5px outset gold;">
		
			<legend>Login Form</legend>
			
			<div><input type="text" name="userid" placeholder="User ID"></div>
			<div><input type="password" name="userpw" placeholder="User PW"></div>
			<div>remember-me<input type="checkbox" name="rememberMe"></div>
			
			<button type="submit" value="Sign-in"></button>
		
		</fieldset>
	
	
	</form>

</body>
</html>