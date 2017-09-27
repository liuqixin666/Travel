<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的脚印</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script src="${pageContext.request.contextPath}/js/js.js"></script>
</head>
<body>
	<div class="container">
		<table border="1">
			<tr align="center">
				<td colspan="5">
					<h3>我的脚印</h3>
				</td>
			</tr>
			<tr class="title bg-gray">
				<td>编号</td>
				<td>国家/地区</td>
				<td>时间</td>
				<td>所见所感</td>
				<td>操作</td>
			</tr>
			<!-- 从request作用域中取list集合 -->
			<c:forEach var="item" items="${requestScope.list}" varStatus="status">
				<tr <c:if test="${status.index%2 == 1}" >class="bg-gray"</c:if> >
					<td>${item.tId}</td>
					<td>${item.area}</td>
					<td>${item.time}</td>
					<td>${item.felling}</td>
					<td>
						<a href="javascript:void(0);" onclick="fn_delete(${item.tId})">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath}/add.jsp">添加脚印</a>
	</div>
</body>
</html>