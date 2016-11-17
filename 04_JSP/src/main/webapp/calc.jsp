<%@ page import="calc.Calculator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Калькулятор</title>
</head>
<body>
<h1>Калькулятор</h1>

<%
    Calculator calc = new Calculator();
    calc.sum(1, 2);
%>

<form action="calc.jsp" method="post">
    <input type="text" value="${param["a"]}" name="a"/>
    +
    <input type="text" value="${param["b"]}" name="b"/>

    =
    ${param["a"] + param["b"]}
    <br>

    <input type="submit" value="Сложить!"/>
</form>

</body>
</html>
