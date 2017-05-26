<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/21
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>执行运算_获取常用开发对象</title>
</head>
<body>
    <h1>empty 运算符 : 判断一个对象是否为null或字符串是否为空字符串或集合内容是否为空或域中是否没有任何属性</h1><hr>
    <%
        String str = "aaaa";
        pageContext.setAttribute("str",str);
        List list = new ArrayList();
        list.add("");
        pageContext.setAttribute("list",list);
    %>
    ${empty str }
    ${empty list}
    ${empty pageScope }


    <h1>三元运算</h1><hr>
    ${10>9? "yes" : "no" }

    <h1>逻辑运算</h1><hr>
    && and
    ||  or
    !   not

    ${not (3>2 and 1<2 or 10>3) }


    <h1>比较运算</h1><hr>
    > gt
    < lt
    >= ge
    <= le
    != ne
    ==eq
    ${1 eq 1 } ${3 ge 2 } ${5+3 lt 3 }
    <h1>算术运算:如果有非数字参与算数运算,el表达式会试图将非数字转换为数字后参与运算</h1><hr>
    ${1+1 }
    ${1-2 }
    ${1+"2" }

</body>
</html>
