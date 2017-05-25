<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <%
  	int day = 7;
  	pageContext.setAttribute("day",day);
   %>
  	<c:choose>
  		<c:when test="${day == 1}">
  			星期一
  		</c:when>
  		<c:when test="${day == 2}">
  			星期二
  		</c:when>
  		<c:when test="${day == 3}">
  			星期三
  		</c:when>
  		<c:when test="${day == 4}">
  			星期四
  		</c:when>
  		<c:when test="${day == 5}">
  			星期五
  		</c:when>
		<c:otherwise>
			休息日!
		</c:otherwise>
  	</c:choose>
  </body>
</html>
