<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <!DOCTYPE html>
    <html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>게시글상세조회</title>
    </head>

    <style>
      #wrapper{
        margin:0 auto;

        font-family: D2coding;
        font-size: 18px;
      }

    </style>


    <body>
       <h1> <%= request.getRequestURI()%></h1>
        <hr>
	
        <p>&nbsp;</p>
        <p>&nbsp;</p>

        <div id="wrapper">

          <form action="#">

            <table>
              <caption></caption>
              <thead>
              <tbody>
                  <tr>
                    <td>BNO</td>
                    <td>${board.bno}</td>
                  </tr>
                  <tr>
                    <td>TITLE</td>
                    <td>${board.title}</td>
                  </tr>
                  <tr>
                    <td>COTENT</td>
                    <td>${board.content}</td>
                  </tr>
                  <tr>
                    <td>WRITER</td>
                    <td>${board.writer}</td>
                  </tr>

              </tbody>
              <tfoot></tfoot>
            </table>

            <!-- <input type="button" value="MODIFY"> -->
            <button type="button" id ="listBtn">LIST</button>
            <button type="button" id="modifyBtn">MODIFY</button>
          
          </form>

        </div>
        
 
        <script>
        var listBtn = document.querySelector('#listBtn');
        var modifyBtn = document.querySelector('#modifyBtn');

        // listBtn.onclick = function(){
        //   console.log('listBtn clicked...');
        // }//.onclick

        listBtn.addEventListener('click', function(){
          location.href='/board/list?currPage=${param.currPage}&amount=${param.amount}';
        });//.addEventListener
        
        modifyBtn.addEventListener('click', function(){
          window.location = "/board/modify?currPage=${param.currPage}&amount=${param.amount}&bno=${board.bno}";
        });//.addEventListener
    </script>
    </body>
    </html>