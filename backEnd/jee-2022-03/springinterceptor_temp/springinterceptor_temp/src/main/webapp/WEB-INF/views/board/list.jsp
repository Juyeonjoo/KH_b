<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>list.jsp</title>
        	<%@include file="/WEB-INF/views/common/favicon.jsp" %>
    </head>
    <body>
        <!-- <h1>${ request.getRequestURI()}></h1> -->
        <h1><%= request.getRequestURI() %></h1>
        <hr>
        
        <button type="button" id="logoutBtn">Logout</button>
        
        <script>
        
        	var logoutBtn = document.querySelector('#logoutBtn');
        	
        	logoutBtn.addEventListener('click', function(){
        		location="/user/logout"; //get방식이면서 user/logout
        		//받아서 처리하는 컨트로럴가 필요.
        		//실제로 logout은 누가 수행해야지?
        				
        	});//onclick
        </script>
    </body>
    </html>