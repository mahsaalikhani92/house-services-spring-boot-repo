<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>order-offers</title>
</head>
<body>
<table class="table table-bordered table-striped text-dark">
    <tr>
        <th>Expert proposed price</th>
        <th>Work duration</th>
        <th>Start time</th>
        <th>Order tracking code</th>
        <th>Expert email</th>
    </tr>
    <c:forEach items="${orderOfferList}" var="offer">
        <tr>
            <td>${offer.proposedPrice}</td>
            <td>${offer.workDuration}</td>
            <td>${offer.startTime}</td>
            <td>${offer.order.trackingCode}</td>
            <td>${offer.expert.email}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
