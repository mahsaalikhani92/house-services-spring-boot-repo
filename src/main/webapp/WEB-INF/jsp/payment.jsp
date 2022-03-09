<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>payment</title>
</head>
<body>
<div>
    <a href="/showOnlinePaymentForm" class="btn btn-info" role="button">Online payment</a><br/>
    <a href="/creditPayment" class="btn btn-info" role="button">Credit payment</a><br/>
</div>
<div>
    <p>${message}</p>
</div>
<div>
    <c:if test=""
    <a href="/" class="btn btn-info" role="button">Add comment</a><br/>
</div>
</body>
</html>
