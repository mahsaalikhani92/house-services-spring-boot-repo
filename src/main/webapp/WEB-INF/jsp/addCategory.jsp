<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>category</title>
  </head>
  <body>
  <form:form cssClass="p-1 my-5 mx-5" action="/categories/add" method="post" modelAttribute="category">
    <p class="text-danger">${error}</p>
    <table class="table table-bordered table-striped text-dark">
      <tr>
        <td>
          <form:label path="title">Category title</form:label>
        </td>
        <td>
          <form:input path="title" name="title"/>
        </td>
        <td>
          <form:errors path="title" cssClass="text-danger"/>
        </td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td>
          <form:button name="addCategory">Add Category</form:button>
        </td>
      </tr>
    </table>
  </form:form>

  <a href="/categories/list" class="btn btn-info" role="button">Show category list</a>
  </body>
</html>
