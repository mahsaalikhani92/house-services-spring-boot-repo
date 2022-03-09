<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>orders</title>
  </head>
  <body>
  <div class="container">
    <form:form cssClass="p-1 my-5 mx-5" action="/saveOrder" method="post" modelAttribute="order">
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
          <td>
            <form:label path="proposedDateToDo">Proposed date</form:label>
          </td>
          <td>
            <form:input path="proposedDateToDo" name="proposedDateToDo"/>
          </td>
          <td>
            <form:errors path="proposedDateToDo" cssClass="text-danger"/>
          </td>
        </tr>
        <tr>
          <td>
            <form:label path="address">Address</form:label>
          </td>
          <td>
            <form:input path="address" name="address"/>
          </td>
          <td>
            <form:errors path="address" cssClass="text-danger"/>
          </td>
        </tr>
        <tr>
          <td></td>
          <td>
            <form:button name="saveOrder">Save Order</form:button>
          </td>
        </tr>
      </table>
    </form:form>
    <div><p>Order tracking code: ${trackingCode}</p></div>
  </div>
  </body>
</html>
