<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/16/2023
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="mailbox1" action="/update">
    <table class="table-view">
        <tr class="table-active">
            <td>Languages:</td>
            <td>
                <form:select path="language" itemValue="${mailbox1.language}">
                    <form:options items="${languages}" />
                </form:select>
            </td>
        </tr>
        <tr class="table-active">
            <td>Page Size:</td>
            <td>
                <form:select path="pageView" itemValue="${mailbox1.pageView}">
                    <form:options items="${pageSize}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Spams filter:</td>
            <td><form:checkbox path="spamFilter"></form:checkbox></td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td><form:textarea path="signature"></form:textarea></td>
        </tr>
        <tr>
            <td>
                <form:button>Submit</form:button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
