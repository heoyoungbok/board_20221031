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
    <title>boardSave.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="/resources/js/jquery.js"></script>
</head>
<body>
   <div class="container">
       <form action="/board/save" method="post" name="boardForm">
           <input type="text" name="boardWriter" placeholder="작성자" class="form-control">
           <input type="text" name="boardPass" placeholder="글비밀번호" class="form-control">
           <input type="text" name="boardTitle" placeholder="제목" class="form-control">
           <input type="text" name="boardContents" placeholder="글내용" class="form-control">

           <input type="submit" class="btn btn-primary" value="글쓰기" >
       </form>

   </div>
</body>
 <script>

 </script>
</html>
