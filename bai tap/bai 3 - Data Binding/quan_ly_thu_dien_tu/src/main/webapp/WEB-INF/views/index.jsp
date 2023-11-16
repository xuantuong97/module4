<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Thông tin cấu hình</h1>
<table>
    <tr>
        <td>Languages: </td>
        <td>${mailbox.language}</td>
    </tr>
    <tr>
        <td>Page size: </td>
        <td>${mailbox.pageView}</td>
    </tr>
    <tr>
        <td>Spam filter: </td>
        <c:choose>
            <c:when test="${mailbox.spamFilter == true}">
                <td>Yes</td>
            </c:when>
            <c:otherwise>
                <td>No</td>
            </c:otherwise>
        </c:choose>
    </tr>
    <tr>
        <td>Signature: </td>
        <td>${mailbox.signature}</td>
    </tr>
</table>
<br>
<a href="/show_update"><button>Update</button></a>
</body>
</html>