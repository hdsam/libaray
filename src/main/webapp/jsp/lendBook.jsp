<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>图书管理系统</title>
<link href="../css/navbar.css" rel="stylesheet" type="text/css">
</head>
<style>
.content form {
	margin: 0 auto;
	width: 502px;
	display: block;
}

.content .row {
	width: 600px;
	line-height: 30px;
	margin: 6px auto;
}

.content form label {
	width: 120px;
	height: 30px;
	display: inline-block;
}

.content form input {
	height: 30px;
	width: 300px;
	display: inline-block;
}
</style>
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
				<li><a href="updateCard.jsp">变更借书证</a>
			</c:if>

			<!--<span>用户管理0</span>-->
			<li><a href="loginSuccess.jsp">个人信息查询</a></li>
			<li><a href="changePassword.jsp">个人密码修改</a></li>
		</ul>
	</div>
	<div class="content">
		<form action="canLendBook" method="post">
			<div class="row">
				<input type="text" name="rdID" placeholder="请先验证该用户是否存在"> <input type="submit"
					 value="查询" style="width: 60px;">
			</div>
		</form>
		<form action="getBook" method="post">
			<div class="row">
				<input type="text" name="bkID" placeholder="请先验证该图书是否存在"> <input type="submit"
					 value="查询" style="width: 60px;">
			</div>
		</form>
		<form role="form" class="form-horizontal" onsubmit="return false;" action="lendBook.action"
			method="post">
			<!--读者编号-->
			<div class="row">
				<label class="control-label col-sm-2 ">图书序号：</label> <input
					type="text" name="rdID" disabled="disabled" value="${book.bkID}" />
			</div>
			<div class="row">
				<!-- rdID rdName rdSex rdDept rdDept rdEmail rdDateReg"-->
				<!--读者姓名-->
				<label class="control-label col-sm-2 ">图书编号：</label> <input
					type="text" name="rdName" value="${book.bkCode}" />

				<!-- 用户密码-->
				<!--         <div class="form-group"> -->
				<!--             <label class="control-label col-sm-2">密码：</label> -->
				<!--             <div class="col-sm-4"> -->
				<!--                 <input type="password" name="rdPwd" class="form-control" placeholder=""/> -->
				<!--             </div> -->
				<!--         </div> -->
				<!--性别-->
			</div>
			<div class="row">
				<label class="control-label col-sm-2 ">书名：</label> <input
					type="text" name="rdSex" value="${book.bkName}">
			</div>
			<div class="row">
				<!--所在单位-->
				<label class="control-label col-sm-2">作者：</label> <input type="text"
					name="rdDept" value="${book.bkAuthor}" />
			</div>
			<div class="row">
				<!--电话-->
				<label class="control-label col-sm-2">出版社：</label> <input
					type="text" name="rdPhoto" value="${book.bkPress }" />
			</div>
			<div class="row">
				<!--电子邮箱-->
				<label class="control-label col-sm-2">出版日期：</label> <input
					type="text" name="rdEmail" value="${book.bkDatePress }" />
			</div>
			<div class="row">

				<!--登记日期-->
				<label class="control-label col-sm-2">ISBN：</label> <input
					type="text" name="rdDateReg" disabled="disabled"
					value="${book.bkISBN }" />
			</div>
			<div class="row">
				<label class="control-label col-sm-2">分类号：</label> <input
					type="text" name="rdPhoto" value="${book.bkCatalog }"
					placeholder="" />
			</div>
			<div class="row">
				<label class="control-label col-sm-2">语言：</label> <input
					type="text" name="rdPhoto" value="${book.bkLanguage }"
					placeholder="" />
			</div>
			<div class="row">
				<label class="control-label col-sm-2">页数：</label> <input
					type="text" name="rdPhoto" value="${book.bkPages }"
					placeholder="" />
			</div>
			<div class="row">
				<label class="control-label col-sm-2">价格：</label> <input
					type="text" name="rdPhoto" value="${book.bkPrice }"
					placeholder="" />
			</div>
			<div class="row">
				<label class="control-label col-sm-2">入馆日期：</label> <input
					type="text" name="rdPhoto" value="${book.bkDateIn }"
					placeholder="" />
			</div>
			
				<div class="row">
				<label class="control-label col-sm-2">内容简介：</label> <input
					type="text" name="rdPhoto" value="${book.bkBrief }"
					placeholder="" />
			</div>
				<div class="row">
				<label class="control-label col-sm-2">图书状态：</label> <input
					type="text" name="rdPhoto" value="${book.bkStatus }"
					placeholder="" />
			</div>
	

	<div class="row">
		<input type="submit" width="40px" value="确认" />
	</div>
	</form>
	</div>
</body>
</html>