<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <title>category-list</title>
    <script>
        $(document).ready(function () {
            $("#categorySelect").click(function () {
                const category = $("#categorySelect").val();
                $.ajax({
                    type: "GET",
                    url: window.location.origin + "/subCategory/customList?categoryTitle=" + category,
                    success: function (data) {
                        var selectSubCat=$("#subCategorySelect"), option="";
                        selectSubCat.empty();
                        for(var i=0; i<data.length; i++){
                            option = option + "<option value='"+data[i].title + "'>"+data[i].title + "</option>";
                        }
                        selectSubCat.append(option);
                    },
                })
            });
        })
    </script>
    <script>
        $(document).ready(function () {
            $("#subCategorySelect").change(function () {
                const subCategory = $("#subCategorySelect").val();
                $.ajax({
                    type: "GET",
                    url: "/orderForm?subCategoryTitle=" + subCategory,
                    cache: false,
                    success() {
                        console.log("success")
                    }
                })
            });
        })
    </script>
</head>
<body>

<select id="categorySelect" name="categorySelect">
    <option value="-1">-category-</option>
    <c:forEach items="${categoryList}" var="category">
        <option value="${category.title}">${category.title}</option>
    </c:forEach>
</select>

<div id="sub">
    <p class="text-danger">${error}</p><br/><br/>
    <select id="subCategorySelect" name="subCategorySelect">
        <option value="-1">-sub category-</option>
    </select>
</div>
</body>
</html>
