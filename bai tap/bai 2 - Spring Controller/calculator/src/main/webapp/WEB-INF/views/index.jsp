<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/calculator">
    <table>
        <tr>
            <td><input name="num1" type="number" step="0.01" value="${num1}"></td>
            <td><input name="num2" type="number" step="0.01" value="${num2}"></td>
        </tr>
        <tr>
            <td><button name="cal" value="plus" type="submit">Addition(+)</button></td>
            <td><button name="cal" value="sub" type="submit">Sub(-)</button></td>
            <td><button name="cal" value="mul" type="submit">Multi(x)</button></td>
            <td><button name="cal" value="abs" type="submit">Division(/)</button></td>
        </tr>
        <tr>
            <td>Result: ${result}</td>
        </tr>
    </table>
</form>
</body>
</html>