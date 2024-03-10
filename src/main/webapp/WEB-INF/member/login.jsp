<%--
  Created by IntelliJ IDEA.
  User: 723ma
  Date: 2024-03-09
  Time: 오후 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        form {
            background-color: #fff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            width: 300px;
        }
        h1 {
            font-size: 24px;
            color: #333;
            margin-bottom: 24px;
        }
        label {
            display: block;
            margin-bottom: 15px;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .error-message {
            color: red;
            margin-bottom: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<c:if test="${param.result == 'error'}">
    <span style="color:red"><h1>로그인 에러입니다. 다시 시도해주세요.</h1></span>
</c:if>
<form action="/login" method="post">
    <label>아이디
        <input type="text" name="id">
    </label>
    <label>비밀번호
        <input type="text" name="pw">
    </label>
    <button type="submit">LOGIN</button>
</form>
</body>
</html>