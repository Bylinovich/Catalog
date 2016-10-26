<%--
  Created by IntelliJ IDEA.
  User: Влад
  Date: 21.10.2016
  Time: 18:23
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
    <c:if test="${user.getPrivilegeLevel()==4}">
        <a href = "signIn.jsp">Sign In</a>
        <a href = "signUp.jsp">Sign Up</a>
    </c:if>
    <c:if test="${user.getPrivilegeLevel()<=3}">
        <a href = "signOut">Sign Out</a>
    </c:if>
    <jsp:useBean id="listResult" class="java.util.ArrayList" scope="request"/>
    <jsp:useBean id="user" class="models.User" scope="session"/>
    <h3>Hello, ${user.getLogin()}</h3>
    <table border="1">
        <tr>
            <th>Марка</th>
            <th>Модель</th>
            <th>Год выпуска</th>
            <th>Цвет</th>
        </tr>

        <c:forEach items="${listResult}" var="cell">
            <tr>
                <td>${cell.getCarMark()}</td>
                <td>${cell.getCarModel()}</td>
                <td>${cell.getYear()}</td>
                <td>${cell.getColor()}</td>
                <c:if test="${user.getPrivilegeLevel()<=0}">
                    <td><a href="edit?id=${cell.getId()}">edit</a></td>
                    <td><a href="delete?id=${cell.getId()}">delete</a></td>
                </c:if>
            </tr>
        </c:forEach>
        <c:if test="${user.getPrivilegeLevel()<=3}">
            <tr>
                <td>
                <a href="addNew">Add new</a>
                </td>
            </tr>
        </c:if>
    </table>
</body>
</html>
