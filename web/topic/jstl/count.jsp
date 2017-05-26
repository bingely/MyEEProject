<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/23
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>cout 的使用</title>
</head>
<body>
    <h1>HTML转义输出</h1>
    <a href="#">xxx</a>
    <c:out value="<a href='#'>xxxx</a"></c:out>

    ${fn:escapeXml('<a href="#">xxx</a>')}

    <h1>输出默认值</h1>
    <%
        String addr = "希尔qi";
        pageContext.setAttribute("addd", addr);
    %>
    <c:out value="${addd}" default="bb"></c:out>
    ${addd == null?"ff":addd}


    <h1>输出变量</h1><hr>
    <%
        String name = "无双";
        pageContext.setAttribute("name",name);
    %>
    <c:out value="${name}"></c:out>
    ${name }
    <h1>输出常量</h1><hr>
    <c:out value="阿斯蒂芬"></c:out>
    ${"啦啦啦啦" }

</body>
</html>
