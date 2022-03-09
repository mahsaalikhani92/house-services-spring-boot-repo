<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>rate</title>
</head>
<body>
<div class="container">
    <form:form cssClass="p-1 my-5 mx-5" action="/addComment" method="post" modelAttribute="comment">
        <table class="table table-bordered table-striped text-dark">
            <tr>
                <td>
                    <form:label path="rate">Rate</form:label>
                </td>
                <td>
                    <form:input path="rate" name="rate"/>
                </td>
                <td>
                    <form:errors path="rate" cssClass="text-danger"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="comment">Comment</form:label>
                </td>
                <td>
                    <form:input path="comment" name="comment"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <form:button name="saveRate">Save rate</form:button>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
