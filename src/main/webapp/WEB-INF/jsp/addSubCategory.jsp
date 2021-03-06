<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>sub-category</title>
</head>
<body>
<form:form cssClass="p-1 my-5 mx-5" action="/subCategory/add" method="post" modelAttribute="subCategory">
    <p class="text-danger">${error}</p>
    <table class="table table-bordered table-striped text-dark">
        <tr>
            <td>
                <form:label path="title">Sub Category title</form:label>
            </td>
            <td>
                <form:input path="title" name="title"/>
            </td>
            <td>
                <form:errors path="title" cssClass="text-danger"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="basePrice">Base price</form:label>
            </td>
            <td>
                <form:input path="basePrice" name="basePrice"/>
            </td>
            <td>
                <form:errors path="basePrice" cssClass="text-danger"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="description">Description</form:label>
            </td>
            <td>
                <form:input path="description" name="description"/>
            </td>
            <td>
                <form:errors path="description" cssClass="text-danger"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td>
                <form:button name="addSubCategory">Add Sub Category</form:button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
