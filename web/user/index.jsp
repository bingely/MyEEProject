<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  </head>
  <body>
	<h1>我的网站</h1><hr>
	<c:if test="${sessionScope.user==null}">
		欢迎光临!游客!
		<a href="${pageContext.request.contextPath }/user/regist.jsp">注册</a>
		<a href="${pageContext.request.contextPath }/user/login.jsp">登录</a>
	</c:if>
	<c:if test="${sessionScope.user!=null}">
		欢迎回来!${sessionScope.user.username }!
		<a href="${pageContext.request.contextPath }/HelloLogout">注销</a>
	</c:if>
  </body>
</html>
