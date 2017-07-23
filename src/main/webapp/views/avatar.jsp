<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21.05.2017
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/avatar.css">
</head>
<body>

<div class="avatar-form">
<form action="/add/avatar" method="post" enctype="multipart/form-data">
    <label class="label-add-photo" for="photo">Add photo</label>
    <input id="photo" class="input-photo" type="file" name="photo">
    <button type="submit" class="home-button">Submit</button>
</form>
</div>

</body>
</html>
