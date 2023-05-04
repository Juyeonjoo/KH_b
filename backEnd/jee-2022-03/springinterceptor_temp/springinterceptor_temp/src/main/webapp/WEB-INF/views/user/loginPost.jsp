<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout.jsp</title>
	<%@include file="/WEB-INF/views/common/favicon.jsp" %>
	
</head>
<body>
	<%--
		reponse.sendRedirect("/board/list");
	--%>
	<c:redirect url="/board/list"/>
	
</body>
</html>