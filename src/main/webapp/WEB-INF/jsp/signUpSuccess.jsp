<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>success-registration</title>
</head>
<body>
<div class="container text-center">
    <h3>You have signed up successfully!</h3>
    <p>Please check your email to verify your account.</p>
    <h4><a href="/signIn">Click here to Sign In</a></h4>
</div>
</body>
</html>
