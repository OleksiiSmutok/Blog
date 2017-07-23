<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02.05.2017
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>article</title>
</head>
<body>
<head>
    <title>home</title>
    <link href="/resources/css/readStyle.css" rel="stylesheet">
    <link href="/resources/css/homeStyle.css" rel="stylesheet">
</head>
<body>

<div class="read-home-panel">
    <div><img class="avatar" src="/resources/img/${user.pathToPhoto}"></div>
    <p id="name">${user.firstName}<span>  </span> ${user.secondName}</p>
    <a href="/"><button class="home-button" id="home">Home</button></a>
    <a href="/logout"><button class="home-button" id="logout1">Logout</button></a>
</div>

<div class="view-article">
    <div class="sub">${article.subject}</div>
    <div class="view-text">${article.text}</div>
    <button class="home-button" id="comment-button">Read comment</button>
    <button class="home-button" id="add-comment">Add comment</button>
    <a href="/edit/article/${article.id}"><button class="home-button">Edit-Article</button></a>
</div>

<c:forEach items="${comments}" var="comment">
<div class="comment-panel">
    <div class="nothing"></div>
    <div class="comment">${comment.text}
        <div class="name-user">${comment.user.firstName} ${comment.user.secondName}</div>
        <div class="mark-in-comment">${comment.mark}</div>
    </div>
    <a href="/delete/comment/${comment.id}"><button class="read-comments">Delete</button></a>
</div>
</c:forEach>

<form action="/add/comment/${article.id}" method="post">
<div class="add-comment-panel">

    <div class="nothing"></div>

    <textarea class="add-comment" name="text"></textarea>

    <select name="mark" class="mark">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
    </select>

    <button class="button-add-comment" type="submit">Add comment</button>
</div>
</form>

<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script src="/resources/js/article.js"></script>
<script src="/resources/js/home.js"></script>

</body>
</body>
</html>
