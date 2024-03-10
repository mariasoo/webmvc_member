<%--
  Created by IntelliJ IDEA.
  User: 723ma
  Date: 2024-03-09
  Time: 오후 6:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Member Form</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .form-container {
            width: 300px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-group {
            margin-bottom: 10px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-group button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: purple;
            color: white;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #5d005d;
        }
        .form-group .reset-btn {
            background-color: #ccc;
            color: black;
        }
        .form-group .reset-btn:hover {
            background-color: #a3a3a3;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>회원 가입</h2>
    <form action="/member/addMember.do" method="post">
        <div class="form-group">
            <label for="id">아이디</label>
            <input type="text" id="id" name="id" required>
        </div>
        <div class="form-group">
            <label for="pw">비밀번호</label>
            <input type="password" id="pw" name="pw" required>
        </div>
        <div class="form-group">
            <label for="name">이름</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="email">이메일</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <button type="submit">가입하기</button>
            <button type="reset" class="reset-btn">다시 입력</button>
        </div>
    </form>
</div>
</body>
</html>
