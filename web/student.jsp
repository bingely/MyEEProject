<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/7
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表达练习</title>
</head>
<body>
<form action="/MyJavaEEProject/servlet/RegistServlet" method="post">
    姓名：<input type="text" name="name"/><br/>
    密码：<input type="password" name="password"/> <br/>
    性别：<input type="radio" name="gender" value="1"/>男
    <input type="radio" name="gender" value="0"/>女 <br/>
    已婚：<input type="checkbox" name="married"/><br/>
    爱好：<input type="checkbox" name="hobby" value="EAT"/>吃饭
    <input type="checkbox" name="hobby" value="SLEEP"/>睡觉
    <input type="checkbox" name="hobby" value="LOOKFENG"/>看美女 <br/>
    故乡：<select name="address">
    <option value="BJ">北京</option>
    <option value="SD">山东</option>
    <option value="HB">湖北</option>
    </select> <br/>
    描述：<textarea rows="3" cols="38" name="description"></textarea>

</form>
</body>
</html>
