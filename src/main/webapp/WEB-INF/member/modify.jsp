<%--
  Created by IntelliJ IDEA.
  User: 723ma
  Date: 2024-03-09
  Time: 오후 6:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Modify Member</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            color: #666;
            margin-bottom: 5px;
        }
        .form-group input[type="text"],
        .form-group input[type="date"],
        .form-group input[type="email"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .form-group input[type="text"][readonly] {
            background-color: #e9ecef;
        }
        .btn-submit {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-submit:hover {
            background-color: #0056b3;
        }
        .link {
            display: inline-block;
            margin-top: 20px;
        }
        .link a {
            color: #007bff;
            text-decoration: none;
        }
        .link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="/member/modifyMember.do" method="post">
        <h2>회원 정보 수정</h2>
        <div class="form-group">
            <label for="id">아이디</label>
            <input type="text" id="id" name="id" value="${dto.id}" readonly>
        </div>
        <div class="form-group">
            <label for="pw">비밀번호</label>
            <input type="text" id="pw" name="pw" value="${dto.pw}">
        </div>
        <div class="form-group">
            <label for="name">이름</label>
            <input type="text" id="name" name="name" value="${dto.name}">
        </div>
        <div class="form-group">
            <label for="email">이메일</label>
            <input type="email" id="email" name="email" value="${dto.email}">
        </div>
        <div class="form-group">
            <label for="date">가입일</label>
            <input type="date" id="date" name="date" value="${dto.date}">
        </div>
        <button type="submit" class="btn-submit">수정하기</button>
    </form>
    <div class="link">
        <a href="/member/addMember.do">회원 가입하기</a>
    </div>
</div>
</body>
</html>

