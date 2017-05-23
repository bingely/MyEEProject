<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.bingley.ee.domain.Book" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/21
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL1_获取数据</title>
</head>
<body>
    <h1>获取javabean的属性</h1>
    <hr>
    <%
        Book bookData = new Book();
        bookData.setName("芙蓉姐姐");
        bookData.setAuth("bingely");
        pageContext.setAttribute("book", bookData);
    %>
    ${book.name }
    ${book.age }

    <img src="${pageContext.request.contextPath }/1.png"/>

    <h1>获取Map中的数据</h1>
    <hr>
    <%
        Map<String, String> map = new HashMap();
        map.put("name", "奥巴马");
        map.put("age", "17");
        map.put("gender", "男");
        map.put("addr", "白宫");
        map.put("name.xiao", "小黑黑");
        pageContext.setAttribute("map", map);
        pageContext.setAttribute("name", "age");
    %>
    ${map["name"] }${map["addr"] }
    ${map.gender }${map.age }
    ${map["name.xiao"] }

    <h1>获取集合中的数据</h1>
    <hr>
    <%
        List<String> list = new ArrayList<String>();
        list.add("甄嬛");
        list.add("安玲荣");
        list.add("凤姐");
        pageContext.setAttribute("list", list);
    %>
    ${list[2] }

    <h1>获取数组数据</h1>
    <hr>
    <%
        String[] names = {"容嬷嬷", "紫薇", "金锁", "小燕子"};
        pageContext.setAttribute("names", names);
    %>
    ${names[2]}
    <h1>获取域中的变量数据</h1>
    <hr>
    <%
        String name = "灭绝师太";
        pageContext.setAttribute("name", name);
    %>
    ${name }
    <h1>获取常量数据</h1>
    <hr>
    ${"阿萨德发射点发" } ${199 } ${true }
</body>
</html>
