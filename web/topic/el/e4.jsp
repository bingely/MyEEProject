<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/23
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="MyELFunc" uri="http://www.bingley.com/MyELFunc" %>
<%--也可以直接拷jar到lib下--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>自定义el标签调用Java方法</title>
</head>
<body>

   ${MyELFunc:URLEnc("北京", "utf-8")}

   ${fn:toUpperCase("helloj")}

</body>
</html>
