<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-31
  Time: 오후 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boardDetail.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
   <div class="container">
       <table class="table table-striped">


           <tr>
           <tr>번호</tr>
           <td>${board.id}</td>
               <tr>작성자</tr>
           <td>${board.boardWriter}</td>
               <tr>글제목</tr>
           <td>${board.boardTitle}</td>
                <tr>글내용</tr>
            <td>${board.boardContents}</td>
                <tr>작성날짜</tr>
           <td>${board.boardDate}</td>
                 <tr>조회수</tr>
           <td>${board.boardHits}</td>

           </tr>
           <a href="/">index.jsp</a>
       </table>

   </div>
</body>
</html>
