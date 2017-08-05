<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21.05.2017
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registration</title>
    <link rel="stylesheet" href="/resources/css/registration.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></head>
<body>

<div class="registration-form">

    <form:form action="/processing/registration" method="post" modelAttribute="user">

        <form:errors cssClass="errors" path="firstName"/>
        <div class="input">
            <i class="fa fa-user fa-2x icon"></i>
            <form:input cssClass="input-group" path="firstName" placeholder="First Name"></form:input>
        </div>

        <form:errors cssClass="errors" path="secondName"/>
        <div class="input">
            <i class="fa fa-user-circle-o fa-2x icon"></i>
            <form:input cssClass="input-group" path="secondName" placeholder="Second Name"/>
        </div>

        <form:errors cssClass="errors" path="email"/>
        <div class="input">
            <i class="fa fa-envelope-o fa-2x icon"></i>
            <form:input cssClass="input-group" path="email" placeholder="gmail"/>
        </div>

        <form:errors cssClass="errors" path="phone"/>
        <div class="input">
            <i class="fa fa-mobile fa-2x icon"></i>
            <form:input cssClass="input-group" path="phone" placeholder="Phone"/>
        </div>

        <form:errors cssClass="errors" path="login"/>
        <div class="input">
            <i class="fa fa-sign-in fa-2x icon"></i>
            <form:input cssClass="input-group" path="login" placeholder="Login"/>
        </div>

        <form:errors cssClass="errors" path="password"/>
        <div class="input">
            <i class="fa fa-lock fa-2x icon"></i>
            <form:input cssClass="input-group" path="password" placeholder="Password"/>
        </div>

        <form:button class="button-submit">Submit</form:button>

    </form:form>

    <a href="/loginPage">
    <p class="login-text">Login</p></a>

</div>

</body>
</html>
