<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>work-management</title>
</head>
<body>
<table class="table table-bordered table-striped text-dark">
    <tr>
        <th>Code</th>
        <th>Start</th>
        <th>Done</th>
    </tr>
    <c:forEach items="${ordersTrackingCodeList}" var="code">
        <tr>
            <td>${code}</td>
            <td><a href="/startOrder?trackingCode=${code}" class="btn btn-info" role="button">start</a></td>
            <td><a href="/doneOrder?trackingCode=${code}" class="btn btn-info" role="button" id="done">Done</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
