<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.04.2017
  Time: 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
    <link href="/resources/css/homeStyle.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>


<div class="home-panel">

    <a href="/avatar/page"><div>
        <img class="avatar" src="/resources/img/${user.pathToPhoto}">
    </div></a>

    <p id="name">${user.firstName}<span>  </span> ${user.secondName}</p>
    <a href="/view/article"><button class="home-button" id="button-view-article">View Article</button></a>
    <button class="home-button" id="button-add-article">Add Article</button>
    <a href="/edit/user/page/${user.id}"><button class="home-button" id="button-edit-user">Edit User</button></a>
    <a href="/logout"><button class="home-button" id="logout">Logout</button></a>
</div>

<form action="/add/article" method="post" enctype="multipart/form-data">
<div class="article">
    <div class="subject">
        <input id="subject" name="subject" placeholder="Subject">
    </div>
    <div class="text">
        <textarea name="text" id="text" placeholder="Add text"></textarea>
    </div>
    <div>
        <input class="input-group" type="file" name="photo">
    </div>
    <button class="button-add" type="submit">Add</button>
</div>
</form>


<%--<c:forEach items="${articleList}" var="article" >--%>
<%--<div class="panel-view">--%>
    <%--<div id="view-name">${article.user.firstName} ${article.user.secondName}--%>
    <%--<p><a href="/read/article/${article.id}"><button class="home-button" >Read Article</button></a></div>--%>

    <%--<div id="view-subject">${article.subject}--%>
    <%--<p><a href="/edit/article/${article.id}"><button class="home-button">Edit-Article</button></a></p></div>--%>

    <%--<div id="view-date" >${article.date}--%>
    <%--<p><a href="/delete/${article.id}"><button class="home-button">Delete</button></a></p></div>--%>

    <%--<i class="fa fa-newspaper-o fa-3x" ></i>--%>
<%--</div>--%>
<%--</c:forEach>--%>

<%--<form enctype="multipart/form-data">--%>
<%--<script src="http://sikbox.com/magic.js?d=http://chernev.ru&r=3&s=grey" type="text/javascript"></script>--%>

<div class="news">

    <c:choose>
        <c:when test="${articleList.size()>=1}">
            <a href="/read/article/${articleList.get(0).id}">
                <div class="news1">${articleList.get(0).subject}
                    <div class="news-photo1"><img width="260" height="301" src="/resources/img/${articleList.get(0).pathToPhoto}"></div>
                </div>
            </a>
        </c:when>
            <c:otherwise>
                <div class="news1">
                    <div class="news-photo1"></div>
                </div>
            </c:otherwise>
    </c:choose>

            <c:choose>
            <c:when test="${articleList.size()>=2}">
                <a href="/read/article/${articleList.get(1).id}">
                    <div class="news2">${articleList.get(1).subject}
                        <div class="news-photo2"><img width="225" height="126" src="/resources/img/${articleList.get(1).pathToPhoto}"></div>
                    </div>
                </a>
            </c:when>
                <c:otherwise>
                    <div class="news2">
                        <div class="news-photo2"></div>
                    </div>
                </c:otherwise>
            </c:choose>


                <c:choose>
                <c:when test="${articleList.size()>=3}">
                    <a href="/read/article/${articleList.get(2).id}">
                        <div class="news3">${articleList.get(2).subject}
                            <div class="news-photo3"><img src="/resources/img/${articleList.get(2).pathToPhoto}" width="245" height="126"></div>
                        </div>
                    </a>
                </c:when>
                <c:otherwise>
                    <div class="news3">
                        <div class="news-photo3"></div>
                    </div>
                </c:otherwise>
                </c:choose>

                    <c:choose>
                    <c:when test="${articleList.size()>=4}">
                        <a href="/read/article/${articleList.get(3).id}">
                            <div class="news4">${articleList.get(3).subject}
                                <div class="news-photo4"><img src="/resources/img/${articleList.get(3).pathToPhoto}" width="475" height="210" ></div>
                            </div>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <div class="news4">
                            <div class="news-photo4"></div>
                        </div>
                    </c:otherwise>
                    </c:choose>


            <c:choose>
            <c:when test="${articleList.size()>=5}">
                <a href="/read/article/${articleList.get(4).id}">
                <div class="news5">${articleList.get(4).subject}
                    <div class="news-photo5"><img src="/resources/img/${articleList.get(4).pathToPhoto}" width="485" height="226"></div>
                </div>
                </a>
            </c:when>
            <c:otherwise>
                <div class="news5">
                    <div class="news-photo5"></div>
                </div>

                </c:otherwise>
            </c:choose>


            <c:choose>
            <c:when test="${articleList.size()>=6}">
                <a href="/read/article/${articleList.get(5).id}">
                    <div class="news6">${articleList.get(5).subject}
                        <div class="news-photo6"><img src="/resources/img/${articleList.get(5).pathToPhoto}" width="250" height="226"></div>
                    </div>
                </a>
                </c:when>
                <c:otherwise>
                    <div class="news6">
                        <div class="news-photo6"></div>
                    </div>
                </c:otherwise>
            </c:choose>

    <%--<a href="/read/article/${articleList.get(6).id}">--%>
    <%--<div class="news7">${articleList.get(6).subject}</div>--%>
    <%--</a>--%>

    <%--<a href="/read/article/${articleList.get(7).id}">--%>
    <%--<div class="news8">${articleList.get(7).subject}</div>--%>
    <%--</a>--%>

</div>
</form>

<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script src="/resources/js/home.js"></script>

</body>
</html>
