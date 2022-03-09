<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
          crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
    <title>user-list</title>
    <script>
        jQuery(document).ready(function ($) {

            $("#search-form").submit(function (event) {
                console.log("submitted");
                enableSearchButton(false);
                event.preventDefault();
                searchViaAjax();
            });
        });

        function searchViaAjax() {
            var search = {}
            search["name"] = $("#name").val();
            search["lastName"] = $("#lastName").val();
            search["email"] = $("#email").val();
            search["rate"] = $("#rate").val();
            search["speciality"] = $("#speciality").val();
            search["role"] = $("#role").val();

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: window.location.origin + "/searchUsers",
                data: JSON.stringify(search),
                dataType: 'json',
                success: function (data) {
                    console.log("SUCCESS: ", data);
                    display(data);
                },
                error: function (e) {
                    console.log("ERROR: ", e);
                    display(e);
                },
                done: function (e) {
                    console.log("DONE");
                    enableSearchButton(true);
                }
            });
        }
        function enableSearchButton(flag) {
            $("#btn-search").prop("disabled", flag);
        }

        function display(data) {
            console.log(document.referrer)
            var tableHeaderRowCount = 2;
            var table = document.getElementById('userTbl');
            var rowCount = table.rows.length;
            for (var i = tableHeaderRowCount; i < rowCount; i++) {
                table.deleteRow(tableHeaderRowCount);
            }
            var trHTML = '';
            $.each(data, function (i, item) {
                console.log(item);
                trHTML += '<tr><td>' + item.name + '</td><td>' + item.lastName + '</td><td>' + item.email + '</td><td>' + item.rate + '</td><td>' + item.speciality + '</td><td>' + item.role + '</td></tr>';
            });
            $('#productTbl').append(trHTML);
        }
    </script>
</head>
<body>
<form id="search-form" class="m-5 p-5 text-center" style="width: 1200px">
    <table id="userTbl" class="table table-striped table-success table-hover">
        <tr>
            <td>
                <label for="name">Name</label><input id="name" name="name" placeHolder="Name"/>
            </td>
            <td>
                <label for="lastName">Last Name</label><input id="lastName" name="lastName" placeHolder="Last Name"/>
            </td>
            <td>
                <label for="email">Email</label><input id="email" name="email" placeHolder="Email"/>
            </td>
            <td>
                <label for="rate">Rate</label><input id="rate" name="rate" placeHolder="Rate"/>
            </td>
            <td>
                <label for="speciality">Speciality</label><input id="speciality" name="speciality" placeHolder="speciality"/>
            </td>
            <td>
                <label for="role">Role</label><input id="role" name="role" placeHolder="role"/>
            </td>
            <td>
                <button type="submit" id="bth-search">Search</button>
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
    </table>
</form>
</body>
</html>
