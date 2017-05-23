<%@ page import="com.bingley.ee.domain.Book" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.LinkedHashMap" %><%--
  Created by IntelliJ IDEA.
  User: SAM
  Date: 2017/5/23
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el</title>
</head>
<body>
    <h1>get javabean demo</h1>
    <%
        Book p = new Book();
        p.setName("芙蓉姐姐");
        p.setAuth("bingely");
        pageContext.setAttribute("p", p);
    %>
    ${p.auth} ${p.name} ${p.price}

    <h1>get map data</h1>
    <%
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name","奥巴马");
        map.put("age","17");
        map.put("gender","男");
        map.put("addr","白宫");
        map.put("name.xiao","小黑黑");
        pageContext.setAttribute("map", map);
    %>
    ${map.}
    <h1>get constant data</h1>
    <hr>
    ${"hello"} ${199 } ${true }
</body>
</html>
