Tomcat
======

* Скачать: http://tomcat.apache.org/
* Распаковать в папку
* Запуск: **catalina.bat run**

Tomcat - web-сервер.

``` jsp
<p>
    2 * 2 = <%= 2 * 2%>
</p>

<% for (int i = 1; i < 20; i++) { %>
<%=i%><sup>2</sup>=<%=i * i%>  &nbsp;
<% } %>
<br>
```

``` java
    out.write("<p>\r\n");
      out.write("    2 * 2 = ");
      out.print( 2 * 2);
      out.write("\r\n");
      out.write("</p>\r\n");
      out.write("\r\n");
 for (int i = 1; i < 20; i++) {
      out.write('\r');
      out.write('\n');
      out.print(i);
      out.write("<sup>2</sup>=");
      out.print(i * i);
      out.write("  &nbsp;\r\n");
 }
      out.write("\r\n");
      out.write("<br>\r\n");
```
