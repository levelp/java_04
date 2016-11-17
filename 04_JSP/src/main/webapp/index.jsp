<%--
  Комментарии
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <title></title>
</head>
<body>

<h1>Наше первое web-приложение</h1>

<p>
    2 * 2 = <%= 2 * 2%>
</p>

<% for (int i = 1; i < 20; i++) { %>
<%=i%><sup>2</sup>=<%=i * i%>  &nbsp;
<% } %>
<br>


<select>
    <%
        PrintWriter writer = new PrintWriter(out);
        String[] strings = new String[]{"aaa", "bbb", "ccc", "ddd"};

        for (int i = 0; i < strings.length; i++) {
            writer.printf("<option value='%d'>%s</option>", i, strings[i]);
        }
    %>
</select>
</body>
</html>
