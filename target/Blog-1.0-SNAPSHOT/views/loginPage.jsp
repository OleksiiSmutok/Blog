<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.04.2017
  Time: 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="/resources/css/loginStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class="login-form">

    <form action="/loginProcessing" method="post">

    <div class="input">
        <i class="fa fa-sign-in fa-2x icon"></i>
        <input class="input-group" type="text" name="username" placeholder="Login">
    </div>

    <div class="input">
        <i class="fa fa-lock fa-2x icon"></i>
        <input class="input-group" type="password" name="password" placeholder="Password">
    </div>

    <button class="logIn" type="submit">LogIn</button>

        <a href="/registration">
            <p class="registration-text">Registration</p></a>

    </form>
</div>

<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script src="/resources/js/login.js"></script>

</body>
</html>
