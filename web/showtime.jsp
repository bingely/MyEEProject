<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/20
  Time: 3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>jsp 入门</title>
    </head>
    <body>
    <%int num = 0; %>
        <font color="red">
            <%--嵌套Java代码--%>
            <%
                Date date = new Date();
                // out === response.getWriter() ，术语九大隐士对象之一，可以直接使用
                out.write(date.toLocaleString());
            %><br/>

            <%= new Date().toLocaleString() %> <br/>
        </font>

    <%
        for(int i=0;i<5;i++){
            num++;
    %>
    <font color="blue">
        <%
            out.write(num+"");
        %>
    </font>
    <%
        }
    %>
    </body>
</html>
