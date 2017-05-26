<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<%
  		pageContext.setAttribute("name","蓝精灵");
  		request.setAttribute("name","伏地魔");
  		session.setAttribute("name","机器猫");
  		application.setAttribute("name","蜡笔小新");
  	 %>
  	 <c:remove var="name"/>
	${name }
  </body>
</html>
