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
    <title>index.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="/resources/js/jquery.js"></script>
</head>
<body>
    <button class="btn-primary" onclick="boardSave()">게시판</button>
    <button class="btn-warning" onclick="boardList()">글목록</button>

</body>
<script>
    const boardSave = () => {
      location.href="/board/save";

    }

    const boardList = () => {
      location.href="/board/";
    }
</script>
</html>

<%-- 글작석 회원가입
  /boardSave       /memberSave
  /board/save       /member/save ---%>

