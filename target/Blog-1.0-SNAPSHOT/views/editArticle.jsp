<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03.05.2017
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
    <link href="/resources/css/homeStyle.css" rel="stylesheet">
    <link href="/resources/css/editStyle.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class="read-home-panel">
    <div><img class="avatar" src="/resources/img/${user.pathToPhoto}"></div>
    <p id="name">${user.firstName}<span>  </span> ${user.secondName}</p>
    <a href="/"><button class="home-button" id="home2">Home</button></a>
    <a href="/logout"><button class="home-button" id="logout2">Logout</button></a>
</div>


<form action="/edit/article/processing/${article.id}" method="post" enctype="multipart/form-data">

    <div class="edit-article">

        <div class="subject">
            <input value="${article.subject}" id="subject" name="subject" placeholder="Subject">
        </div>

            <textarea name="text" class="text" placeholder="Add text">${article.text}</textarea>

        <div>
            <input class="input-photo" value="${article.pathToPhoto}" type="file" name="photo">
        </div>

        <button class="button-add" type="submit">Edit</button>

    </div>
</form>

<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script src="/resources/js/home.js"></script>

</body>
</html>
