<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외처리</title>
</head>
<body>

	<h1><%=request.getRequestURI() %> </h1>
	<hr>
	
	<p>${__EXCEPTIOIN__}</p>
	
	<hr>
	
	<ul>
		<c:forEach var="stack" items="${__EXCEPTION__.getStackTrace() }">
			<li>at ${stack}</li>
		</c:forEach>
		
	</ul>
	
	
</body>
</html>