<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/condiment" method="get">
<table>
    <tr>
        <td><input type="checkbox" name="condiment" value="Lettuce">Lettuce</td>
        <td><input type="checkbox" name="condiment" value="Tomato">Tomato</td>
        <td><input type="checkbox" name="condiment" value="Mustard">Mustard</td>
        <td><input type="checkbox" name="condiment" value="Sprouts">Sprouts</td>
    </tr>
    <tr><input type="submit"></tr>
</table>
</form>
</body>
</html>