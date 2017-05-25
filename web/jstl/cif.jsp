<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<c:if test="${2>1}">
  		确实是这样的....
  	</c:if>
  	<c:if test="${2<=1}">
		你确定吗?
  	</c:if>
  </body>
</html>
