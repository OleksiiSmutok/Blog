<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15.05.2017
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
    <link rel="stylesheet" href="/resources/css/homeStyle.css">
    <link rel="stylesheet" href="/resources/css/editStyle.css">
    <link rel="stylesheet" href="/resources/css/readStyle.css">
</head>
<body>

<div class="home-panel">

    <div><img class="avatar" src="/resources/img/${user.pathToPhoto}"></div>

    <p id="name">${user.firstName}<span>  </span> ${user.secondName}</p>
    <a href="/"><button class="home-button" id="home">Home</button></a>
    <a href="/logout"><button class="home-button" id="logout">Logout</button></a>
</div>

<div class="user-edit-panel">
<form action="/edit/user/${user.id}" method="post" enctype="multipart/form-data">
<div class="edit-user">


    <input class="input-group" name="firstName" placeholder="First Name" type="text" value="${user.firstName}"/>

    <input class="input-group" name="secondName" placeholder="Second Name" type="text" value="${user.secondName}"/>

    <input class="input-group" name="email" placeholder="Email" type="text" value="${user.email}"/>

    <input class="input-group" name="phone" placeholder="Phone" type="text" value="${user.phone}"/>

    <input class="input-group" name="login" placeholder="Login" type="text" value="${user.login}"/>

    <input class="input-group" name="password" placeholder="Password" type="text" value="${user.password}"/>

    <input class="input-group" name="pathToPhoto" placeholder="Photo" type="file" value="${user.pathToPhoto}">

    <button type="submit" class="edit-user-button">Submit</button>

</div>
</form>
</div>

</body>
</html>
