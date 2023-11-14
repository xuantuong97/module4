<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/14/2023
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary" method="post">
    <table>
        <tr>
            <td>Nhập từ tiếng Anh cần tra cứu</td>
        </tr>
        <tr>
            <td><input name="input" type="text"></td>
            <td><button>Tra cứu</button></td>
        </tr>
    </table>
    <p>Kết quả: ${result}</p>
</form>
</body>
</html>
