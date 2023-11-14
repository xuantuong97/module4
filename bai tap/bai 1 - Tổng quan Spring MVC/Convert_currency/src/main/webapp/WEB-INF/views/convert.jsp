<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/14/2023
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td><lable>Nhập: </lable></td>
            <td><input name="input" type="number" step = "0.01"></td>
            <td><button>Chuyển đổi</button></td>
        </tr>
    </table>
</form>
<p>  Kết quả: ${result}</p>
</body>
</html>
