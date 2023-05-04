<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <!DOCTYPE html>
    <html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>상세게시글조회</title>
    </head>
    
    <body>
      <h1> <%= request.getRequestURI()%></h1>
       <hr>
 
       <p>&nbsp;</p>
       <p>&nbsp;</p>

       <div id="wrapper">

         <form action="/board/modify" method="post">
			
			<input type="hidden" name="currPage" value="${param.currPage}">
			<input type="hidden" name="amount" value="${param.amount}">
			
           <table>
             <caption></caption>
             <thead>
             <tbody>
                 <tr>
                   <td>BNO</td>
                   <td><input type="text" name="bno" value="${board.bno}" readonly></td>
                 </tr>
                 <tr>
                   <td>TITLE</td>
                   <td><input type="text" name="title" value="${board.title}" size="70"></td>
                 </tr>
                 <tr>
                   <td>COTENT</td>
                   <td><textarea name="content" cols="70" rows="10">${board.content}</textarea></td>
                 </tr>
                 <tr>
                   <td>WRITER</td>
                   <td><input type="text" name="writer" value="${board.writer}" readonly></td>
                 </tr>

             </tbody>
             <tfoot></tfoot>
           </table>

           <!-- <input type="button" value="MODIFY"> -->
           <!-- <input type="submit" value="MODIFY "> -->
           <button type="submit" id ="submitBtn">MODIFY</button>
           <button type="button" id ="removeBtn">REMOVE</button>
           <button type="button" id="listBtn">LIST</button>
         
         </form>

       </div>
      
       <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> -->

       <script>
       var listBtn = document.querySelector('#listBtn');
       var removeBtn = document.querySelector('#removeBtn');

       // listBtn.onclick = function(){
       //   console.log('listBtn clicked...');
       // }//.onclick

       listBtn.addEventListener('click', function(){
         location.href='/board/list?currPage=${param.currPage}&amount=${param.amount}';
       })//.addEventListener
       
      //  modifyBtn.addEventListener('click', function(){
      //    window.location = "/board/modify?bno=${board.bno}";
      //  })//.addEventListener

      removeBtn.addEventListener('click', function(){
        
    	  //Form 태그를 조작해서 삭제요청 전송
    	  var form = document.querySelector('form');

        form.setAttribute('method', 'POST');
        form.setAttribute('action', '/board/remove');
        form.submit();
      })//.addEventListener
   </script>
   </body>
    </html>