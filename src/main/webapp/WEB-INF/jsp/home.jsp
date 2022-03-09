<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <title>home</title>
</head>
<body style="align-items: center">
<div style="padding:5px; margin: 20px; align-items: center">
    <table>
        <tr>
            <td><h1>Welcome to Online House Services</h1></td>
        </tr>
        <%--<tr>
            <td>Are you admin?</td>
            <td><a href="/adminLogin" class="btn btn-info" role="button">Sign In</a></td>
        </tr>--%>
        <tr>
            <td>Sign In?</td>
            <td><a href="/showLogin" class="btn btn-info" role="button">Sign In</a></td>
        </tr>
        <tr>
            <td>New user?</td>
            <td></td>
        </tr>
        <tr>
            <td>Make an account</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <a href="/showClientForm" class="btn btn-info" role="button">Client</a>
                <a href="/showExpertForm" class="btn btn-info" role="button">Expert</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
