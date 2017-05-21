<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/20
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session 购物小demo</title>
</head>
<body>
    <%
        /*要进行url重写(解决禁用cookie），先获取session*/
        request.getSession();

        String url1 = request.getContextPath() + "/hellobuy?prod=电视机";
        url1 = response.encodeURL(url1);
        String url2 = request.getContextPath() + "/hellobuy?prod=冰箱";
        url2 = response.encodeURL(url2);
        String url3 = request.getContextPath() + "/helloPay";
        url3 = response.encodeURL(url3);
    %>

    <a href="<%=url1%>">电视机</a>
    <a href="<%=url2%>">冰箱</a>
    <a href="<%=url3%>">支付</a>
</body>
</html>
