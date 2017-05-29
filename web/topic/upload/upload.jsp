<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/28
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h1>文件上传</h1>
    <form action="${pageContext.request.contextPath}/UploadServlet" method="POST" enctype="multipart/form-data">
    信息1 <input type="text" name="decrip1"/> <br>
    信息2 <input type="text" name="decrip2"/> <br>
    <input type="file" name="fileupload">
    <input type="submit" value="上传">
    </form>
</body>
</html>
