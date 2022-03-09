<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>offer</title>
</head>
<body>
<div class="container">
    <form:form cssClass="p-1 my-5 mx-5" action="/saveOffer" method="post" modelAttribute="offer">
        <p class="text-danger">${error}</p>
        <table class="table table-bordered table-striped text-dark">
            <tr>
                <td>
                    <form:label path="proposedPrice">Proposed price</form:label>
                </td>
                <td>
                    <form:input path="proposedPrice" name="proposedPrice"/>
                </td>
                <td>
                    <form:errors path="proposedPrice" cssClass="text-danger"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="workDuration">Description</form:label>
                </td>
                <td>
                    <form:input path="workDuration" name="workDuration"/>
                </td>
                <td>
                    <form:errors path="workDuration" cssClass="text-danger"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="startTime">Proposed date</form:label>
                </td>
                <td>
                    <form:input path="startTime" name="startTime"/>
                </td>
                <td>
                    <form:errors path="startTime" cssClass="text-danger"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <form:button name="saveOffer">Save Offer</form:button>
                </td>
            </tr>
            <tr><p>offer for order with ${orderTrCode} saved successfully</p></tr>
        </table>
    </form:form>
</div>
</body>
</html>
