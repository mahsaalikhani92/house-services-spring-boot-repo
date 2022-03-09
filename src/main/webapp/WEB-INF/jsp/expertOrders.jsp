<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>expert-orders</title>
</head>
<body>
<table class="table table-bordered table-striped text-dark">
    <tr>
        <th>Sub category title</th>
        <th>Orders</th>
    </tr>
    <c:forEach items="${subCategoryOrderMap}" var="subOrderMap">
        <tr>
        <td>
                ${subOrderMap.key}
        </td>
        <td>
        <table>

        </table>
        <c:forEach items="${subOrderMap.value}" var="order">
            <tr>
                <td>Tracking code</td>
                <td>${order.trackingCode}</td>
            </tr>
            <tr>
                <td>Client proposed price</td>
                <td>${order.proposedPrice}</td>
            </tr>
            <tr>
                <td>Description</td>
                <td>${order.description}</td>
            </tr>
            <tr>
                <td>Proposed date to do</td>
                <td>${order.proposedDateToDo}</td>
            </tr>
            <tr>
                <td>Address</td>
                <td> ${order.address}</td>
            </tr>
            <tr>
                <td>Status</td>
                <td>${order.orderStatus}</td>
            </tr>
            <tr><a href="/saveOffer?trackingCode=${order.trackingCode}" class="btn btn-info" role="button">Add</a></tr>
        </c:forEach>
        </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
