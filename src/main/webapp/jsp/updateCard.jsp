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

.content .row{
	width: 600px;
	line-height: 30px;
	margin:  6px auto;
}
.content form label {
	width: 120px;
	height:30px;
	display:inline-block;
}

.content form input {
	height:30px;
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
		<form action="queryUserExist.action?uri=updateCard" method="post">
			<div class="row">
				<input type="text" name="rdID" placeholder="请先验证该用户是否存在"> <input type="submit" 
					value="查询" style="width: 60px;">
			</div>
		</form>
		<form role="form" class="form-horizontal" action="updateCard.action"
			method="post">
			<!--读者编号-->
			<div class="row">
				<label class="control-label col-sm-2 ">读者编号：</label> <input
					type="text" name="rdID" disabled="disabled"
					value="${updateUser.rdID}" />
			</div>
			<div class="row"><!-- rdID rdName rdSex rdDept rdDept rdEmail rdDateReg"-->
				<!--读者姓名-->
				<label class="control-label col-sm-2 ">读者姓名：</label> <input
					type="text" name="rdName" value="${updateUser.rdName}" />

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
				<label class="control-label col-sm-2 ">性别：</label> <input
					type="text" name="rdSex" value="${updateUser.rdSex }">
			</div>
			<div class="row">
				<!--所在单位-->
				<label class="control-label col-sm-2">所在单位：</label> <input
					type="text" name="rdDept" value="${updateUser.rdDept}" />
			</div>
			<div class="row">
				<!--电话-->
				<label class="control-label col-sm-2">电话：</label> <input type="text"
					name="rdPhoto" value="${updateUser.rdPhoto }" />
			</div>
			<div class="row">
				<!--电子邮箱-->
				<label class="control-label col-sm-2">电子邮箱：</label> <input
					type="text" name="rdEmail" value="${updateUser.rdEmail }" />
			</div>
			<div class="row">

				<!--登记日期-->
				<label class="control-label col-sm-2">登记日期：</label> <input
					type="date" name="rdDateReg" disabled="disabled"
					value="${updateUser.rdDateReg }" />
			</div>
			<div class="row">
				<!--             照片 -->
				<!--             <label class="control-label col-sm-2">读者照片：</label> -->
				<!--             <input type="file" name="rdPhoto" class="form-control-static" placeholder=""/> -->
				<!--         </div> -->

				<!-- 证件状态-->
				<label class="control-label col-sm-2">证件状态：</label> <select
					class="form-control" name="rdStatus">
					<option value="有效" class="active">有效</option>
					<option value="挂失">挂失</option>
					<option value="注销">注销</option>
				</select>
			</div>
			<div class="row">
				<!-- 已借书数量 -->
				<label class="control-label col-sm-2">已借数量：</label> <input
					type="number" name="rdBorrowQty" class="form-control" max="8"
					min="0" class="disabled" value="0" />
			</div>
			<div class="row">
				<!-- 用户类型-->
				<label class="control-label col-sm-2">用户类型：</label> <select
					class="form-control" name="rdType">
					<option value="10" class="active">教师</option>
					<option value="20">本科生</option>
					<option value="21">专科生</option>
					<option value="30">硕士研究生</option>
					<option value="31">博士研究生</option>
				</select>
			</div>
			<div class="row">
				<input type="submit" width="40px"  value="确认" />
			</div>
		</form>
	</div>
</body>
</html>