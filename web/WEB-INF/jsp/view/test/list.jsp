<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 12/08/2016
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>

    <h1><spring:message code="user.list.title.header" /></h1>
    <a href="?language=en_US">English </a><span> - </span><a href="?language=es_MX">Español </a>
    <div class="row s12">
        <c:forEach items="${list}" var="userDto">
            <div class="col s3 m3">
                <div class="card blue-grey darken-1">
                    <div class="card-content white-text">
                        <span class="card-title">${userDto.name}</span>
                        <label>${userDto.surname}</label>
                        <label>${userDto.email}</label>
                    </div>
                    <div class="card-action">
                        <a href="/view/${userDto.id}"><spring:message code="user.list.link.foot.card.view" /> </a>
                        <a href="/update/${userDto.id}"><spring:message code="user.list.link.foot.card.update" /></a>
                        <a href="/remove/${userDto.id}"><spring:message code="user.list.link.foot.card.delete" /></a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>

</body>
</html>
