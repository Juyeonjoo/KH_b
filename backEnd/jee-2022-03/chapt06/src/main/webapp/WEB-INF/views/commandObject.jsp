<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>commandObject.jsp</title>
</head>
<body>
	<h1><%= request.getRequestURI() %></h1>
	<hr>

	<p>${sampleDTO}</p>
	<p>1. name: ${sampleDTO.name}</p>
	<p>2. age : ${sampleDTO.age}</p>
	<p>3. page: ${page}</p>

</body>
</html>