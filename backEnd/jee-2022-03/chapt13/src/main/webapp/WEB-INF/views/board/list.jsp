<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

  <!DOCTYPE html>
    <html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>게시판목록</title>
    </head>
    	
    	<style>
	 		* 	{
	 		margin:0 auto;
	    	padding: 0;
	    		}
	    		
	    	table {
	    		border: 1px ridge purple;
	    		border-collapse:collapse;
	    		}

	    	td {
	    		padding:10px;
	    	}
	    	
	    	th{

          padding: 7px;
	    		background-color: purple;
	    		color: white;
          font-size: 18px;
	    	}

        tr:hover{
          background-color: bisque;
        }

        a, a:link, a:visited{
          text-decoration: none;
        }
	    	
        #registerBtn{
          width: 150px;
          height: 40px;
          border: 0;
          margin-bottom: 20px;

          font-size: 18px;
          font-weight: bold;
          font-family: D2coding;
          
          cursor:pointer;

          background-color: brown;
          color: white;
          
        }
    	</style>
    <body>
       <h1> <%= request.getRequestURI()%></h1>
        <hr>
	
		<p>&nbsp;</p>
		<p>&nbsp;</p>
      <div id="wrapper">

        <table border="1">
            <caption>
              <button type="button" id="registerBtn">REGISTER</button>
            </cation>
              <thead>
                <tr>
                  <th>bno</th>
                  <th>title</th>
                  <!-- <th>content</th> -->
                  <th>writer</th>
                  <th>intsert_ts</th>
                  <th>update_ts</th>
                </tr>
              </thead>

              <tbody>
                <c:forEach items="${list}" var="boardVO"> 
                  <tr>
                    <td>${boardVO.bno}</td>
                    <td><a href="/board/get?currPage=${param.currPage}&amount=${param.amount}&bno=${boardVO.bno}">${boardVO.title}</a></td>
                    <!-- <td>${boardVO.title}</td> -->
                    <!-- <td>${boardVO.content}</td> -->
                    <td>${boardVO.writer}</td>
                    <!-- <td><fmt:formatDate pattern ="yyyy/MM/dd HH:mm:ss" value="${boardVO.insert_ts}"/></td> -->
                    <td>${boardVO.insert_ts}</td>
                    <td>${boardVO.update_ts}</td>
                </tr>
              </c:forEach> 
              </tbody>
              
              <tfoot></tfoot>
        </table>

      </div>

      <script>
        var registerBtn = document.querySelector('#registerBtn');

        registerBtn.addEventListener('click', function(){
          location = '/board/register?currPage=${param.currPage}&amount=${param.amount}';
        });//.addEventListener

      var result = "${param.result}";
      if(result !=null && result !=""){
        console.log('result: ' + result); //내장객체인 param이용해서 이 자리에 찍어라.
        alert('result: ' + result);    
      } //if
      </script>
    </body> 
    </html>