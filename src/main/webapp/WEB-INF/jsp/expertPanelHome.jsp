<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>Title</title>
   <%-- <script>
        $("#creditBtn").change(function (){
            $.ajax({
                type:"GET",
                url:"/expertCredit",
                cache:false,
                success(){
                    console.log("success")
                }
            })
        });
    </script>--%>
</head>
<body>
<div>
    <a href="/expertOrders" class="btn btn-info" role="button">Offer</a>
    <a href="/expertOrderList" class="btn btn-info" role="button">Show orders history</a>
    <a href="/subCategory/addExpert" class="btn btn-info" role="button">Add new Expert to Sub Category</a>
    <a href="/waitingOrderList" class="btn btn-info" role="button">Get started</a>

    <%--<form:button name="creditBtn" id="creditBtn">Your Credit</form:button>
    <div>
        <p>Your credit is ${credit}</p>
    </div>--%>
</div>
</body>
</html>
