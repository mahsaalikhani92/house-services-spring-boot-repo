<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>client-signup</title>
</head>
<body>
<div class="container">
    <form:form cssClass="p-1 my-5 mx-5" action="/clientSignUp" method="post" modelAttribute="client">
        <p class="text-danger">${error}</p>
        <table class="table table-bordered table-striped text-dark">
            <tr>
                <td>
                    <form:label path="name">Name</form:label>
                </td>
                <td>
                    <form:input path="name" name="name"/>
                </td>
                <td>
                    <form:errors path="name" cssClass="text-danger"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="lastName">Last name</form:label>
                </td>
                <td>
                    <form:input path="lastName" name="lastName"/>
                </td>
                <td>
                    <form:errors path="lastName" cssClass="text-danger"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="email">Email</form:label>
                </td>
                <td>
                    <form:input path="email" name="email"/>
                </td>
                <td>
                    <form:errors path="email" cssClass="text-danger"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="password">Password</form:label>
                </td>
                <td>
                    <form:input path="password" name="password"/>
                </td>
                <td>
                    <form:errors path="password" cssClass="text-danger"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <form:button name="clientSignUp">Sign Up</form:button>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
