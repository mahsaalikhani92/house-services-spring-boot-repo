<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>Logged-In</title>
</head>
<%

%>
<body>
<div>
    <h1>You are successfully Logged in</h1>
</div>
    <div>
        <c:if test="">

        </c:if>
        <a href="<c:url value="/showClientPage"/>" class="btn btn-info" role="button">Client panel</a>
        <a href="<c:url value="/showExpertPage"/>" class="btn btn-info" role="button">Expert panel</a>
    </div>
</body>
</html>
