<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.07.2017
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
    <link rel="stylesheet" href="/resources/css/homeStyle.css">
    <link rel="stylesheet" href="/resources/css/viewArticle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class="home-panel">

    <a href="/avatar/page"><div>
        <img class="avatar" src="/resources/img/${user.pathToPhoto}">
    </div></a>

    <p id="name">${user.firstName}<span>  </span> ${user.secondName}</p>
    <a href="/"><button class="home-button-a">Home</button></a>
    <a href="/logout"><button class="home-button" id="logout">Logout</button></a>
</div>

<c:forEach items="${articleList}" var="article" >
    <div class="panel-view">
        <div id="view-name">${article.user.firstName} ${article.user.secondName}
            <p><a href="/read/article/${article.id}"><button class="home-button" >Read Article</button></a></p></div>

        <div id="view-subject">${article.subject}
            <p><a href="/edit/article/${article.id}"><button class="home-button">Edit-Article</button></a></p></div>

        <div id="view-date" >${article.date}
            <p><a href="/delete/${article.id}"><button class="home-button">Delete</button></a></p></div>

        <i class="fa fa-newspaper-o fa-3x" ></i>
    </div>
</c:forEach>

<script src="/resources/js/jquery-3.2.1.min.js"></script>

</body>
</html>
