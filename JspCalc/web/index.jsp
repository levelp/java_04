<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Умножение чисел</title>
</head>
<body>
<form action="index.jsp">
    <label>Первое число:
        <input type="text" name="a" value="${param['a']}"/>
    </label>
    <br>
    <label>Второе число:
        <input type="text" name="b" value="${param['b']}"/>
    </label>
    <br>
    <input type="submit" value="Посчитай!"/>
    <br>
    ${param['a']} * ${param['b']} = ${param['a'] * param['b']}
</form>
</body>
</html>
