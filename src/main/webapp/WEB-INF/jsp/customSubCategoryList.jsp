<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>custom-sub-category-list</title>
</head>
<body>
<form:form cssClass="p-1 my-5 mx-5" cssStyle="width: 1200px" action="/subCategory/costomList" method="get">
    <table class="table table-bordered table-striped text-dark">
        <tr>
            <th>Sub category title</th>
            <th>Order</th>
        </tr>
        <c:forEach items="${customSubCategoryList}" var="subCategory">
            <tr>
                <td>${subCategory.title}</td>
                <td>
                    <a href="/orderForm?subCategoryTitle=${subCategory.title}" class="btn btn-info" role="button">Add</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form:form>
</body>
</html>
