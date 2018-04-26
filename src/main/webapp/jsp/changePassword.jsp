<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>图书管理系统</title>
    <link href="../css/navbar.css" rel="stylesheet" type="text/css">
</head>
<style>

    .content form{
        margin: 0  auto;
        width: 50%;
        display: block;
    }
    .content form .row {
       height: 30px;
       width: 600px;
        margin: 20px auto ;
        font-size: 16px;
        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    }
    .content form .row>input{
        width: 300px;
        height:30px;
        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        text-indent: 10px;
        font-size: 16px;
    }
    .content form .row >label{
        display: inline-block;
        height:30px;
        width: 140px;
    }
    .content form .row >label>input{
        width: 60px;
        margin:0 40px ;
        height: 30x;

    }
</style>
<body>
<div class="header">
    <div class="brand">长江大学图书馆</div>
     <div class="username">你好！<span>${reader.rdName}</span></div>
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
			<li><a href="./loginSuccess.jsp">个人信息查询</a></li>
			<li><a href="./changePassword.jsp">个人密码修改</a></li>
		</ul>
	</div>
<div class="content">
    <form  action="changePassword.action" method="post">
        <div class="row">
            <label>请输入新密码：</label><input  type="password" name="password1" placeholder="请输入密码"/>
        </div>
        <div class="row">
            <label>请再次输入密码：</label><input type="password" name="password2" placeholder="请再次输入密码">
        </div>
        <div class="row">
        <label><input type="submit" value="更改"/></label><label><input type="reset" value="重置"/></label>
    </div>
    </form>
</div>
</body>
</html>