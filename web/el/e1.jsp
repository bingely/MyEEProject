<%@ page import="com.bingley.ee.domain.Book" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
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

    <img src="${pageContext.request.contextPath }/1.png"/>

    <h1>get map data</h1>
    <%
        Map<String, String> mapData = new LinkedHashMap<String, String>();
        mapData.put("name","奥巴马");
        mapData.put("age","17");
        mapData.put("gender","男");
        mapData.put("addr","白宫");
        mapData.put("name.xiao","小黑黑");
        pageContext.setAttribute("map", mapData);
    %>
    <%--使用中括号的地方都可以使用点号替代,除了中括号中是数字或者中括号中包含特殊字符( - . )的情况除外--%>
    ${map["name"]}
    ${map.gender}
    ${map["name.xiao"]}


    <h1>获取集合中的数据</h1><hr>
    <%
        List<String> list = new ArrayList<String>();
        list.add("甄嬛");
        list.add("安玲荣");
        list.add("凤姐");
        pageContext.setAttribute("list",list);
    %>
    ${list[2] }


    <h1>获取数组数据</h1><hr>
    <%
        String [] names = {"容嬷嬷","紫薇","金锁","小燕子"};
        pageContext.setAttribute("names",names);
    %>
    ${names[2]}


    <h1>获取域中的变量数据</h1><hr>
    <%
        String name = "灭绝师太";
        pageContext.setAttribute("name",name);
    %>
    ${name}

    <h1>获取常量数据</h1>
    <hr>
    ${"hello"} ${199 } ${true }
</body>
</html>
