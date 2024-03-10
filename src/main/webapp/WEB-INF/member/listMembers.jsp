<%--
  Created by IntelliJ IDEA.
  User: 723ma
  Date: 2024-03-08
  Time: 오후 5:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List Members</title>
    <style>
        .centered {
            text-align: center;
            margin: auto;
        }
        .button-style {
            display: inline-block;
            padding: 10px 20px;
            text-decoration: none;
            color: white;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        table {
            margin-top: 20px;
            width: 100%;
        }
    </style>
</head>
<body>
<div class="centered">
<h2>회원정보</h2>
<table border ="1">
    <tr>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>이메일</th>
        <th>가입일</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
    <c:forEach items="${dtoList}" var="dto">
        <tr>
            <td><c:out value="${dto.id}" /></td>
            <td><c:out value="${dto.pw}" /></td>
            <td><c:out value="${dto.name}" /></td>
            <td><c:out value="${dto.email}" /></td>
            <td><c:out value="${dto.date}" /></td>
            <td>
                <a href="/member/modifyMember.do?id=${dto.id}" class="action-link">수정</a>
            </td>
            <td>
                <a href="/member/deleteMember.do?id=${dto.id}" class="action-link delete">삭제</a>
            </td>
        </tr>
    </c:forEach>
</table>
<span><a href="/member/addMember.do" class="button-style">회원 가입하기</a></span>
</div>
</body>
</html>
