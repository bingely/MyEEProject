<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<h1>HTML转义输出</h1><hr>
  	<a href="#">xxx</a>
  	<c:out value="<a href='#'>xxx</a>" ></c:out>
  	${fn:escapeXml('<a href="#">xxx</a>') }
  	
  	<h1>输出默认值</h1><hr>
  	<%
  		String addr = "西二旗";
  		//pageContext.setAttribute("addr",addr);
  	 %>
	<c:out value="${addr}" default="北京"></c:out>
	${addr == null?"北京" : addr }
	
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
