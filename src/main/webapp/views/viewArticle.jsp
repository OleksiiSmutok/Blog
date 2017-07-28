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
</head>
<body>

<div class="home-panel">

    <a href="/avatar/page"><div>
        <img class="avatar" src="/resources/img/${user.pathToPhoto}">
    </div></a>

    <p id="name">${user.firstName}<span>  </span> ${user.secondName}</p>
    <button class="home-button" id="button-view-article">View Article</button>
    <button class="home-button" id="button-add-article">Add Article</button>
    <a href="/edit/user/page/${user.id}"><button class="home-button" id="button-edit-user">Edit User</button></a>
    <a href="/logout"><button class="home-button" id="logout">Logout</button></a>
</div>

</body>
</html>
