<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <title>client</title>
   <%-- <script>
        $("#creditBtn").change(function () {
            $.ajax({
                type: "GET",
                url: "/clientCredit",
                cache: false,
                success() {
                    console.log("success")
                }
            })
        });
    </script>--%>
</head>
<body>
<table class="table table-bordered table-striped text-dark">
    <tr>
        <a href="/categories/list" class="btn btn-info" role="button">Order</a><br/>
    </tr>
    <tr>
        <form action="/orderOffers" method="get">
            <label for="orderCode">Order tracking code</label>
            <input type="text" id="orderCode" name="orderCode"/>
            <input type="submit">
            <a href="/orderOffers" class="btn btn-info" role="button">Show offers</a><br/>
        </form>
    </tr>
    <tr>
       <%-- <input type="button" <c:if test="${ == }"><c:out value="enabled='enabled'"/></c:if>">--%>
    </tr>
    <tr>
        <a href="/clientOrderList" class="btn btn-info" role="button">Show orders history</a><br/>
    </tr>
    <%--<tr>
        <td>
            <form:button name="creditBtn" id="creditBtn">Your Credit</form:button>
        </td>
        <td><p>Your credit is ${credit}</p></td>
    </tr>--%>
</table>
</body>
</html>
