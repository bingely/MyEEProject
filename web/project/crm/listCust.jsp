<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function checkAll(allC){
  			var otherCs = document.getElementsByName("delId");
  			for(var i=0;i<otherCs.length;i++){
  				otherCs[i].checked = allC.checked;
  			}
  		}
  	</script>
  </head>
  <body style="text-align: center;">
  	<h1>客户列表页面</h1><hr>
  	<form action="${pageContext.request.contextPath}/servlet/BatchDelServlet" method="POST">
  	<table border="1" width="100%">
  		<tr>
  			<th><input type="checkbox" onclick="checkAll(this)"/>全选</th>
  			<th>客户姓名</th>
  			<th>客户性别</th>
  			<th>出生日期</th>
  			<th>手机号码</th>
  			<th>电子邮箱</th>
  			<th>客户爱好</th>
  			<th>客户类型</th>
  			<th>描述信息</th>
  			<th>修改</th>
  			<th>删除</th>
  		</tr>
  		<c:forEach items="${requestScope.list}" var="cust">
	  		<tr>
	  			<td><input type="checkbox" name="delId" value="${cust.id }" /></td>
	  			<td><c:out value="${cust.name }"/></td>
	  			<td><c:out value="${cust.gender }"/></td>
	  			<td><c:out value="${cust.birthday }"/></td>
	  			<td><c:out value="${cust.cellphone }"/></td>
	  			<td><c:out value="${cust.email }"/></td>
	  			<td><c:out value="${cust.preference }"/></td>
	  			<td><c:out value="${cust.type }"/></td>
	  			<td><c:out value="${cust.description }"/></td>
	  			<td><a href="${pageContext.request.contextPath }/servlet/CustInfoServlet?id=${cust.id }">修改</a></td>
	  			<td><a href="${pageContext.request.contextPath }/servlet/DelCustServlet?id=${cust.id }">删除</a></td>
	  		</tr>
  		</c:forEach>
  	</table>
  	<input type="submit" value="批量删除"/>
  	</form>
  </body>
</html>
