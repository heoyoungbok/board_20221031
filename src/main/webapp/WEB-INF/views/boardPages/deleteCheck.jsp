
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-02
  Time: 오전 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>deleteCheck.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        #update-form {
            width: 800px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div class="container" id="delete-Check">
        <input type="text" id="boardPass" placeholder="비밀번호" class="form-control">
    <button class="btn btn-secondary" onclick="passCheck()">확인</button><%--id값이 반드시 있어야 함   hidden 노출하지 않고 값을 전송할 때  --%>

</div>
</body>
<script>
    const passCheck = () => {
        const passInput = document.getElementById("boardPass").value;
        const passDB = '${board.boardPass}';
        const id = '${board.id}';
        <%--'${board.boardPass}';--%>
        if(passInput == passDB){
           location.href = "/delete?id="+id; // 지우는 삭제문  만약 맞으면 삭제를 해라 명령문
        }else {
            alert("비밀번호가 일치하지 않습니다.");
        }


    }
</script>
</html>