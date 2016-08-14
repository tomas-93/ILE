<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 13/08/2016
  Time: 09:38 PM
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

<h1><spring:message code="user.form.title.header"/></h1>
<a href="?language=en_US">English </a><span> - </span><a href="?language=es_MX">Español </a>

<form:form action="/update" method="post" modelAttribute="userDto" cssclass="row">

    <div class="input-field col s12">
        <form:input path="name" id="first_name" type="text" class="validate"/>
        <form:label path="name" class="active" for="first_name"><spring:message code="user.form.name"/></form:label>
        <form:label path="name" cssClass="">
            <form:errors path="name" cssClass=""/>
        </form:label>
    </div>
    <div class="input-field col s12">
        <form:input path="surname" id="surname" type="text" class="validate"/>
        <form:label path="surname" class="active" for="surname"><spring:message code="user.form.surname"/></form:label>
        <form:label path="surname" cssClass="">
            <form:errors path="surname" cssClass=""/>
        </form:label>
    </div>
    <div class="input-field col s12">
        <form:input path="email" id="email" type="email" class="validate"/>
        <form:label path="email" class="active" for="email"><spring:message code="user.form.email"/> </form:label>
        <form:label path="email" cssClass="">
            <form:errors path="email" cssClass=""/>
        </form:label>
    </div>
    <button class="btn waves-effect waves-light" type="submit" name="action">Submit
        <i class="material-icons right">send</i>
    </button>
</form:form>

<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>

</body>
</html>