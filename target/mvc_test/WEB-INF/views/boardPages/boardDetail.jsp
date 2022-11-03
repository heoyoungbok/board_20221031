<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-31
  Time: 오후 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>boardDetail.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="/resources/js/jquery.js"></script>

<head>
    <style>
        #detail{
            width: 800px;
            margin-top: 50px;
        }
        #comment-write{
            width:  600px;
            
        }
    </style>
</head>
<body>
   <div class="container" id="detail">
       <table class="table table-hover">


           <tr>
           <th>번호</th>
           <td>${board.id}</td>
               </tr>
           <tr>
               <th>작성자</th>
               <td>${board.boardWriter}</td>
           </tr>
        <tr>
<%--            <th>작성날짜</th>--%>
<%--            <td>${board.boardDate}</td>--%>

        </tr>
           <tr>
               <th>조회수</th>
               <td>${board.boardHits}</td>

           </tr>
           <tr>
               <th>글제목</th>
               <td>${board.boardTitle}</td>
           </tr>
           <tr>
               <th>글내용</th>
               <td>${board.boardContents}</td>
           </tr>

           <tr>
              <c:if test="${board.storedFileName != null}" >


             <th>file</th>
           <td>
               <img src="${pageContext.request.contextPath}/upload/${board.storedFileName}"
                    alt="" width="100" height="100">
           </td>
           </tr>
           </c:if>
       </table>

      <button class="btn btn-primary" onclick="listFn()">목록</button>
       <button class="btn btn-warning" onclick="updateFn()">수정</button>
       <button class="btn btn-danger" onclick="deleteFn()">삭제</button>
   </div>
   <div class="container mt-5">    
       <div id="comment-write" class="input-group mb-3">
           <input type="text" id="commentWhite" name="commentWhite" class="form-control" placeholder="작성자">
         <label for="commentWhite">작성</label>
       </div>
       <div class="form-floating">
               <input type="text" id="commentContents" name="commentContents" class="form-control" placeholder="내용">
               <label for="commentContents">내용</label>
           </div>
       <button id="comment-write-btn" class="btn btn-secondary" onclick="commentWrite()">댓글작성</button>
       </div>
</body>
<script>
    const listFn = () => {
        const page ='${page}';
      location.href="/board/paging?page="+page; //페이지 값을 넘겨준다 (페이지 목록을 그대로 돌아오는 값)
    }
    const updateFn = () => {
         // 글번호 작성자      제목과 글내용만 수정가능하게끔
        const id= '${board.id}';
        location.href="/board/update?id="+id;   // 어떤 글에 대한 넘어줘야하는게 있어야 한다
    }
    const deleteFn = () => {

        const id ='${board.id}';
      location.href="/board/delete?id="+id;
    }
    
    const commentWrite = () => {

        const commentCk = document.getElementById("commentWhite,commentContents");
        const commentArea = document.getElementById("comment-write-btn");


        $.ajax({
            type:"post",
            url:"/comment/save",
            data:{id:commentCk},
            dataType:"text",
            success:function (result){
                console.log("checkResult",result);
                commentArea.innerText = result;
            },
         error:function (){
           console.log("실패");
         }
        });


    }
    
    
</script>

</html>
