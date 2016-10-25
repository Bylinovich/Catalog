<%--
  Created by IntelliJ IDEA.
  User: Влад
  Date: 23.10.2016
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@page import="models.Car"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="listResult" class="java.util.ArrayList" scope="request"/>

<form action = "save" method = "GET">
    <table border = "1">

        <tr>
            <td>Mark</td>
            <td><input type = text name = "carMark" value="${carMark}" size = "70"/></td>
        </tr>
        <tr>
            <td>Model</td>
            <td><input type = text name = "carModel" value="${carModel}" size = "70"/></td>
        </tr>
        <tr>
            <td>Year</td>
            <td><input type = text name = "year" value="${year}" size = "70"/></td>
        </tr>
        <tr>
            <td>Color</td>
            <td><input type = text name = "color" value="${color}" size = "70"/></td>
        </tr>

        <tr>
            <td><input type = "submit" name="${buttonName}" value = "${value}"/></td>
        </tr>
    </table>
</form>

</body>
</html>
