<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>online</title>
</head>
<body>
<form:form cssClass="p-1 my-5 mx-5" action="onlinePayment" method="post" modelAttribute="transaction">
    <table class="table table-bordered table-striped text-dark">
        <tr>
            <td></td>
            <td><div id="ten-countdown"></div></td>
        </tr>
        <tr>
            <td>
                <form:label path="orderCode">Order Code</form:label>
            </td>
            <td>
                <form:input path="orderCode" name="orderCode"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="amount">Amount</form:label>
            </td>
            <td>
                <form:input path="amount" name="amount"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="originCardNumber">Card Number</form:label>
            </td>
            <td>
                <form:input path="originCardNumber" name="originCardNumber"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="ccv2">ccv2</form:label>
            </td>
            <td>
                <form:input path="ccv2" name="ccv2"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="expireYear">Expire year</form:label>
            </td>
            <td>
                <form:input path="expireYear" name="expireYear"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="expireMonth">Expire month</form:label>
            </td>
            <td>
                <form:input path="expireMonth" name="expireMonth"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">Password</form:label>
            </td>
            <td>
                <form:input path="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button name="payment">Payment</form:button>
            </td>
        </tr>
    </table>
</form:form>

<script type="text/javascript" src="/static/js/timeOut.js"></script>
</body>
</html>
