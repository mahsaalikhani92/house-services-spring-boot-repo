<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>order-list</title>
</head>
<body>
<table class="table table-bordered table-striped text-dark">
    <tr>
        <th>Tracking code</th>
        <th>Proposed price</th>
        <th>Description</th>
        <th>Placing date</th>
        <th>Proposed date to do</th>
        <th>Address</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${orderList}" var="order">
        <tr>
            <td>${order.trackingCode}</td>
            <td>${order.proposedPrice}</td>
            <td>${order.description}</td>
            <td>${order.orderPlacingDate}</td>
            <td>${order.proposedDateToDo}</td>
            <td>${order.address}</td>
            <td>${order.orderStatus}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
