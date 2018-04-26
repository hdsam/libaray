<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>图书管理系统</title>
<link href="css/navbar.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript"></script>
<body>
	<div class="header">
		<div class="brand">长江大学图书馆</div>
		<div class="username">
			你好！<span>${reader.rdName}</span>
		</div>
	</div>
	<div class="navbar">
		<ul>
			<c:if test="${reader.rdAdminRoles >= 8 }">
				<!-- <span>系统管理8</span> -->
				<li><a href="#">用户管理</a></li>
			</c:if>
			<c:if test="${reader.rdAdminRoles mod 8>=4 }">
				<!-- <span>借阅管理4</span> -->
				<li><a href="lendBook.jsp">借书</a></li>
				<li><a href="keepBook.jsp">续借</a></li>
				<li><a href="payBack.jsp">还书</a></li>
			</c:if>
			<c:if test="${reader.rdAdminRoles mod 4 >=2}">
				<!-- <span>图书管理2</span>-->
				<li><a href="sortBook.jsp">图书编目</a></li>
				<li><a href="addBook.jsp">新书入库</a></li>
				<li><a href="updateBook.jsp">图书信息维护</a></li>
			</c:if>
			<c:if test="${reader.rdAdminRoles mod 2 == 1}">
				<!--<span>借书证管理1</span> -->
				<li><a href="generateCard.jsp">办理借书证</a>
				<li><a href="jumpToupdateCard">变更借书证</a>
			</c:if>

			<!--<span>用户管理0</span>-->
			<li><a href="loginSuccess.jsp">个人信息查询</a></li>
			<li><a href="changePassword.jsp">个人密码修改</a></li>
		</ul>
	</div>
	<div class="content">
		<div class="table" style="margin:  0 auto;" align="center">
			<table border="1px solid #8e8e8e"  cellspacing="0" cellpadding="0" >
			<tbody>
				<tr>
					<th>姓名：</th>
					<td>${reader.rdName}</td>
				<tr>
				<tr>
					<th>性别：</th>
					<td colspan="2">${reader.rdSex}</td>
				<tr>
				<tr>
					<th>借书证编号：</th>
					<td>${reader.rdID }</td>
				<tr>
				<tr>
					<th>读者类别：</th>
					<td><c:choose>
						<c:when test="${reader.rdType==10}">
							教师
						</c:when>
						<c:when test="${reader.rdType==20}">
							本科生
						</c:when>
						<c:when test="${reader.rdType==21}">
							专科生
						</c:when>
						<c:when test="${reader.rdType==30}">
							硕士研究生
						</c:when>
						<c:when test="${reader.rdType==31}">
							博士研究生
						</c:when>
					</c:choose>
					</td>
				<tr>
				<tr>
					<th>邮箱：</th>
					<td>${reader.rdEmail }</td>
				<tr>
				<tr>
					<th>电话：</th>
					<td>${reader.rdPhone }</td>
				<tr>
				<tr>
					<th>部门：</th>
					<td>${reader.rdDept }</td>
				<tr>
				<tr>
					<th>登记日期：</th>
					<td>${reader.rdDateReg }</td>
				<tr>
				<tr>
					<th>证件状态：</th>
					<td>${reader.rdStatus }</td>
				<tr>
				<tr>
					<th>已借书数量：</th>
					<td>${reader.rdBorrowQty }</td>
				<tr>
				<tr>
					<th>系统角色：</th>
					<td><c:if test="${reader.rdAdminRoles >= 8 }">
							系统管理员、
						</c:if> <c:if test="${reader.rdAdminRoles mod 8>=4 }">
							借阅管理员、
						</c:if> <c:if test="${reader.rdAdminRoles mod 4 >=2}">
							图书管理员、
						</c:if> <c:if test="${reader.rdAdminRoles mod 2 == 1}">
							借书证管理员、
						</c:if> 
							读者
					</td>
				</tr>
			</tbody>
		</table>
		</div>

	</div>
</body>
</html>
