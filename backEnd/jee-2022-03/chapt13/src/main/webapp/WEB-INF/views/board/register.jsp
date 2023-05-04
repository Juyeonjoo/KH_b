<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <!DOCTYPE html>
    <html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>신규게시글작성</title>
    </head>
    
 
    <body>
      <h1> <%= request.getRequestURI()%></h1>
       <hr>
 
       <p>&nbsp;</p>
       <p>&nbsp;</p>

       <div id="wrapper">

         <form action="/board/register" method="post">
			
			<input type="hidden" name="currPage" value="${param.currPage}">
			<input type="hidden" name="amount" value="${param.amount}">
			
           <table>
             <caption></caption>
             <thead>
             <tbody>
                 <tr>
                   <td>TITLE</td>
                   <td><input type="text" name="title" size="70"></td>
                 </tr>
                 <tr>
                   <td>COTENT</td>
                   <td><textarea name="content" cols="70" rows="10"></textarea></td>
                 </tr>
                 <tr>
                   <td>WRITER</td>
                   <td><input type="text" name="writer" value="Ju" readonly></td>
                 </tr>

             </tbody>
             <tfoot></tfoot>
           </table>

           <!-- <input type="button" value="MODIFY"> -->
           <!-- <input type="submit" value="MODIFY "> -->
           <button type="submit" id ="submitBtn">register</button>
           <button type="button" id="listBtn">LIST</button>
         
         </form>

       </div>
      
       <script>
        var listBtn = document.querySelector('#listBtn');

        listBtn.addEventListener('click', function(){
          location.href='/board/list?currPage=${param.currPage}&amount=${param.amount}';
        })//.addEventListener
        
    </script>

    </html>