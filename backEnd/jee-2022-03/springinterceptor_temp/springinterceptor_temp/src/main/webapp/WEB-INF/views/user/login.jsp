<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>login.jsp</title>
        
        <%--@include file="../common/favicon.jsp" --%>
		<%@include file="/WEB-INF/views/common/favicon.jsp" %>
    </head>
    <body>
    	<h1><%= request.getRequestURI() %></h1>
    	
        <form action="/user/loginPost"method="post" style="width: 300px;">
            <fieldset style="border: 5px outset gold;">
            
                <legend>login form</legend>

                <div><input type="text" name="userid" placeholder="User ID"></div>
                <div><input type="password" name="userpw" placeholder="User PW"></div>
                <div>remember-me<input type="checkbox" name="rememberMe"></div>

				<button type="submit" value="Sign-in">전송</button>

            </fieldset>

        </form>
    </body>
    </html>