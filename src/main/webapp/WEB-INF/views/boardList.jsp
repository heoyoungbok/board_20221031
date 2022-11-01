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
    <title>boardList.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="/resources/js/jquery.js"></script>

</head>
<body>
<div class="container">
    <table class="table table-striped table-hover">
        <tr>
            <th>글번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>글내용</th>
            <th>조회</th>
            <th>조회수</th>
            <th>날짜</th>
            <th>삭제</th>
            <th>수정</th>
        </tr>
  <c:forEach items="${boardList}" var="board">
      <tr>
      <td>${board.id}</td>

      <td>${board.boardWriter}</td>
      <td>${board.boardTitle}</td>
          <td>${board.boardContents}</td>
          <td> <a href="/board?id=${board.id}">조회</a></td>
          <td>${board.boardHits}</td>
      <td>${board.boardDate}</td>


          
          <td>

<%--      <button class="btn btn-primary" onclick="findBoard('${board.id}')">조회</button>--%>
          </td>
      </tr>
  </c:forEach>
    </table>
<%--    <div id="check-zone">--%>

<%--    </div>--%>
</div>
</body>
<script>
//  const findBoard = (findId) => {
// console.log("findId",findId);
//     const checkZone = document.getElementById("check-zone");
//     $.ajax({
//         type:"get",
//         url:"/board",
//         data:{id: findId},
//         dataType:"json",
//         success:function (board){
//             console.log("조회결과",board);
//             console.log("조회id",board.id);
//             let result =
//                 "        <table class=\"table table-striped\">\n" +
//                 "            <tr>\n" +
//                 "                <th>id</th>\n" +
//                 "                <td>"+ board.id +"</td>\n" +
//                 "            </tr>\n" +
//                 "            <tr>\n" +
//                 "                <th>작성자</th>\n" +
//                 "                <td>" + board.boardWriter +"</td>\n" +
//                 "            </tr>\n" +
//                 "            <tr>\n" +
//                 "                <th>글제목</th>\n" +
//                 "                <td>" + board.boardTitle +"</td>\n" +
//                 "            </tr>\n" +
//                 "            <tr>\n" +
//                 "                <th>글내용</th>\n" +
//                 "                <td> " + board.boardContents + "</td>\n" +
//                 "            </tr>\n" +
//                 "            <tr>\n" +
//                 "                <th>작성날짜</th>\n" +
//                 "                <td>" + board.boardDate + "</td>\n" +
//                 "            </tr>\n" +
//                 "                <th>조회수</th>\n" +
//                 "                <td>" + board.boardHits + "</td>\n" +
//                 "            </tr>\n" +
//                 "        </table>";
//             checkZone.innerHTML = result;
//         },
//         error:function (){
//
//         }
//     });
     

</script>
</html>
