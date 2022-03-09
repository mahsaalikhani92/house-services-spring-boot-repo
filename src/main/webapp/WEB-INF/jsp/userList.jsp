<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
          crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>user-list</title>
</head>
<body>
<c:if test="${sessionScope.admin.username ne null}">
    <p class="p-5">${sessionScope.admin.username}</p>
</c:if>

<form:form cssClass="p-1 my-5 mx-5" cssStyle="width: 1200px" modelAttribute="userDto" action="/users/search" method="post">
    <table class="table table-bordered table-striped text-dark">
        <tr>
            <td>
                <form:input path="name" name="name" placeHolder="Name"/>
            </td>
            <td>
                <form:input path="lastName" name="lastName" placeHolder="Last name"/>
            </td>
            <td>
                <form:input path="email" name="email" placeHolder="Email"/>
            </td>
            <td>
                <form:input path="rate" name="rate" placeHolder="Rate"/>
            </td>
            <td>
                <form:input path="speciality" name="speciality" placeHolder="Speciality"/>
            </td>
            <td>
                <form:input path="role" name="role" placeHolder="Role"/>
            </td>
            <td>
                <form:button name="search">Search</form:button>
            </td>
        </tr>
        <tr>
            <th>Name</th>
            <th>Last name</th>
            <th>Email</th>
            <th>Rate</th>
            <th>Speciality</th>
            <th>Role</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.meanRate}</td>
                <td>${user.speciality}</td>
                <td>${user.role}</td>
            </tr>
        </c:forEach>
    </table>
</form:form>

</body>
</html>
