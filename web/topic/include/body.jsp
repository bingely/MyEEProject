<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <%request.getRequestDispatcher("/include/head.jsp").include(request,response); %>
  	<%--@include file="/include/head.jsp" --%>
  	from body.....
  	<%--@include file="/include/head.jsp" --%>
  	<%request.getRequestDispatcher("/include/foot.jsp").include(request,response); %>
  </body>
</html>
